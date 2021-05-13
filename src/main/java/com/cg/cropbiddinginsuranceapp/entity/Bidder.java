package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.Entity;

@Entity
public class Bidder extends Person {
	
	private String traderlicence;
	
	//Constructors
	
	public Bidder() {}

	public Bidder(String traderlicence) {
		super();
		this.traderlicence = traderlicence;
	}

	public String getTraderlicence() {
		return traderlicence;
	}

	public void setTraderlicence(String traderlicence) {
		this.traderlicence = traderlicence;
	}

	@Override
	public String toString() {
		return "Bidder [traderlicence=" + traderlicence + "]";
	}

	
	
	

}

