package com.telusko.question_service.controller;


import com.telusko.question_service.model.Question;
import com.telusko.question_service.model.QuestionWrapper;
import com.telusko.question_service.model.Response;
import com.telusko.question_service.service.QuestionService;
import com.telusko.question_service.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@RestController
@RequestMapping("/question")
@CrossOrigin
@Tag(name = "Question APIs", description = "Operations related to Question Management")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    @Operation(summary = "Get all questions")
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @Operation(summary = "Get questions by category")
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsbyCategory(
            @PathVariable String category) {

        return questionService.getQuestionsByCategory(category);
    }

    @Operation(summary = "Add a new question")
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {

        return questionService.addQuestion(question);
    }

    @Operation(summary = "Generate question IDs for a quiz")
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(
            @RequestParam String categoryName,
            @RequestParam Integer numQuestions) {

        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @Operation(summary = "Get questions using question IDs")
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(
            @RequestBody List<Integer> questionIds) {

        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questionIds);
    }

    @Operation(summary = "Calculate quiz score")
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(
            @RequestBody List<Response> responses) {

        return questionService.getScore(responses);
    }
}


