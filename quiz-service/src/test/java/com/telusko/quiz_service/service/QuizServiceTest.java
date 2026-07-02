package com.telusko.quiz_service.service;

import com.telusko.quiz_service.dao.QuizDao;
import com.telusko.quiz_service.exception.QuizNotFoundException;
import com.telusko.quiz_service.feign.QuizInterface;
import com.telusko.quiz_service.model.QuestionWrapper;
import com.telusko.quiz_service.model.Quiz;
import com.telusko.quiz_service.service.QuizService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuizServiceTest {

    @Mock
    private QuizDao quizDao;

    @Mock
    private QuizInterface quizInterface;

    @InjectMocks
    private QuizService quizService;

    @Test
    void testCreateQuiz() {

        List<Integer> ids = List.of(1,2,3);

        when(quizInterface.getQuestionsForQuiz("Java",3))
                .thenReturn(ResponseEntity.ok(ids));

        ResponseEntity<String> response =
                quizService.createQuiz("Java",3,"Java Quiz");

        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertEquals("Success",response.getBody());

        verify(quizDao,times(1)).save(any(Quiz.class));
    }

    @Test
    void testGetQuizQuestions() {

        Quiz quiz = new Quiz();
        quiz.setQuestionIds(List.of(1,2));

        when(quizDao.findById(1))
                .thenReturn(Optional.of(quiz));

        List<QuestionWrapper> wrappers = new ArrayList<>();

        when(quizInterface.getQuestionsFromId(List.of(1,2)))
                .thenReturn(ResponseEntity.ok(wrappers));

        ResponseEntity<List<QuestionWrapper>> result =
                quizService.getQuizQuestions(1);

        assertEquals(HttpStatus.OK,result.getStatusCode());
    }
    @Test
    void testQuizNotFound() {

        when(quizDao.findById(100))
                .thenReturn(Optional.empty());

        assertThrows(
                QuizNotFoundException.class,
                () -> quizService.getQuizQuestions(100)
        );
    }

    @Test
    void testGetAllQuizzes() {

        List<Quiz> quizzes = List.of(new Quiz());

        when(quizDao.findAll())
                .thenReturn(quizzes);

        ResponseEntity<List<Quiz>> response =
                quizService.getAllQuizzes();

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(1,response.getBody().size());
    }

}