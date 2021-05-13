package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Bidding {
	@Id
	private int biddingId;
	private double bidPerQuintal;
	
	@Enumerated(EnumType.STRING)
	private BidStatus bidStatus;

	public Bidding() {}
	public Bidding(int biddingId, double bidPerQuintal, BidStatus bidStatus) {
		super();
		this.biddingId = biddingId;
		this.bidPerQuintal = bidPerQuintal;
		this.bidStatus = bidStatus;
	}
	public int getBiddingId() {
		return biddingId;
	}
	public void setBiddingId(int biddingId) {
		this.biddingId = biddingId;
	}
	public double getBidPerQuintal() {
		return bidPerQuintal;
	}
	public void setBidPerQuintal(double bidPerQuintal) {
		this.bidPerQuintal = bidPerQuintal;
	}
	public BidStatus getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(BidStatus bidStatus) {
		this.bidStatus = bidStatus;
	}
	
	@Override
	public String toString() {
		return "Bidding [biddingId=" + biddingId + ", bidPerQuintal=" + bidPerQuintal + ", bidStatus=" + bidStatus
				+ "]";
	}
}
