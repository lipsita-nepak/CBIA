package com.cg.bidlibrary.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bidlibrary.entities.Bid;

@SpringBootTest
class BidServiceTest {
@Autowired
IBidService bidService;

	@Test
	@Disabled
	void testSaveBid() {
		Bid bid = new Bid();
		bid.setBidId(1001);
		bid.setDateOfBidding("2022-05-15");
		Bid persistedBid = bidService.save(bid);
		assertEquals(1001,persistedBid.getBidId());
	}
	
	@Test
	@Disabled
	void testDeleteBid() {
		Bid bid = bidService.deleteByBidId(1001);
		assertEquals(1001,bid.getBidId());
		
}
	
	@Test
	@Disabled
	void testUpdateBid() {
		Bid bid = new Bid();
		bid.setBidId(20);
		bid.setDateOfBidding("2021-05-15");
		Bid persistedBid = bidService.update(bid);
		assertEquals("2021-05-15",persistedBid.getDateOfBidding());
	}
	
	@Test
	
	void testRetrieveBid() {
		List<Bid> bid = bidService.findAll();
		int size = bid.size();
		assertEquals(size,bid.size());
	}
	
	@Test
	
	void testRetrieveBidById() {
		Bid bid = bidService.findByBidId(20);
		
		assertEquals(20,bid.getBidId());
		}
		
}


