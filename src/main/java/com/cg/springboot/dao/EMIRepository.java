package com.cg.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.springboot.entity.EMI;
import com.cg.springboot.entity.LoanAgreement;



@Repository
public interface EMIRepository extends JpaRepository<EMI,Long> {





	

	@Query("from EMI e where e.loanAgreement=?1")
	public EMI getByLoanAgreement(LoanAgreement loan);

//	@Query("from EMI c where c.EMIId=?1")
//     public EMI getById(long id);	
} 