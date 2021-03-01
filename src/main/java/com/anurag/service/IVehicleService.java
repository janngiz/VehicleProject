package com.anurag.service;

import java.util.List;

import com.anurag.entities.Vehicle;

public interface IVehicleService {

	Integer saveVehicle(Vehicle vehicle);

	List<Vehicle> getAllVehicle();

	Vehicle getVehicleById(Integer id);

	Integer updateVehicleById(Vehicle vehicle, Integer id);

	void deleteVehicleById(Integer id);

}
