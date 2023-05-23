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
@Table(name = "answers")
public class Answer {
    
	@Id
	@GeneratedValue(generator = "use-or-generate")
	@Column(name = "answerId")
	@Type(type = "org.hibernate.type.UUIDCharType")
    private UUID answerId;
	
    private String answer;

    @ManyToOne
    @JoinColumn(name = "quesId")
    private Question question;

	public UUID getAnswerId() {
		return answerId;
	}

	public void setAnswerId(UUID answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer(UUID answerId, String answer, Question question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
	}

    // Constructors, getters, and setters
}
