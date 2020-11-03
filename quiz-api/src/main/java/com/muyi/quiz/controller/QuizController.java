package com.muyi.quiz.controller;

import com.muyi.quiz.dto.QuizDto;
import com.muyi.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quizzes")
    public List<QuizDto> getAllQuizzes(){
        return quizService.getAllQuiz();
    }

    @GetMapping("/quiz-ids")
    public List<Integer> getQuizIds(){
        return quizService.getQuizIds();
    }

    @GetMapping("/quiz/{id}")
    public QuizDto getQuizById(@PathVariable("id") Integer id){
        return quizService.getQuizDtoById(id);
    }
}
