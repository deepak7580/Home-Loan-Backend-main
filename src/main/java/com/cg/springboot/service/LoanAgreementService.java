package com.cg.springboot.service;


import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.springboot.entity.LoanAgreement;
import com.cg.springboot.exception.InvalidLoanAgreementException;



@Service
public interface LoanAgreementService {

	public void addLoanAgreement(LoanAgreement loan) ;
	public LoanAgreement updateLoanAgreement(long loanAgreementId,LoanAgreement loan) throws InvalidLoanAgreementException;
	
	
	public LoanAgreement deleteLoanAgreement(long loanId)throws InvalidLoanAgreementException;
	public List<LoanAgreement> retrieveAllLoanAgreement();
	public LoanAgreement retrieveLoanAgreementById(Long loanAgreementId)throws InvalidLoanAgreementException;


}

