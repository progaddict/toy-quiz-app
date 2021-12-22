package com.supereventsmegacorp.quizzioapp.quiz.control;

import com.supereventsmegacorp.quizzioapp.quiz.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
