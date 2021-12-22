package com.supereventsmegacorp.quizzioapp.quiz.control;

import com.supereventsmegacorp.quizzioapp.quiz.entity.QuizEntity;
import com.supereventsmegacorp.quizzioapp.quiz.entity.QuizModel;
import com.supereventsmegacorp.quizzioapp.quiz.entity.UserEntity;
import com.supereventsmegacorp.quizzioapp.quiz.entity.UserModel;
import org.mapstruct.Mapper;

@Mapper
public interface EntityModelMapper {
    UserModel userEntityToUserModel(final UserEntity entity);

    QuizModel quizEntityToQuizModel(final QuizEntity entity);

    QuizEntity quizModelToQuizEntity(final QuizModel model);
}
