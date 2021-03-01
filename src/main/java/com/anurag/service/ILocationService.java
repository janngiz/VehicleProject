package com.anurag.service;

import java.util.List;

import com.anurag.entities.Location;


public interface ILocationService {
	
	Integer saveLocation(Location location);

	List<Location> getAllLocation();

	Location getLocationById(Integer id);

	Integer updateLocationById(Location location, Integer id);

	void deleteLocationById(Integer id);

}
