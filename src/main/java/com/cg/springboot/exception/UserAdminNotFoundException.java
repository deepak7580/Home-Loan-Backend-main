package com.cg.springboot.exception;

public class UserAdminNotFoundException extends RuntimeException {
	
	private String message;
	public  UserAdminNotFoundException(String message)
	{
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
