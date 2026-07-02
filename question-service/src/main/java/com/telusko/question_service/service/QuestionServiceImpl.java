package com.telusko.question_service.service;

import com.telusko.question_service.dao.QuestionDao;
import com.telusko.question_service.model.Question;
import com.telusko.question_service.model.QuestionWrapper;
import com.telusko.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    // ---------------- GET ALL QUESTIONS ----------------
    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    // ---------------- GET BY CATEGORY ----------------
    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    // ---------------- ADD QUESTION (WRITE OPERATION) ----------------
    @Override
    @Transactional
    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add question", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ---------------- GET QUESTIONS FOR QUIZ ----------------
    @Override
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        try {
            List<Integer> questions =
                    questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);

            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    // ---------------- GET QUESTIONS FROM IDS ----------------
    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {

        try {
            List<QuestionWrapper> wrappers = new ArrayList<>();

            for (Integer id : questionIds) {
                Question question = questionDao.findById(id).orElse(null);

                if (question != null) {
                    QuestionWrapper wrapper = new QuestionWrapper();
                    wrapper.setId(question.getId());
                    wrapper.setQuestionTitle(question.getQuestionTitle());
                    wrapper.setOption1(question.getOption1());
                    wrapper.setOption2(question.getOption2());
                    wrapper.setOption3(question.getOption3());
                    wrapper.setOption4(question.getOption4());

                    wrappers.add(wrapper);
                }
            }

            return new ResponseEntity<>(wrappers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    // ---------------- CALCULATE SCORE (READ ONLY TRANSACTION) ----------------
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<Integer> getScore(List<Response> responses) {

        try {
            int right = 0;

            for (Response response : responses) {
                Question question =
                        questionDao.findById(response.getId()).orElse(null);

                if (question != null &&
                        response.getResponse().equals(question.getRightAnswer())) {
                    right++;
                }
            }

            return new ResponseEntity<>(right, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
        }
    }
}
