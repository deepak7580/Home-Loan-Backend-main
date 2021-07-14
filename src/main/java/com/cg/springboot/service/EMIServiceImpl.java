package com.cg.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.calculate.EmiCalculator;
import com.cg.springboot.dao.EMIRepository;
import com.cg.springboot.entity.EMI;



@Service
public class EMIServiceImpl implements EMIService{

	@Autowired
	EMIRepository emiRepo;
	
	@Autowired
	EmiCalculator emiCal;
	

	@Override
	public void addLoanAgreement(EMI loan) {
		
		emiRepo.save(loan);
		
	}

		
}