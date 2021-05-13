package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.cropbiddinginsuranceapp.entity.*;
import com.cg.cropbiddinginsuranceapp.exception.BidderNotFoundException;
import com.cg.cropbiddinginsuranceapp.repository.IBidderRepository;


@ExtendWith(SpringExtension.class)
class BidderServiceMockitoTest {

	@InjectMocks
	BidderServiceImpl bidService;
	
	@MockBean
	IBidderRepository bidRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@Disabled
	void testAddBidder() {
		Bidder bidder=new Bidder();
		
		Address homeAddress=new Address("1-2","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("3-4","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(90);
		bankDetails.setBank(bank);
		
		bidder.setAadharNumber("123456");
		bidder.setContactNumber("9876543210");
		bidder.setEmailId("abc@gmail.com");
		bidder.setName("sam");
		bidder.setPanNumber("67890");
		bidder.setTraderlicence("licenseA");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Mockito.when(bidRepo.save(bidder)).thenReturn(bidder);
		
		Bidder persistedBidder=bidService.addBidder(bidder);
		assertEquals("sam",persistedBidder.getName());
		assertEquals("abc@gmail.com",persistedBidder.getEmailId());
		
		
	}
	
	@Test
	@Disabled
	void testUpdateBidder() {
		
		Bidder bidder=new Bidder();
		
		Address homeAddress=new Address("8-9","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("6-7","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(900);
		bankDetails.setBank(bank);
		
		bidder.setAadharNumber("123456");
		bidder.setContactNumber("9876543210");
		bidder.setEmailId("abc@gmail.com");
		bidder.setName("Pranil");
		bidder.setUserId(3);
		bidder.setPanNumber("67890");
		bidder.setTraderlicence("licenseA");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Mockito.when(bidRepo.findById(3)).thenReturn(Optional.of(bidder));
		Mockito.when(bidRepo.save(bidder)).thenReturn(bidder);
		
		Bidder updated=bidService.updateBidder(bidder);
		System.out.println(updated);
		assertEquals("Pranil", updated.getName());
	}
	
	@Test
	@Disabled
	void testDeleteBidder() {
		Bidder bidder=new Bidder();
		Address homeAddress=new Address("1-2","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("3-4","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(90);
		bankDetails.setBank(bank);
		
		bidder.setUserId(5);
		bidder.setAadharNumber("123456");
		bidder.setContactNumber("9876543210");
		bidder.setEmailId("abc@gmail.com");
		bidder.setName("sam");
		bidder.setPanNumber("67890");
		bidder.setTraderlicence("licenseA");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Mockito.when(bidRepo.findById(5)).thenReturn(Optional.of(bidder));
		bidRepo.deleteById(5);
		Bidder persistedbid = bidService.deleteBidder(5);
		
		assertEquals(5, persistedbid.getUserId());
		
	}
	
	@Test
	@Disabled
	void testRetrieveAllBidders() {
		
		Bidder bidder=new Bidder();
		Address homeAddress=new Address("1-2","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("3-4","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(90);
		bankDetails.setBank(bank);
		
		bidder.setUserId(5);
		bidder.setAadharNumber("123456");
		bidder.setContactNumber("9876543210");
		bidder.setEmailId("abc@gmail.com");
		bidder.setName("sam");
		bidder.setPanNumber("67890");
		bidder.setTraderlicence("licenseA");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Bidder bidder1=new Bidder();
		
		Address homeAddress1=new Address("8-9","yamgal","Hyd","Telangana","501510");
		Address bankAddress1=new Address("6-7","lbnagar","hyd","Telangana","502001");
		
		Bank bank1=new Bank(2,"ICICI","123abc");
		bank1.setAddress(bankAddress1);
		
		Account bankDetails1=new Account(900);
		bankDetails1.setBank(bank1);
		
		bidder1.setAadharNumber("123456");
		bidder1.setContactNumber("9876543210");
		bidder1.setEmailId("abc@gmail.com");
		bidder1.setName("Pranil");
		bidder1.setUserId(3);
		bidder1.setPanNumber("67890");
		bidder1.setTraderlicence("licenseA");
		bidder1.setBankDetails(bankDetails1);
		bidder1.setHomeAddress(homeAddress1);
		
		List<Bidder> bidderList = new ArrayList<>();
		bidderList.add(bidder);
		bidderList.add(bidder1);
		
		Mockito.when(bidRepo.findAll()).thenReturn(bidderList);
		
		List<Bidder> bidders = bidService.retrieveAllBidders();
		assertEquals(2, bidders.size());
		
	}
	
	@Test
	@Disabled
	void testRetrieveBidderById() throws BidderNotFoundException {
		
		Bidder bidder=new Bidder();
		Address homeAddress=new Address("1-2","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("3-4","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(90);
		bankDetails.setBank(bank);
		
		bidder.setUserId(5);
		bidder.setAadharNumber("123456");
		bidder.setContactNumber("9876543210");
		bidder.setEmailId("abc@gmail.com");
		bidder.setName("sam");
		bidder.setPanNumber("67890");
		bidder.setTraderlicence("licenseA");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Mockito.when(bidRepo.findById(5)).thenReturn(Optional.of(bidder));
		Bidder persistedbid = bidService.retrieveBidderById(5);
		assertEquals("sam",persistedbid.getName());
		
	}

}
