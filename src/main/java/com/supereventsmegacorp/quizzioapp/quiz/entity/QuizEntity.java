package com.supereventsmegacorp.quizzioapp.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "quiz")
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class QuizEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    @NotNull
    private Long id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "description")
    @NotNull
    @NotBlank
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity creator;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuizEntity)) {
            return false;
        }
        return Objects.nonNull(id) && id.equals(((QuizEntity) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
