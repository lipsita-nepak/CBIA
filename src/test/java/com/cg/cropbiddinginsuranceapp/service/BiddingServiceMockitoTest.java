package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.cropbiddinginsuranceapp.entity.BidStatus;
import com.cg.cropbiddinginsuranceapp.entity.Bidding;
import com.cg.cropbiddinginsuranceapp.repository.IBiddingDao;

@ExtendWith(SpringExtension.class)
class BiddingServiceMockitoTest {
	@InjectMocks
	BiddingServiceImpl bs;
	
	@MockBean
	IBiddingDao bdao;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testAdd(){
		Bidding bid=new Bidding(3,1800.0,BidStatus.CLOSED);
		Mockito.when(bdao.save(bid)).thenReturn(bid);
		Bidding b=bdao.save(bid);
		assertEquals(3,b.getBiddingId());
	}
	
	@Test 
	void testViewAll() {
		Bidding bid1=new Bidding(5,1700.0,BidStatus.CLOSED);
		Bidding bid2=new Bidding(4,1800.0,BidStatus.CLOSED);
		List<Bidding>l=new ArrayList<>();
		l.add(bid1);
		l.add(bid2);
		Mockito.when(bdao.findAll()).thenReturn(l);
		List<Bidding>bidList=bs.retriveAllBidding();
		assertEquals(2,bidList.size());
	}
	
	@Test
	void testViewById() {
		Bidding bid=new Bidding(5,1700.0,BidStatus.CLOSED);
		Mockito.when(bdao.findById(5)).thenReturn(Optional.of(bid));
		assertEquals(5,bid.getBiddingId());
	}
	
	@Test
	void testUpdateStatus() {
		Bidding bid=new Bidding(5,1700.0,BidStatus.CLOSED);
		Mockito.when(bdao.findById(5)).thenReturn(Optional.of(bid));
		bid.setBidStatus(BidStatus.SOLD);
		bs.updateBiddingStatus(5, bid);
		assertEquals(BidStatus.SOLD,BidStatus.SOLD);
	}
}
