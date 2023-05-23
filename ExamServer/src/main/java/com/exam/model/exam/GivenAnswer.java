package com.exam.model.exam;

import java.util.UUID;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.exam.model.User;

@Entity
@Table(name = "given_answers")
public class GivenAnswer {
    
	@Id
	@GeneratedValue(generator = "use-or-generate")
	@Column(name = "givenAnswerId")
	@Type(type = "org.hibernate.type.UUIDCharType")
    private UUID givenAnswerId;

    @ManyToOne
    @JoinColumn(name = "answerId")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private LocalDateTime createdOn;

	public GivenAnswer(UUID givenAnswerId, Answer answer, User user, LocalDateTime createdOn) {
		super();
		this.givenAnswerId = givenAnswerId;
		this.answer = answer;
		this.user = user;
		this.createdOn = createdOn;
	}

	public UUID getGivenAnswerId() {
		return givenAnswerId;
	}

	public void setGivenAnswerId(UUID givenAnswerId) {
		this.givenAnswerId = givenAnswerId;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

    // Constructors, getters, and setters
    
}

