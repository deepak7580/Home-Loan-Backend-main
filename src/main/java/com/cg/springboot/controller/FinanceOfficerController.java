package com.cg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboot.entity.FinanceVerificationOfficer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.service.FinanceOfficerService;
import com.cg.springboot.service.LoanService;

@RestController
@RequestMapping("/financers")
public class FinanceOfficerController {
	
	
	@Autowired
	FinanceOfficerService financeService;
	
	@Autowired
	LoanService loanService;
	
//	@GetMapping("/healthy")
//	public void healthCheck() {
//		System.out.println("Running  add Product Controller...");
//		}
	
//	adding single financeuser into database
	@PostMapping("/addFinanceUser")
	public FinanceVerificationOfficer addFinanceUser(@RequestBody  FinanceVerificationOfficer financer)
	{	
		System.out.println(financer.getUsers());
		financeService.addFinanceUser(financer);
		return financer;
	}
	
	//viewing all the records from the database
	@GetMapping("/viewFinanceUser")
		public List<FinanceVerificationOfficer> viewFinanceUser()
	{
		List<FinanceVerificationOfficer> financer=financeService.viewFinanceUser();
		return financer;
	}
	
//	
//	@PutMapping("/updateStatus/{userId}")
//	public void updateStatus(@PathVariable("userId") String userId, FinanceVerificationOfficer fin ){
//		financeService.updateStatus(userId,fin);
//
//	}
	
	
	@PutMapping("/update/{finAppId}")
	public LoanApplication updateStatus(@PathVariable("finAppId") long finAppId,@RequestBody LoanApplication status)
	{
		LoanApplication stat =financeService.updateStatus(finAppId,status);
		return stat;
	}
}
