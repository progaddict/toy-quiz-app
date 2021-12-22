package com.supereventsmegacorp.quizzioapp.quiz.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "user")
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    @NotNull
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @NotBlank
    private String lastName;

    @Column(name = "email", unique = true)
    @NotNull
    @NotBlank
    @Email
    private String email;

    @OneToMany(
            mappedBy = "creator",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<QuizEntity> quizes;

    public void addQuiz(final QuizEntity quiz) {
        quizes.add(quiz);
        quiz.setCreator(this);
    }

    public void removeQuiz(final QuizEntity quiz) {
        quizes.remove(quiz);
        quiz.setCreator(null);
    }
}
