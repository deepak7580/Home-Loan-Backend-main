package com.cg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.springboot.entity.EMI;
import com.cg.springboot.service.EMIService;


@RestController
public class EMIController {
	@Autowired
	EMIService emi;


	@PostMapping("/add")
	
	public EMI addLoanAgreement(@RequestBody EMI loan) {
	
		emi.addLoanAgreement( loan);
		
		return loan;
	}
		
		
		
		
		
		}
		
		
	



