package com.supereventsmegacorp.quizzioapp.quiz.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class QuizModel {
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;
}
