package com.cg.springboot.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="User_Table")
public class User {
	
	@Id
	@NotEmpty(message = "User Id can't be empty!")
	@Size(min = 5, max = 20, message = "User Id has to be of minimum 5 chars!")
	private String userId;
	
	@NotEmpty(message = "Password can't be empty!")
	@Size(min = 8, max = 20, message = "Password has to be of minimum 8 chars!")
	private String password;
	
	@NotEmpty(message = "Role Type can't be empty!")
	@Size(min = 2, max = 14, message = "Invalid Role please enter a vaild Role!")
	@Pattern(regexp = ("^(user|admin|financeofficer|landofficer|customer)$"), message = "INVALID Role PLEASE ENTER AGAIN")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! re-enter the role")
	private String role;
	
	
	public User() {
		
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
	
	public User(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	
	

}




