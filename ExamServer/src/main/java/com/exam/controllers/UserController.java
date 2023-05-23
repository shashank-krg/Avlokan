package com.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import java.util.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//creating User
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setProfile("default.png");
		
		//Encoding password
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> roles = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRoles = new UserRole();
		userRoles.setUser(user);
		userRoles.setRole(role);
		
		roles.add(userRoles);
		return this.userService.createUser(user,roles);
	}
	
	//get user by userName
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String userName) {
	
		return this.userService.getUser(userName);
	}

	//delete user by userName
		@DeleteMapping("/{userId}")
		public void deleteUser(@PathVariable("userId") long userId) {
			this.userService.deleteUser(userId);
		}
}
