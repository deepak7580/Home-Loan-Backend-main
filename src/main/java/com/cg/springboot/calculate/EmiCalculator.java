package com.cg.springboot.calculate;

import org.springframework.stereotype.Component;

@Component
public class EmiCalculator {

	
	private double loanAmount;
	private double rateOfInterest;
	private int tenure;

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public int getTenure() {
		return tenure;
	}

	@Override
	public String toString() {
		return "EmiCalculator [loanAmount=" + loanAmount + ", rateOfInterest=" + rateOfInterest + ", tenure=" + tenure
				+ "]";
	}

	public EmiCalculator(double loanAmount) {
		super();
		this.loanAmount = loanAmount;
	}

	public EmiCalculator() {
		super();
	}

	public double getEMIAmount() {
		return (loanAmount + (getInterestAmount())) / (tenure);
	}

	public double getInterestAmount() {
		System.out.println("during interst calculation loan is"+loanAmount+" "+rateOfInterest+" "+tenure);
		double result = this.loanAmount*rateOfInterest*tenure;
		System.out.println("result=" +result);
		return result;
	}

}
