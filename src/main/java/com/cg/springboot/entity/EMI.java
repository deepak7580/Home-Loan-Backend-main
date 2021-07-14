package com.cg.springboot.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="emi_table")

public class EMI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long EMIId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dueDate;
	
	@DecimalMin(value = "0", message = "Emi should not be zero")
	private double emiAmount;
	
	@DecimalMin(value = "0", message = "Loan should not be zero")
	private double loanAmount;
	
	@DecimalMin(value = "0", message = "Interest should not be zero")
	private double interestAmount;
	
	
	
@OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE,
        CascadeType.REFRESH, CascadeType.DETACH})
@JoinColumn(name="loan_agreement_id",unique= true)
@JsonIgnore
private LoanAgreement loanAgreement;

	
public EMI(long eMIId, LocalDate dueDate, double emiAmount, double loanAmount, double interestAmount,
		LoanAgreement loanAgreement) {
	
	super();
	//System.out.println("sumit"+loanAgreement);
	EMIId = eMIId;
	this.dueDate = dueDate;
	this.emiAmount = emiAmount;
	this.loanAmount = loanAmount;
	this.interestAmount = interestAmount;
	this.loanAgreement = loanAgreement;
}
	

	public EMI() {
			}

	public long getEMIId() {
		return EMIId;
	}

	public void setEMIId(long eMIId) {
		EMIId = eMIId;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}
	
	public LoanAgreement getLoanAgreement() {
		return loanAgreement;
	}

	public void setLoanAgreement(LoanAgreement loanAgreement) {
		this.loanAgreement = loanAgreement;
	}

	@Override
	public String toString() {
		return "EMI [EMIId=" + EMIId + ", dueDate=" + dueDate + ", emiAmount=" + emiAmount + ", loanAmount="
				+ loanAmount + ", interestAmount=" + interestAmount + ", loanAgreement=" + loanAgreement + "]";
	}

	



		
	}
