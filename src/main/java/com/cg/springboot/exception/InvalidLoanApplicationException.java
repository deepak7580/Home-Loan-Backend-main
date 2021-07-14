package com.cg.springboot.exception;

public class InvalidLoanApplicationException extends RuntimeException{

	private String message;

	public InvalidLoanApplicationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
