package com.supereventsmegacorp.quizzioapp.quiz.control;

import com.supereventsmegacorp.quizzioapp.quiz.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {
}
