package com.cg.springboot.constents;

public interface BusinessRules {
	
	static final double rateOfInterest=0.10;
	static final int tenure=7;
	static final double totalAnnualIncome=2000000;
	static final double monthlyExpenses=5000;
	static final double otherMonthlyExpenses=2000;
	
	public double getROI();
	public int getTen();
	public double getTAI();
	public double getME();
	public double getOME();

}
