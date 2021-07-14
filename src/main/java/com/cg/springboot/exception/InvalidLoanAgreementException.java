package com.cg.springboot.exception;



public class InvalidLoanAgreementException extends RuntimeException {

	
	private String message;
	 public InvalidLoanAgreementException(String message) {
	super();
	this.message=message;
}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	 
}

