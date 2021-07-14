package com.cg.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.springboot.entity.LandVerificationOfficer;
import com.cg.springboot.entity.User;

@Repository
public interface LandVerificationOfficerRepository extends JpaRepository <LandVerificationOfficer,String> {
	
	@Query("from LandVerificationOfficer l where l.users=?1")
	public LandVerificationOfficer findByUsers(User u);
}




