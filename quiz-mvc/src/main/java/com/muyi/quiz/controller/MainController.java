package com.muyi.quiz.controller;

import com.muyi.quiz.dto.AnswerDto;
import com.muyi.quiz.dto.QuizDto;
import com.muyi.quiz.proxy.QuizServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"currentQuestion","questionIds","quiz","result"})
public class MainController {

    ///////////////////////////////
    //To do
    //Update result page to show more info(time taken, how many correct answers, pass or fail)
    //Implement the bonus features
    //////////////////////////////
    @Autowired
    private QuizServiceProxy quizServiceProxy;

    @GetMapping("/")
    public String showHome(Model model){
        model.addAttribute("currentQuestion",0);
        List<Integer> quizIds = quizServiceProxy.getQuizIds();
        model.addAttribute("questionIds", quizIds);
        model.addAttribute("result",0);
        return "welcome";
    }

    @GetMapping("/show-question")
    public String showQuestion(@ModelAttribute("answer") AnswerDto answerDto, Model model){
        //check question number if it's 5 then stop
        int currentQuestion = (int) model.getAttribute("currentQuestion");
        ////////////////////////create query to fetch id in repo later
        if(currentQuestion<5){

            currentQuestion++;
            List<Integer> quizIds = (List<Integer>) model.getAttribute("questionIds");
            QuizDto quizDto = quizServiceProxy.getQuizDtoById(quizIds.get(currentQuestion-1));
            model.addAttribute("currentQuestion",currentQuestion);
            model.addAttribute("quiz", quizDto);
            return "question";
        }else{
            //show result
            return "result";
        }

    }

    @PostMapping("/save-answer")
    public String saveAnswer(@Valid @ModelAttribute("answer") AnswerDto answerDto, BindingResult bindingResult, Model model){
        System.out.println("Option selected: "+answerDto.getAnswer());
        if(bindingResult.hasErrors()){
            //System.out.println("Error found in input.");
            return "question";
        }
        //Mark the answer
        QuizDto quizDto = (QuizDto) model.getAttribute("quiz");
        if(quizDto.getAnswer()==answerDto.getAnswer()){
            int result = (int) model.getAttribute("result");
            model.addAttribute("result", ++result);
        }

        return "redirect:/show-question";
    }
}
