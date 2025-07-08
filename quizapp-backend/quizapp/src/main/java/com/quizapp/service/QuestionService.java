package com.quizapp.service;

import com.quizapp.entity.Question;
import com.quizapp.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public List<Question> getAllQuestions() {
        return repo.findAll();
    }
    public Optional<Question> getQuestionById(int id) {
        return repo.findById(id);
    }

    public Question saveQuestion(Question question) {
        return repo.save(question);
    }

}
