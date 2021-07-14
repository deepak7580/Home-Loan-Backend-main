package com.cg.springboot.service;

import java.util.List;

import com.cg.springboot.dto.LoanApplicationDto;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.exception.InvalidLoanApplicationException;

public interface LoanService {

	LoanApplication addLoanApplication(LoanApplication loanApplication);

	List<LoanApplication> retrieveAllLoanApplication();

	LoanApplication retrieveLoanApplicationById(long loanId)throws InvalidLoanApplicationException;

	LoanApplication updateLoanApplication(long loanId, LoanApplication loan)throws InvalidLoanApplicationException;

	LoanApplication deleteLoanApplication(long loanId)throws InvalidLoanApplicationException;



}
