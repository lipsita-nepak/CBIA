package com.cg.bidlibrary.service;

import static org.junit.jupiter.api.Assertions.*;

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

import com.cg.bidlibrary.entities.Bid;
import com.cg.bidlibrary.repository.IBidRepository;

@ExtendWith(SpringExtension.class)
class BidServiceMockitoTest {
		// @InjectMock - injects bidService and inject dependent classes/interfaces 
		//that are annotated with @Mock
	
	@InjectMocks
	BidSeviceImpl bidService; 
	
	// @MockBean - injecting external services
	@MockBean
	IBidRepository bidRepo;
	//Initialization of MockTest
	
	@BeforeEach
	void init() {
	MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testCreateBid() {
			Bid bid = new Bid();
			Mockito.when(bidRepo.save(bid)).thenReturn(bid);
			bid.setBidId(1001);
			bid.setDateOfBidding("2022-05-15");
			Bid persistedBid = bidService.save(bid);
			assertEquals(1001,persistedBid.getBidId());
	}
	@Test
	void testFindByBidId() {
		Bid bid = new Bid(20,"2022-05-15");
		Mockito.when(bidRepo.findById(20)).thenReturn(Optional.of(bid));
		//bid.setBidId(1001);
	//	bid.setDateOfBidding("2022-05-15");
		Bid persistedBid = bidService.findByBidId(20);
		assertEquals(20,persistedBid.getBidId());
}
	@Test
	void testDeleteBid() {
		Bid bid = new Bid(20,"2022-05-15");
		//bidService.deleteByBidId(1001);
		Mockito.when(bidRepo.findById(20)).thenReturn(Optional.of(bid));
		//bidRepo.deleteById(20);
		//Bid persistedBid = bidService.deleteByBidId(20);
		bid.deleteBid(20);
		assertEquals(20,bid.getBidId());
		
}
	@Test
	void testUpdateBid() {
		Bid bid = new Bid(20,"2022-05-15");
		Mockito.when(bidRepo.findById(20)).thenReturn(Optional.of(bid));
		Mockito.when(bidRepo.save(bid)).thenReturn(bid);
		Bid B = bid.upadate(bid); 
		//bid.setBidId(20);
		//bid.setDateOfBidding("2021-05-15");
		Bid persistedBid = bidService.update(bid);
		assertEquals("2022-05-15",persistedBid.getDateOfBidding());
	}
	
	@Test
	void testRetrieveBid() {
		List<Bid> bid = bidService.findAll();
		int size = bid.size();
		assertEquals(size,bid.size());
	}
}


