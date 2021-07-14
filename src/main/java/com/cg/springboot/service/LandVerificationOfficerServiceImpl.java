package com.cg.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.dao.LandVerificationOfficerRepository;
import com.cg.springboot.dao.LoanRepo;
import com.cg.springboot.dao.UserRepo;

import com.cg.springboot.entity.LandVerificationOfficer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.User;


@Service
public class LandVerificationOfficerServiceImpl  implements LandVerificationOfficerService
{

	@Autowired
	LandVerificationOfficerRepository   landVerificationRepo;


	@Autowired
	LoanRepo loanRepo;


	@Autowired
	UserRepo userRepo;
	
	
	@Override
	public void addLandUser(LandVerificationOfficer landoff) {

		String users = landoff.getUsers().getUserId();
		String role = landoff.getUsers().getRole();
		
		landoff.setUsers(null);
		User u= userRepo.getById(users);
		LandVerificationOfficer c1= landVerificationRepo.findByUsers(u);
		if(c1!=null)
		{
			throw new RuntimeException("user Already registered");
		}
		if(u!=null && !(u.getRole().equals("landOfficer"))) {

			throw new RuntimeException("role doesn't match with user id");
		}
		if(u==null)
		{
			throw new RuntimeException("user not exist please register!!!");
		}

		if(role.equalsIgnoreCase("landOfficer")) {
			landoff.setUsers(u);
			landVerificationRepo.save(landoff);
		}
		else {
			throw new RuntimeException("role doesn't match with user id	");
		}
	}
	
	
	

	@Override
	public List<LandVerificationOfficer> viewLandUser() {
		List<LandVerificationOfficer> landoff=landVerificationRepo.findAll();
		return landoff;
	}


	//view user by id
	@Override
	public LandVerificationOfficer viewLandUserById(String landId) {
		Optional <LandVerificationOfficer> landoff = landVerificationRepo.findById(landId);
		return landoff.get();
	}
	
	
	
	
	
	
	@Override
	public LoanApplication updateStatus(long landAppId, LoanApplication status) {
		
		//	LoanApplicationRepository.setUpdateStatus("APPROVED",landAppId);
		Optional<LoanApplication> l1 = loanRepo.findById(landAppId);
		if (l1.isPresent()) {
			loanRepo.save(status);
			return status;

		}
		else {
			throw new RuntimeException("Loan application is not updated");
		}}

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
