package com.supereventsmegacorp.quizzioapp.quiz.boundary;

import com.supereventsmegacorp.quizzioapp.quiz.control.QuizService;
import com.supereventsmegacorp.quizzioapp.quiz.entity.QuizModel;
import com.supereventsmegacorp.quizzioapp.quiz.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(QuizController.URL_PREFIX)
@lombok.RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuizController {
    public static final String URL_PREFIX = "/api/v1/user";

    private final QuizService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUser(@NotNull @Positive @PathVariable("id") final Long id) {
        return userService.getUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/quiz")
    public ResponseEntity<UserModel> createQuiz(
            @NotNull @Positive @PathVariable("id") final Long id,
            @NotNull @Valid @RequestBody final QuizModel quiz
    ) {
        return userService.addQuiz(id, quiz)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
