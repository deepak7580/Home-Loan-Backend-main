package com.cg.springboot.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Customer_Table")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;
	
	@NotEmpty(message = "Customer Name can't be empty!")
	@Size(min = 3, max = 25, message = "Invalid Customer Name please enter a vaild Customer Name!")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Accepts only alphabets! re-enter the name")
	private String customerName;
	
	@NotEmpty(message = "Phone Number can't be empty!")
	@Size(min = 10, max = 10, message = "Invalid Phone Number please enter a vaild phone number of minimum 10 digits")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid input:Enter numbers only")
	private String mobileNumber;
	
	@NotEmpty(message = "Email ID can't be empty!")
	@Size(min = 2, max = 30, message = "Invalid Email ID please enter a vaild email ID")
	@Email(message = "Not the proper Email ID format! enter again")
	private String email;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dateOfBirth;
	
	@NotEmpty(message = "Gender can't be empty!")
	@Size(min = 4, max = 6, message = "Please enter Male/Female/Others")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! re-enter the gender")
	private String gender;
	
	@NotEmpty(message = "Nationality can't be empty!")
	@Size(min = 2, max = 15, message = "Please enter proper nationality")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! re-enter the nationality")
	private String nationality;
	
	@NotEmpty(message = "Aadhar Card number can't be empty!")
	@Size(min = 12, max = 12, message = "Please enter 12 digit AADHAR!")
	private String aadharNumber;
	
	@NotEmpty(message = "PAN card number can't be empty!")
	@Size(min = 10, max = 10, message = "Please enter 10 digit PAN!")
	private String panNumber;
	
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE,
            CascadeType.REFRESH, CascadeType.DETACH})
	private User user;
	
	
	public Customer() {
		
	}
	
	
	public Customer( String customerName,
			String mobileNumber, String email, LocalDate dateOfBirth, String gender, String nationality,
			String aadharNumber, String panNumber,User user) {

		
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.user=user;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

}








	

















	








	








	
	
	

