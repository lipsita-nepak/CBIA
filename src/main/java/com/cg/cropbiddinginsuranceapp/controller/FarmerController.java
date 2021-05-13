package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.exception.FarmerNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IFarmerService;


@RestController
public class FarmerController {

	@Autowired
	IFarmerService farmerService;
	

	@GetMapping("/farmer")
	public List<Farmer> retrieveAllFarmers(){
		return farmerService. retrieveAllFarmers();
	}
	
	@GetMapping("/farmer/{id}")
	public Farmer retrieveFarmerById(@PathVariable("id") int userId) {
		if(farmerService.retrieveFarmerById(userId) == null) {
			throw new FarmerNotFoundException("Farmer not found with given id: "+userId);
		}
		return farmerService. retrieveFarmerById(userId);
	}

	@PostMapping("/farmer")
	public Farmer addFarmer(@RequestBody Farmer farmer) {
		return farmerService.addFarmer(farmer);
	}
	
	@DeleteMapping("/farmer/{id}")
	public Farmer deleteFarmer(@PathVariable("id") int userId) {
		return farmerService.deleteFarmerById(userId);
	}
	
	@PatchMapping("/farmer/id/{id}")
	public Farmer updateName(@PathVariable("id") int id, @RequestBody Farmer farmer) {
		return farmerService.updateFarmerName(id, farmer);
	}
	
	/*@PatchMapping("/farmer/farmaddress/{id}")
	public Farmer updateFarmAddress(@PathVariable("id") int id, @RequestBody Farmer farmer) {
		return farmerService.updateFarmerHomeAddress(id, farmer);
	}
	
	@PatchMapping("/farmer/homeaddress/{id}")
	public Farmer updateHomeAddress(@PathVariable("id") int id, @RequestBody Farmer farmer) {
		return farmerService.updateFarmerFarmAddress(id, farmer);
	}*/
	
	@PutMapping("/farmer/{id}") 
	public Farmer updateFarmer(@PathVariable("id") int id, @RequestBody Farmer farmer) {
		return farmerService.updateFarmer(id,farmer);
	}
}
