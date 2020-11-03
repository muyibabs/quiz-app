package com.muyi.quiz.proxy;

import com.muyi.quiz.dto.QuizDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "quiz-api")
public interface QuizServiceProxy {

    @GetMapping("/quizzes")
    List<QuizDto> getAllQuiz();

    @GetMapping("/quiz/{id}")
    QuizDto getQuizDtoById(@PathVariable Integer id);

    @GetMapping("/quiz-ids")
    List<Integer> getQuizIds();

}
