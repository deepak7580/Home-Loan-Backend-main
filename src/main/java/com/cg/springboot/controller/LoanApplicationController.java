package com.cg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboot.dto.LoanApplicationDto;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.exception.InvalidLoanApplicationException;
import com.cg.springboot.service.LoanService;

@RestController
public class LoanApplicationController {
	@Autowired
	LoanService loanService;

	//Add Loan Application
	@PostMapping("/addLoan")
	public LoanApplication addLoanApplication(@RequestBody LoanApplication loan) throws InvalidLoanApplicationException{
		return 	loanService.addLoanApplication(loan);
		
	}
	
	//View All Loan Application Record
	@GetMapping("/viewAll")
	public List<LoanApplication> retrieveAllLoanApplication() throws InvalidLoanApplicationException
	{
		List<LoanApplication>loan=loanService.retrieveAllLoanApplication();
		return loan;
	}
	
	//View Loan Application Record by ID
	@GetMapping("/view/{loanId}")
	public LoanApplication retrieveLoanApplicationById(@PathVariable("loanId")long loanId) throws InvalidLoanApplicationException 
	{
		LoanApplication loanApplication=loanService.retrieveLoanApplicationById(loanId);
		return loanApplication;
	}
	
	//Update Loan Application Record by ID
	@PutMapping("/update/{loanId}")
	public LoanApplication updateLoanApplication(@PathVariable("loanId")long loanId,@RequestBody LoanApplication loan) throws InvalidLoanApplicationException
	{
		LoanApplication loanApp=loanService.updateLoanApplication(loanId,loan);
		return loanApp;
	}
	
	//Delete Loan Application Record by ID
	@DeleteMapping("delete/{loanId}")
	public LoanApplication deleteLoanApplication(@PathVariable("loanId")long loanId) throws InvalidLoanApplicationException
	{
		return loanService.deleteLoanApplication(loanId);
	}


}
