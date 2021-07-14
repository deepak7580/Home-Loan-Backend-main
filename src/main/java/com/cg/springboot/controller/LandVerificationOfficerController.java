package com.cg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboot.entity.LandVerificationOfficer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.service.LandVerificationOfficerService;
import com.cg.springboot.service.LoanService;

@RestController
@RequestMapping("/landUser")
public class LandVerificationOfficerController {
	
	
	@Autowired
	LandVerificationOfficerService landVerificationOfficerService;
	
	@Autowired
	LoanService loanService;
	
	@PostMapping("/addLandUser")
	public LandVerificationOfficer addLandUser(@RequestBody LandVerificationOfficer landoff)
	{
		System.out.println(landoff.getUsers());
		landVerificationOfficerService.addLandUser(landoff);
		return landoff;
	}
	@GetMapping("/viewLandUser")
	public List<LandVerificationOfficer> viewLandUser()
	{
		List<LandVerificationOfficer> landoff=landVerificationOfficerService.viewLandUser();
		return landoff;
	}
	
	@PutMapping("/update/{landAppId}")
	public LoanApplication updateStatus(@PathVariable("landAppId") long landAppId,@RequestBody LoanApplication status)
	{
		LoanApplication stat =landVerificationOfficerService.updateStatus(landAppId,status);
		return stat;
	}

}
