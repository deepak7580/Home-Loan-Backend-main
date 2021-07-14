package com.cg.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.calculate.HomeLoanBorrowingAmountCalculator;
import com.cg.springboot.dao.CustomerRepository;
import com.cg.springboot.dao.LoanRepo;
import com.cg.springboot.dto.LoanApplicationDto;
import com.cg.springboot.entity.Customer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.Status;
import com.cg.springboot.exception.InvalidLoanApplicationException;

@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	LoanRepo loanrepo;
	@Autowired
	CustomerRepository custRepo;

	@Override
	public LoanApplication addLoanApplication(LoanApplication loanApplication) throws InvalidLoanApplicationException {
		// loanrepo.save(loanApplication);
		System.out.println(loanApplication.toString());

		Customer cust = (loanApplication.getCustomer());

		int id = cust.getCustomerId();
		Customer c = custRepo.findById(id).get();
		System.out.println(c.toString());
		LoanApplication l = loanrepo.getByCustomer(c);
		
//		loanApplication.setLoanApprovedAmount(0.00);
//		loanApplication.setLandVerificationApproval(false);
//		loanApplication.setFinananceVerificationApproval(false);
//		loanApplication.setAdminApproval(false);
		loanApplication.setStatus(Status.PENDING);

		if (l == null) {
			
//			loanApp.setApplicationId(loanApp.getApplicationId());
			
			//LoanApplication homeCal=new LoanApplication(loanApplication.getTotalAnnualIncome(),
				//	loanApplication.getMonthlyExpenses(),loanApplication.getOtherMonthlyExpenses());
			double approvedAmount=loanApplication.getLoanApprovedAmount();
			double appliedAmount=loanApplication.getLoanAppliedAmount();
			
			System.out.println(approvedAmount+" "+appliedAmount);
			
			if (approvedAmount>appliedAmount) {
				System.out.println("applied amount is approvable="+appliedAmount);
				loanApplication.setLoanApprovedAmount(appliedAmount);
			}
			else {
				System.out.println("apply for some lower amount="+approvedAmount);
				loanApplication.setLoanApprovedAmount(approvedAmount);
			}
			loanApplication.setCustomer(c);
			System.out.println("about to save");
			LoanApplication la =loanApplication;
			System.out.println("toDB"+la.toString());
			return loanrepo.save(la);
			

		} else {
			return null;
		}

//	try {
//		loanrepo.save(loanApplication);
//		return "ok";
//	}catch(Exception e)
//	{
//		System.out.println(e);
//		return "jnjn";
//	}
//	

	}

	@Override
	public List<LoanApplication> retrieveAllLoanApplication() throws InvalidLoanApplicationException {
		try {
			List<LoanApplication> loan=loanrepo.findAll();
			return loan;
		}
		catch (Exception e) {
			throw new InvalidLoanApplicationException("Loan Application Found");
		}
	}

	@Override
	public LoanApplication retrieveLoanApplicationById(long loanId) throws InvalidLoanApplicationException {
		try {
			Optional<LoanApplication> loan= loanrepo.findById(loanId);
			return loan.get();
			}
			catch (Exception e) {
				throw new InvalidLoanApplicationException("Loan Application ID NOT FOUND");
			}
	}

	@Override
	public LoanApplication updateLoanApplication(long loanId, LoanApplication loanApp) throws InvalidLoanApplicationException {
		Optional<LoanApplication> loan = loanrepo.findById(loanId);
		if(loan.isPresent()) {
		loan.get().setApplicationId(loanId);
		loan.get().setApplicationDate(loanApp.getApplicationDate());
		loan.get().setLoanAppliedAmount(loanApp.getLoanAppliedAmount());
		loan.get().setLoanApprovedAmount(0.00);
		loan.get().setLandVerificationApproval(false);
		loan.get().setFinananceVerificationApproval(false);
		loan.get().setAdminApproval(false);
		loan.get().setStatus(loanApp.getStatus());

		loanrepo.save(loan.get());
		custRepo.save(loan.get().getCustomer());
		return loan.get();
	}
	else {
		throw new InvalidLoanApplicationException("Loan Application NOT FOUND with matching ID");
	}
	
}

	@Override
	public LoanApplication deleteLoanApplication(long loanId) throws InvalidLoanApplicationException {
		try {
			LoanApplication loan=loanrepo.getById(loanId);
			loanrepo.deleteById(loan.getApplicationId());
			return loan;
			}
			catch (Exception e) {
				throw new InvalidLoanApplicationException("Loan Application NOT FOUND");
			}
	}
}
