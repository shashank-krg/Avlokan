package com.exam.repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question,UUID> {

	Set<Question> findByQuiz(Quiz quiz);
}
