package com.anurag.service;

import java.util.List;

import com.anurag.entities.VehicleMovement;

public interface IVehicleMovementService {
	Integer saveVehicleMovement(VehicleMovement vehicleMovement);

	List<VehicleMovement> getAllVehicleMovement();

	VehicleMovement getVehicleMovementById(Integer id);

	Integer updateVehicleMovementById(VehicleMovement vehicleMovement, Integer id);

	void deleteVehicleMovementById(Integer id);

}
