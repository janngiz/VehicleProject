package com.anurag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.entities.VehicleMovement;
import com.anurag.exception.RequiredNotFoundException;
import com.anurag.repository.IVehicleMovementRepository;

@Service
public class VehicleMovementServiceImp implements IVehicleMovementService {

	@Autowired
	IVehicleMovementRepository vehicleMovementRepo;
	
	@Override
	public Integer saveVehicleMovement(VehicleMovement vehicleMovement) {
	Integer id =	vehicleMovementRepo.save(vehicleMovement).getId();
		return id;
	}

	@Override
	public List<VehicleMovement> getAllVehicleMovement() {
    List<VehicleMovement> list = vehicleMovementRepo.findAll();
		return list;
	}

	@Override
	public VehicleMovement getVehicleMovementById(Integer id) {
		Optional<VehicleMovement> opt =  vehicleMovementRepo.findById(id);
		
		VehicleMovement  vehicleMovement = opt.orElseThrow(
				()-> new RequiredNotFoundException("VehicleMovement not found")
				);
		return vehicleMovement;
	}

	@Override
	public Integer updateVehicleMovementById(VehicleMovement vehicleMovement, Integer id) {
		vehicleMovement.setId(id);
		Integer db = vehicleMovementRepo.save(vehicleMovement).getId();
		return db;
	}

	@Override
	public void deleteVehicleMovementById(Integer id) {
	 VehicleMovement vehicleMovement =	getVehicleMovementById(id);
		vehicleMovementRepo.delete(vehicleMovement);

	}

}
