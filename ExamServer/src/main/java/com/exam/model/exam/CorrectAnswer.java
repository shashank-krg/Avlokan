package com.exam.model.exam;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "correct_answers")
public class CorrectAnswer {
    
	
	@Id
	@GeneratedValue(generator = "use-or-generate")
	@Column(name = "correctAnswerId")
	@Type(type = "org.hibernate.type.UUIDCharType")
    private UUID correctAnswerId;

    @ManyToOne
    @JoinColumn(name = "quesId")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answerId")
    private Answer answer;

	public CorrectAnswer(UUID correctAnswerId, Question question, Answer answer) {
		super();
		this.correctAnswerId = correctAnswerId;
		this.question = question;
		this.answer = answer;
	}

	public UUID getCorrectAnswerId() {
		return correctAnswerId;
	}

	public void setCorrectAnswerId(UUID correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

    // Constructors, getters, and setters
    
}
