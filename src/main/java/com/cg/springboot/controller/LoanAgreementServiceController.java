package com.cg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.springboot.entity.LoanAgreement;
import com.cg.springboot.exception.InvalidLoanAgreementException;
import com.cg.springboot.service.LoanAgreementService;
import java.util.List;
import javax.validation.Valid;

@RequestMapping("/Agreement")
@RestController
public class LoanAgreementServiceController {
	
	public LoanAgreementServiceController() {
		
	}
	@Autowired
	LoanAgreementService loanAgreements;
	
	@GetMapping("/viewall")
	public List<LoanAgreement> retrieveAllLoanAgreement()throws InvalidLoanAgreementException{
		return this.loanAgreements.retrieveAllLoanAgreement();
	}
	
	@GetMapping("/view/{loanId}") 
	public LoanAgreement retrieveLoanAgreementById(@PathVariable("loanId")Long loanAgreementId) throws InvalidLoanAgreementException {
		return this.loanAgreements.retrieveLoanAgreementById(loanAgreementId);
		
	}
	
	
	@PostMapping("/addLoanAgreement")
	public LoanAgreement addLoanAgreement(@RequestBody LoanAgreement loan)throws InvalidLoanAgreementException {
		
		loanAgreements.addLoanAgreement(loan);
		return loan;
	}

	@PutMapping("/update/{loanId}")
	public LoanAgreement updateLoanAgreement(@PathVariable("loanId") long loanAgreementId, @RequestBody @Valid LoanAgreement loan) throws InvalidLoanAgreementException  {
		
	this.loanAgreements.updateLoanAgreement(loanAgreementId,loan);
	return loan;
	
	}
	
	@DeleteMapping("/delete/{loanId}")
	public LoanAgreement deleteLoanAgreement(@PathVariable("loanId") long loanId) throws InvalidLoanAgreementException  {
		return this.loanAgreements.deleteLoanAgreement(loanId);
	}
			
		}
		
	
	
