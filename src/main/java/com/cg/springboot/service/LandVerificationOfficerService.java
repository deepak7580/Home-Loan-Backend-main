package com.cg.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.springboot.entity.LandVerificationOfficer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.User;



@Service
public interface LandVerificationOfficerService {
	
	void addLandUser(LandVerificationOfficer landoff);
	
	List<LandVerificationOfficer> viewLandUser();
	
	LandVerificationOfficer viewLandUserById(String landId);

	LoanApplication updateStatus(long landAppId, LoanApplication status);

	String signIn(User user);


}
