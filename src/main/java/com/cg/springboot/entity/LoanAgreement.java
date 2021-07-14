package com.cg.springboot.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="loan_agreement")
public class LoanAgreement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanAgreementId;
//	@Column(unique = true)
//	private long loanApplicationId;
//	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="loan_application_application_id")
	private LoanApplication loanApplication;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "loanAgreement")
    private EMI emi;

	public EMI getEmi() {
		return emi;
	}
	@Transactional
	public void setEmi(EMI emi) {
	emi.setLoanAgreement(this);
	
		this.emi = emi;
	}

	
	public LoanAgreement() {
		
	}

	public LoanAgreement(long loanAgreementId, LoanApplication loanApplication, EMI emi) {
		super();
		this.loanAgreementId = loanAgreementId;
		this.loanApplication = loanApplication;
		this.emi = emi;
	}
	
	
	public LoanApplication getLoanApplication() {
		return loanApplication;
	}
	
	@Override
	public String toString() {
		return "LoanAgreement [loanAgreementId=" + loanAgreementId + ", loanApplication=" + loanApplication + ", emi="
				+ emi + "]";
	}
	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}
	
	public long getLoanAgreementId() {
		return loanAgreementId;
	}

	public void setLoanAgreementId(long loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}



	
}

