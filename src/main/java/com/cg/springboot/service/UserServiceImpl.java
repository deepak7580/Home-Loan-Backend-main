package com.cg.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.dao.UserRepo;
import com.cg.springboot.entity.User;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;

	@Override
	public void register(User user) {
		
		userRepo.save(user);
		
	}
	
	@Override
	public String signIn(User user) {
		
		Optional<User> data = userRepo.findByUserIdAndPassword(user.getUserId(),user.getPassword());
		if(data.isPresent()) {
			System.out.println("log in successful");
			
		}
		else {
			System.out.println("login failed");
		}
		return null;
	}

}
