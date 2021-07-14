package com.cg.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.springboot.entity.FinanceVerificationOfficer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.User;

@Service
public interface FinanceOfficerService {
	
	
	void addFinanceUser(FinanceVerificationOfficer financer);

	List<FinanceVerificationOfficer> viewFinanceUser();

	FinanceVerificationOfficer viewFinanceUserById(String finId);
	
	
	


//	
//	void updateStatus( int loanAppId, FinanceVerificationOfficer fin);
	//String login(User user);

//	String login(Users users);

	LoanApplication updateStatus(long finAppId, LoanApplication status);

	String signIn(User user);
	

}
