package com.muyi.quiz.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AnswerDto {

    private Integer id;

    @Min(value = 1, message = "Invalid answer.")
    @Max(value = 4, message = "Invalid answer.")
    @NotNull(message = "Invalid answer.")
    private Integer answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}
