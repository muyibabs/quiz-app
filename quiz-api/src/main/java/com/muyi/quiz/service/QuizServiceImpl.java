package com.muyi.quiz.service;

import com.muyi.quiz.dto.QuizDto;
import com.muyi.quiz.model.Quiz;
import com.muyi.quiz.repository.QuizRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<QuizDto> getAllQuiz() {
        List<Quiz> quizList = quizRepository.findAll();
        if(quizList==null || quizList.size()==0)
            return null;
        List<QuizDto> quizDtos = new ArrayList<>();
        for(Quiz quiz: quizList){
            QuizDto quizDto = new QuizDto();
            BeanUtils.copyProperties(quiz, quizDto);
            quizDtos.add(quizDto);
        }
        return quizDtos;
    }

    @Override
    public QuizDto getQuizDtoById(Integer id) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if(!optionalQuiz.isPresent())
            return null;
        QuizDto quizDto = new QuizDto();
        BeanUtils.copyProperties(optionalQuiz.get(), quizDto);
        return quizDto;
    }

    @Override
    public List<Integer> getQuizIds() {
        List<QuizDto> allQuiz = this.getAllQuiz();
        if(allQuiz==null)
            return null;
        return allQuiz.stream().map(quizDto -> quizDto.getId()).collect(Collectors.toList());
    }
}
