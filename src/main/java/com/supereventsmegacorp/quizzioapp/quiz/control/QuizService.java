package com.supereventsmegacorp.quizzioapp.quiz.control;

import com.supereventsmegacorp.quizzioapp.quiz.entity.QuizEntity;
import com.supereventsmegacorp.quizzioapp.quiz.entity.QuizModel;
import com.supereventsmegacorp.quizzioapp.quiz.entity.UserEntity;
import com.supereventsmegacorp.quizzioapp.quiz.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@lombok.RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuizService {
    private final UserRepository userRepository;
    private final UserRepository quizRepository;
    private final UserRepository voteRepository;
    private final EntityModelMapper mapper;

    @Transactional
    public Optional<UserModel> addQuiz(final long userId, final QuizModel quiz) {
        final Optional<UserEntity> usr = userRepository.findById(userId);
        if (usr.isEmpty()) {
            return Optional.empty();
        }
        final UserEntity userEntity = usr.get();
        final QuizEntity quizEntity = mapper.quizModelToQuizEntity(quiz);
        userEntity.addQuiz(quizEntity);
        userRepository.save(userEntity);
        return Optional.ofNullable(mapper.userEntityToUserModel(userEntity));
    }

    @Transactional(readOnly = true)
    public Optional<UserModel> getUser(final long id) {
        return userRepository.findById(id).map(mapper::userEntityToUserModel);
    }
}
