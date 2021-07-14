package com.cg.springboot.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.springboot.entity.LoanAgreement;
import com.cg.springboot.entity.LoanApplication;




@Repository
public interface LoanAgreementRepository extends JpaRepository <LoanAgreement, Long>{

@Query("from LoanAgreement e where e.loanAgreementId=?1")
public LoanAgreement getById(long id);

@Query("From LoanAgreement c where c.loanApplication=?1")
public LoanAgreement findByLoanApplication(LoanApplication l);


}
