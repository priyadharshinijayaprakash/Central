package com.master.web.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.web.dao.QuizDAO;
import com.master.web.dao.WebDAO;
import com.master.web.model.QuestionWrapper;
import com.master.web.model.Quiz;
import com.master.web.model.Response;
import com.master.web.model.Web;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDao;
    @Autowired
    WebDAO questionDao;


    public String createQuiz(String category, int numQ) {

        List<Web> questions = WebDAO.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return "Success";

    }

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Web> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Web q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return questionsForUser;

    }

    public Integer calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Web> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return right;
    }
}