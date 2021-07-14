package com.cg.springboot.service;

import org.springframework.stereotype.Service;

import com.cg.springboot.entity.User;

@Service
public interface UserService {

	void register(User user);

	String signIn(User user);

}
