package com.supereventsmegacorp.quizzioapp.quiz.control;

import com.supereventsmegacorp.quizzioapp.quiz.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
}
