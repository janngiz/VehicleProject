package com.anurag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.entities.Location;
import com.anurag.exception.RequiredNotFoundException;
import com.anurag.repository.ILocationRepository;

@Service
public class LocationServiceImp implements ILocationService {

	@Autowired
	ILocationRepository locationRepo;
	
	@Override
	public Integer saveLocation(Location location) {
	Integer id =	locationRepo.save(location).getId();
		return id;
	}

	@Override
	public List<Location> getAllLocation() {
	List<Location> list =	locationRepo.findAll();
		return list;
	}

	@Override
	public Location getLocationById(Integer id) {
       Optional<Location> opt =  locationRepo.findById(id);
		
		Location  location = opt.orElseThrow(
				()-> new RequiredNotFoundException("Location not found")
				);
		return location;
	}

	@Override
	public Integer updateLocationById(Location location, Integer id) {
		location.setId(id);
		Integer db =locationRepo.save(location).getId();
		return db;
	}

	@Override
	public void deleteLocationById(Integer id) {
		Location location = getLocationById(id);
		locationRepo.delete(location);

	}

}
