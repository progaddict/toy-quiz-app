package com.supereventsmegacorp.quizzioapp.quiz.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class UserModel {
    private Long id;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    private List<QuizModel> quizes;
}
