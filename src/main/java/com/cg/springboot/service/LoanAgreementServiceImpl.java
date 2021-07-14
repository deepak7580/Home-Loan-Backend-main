package com.cg.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.calculate.EmiCalculator;
import com.cg.springboot.dao.EMIRepository;
import com.cg.springboot.dao.LoanAgreementRepository;
import com.cg.springboot.dao.LoanRepo;
import com.cg.springboot.entity.EMI;
import com.cg.springboot.entity.LoanAgreement;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.exception.InvalidLoanAgreementException;


@Service
public class LoanAgreementServiceImpl implements LoanAgreementService {

	@Autowired
	LoanAgreementRepository loanRepository;
	@Autowired
	EMIRepository emiRepo;
	@Autowired
	LoanRepo loanRepo;
	

	@Override
	public void addLoanAgreement(LoanAgreement loanAgreement)throws InvalidLoanAgreementException {
		System.out.println(loanAgreement.toString());
		System.out.println("deepak"+loanAgreement.getLoanApplication().toString());
		Long loanApp=loanAgreement.getLoanApplication().getApplicationId();
		
		
		System.out.println(loanApp.toString()+"rohit");
		loanAgreement.setLoanApplication(null);
		LoanApplication l=loanRepo.getByApplicationId(loanApp);
		
		
		
		if(l==null) {
			
			throw new RuntimeException("Application Id not Found...!!!!");
		}
		
		EMI emi=new EMI();
		//LoanApplication loan = new LoanApplication();
		emi.setEmiAmount(l.getEMIAmount());
		emi.setDueDate(l.getApplicationDate().plusYears(l.getTenure()));
		emi.setLoanAmount(l.getLoanApprovedAmount());
		emi.setInterestAmount(l.getInterestAmount());
		
		loanAgreement.setEmi(emi);
		
		loanAgreement.setLoanApplication(l);
		loanRepository.save(loanAgreement);
		
	}
		
		
//		try {
//		loanRepository.save(loan);}
//		emiRepo.save(loan.getEmi());	}
//		catch(Exception e) {
//			throw new InvalidLoanAgreementException("Oops! Something is missing. Give proper details.");
//		}
//	}

	@Override
	public LoanAgreement retrieveLoanAgreementById(Long loanAgreementId)throws InvalidLoanAgreementException {
		try {
		Optional<LoanAgreement> loa= loanRepository.findById(loanAgreementId);
		return loa.get();
	}
		catch(Exception e) {
			throw new InvalidLoanAgreementException("Loan agreement ID not found in records!");
		}
	}


	@Override
	public List<LoanAgreement> retrieveAllLoanAgreement()throws InvalidLoanAgreementException {
	try {
		List<LoanAgreement> loa=loanRepository.findAll();
		return loa;
	}
	catch(Exception e) {
		throw new InvalidLoanAgreementException("Loan agreement found!");
	}
	}
	

//	@Override
//	public LoanAgreement updateLoanAgreement(long loanAgreementId,LoanAgreement loan)throws InvalidLoanAgreementException  {
//		
//		try {
//		Optional<LoanAgreement> loa = loanRepository.findById(loanAgreementId);
//		loa.get().setLoanAgreementId(loan.getLoanAgreementId());
//		loa.get().setLoanApplicationId(loan.getLoanApplicationId());
//		
//			loanRepository.save(loa.get());
//		return loa.get();
//}
//catch (Exception e){
//	throw new InvalidLoanAgreementException("Loan agreement couldn't be Updated! ");
//}
//
//	}
	
	@Override
	public LoanAgreement deleteLoanAgreement(long loanId)throws InvalidLoanAgreementException {
		try {
		LoanAgreement loan = loanRepository.getById(loanId);
		//EMI emi = emiRepo.getByLoanAgreement(loan);
		loanRepository.deleteById(loan.getLoanAgreementId());
		//emiRepo.deleteById(emi.getEMIId());
		
		return loan;
		
	}
		catch (Exception e){
			throw new InvalidLoanAgreementException("Loan agreement not found for delete operation!");
		}
	
	}

	@Override
	public LoanAgreement updateLoanAgreement(long loanAgreementId, LoanAgreement loan)
			throws InvalidLoanAgreementException {
				return null;
		
}
}


