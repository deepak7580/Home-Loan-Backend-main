package com.cg.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.springboot.entity.FinanceVerificationOfficer;
import com.cg.springboot.entity.User;

@Repository
public interface FinanceVerificationOfficerRepo extends JpaRepository<FinanceVerificationOfficer, String>{
	
	@Query("from FinanceVerificationOfficer f where f.users=?1")
	public FinanceVerificationOfficer findByUsers(User u);
	
//	@Query("from FinanceVerificationOfficer f where f.userId=:userId AND f.role=:role")
//	public FinanceVerificationOfficer findByUsersAndRole(@Param("userId") String userId, @Param("role") String role);

//	static void setUpdateStatus(String string, String userId) {

//	}
//	
	
	
	
//	@Query("from User where userId=:user AND password=:pwd")
//	User findByIdAndPwd(@Param("user") int user,@Param("pwd") String pwd);


}
