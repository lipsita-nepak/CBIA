package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.repository.IFarmerRepository;


@Service
public class FarmerServiceImpl implements IFarmerService {

	@Autowired
	IFarmerRepository farmerRepo;
	
	@Override
	public Farmer addFarmer(Farmer farmer) {
		return farmerRepo.save(farmer);
	}

	@Override
	public Farmer updateFarmer(int id,Farmer farmer) {
		Optional<Farmer> f = farmerRepo.findById(id);
		if(!f.isPresent()) {
			return null;
		}
		f.get().setName(farmer.getName());
		f.get().setContactNumber(farmer.getContactNumber());
		f.get().setEmailId(farmer.getEmailId());
		f.get().setAadharNumber(farmer.getAadharNumber());
		f.get().setPanNumber(farmer.getPanNumber());
		f.get().setHomeAddress(farmer.getHomeAddress());
		f.get().setFarmAddress(farmer.getFarmAddress());
		f.get().setBankDetails(farmer.getBankDetails());
		return farmerRepo.save(f.get());
	}
	
	@Override
	public Farmer updateFarmerName(int id, Farmer farmer) {
		Optional<Farmer> f = farmerRepo.findById(id);
		if(!f.isPresent()) {
			return null;
		}
		f.get().setName(farmer.getName());
		return farmerRepo.save(f.get());
	}
	
	/*@Override
	public Farmer updateFarmerHomeAddress(int id, Farmer farmer) {
		Optional<Farmer> f = farmerRepo.findById(id);
		if(!f.isPresent()) {
			return null;
		}
		f.get().setHomeAddress(farmer.getHomeAddress());;
		return farmerRepo.save(f.get());
	}
	
	@Override
	public Farmer updateFarmerFarmAddress(int id, Farmer farmer) {
		Optional<Farmer> f = farmerRepo.findById(id);
		if(!f.isPresent()) {
			return null;
		}
		f.get().setFarmAddress(farmer.getFarmAddress());;
		return farmerRepo.save(f.get());
	}*/

	@Override
	public Farmer deleteFarmerById(int id) {
		Optional<Farmer> f = farmerRepo.findById(id);
		if(!f.isPresent()) {
			return null;
		}
		farmerRepo.deleteById(id);
		return f.get();
	}

	@Override
	public List<Farmer> retrieveAllFarmers() {
		return farmerRepo.findAll();
	}

	@Override
	public Farmer retrieveFarmerById(int id) {
		Optional<Farmer> f = farmerRepo.findById(id);
		if(!f.isPresent()) {
			return null;
		}
		return f.get();
	}
}
