package com.cg.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.dao.FinanceVerificationOfficerRepo;
import com.cg.springboot.dao.LoanRepo;
import com.cg.springboot.dao.UserRepo;
import com.cg.springboot.entity.FinanceVerificationOfficer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.User;



@Service
public class FinanceOfficerServiceImpl implements FinanceOfficerService{
	
	@Autowired
	FinanceVerificationOfficerRepo financeVerificatonOfficerRepo;
	
	@Autowired
	LoanRepo loanRepo;
	
	@Autowired
	UserRepo userRepo;
	
	
	//add user
	@Override
	public void addFinanceUser(FinanceVerificationOfficer financer) {
	
		String users = financer.getUsers().getUserId();
		String role = financer.getUsers().getRole();
		
		financer.setUsers(null);
		User u=userRepo.getById(users);
		
		FinanceVerificationOfficer c=financeVerificatonOfficerRepo.findByUsers(u);
		
		if(c!=null)
		{
		
			throw new RuntimeException("user Already registered");
		}
		if(u!=null && !(u.getRole().equals("financeOfficer"))) {
			
			throw new RuntimeException("role doesn't match with user id");
		}
		if(u==null)
		{
			throw new RuntimeException("user not exist please register!!!");
		}
		
//				System.out.println(role.equalsIgnoreCase("financeOfficer"));
			if(role.equalsIgnoreCase("financeOfficer")) {
		    financer.setUsers(u);
		  
		    financeVerificatonOfficerRepo.save(financer);
			}
			else {
				throw new RuntimeException("role doesn't match with user id	");
			}
	}
//		Optional<FinanceVerificationOfficer> financer1 = financeVerificatonOfficerRepo.findById(financer.getUserId());
//		
//		if(financer1.isPresent())
//		{
//			throw new RuntimeException("user id already exist");
//		}
//		else
//		{
//			financeVerificatonOfficerRepo.save(financer);
//		}
	
	

	
	
	//view user
	@Override
	public List<FinanceVerificationOfficer> viewFinanceUser() {
		
		List<FinanceVerificationOfficer> financer = financeVerificatonOfficerRepo.findAll();
		return financer;
	}

	
	
	//view user by id
	@Override
	public FinanceVerificationOfficer viewFinanceUserById(String finId) {
		
		Optional<FinanceVerificationOfficer> financer = financeVerificatonOfficerRepo.findById(finId);
		
		return financer.get();
	}


	
	
	//update status
//	@Override
//	public void updateStatus(int loanAppId, FinanceVerificationOfficer fin) {
//		// TODO Auto-generated method stub
//		
//		String status;
//		Optional<FinanceVerificationOfficer> data = financeVerificatonOfficerRepo.findById(users.getUserId());
		
		
//	}


	
	
	//Login
	
//	@Override
//	public String login(Users users) {
//		
//		String status;
//		Optional<FinanceVerificationOfficer> data = financeVerificatonOfficerRepo.findById(users.getUserId());
//		
//				
//		if(data.isPresent())
//		{
//			status="logged in succssesfully";
//	}
//		else
//		{
//			status ="invalid credential";
//		}
//
//		return status;
//	}




	@Override
	public LoanApplication updateStatus(long finAppId, LoanApplication status) {
		
		Optional<LoanApplication> optional = loanRepo.findById(finAppId);
		if (optional.isPresent()) {
			loanRepo.save(status);
			return status;
		} else {
			throw new RuntimeException("Loan application couldn't be Updated! ");
		
		
//		Optional<LoanApplication> loanApp = loanRepo.findById(finAppId);
//		loanApp.get().setFinananceVerificationApproval(status.ge);
		
//		Optional<LoanApplication> loan = loanRepo.findById(finAppId);
//		loan.get().setFinananceVerificationApproval(status.g);
//		
//		return null;
	}
	}




	@Override
	public String signIn(User user) {
		
		Optional<User> data = userRepo.findByUserIdAndPassword(user.getUserId(),user.getPassword());
		if(data.isPresent()) {
			System.out.println("log in successful");
			
		}
		else {
			System.out.println("login failed");
		}
		return null;
	}

}

	
	
	








	
//	@Override
//	public void updateStatus(String userId, FinanceVerificationOfficer fin) {
//		
//		fin.s
//	}

//	@Override
//	public void updateStatus(FinanceVerificationOfficer financer) {
//		FinanceVerificationOfficerRepo.setUpdateStatus("APPROVED", financer.getUserId());
//			   }


		
	
	
	
	


