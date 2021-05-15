package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.Entity;

@Entity
public class Bidder extends Person {
	
	private String traderLicence;
	
	//Constructors
	
	public Bidder() {}


	public Bidder(String traderLicence, String name, String contactNumber, String emailId, String aadharNumber, String panNumber) {
		super(name, contactNumber, emailId, aadharNumber, panNumber);
		this.traderLicence=traderLicence;
	}

	public String getTraderlicence() {
		return traderLicence;
	}

	public void setTraderlicence(String traderlicence) {
		this.traderLicence = traderlicence;
	}


	@Override
	public String toString() {
		return "Bidder [traderLicence=" + traderLicence + ", getUserId()=" + getUserId() + ", getName()=" + getName()
				+ ", getContactNumber()=" + getContactNumber() + ", getEmailId()=" + getEmailId()
				+ ", getHomeAddress()=" + getHomeAddress() + ", getBankDetails()=" + getBankDetails()
				+ ", getAadharNumber()=" + getAadharNumber() + ", getPanNumber()=" + getPanNumber() + "]";
	}

	

	
	
	

}

