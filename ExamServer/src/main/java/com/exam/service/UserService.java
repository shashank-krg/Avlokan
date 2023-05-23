package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;
import java.util.UUID;

public interface UserService {

	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get user by userName
	
	public User getUser(String userName);
	
	//delete user by userId
	
	public void deleteUser(Long userId);
}
