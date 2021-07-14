package com.cg.springboot.service;


import org.springframework.stereotype.Service;
import com.cg.springboot.entity.EMI;


@Service
public interface EMIService {

	void addLoanAgreement(EMI loan);

}