package com.cg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboot.entity.Admins;
import com.cg.springboot.service.AdminService;

@RestController
@RequestMapping
public class AdminController {
	
	@Autowired
	AdminService aser; 
	
	@PostMapping("/addAdmin")
	public Admins addNewUser(@RequestBody Admins admins) {
		
		System.out.println(admins.getUser());
		aser.addNewUser(admins);
		return admins;
	}

}
