package com.anurag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.entities.Vehicle;
import com.anurag.service.IVehicleService;

@RestController
@RequestMapping("/vehicle")
 class VehicleController {
	
	@Autowired
	IVehicleService vehicleService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveVehicle(@RequestBody Vehicle vehicle) {
	 Integer id =	vehicleService.saveVehicle(vehicle);
		return new ResponseEntity<String>(id +" id is saved",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Vehicle>> getAllVehicle() {
	 List<Vehicle> list =	vehicleService.getAllVehicle();
		return new ResponseEntity<List<Vehicle>>( list,HttpStatus.OK);
	}
	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Vehicle> getById(@PathVariable Integer id) {
	 Vehicle vehicle =	vehicleService.getVehicleById(id);
		return new ResponseEntity<Vehicle>(vehicle ,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
	 	vehicleService.deleteVehicleById(id);
		return new ResponseEntity<String>(id +" id vehicle is deleted" ,HttpStatus.OK);
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody Vehicle vehicle) {
	 	Integer db = vehicleService.updateVehicleById(vehicle, id);
		return new ResponseEntity<String>(db +" id vehicle is updated" ,HttpStatus.OK);
	}
	
	
	

}
