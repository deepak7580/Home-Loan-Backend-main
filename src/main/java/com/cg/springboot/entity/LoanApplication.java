package com.cg.springboot.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;

import org.modelmapper.ModelMapper;



@Entity
@Table(name="LoanApplication",uniqueConstraints= {@UniqueConstraint(columnNames= {"customer_customer_id"})})
public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long applicationId;
		
	private LocalDate applicationDate;
	private double loanAppliedAmount;
	private double loanApprovedAmount;
	private boolean landVerificationApproval;
	private boolean finananceVerificationApproval;
	private boolean adminApproval;
	private double totalAnnualIncome;
	private double monthlyExpenses;
	private double otherMonthlyExpenses;
	private double rateOfInterest;
	private int tenure;
	
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE,
            CascadeType.REFRESH, CascadeType.DETACH})
	
	private Customer customer;
		
	
	public double getEMIAmount() {
		return (loanAppliedAmount + (getInterestAmount())) / (tenure);
	}

	public double getInterestAmount() {
		System.out.println("during interst calculation loan is"+loanAppliedAmount+" "+rateOfInterest+" "+tenure);
		double result = this.loanAppliedAmount*rateOfInterest*tenure;
		System.out.println("result=" +result);
		return result;
	}
	
	public double getHomeLoanBorrowingAmount(double totalAnnualIncome,double monthlyExpenses,double otherMonthlyExpenses,int tenure) {
		System.out.println(totalAnnualIncome+""+monthlyExpenses+""+otherMonthlyExpenses+""+tenure);
		
		double monthlySavings = ((totalAnnualIncome)/(monthlyExpenses+otherMonthlyExpenses)*12);
		return monthlySavings*12*this.tenure;
		
	}

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
		
		System.out.println("Home Loan Borrowing");
		this.loanApprovedAmount = this.getHomeLoanBorrowingAmount(
						 totalAnnualIncome, monthlyExpenses,
							otherMonthlyExpenses, tenure);
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

	public double getTotalAnnualIncome() {
		return totalAnnualIncome;
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

	public double getOtherMonthlyExpenses() {
		return otherMonthlyExpenses;
	}

	public void setOtherMonthlyExpenses(double otherMonthlyExpenses) {
		this.otherMonthlyExpenses = otherMonthlyExpenses;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
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

	public LoanApplication(long applicationId, LocalDate applicationDate, double loanAppliedAmount,
			double loanApprovedAmount, boolean landVerificationApproval, boolean finananceVerificationApproval,
			boolean adminApproval, double totalAnnualIncome, double monthlyExpenses, double otherMonthlyExpenses,
			double rateOfInterest, int tenure, Status status, Customer customer) {
		
		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.loanAppliedAmount = loanAppliedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.finananceVerificationApproval = finananceVerificationApproval;
		this.adminApproval = adminApproval;
		this.totalAnnualIncome = totalAnnualIncome;
		this.monthlyExpenses = monthlyExpenses;
		this.otherMonthlyExpenses = otherMonthlyExpenses;
		this.rateOfInterest = rateOfInterest;
		this.tenure = tenure;
		this.status = status;
		this.customer = customer;
		this.loanApprovedAmount =loanApprovedAmount;
		
		System.out.println("in constructor");
	}

	public LoanApplication() {
		
	}



	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", applicationDate=" + applicationDate
				+ ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount=" + loanApprovedAmount
				+ ", landVerificationApproval=" + landVerificationApproval + ", finananceVerificationApproval="
				+ finananceVerificationApproval + ", adminApproval=" + adminApproval + ", totalAnnualIncome="
				+ totalAnnualIncome + ", monthlyExpenses=" + monthlyExpenses + ", otherMonthlyExpenses="
				+ otherMonthlyExpenses + ", rateOfInterest=" + rateOfInterest + ", tenure=" + tenure + ", status="
				+ status + ", customer=" + customer + "]";
	}

	
}
