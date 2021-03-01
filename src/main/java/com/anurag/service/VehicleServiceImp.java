package com.anurag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.entities.Vehicle;
import com.anurag.exception.RequiredNotFoundException;
import com.anurag.repository.IVehicleRepository;

@Service
public class VehicleServiceImp implements IVehicleService {

	@Autowired
	IVehicleRepository vehicleRepo;
	
	@Override
	public Integer saveVehicle(Vehicle vehicle) {
	Integer id =	vehicleRepo.save(vehicle).getId();
		return id;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
    List<Vehicle> list = vehicleRepo.findAll();
		return list;
	}

	@Override
	public Vehicle getVehicleById(Integer id) {
		Optional<Vehicle> opt =  vehicleRepo.findById(id);
		
		Vehicle  vehicle = opt.orElseThrow(
				()-> new RequiredNotFoundException("Vehicle not found")
				);
		return vehicle;
	}

	@Override
	public Integer updateVehicleById(Vehicle vehicle, Integer id) {
		vehicle.setId(id);
		Integer db =vehicleRepo.save(vehicle).getId();
		return db;
	}

	@Override
	public void deleteVehicleById(Integer id) {
	 Vehicle vehicle =	getVehicleById(id);
		vehicleRepo.delete(vehicle);

	}

}
