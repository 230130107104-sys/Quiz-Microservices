package com.telusko.quiz_service.controller;


import com.telusko.quiz_service.model.QuestionWrapper;
import com.telusko.quiz_service.model.Response;
import com.telusko.quiz_service.model.QuizDto;
import com.telusko.quiz_service.model.Quiz;
import com.telusko.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("quiz")
@Tag(name = "Quiz APIs", description = "Operations related to Quiz Management")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Operation(summary = "Create a new quiz")
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
        return quizService.createQuiz(
                quizDto.getCategoryName(),
                quizDto.getNumQuestions(),
                quizDto.getTitle()
        );
    }

    @Operation(summary = "Get all questions of a quiz")
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(
            @PathVariable Integer id) {

        return quizService.getQuizQuestions(id);
    }

    @Operation(summary = "Submit quiz and calculate score")
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(
            @PathVariable Integer id,
            @RequestBody List<Response> responses) {

        return quizService.calculateResult(id, responses);
    }

    @Operation(summary = "Get all quizzes")
    @GetMapping("all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }
}