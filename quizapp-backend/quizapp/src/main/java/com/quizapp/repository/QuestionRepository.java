package com.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizapp.entity.Question;
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
