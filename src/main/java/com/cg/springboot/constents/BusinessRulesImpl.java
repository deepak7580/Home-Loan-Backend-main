package com.cg.springboot.constents;

public class BusinessRulesImpl implements BusinessRules{

	@Override
	public double getROI() {
		
		return rateOfInterest;
	}

	@Override
	public int getTen() {
		// TODO Auto-generated method stub
		return tenure;
	}

	@Override
	public double getTAI() {
		// TODO Auto-generated method stub
		return totalAnnualIncome;
	}

	@Override
	public double getME() {
		// TODO Auto-generated method stub
		return monthlyExpenses;
	}

	@Override
	public double getOME() {
		// TODO Auto-generated method stub
		return  otherMonthlyExpenses;
	}
	
	

}
