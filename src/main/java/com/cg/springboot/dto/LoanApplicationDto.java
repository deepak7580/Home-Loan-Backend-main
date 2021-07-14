package com.cg.springboot.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;

import org.modelmapper.ModelMapper;

import com.cg.springboot.entity.Customer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.entity.Status;

public class LoanApplicationDto{
	private static final ModelMapper modelMapper = new ModelMapper();
	
	private double totalAnnualIncome;
	private double monthlyExpenses;
	private double otherMonthLyExpenses;
	
	
	public double getTotalAnnualIncome() {
		return totalAnnualIncome;
	}
	public LoanApplicationDto(double totalAnnualIncome, double monthlyExpenses, double otherMonthLyExpenses,
		long applicationId, LocalDate applicationDate, double loanAppliedAmount, double loanApprovedAmount,
		boolean landVerificationApproval, boolean finananceVerificationApproval, boolean adminApproval, Status status,
		Customer customer) {
	super();
	this.totalAnnualIncome = totalAnnualIncome;
	this.monthlyExpenses = monthlyExpenses;
	this.otherMonthLyExpenses = otherMonthLyExpenses;
	this.applicationId = applicationId;
	this.applicationDate = applicationDate;
	this.loanAppliedAmount = loanAppliedAmount;
	this.loanApprovedAmount = loanApprovedAmount;
	this.landVerificationApproval = landVerificationApproval;
	this.finananceVerificationApproval = finananceVerificationApproval;
	this.adminApproval = adminApproval;
	this.status = status;
	this.customer = customer;
}
	public void setTotalAnnualIncome(double totalAnnualIncome) {
		this.totalAnnualIncome = totalAnnualIncome;
	}
	public double getMonthlyExpenses() {
		return monthlyExpenses;
	}
	public void setMonthlyExpenses(double monthlyExpenses) {
		this.monthlyExpenses = monthlyExpenses;
	}
	public double getOtherMonthLyExpenses() {
		return otherMonthLyExpenses;
	}
	public void setOtherMonthLyExpenses(double otherMonthLyExpenses) {
		this.otherMonthLyExpenses = otherMonthLyExpenses;
	}
	
	@Override
	public String toString() {
		return "LoanApplicationDto [totalAnnualIncome=" + totalAnnualIncome + ", monthlyExpenses=" + monthlyExpenses
				+ ", otherMonthLyExpenses=" + otherMonthLyExpenses + "]";
	}
	
	public LoanApplication convertToEntity() {
		System.out.println("current"+this.toString());
		LoanApplication obj = modelMapper.map(this, LoanApplication.class);
		System.out.println("new"+obj.toString());
		return obj;
			
		
	}
	private long applicationId;
	private LocalDate applicationDate;
	private double loanAppliedAmount;
	private double loanApprovedAmount;
	private boolean landVerificationApproval;
	private boolean finananceVerificationApproval;
	private boolean adminApproval;
	private Status status;
	private Customer customer;
	
	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}

	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}

	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}

	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}

	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}

	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}

	public boolean isFinananceVerificationApproval() {
		return finananceVerificationApproval;
	}

	public void setFinananceVerificationApproval(boolean finananceVerificationApproval) {
		this.finananceVerificationApproval = finananceVerificationApproval;
	}

	public boolean isAdminApproval() {
		return adminApproval;
	}

	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



}
