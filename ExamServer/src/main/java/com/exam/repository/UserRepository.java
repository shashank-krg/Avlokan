package com.exam.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.User;


public interface UserRepository extends JpaRepository<User,Long> {

	public User findByUserName(String username);
}