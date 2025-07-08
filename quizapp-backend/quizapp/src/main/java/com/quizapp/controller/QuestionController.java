package com.quizapp.controller;

import com.quizapp.entity.Question;
import com.quizapp.service.QuestionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }
    @GetMapping
    public List<Question> getQuestions() {
        return service.getAllQuestions();
    }
    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question newQuestion) {
        Question savedQuestion = service.saveQuestion(newQuestion);
        return ResponseEntity.ok(savedQuestion);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable int id, @RequestBody Question updatedQuestion) {
        Optional<Question> existing = service.getQuestionById(id);
        if (existing.isPresent()) {
            Question q = existing.get();
            q.setQuestion(updatedQuestion.getQuestion());
            q.setOption1(updatedQuestion.getOption1());
            q.setOption2(updatedQuestion.getOption2());
            q.setOption3(updatedQuestion.getOption3());
            q.setOption4(updatedQuestion.getOption4());
            q.setCorrectAnswer(updatedQuestion.getCorrectAnswer());

            Question saved = service.saveQuestion(q);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
