package com.cg.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Land_Verification_Table")
public class LandVerificationOfficer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int landuserId;
	private String officerName;
	private String officerContact;
	@OneToOne
	private User users;

//constructors
	public LandVerificationOfficer(int landuserId, String officerName, String officerContact, User users) {
		super();
		this.landuserId = landuserId;
		this.officerName = officerName;
		this.officerContact = officerContact;
		this.users = users;
	}
	public LandVerificationOfficer() {
		super();
	}
	public int getLanduserId() {
		return landuserId;
	}
	public void setLanduserId(int landuserId) {
		this.landuserId = landuserId;
	}
	public String getOfficerName() {
		return officerName;
	}
	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}
	public String getOfficerContact() {
		return officerContact;
	}
	public void setOfficerContact(String officerContact) {
		this.officerContact = officerContact;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "LandVerificationOfficer [landuserId=" + landuserId + ", officerName=" + officerName
				+ ", officerContact=" + officerContact + ", users=" + users + "]";
	}


}
