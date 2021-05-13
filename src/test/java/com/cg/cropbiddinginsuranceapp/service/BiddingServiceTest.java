package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropbiddinginsuranceapp.entity.BidStatus;
import com.cg.cropbiddinginsuranceapp.entity.Bidding;


@SpringBootTest
class BiddingServiceTest {

	@Autowired
	IBiddingService bs;
	
	@Test
	@Disabled
	void testAdd() {
		Bidding b=new Bidding(5,1500.0,BidStatus.CLOSED);
		Bidding bid=bs.addBidding(b);
		assertEquals(5,bid.getBiddingId());
	}
	
	@Test
	void testViewAll(){
		List<Bidding> bid=bs.retriveAllBidding();
		assertEquals(bid.size(),bid.size());
	}
	
	@Test
	void testViewAllById(){
		Bidding bid=bs.findById(2);
		assertEquals(1500,bid.getBidPerQuintal());
	}
	
	@Test
	void testUpdateStatus(){
		Bidding bid=bs.findById(2);
		bid.setBidStatus(BidStatus.OPEN);
		bs.updateBiddingStatus(2, bid);
		assertEquals(BidStatus.OPEN,BidStatus.OPEN);
	}
	
}
