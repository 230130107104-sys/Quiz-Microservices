package com.telusko.quiz_service.service;

import com.telusko.quiz_service.dao.QuizDao;
import com.telusko.quiz_service.exception.QuizNotFoundException;
import com.telusko.quiz_service.feign.QuizInterface;
import com.telusko.quiz_service.model.QuestionWrapper;
import com.telusko.quiz_service.model.Quiz;
import com.telusko.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    //  WRITE OPERATION → Transaction useful
    @Transactional
    @Override
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions =
                quizInterface.getQuestionsForQuiz(category, numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    //  READ OPERATION → no need @Transactional
    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Quiz quiz = quizDao.findById(id)
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found with id: " + id));

        return quizInterface.getQuestionsFromId(quiz.getQuestionIds());
    }

    //  ONLY REST CALL → NO Transaction needed
    @Override
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        return quizInterface.getScore(responses);
    }

    //  READ ONLY → no transaction needed
    @Override
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        try {
            return new ResponseEntity<>(quizDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}