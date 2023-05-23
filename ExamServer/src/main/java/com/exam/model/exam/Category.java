package com.exam.model.exam;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import java.util.Set;
import java.util.UUID;
import java.util.LinkedHashSet;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(generator = "use-or-generate")
	@Column(name = "cid")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID cid;
	
	private String title;
	
	private String description;
	
	@OneToMany(mappedBy = "category",  cascade= CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quizzes = new LinkedHashSet<>();
	
	public Category() {
		
	}

	public Category(String title, String description) {
	
		this.title = title;
		this.description = description;
	}

	public UUID getCid() {
		return cid;
	}

	public void setCid(UUID cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
