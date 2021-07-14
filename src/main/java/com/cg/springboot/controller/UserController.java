package com.cg.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboot.entity.User;
import com.cg.springboot.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public User register(@Valid @RequestBody User user)
	{
		userService.register(user);
		return user;
	}

	@PostMapping("/signIn")
	public User signIn(@RequestBody User user) {
		userService.signIn(user);
		return user;
	}
}
