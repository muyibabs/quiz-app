package com.muyi.quiz.service;

import com.muyi.quiz.dto.QuizDto;

import java.util.List;

public interface QuizService {

    List<QuizDto> getAllQuiz();
    QuizDto getQuizDtoById(Integer id);
    List<Integer> getQuizIds();
}
