package com.cg.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Finance_Verification_Officer")
public class FinanceVerificationOfficer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int finVerUserId;
	private String finOfficerName;
	private String finOfficerContact;
	@OneToOne
	private User users;
	
	//default constructor
	public FinanceVerificationOfficer() {
		super();
	}
	
	//constructors
	public FinanceVerificationOfficer(int finVerUserId, String finOfficerName, String finOfficerContact, User users) {
		super();
		this.finVerUserId = finVerUserId;
		this.finOfficerName = finOfficerName;
		this.finOfficerContact = finOfficerContact;
		this.users = users;
	}
	

//to string
	@Override
	public String toString() {
		return "FinanceVerificationOfficer [finVerUserId=" + finVerUserId + ", finOfficerName=" + finOfficerName
				+ ", finOfficerContact=" + finOfficerContact + ", users=" + users + "]";
	}


	public int getFinVerUserId() {
		return finVerUserId;
	}


	public void setFinVerUserId(int finVerUserId) {
		this.finVerUserId = finVerUserId;
	}


	public String getFinOfficerName() {
		return finOfficerName;
	}


	public void setFinOfficerName(String finOfficerName) {
		this.finOfficerName = finOfficerName;
	}


	public String getFinOfficerContact() {
		return finOfficerContact;
	}


	public void setFinOfficerContact(String finOfficerContact) {
		this.finOfficerContact = finOfficerContact;
	}


	public User getUsers() {
		return users;
	}


	public void setUsers(User users) {
		this.users = users;
	}


	
}
