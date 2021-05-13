package com.cg.cropbiddinginsuranceapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bid {

@Id
	private int bidId;
	private String dateOfBidding;
	//private Object localDate;
	
	
	public Bid() {}
	public Bid(int bidId ,String dateOfBidding) {
		super();
		this.bidId = bidId;
		this.dateOfBidding = dateOfBidding;
		
	}
	//Getters & Setters
	
	
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public String getDateOfBidding() {
		return dateOfBidding;
	}
	
	public void setDateOfBidding(String pdate) {
		this.dateOfBidding = pdate;
	}
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", dateOfBidding=" + dateOfBidding + "]";
	}
	public void deleteBid(int i) {
		// TODO Auto-generated method stub
		
	}
	public Bid upadate(Bid bid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}