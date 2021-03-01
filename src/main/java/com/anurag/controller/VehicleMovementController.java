package com.anurag.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.entities.VehicleMovement;
import com.anurag.repository.IVehicleMovementRepository;
import com.anurag.service.IVehicleMovementService;
import com.anurag.util.PDFGenerator;


@RestController
@RequestMapping("/vehicleMovement")
class VehicleMovementController {

	@Autowired
	IVehicleMovementService vehicleMovementService;
	
	@Autowired
	IVehicleMovementRepository vehicleMovementRepo;
	
	@GetMapping(value="/vehicleMovements",
			produces =MediaType.APPLICATION_PDF_VALUE
			)
	public ResponseEntity<InputStreamResource> vehicleReport() throws IOException {
		
		List<VehicleMovement> vehicleMovements = vehicleMovementRepo.findAll();
		
		ByteArrayInputStream bis = PDFGenerator.customerPDFReport(vehicleMovements);
		
		HttpHeaders headers = new  HttpHeaders();
		headers.add("Content-Disposition","inline;filename=customers.pdf");
		
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	
	

	@PostMapping("/save")
	public ResponseEntity<String> saveVehicleMovement(@RequestBody VehicleMovement vehicleMovement) {
		Integer id = vehicleMovementService.saveVehicleMovement(vehicleMovement);
		return new ResponseEntity<String>(id + " id is saved", HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<VehicleMovement>> getAllVehicleMovement() {
		List<VehicleMovement> list = vehicleMovementService.getAllVehicleMovement();
		return new ResponseEntity<List<VehicleMovement>>(list, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<VehicleMovement> getById(@PathVariable Integer id) {
		VehicleMovement VehicleMovement = vehicleMovementService.getVehicleMovementById(id);
		return new ResponseEntity<VehicleMovement>(VehicleMovement, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		vehicleMovementService.deleteVehicleMovementById(id);
		return new ResponseEntity<String>(id + " id VehicleMovement is deleted", HttpStatus.OK);
	}

	@PutMapping("/updateById/{id}")
	public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody VehicleMovement vehicleMovement) {
		Integer db = vehicleMovementService.updateVehicleMovementById(vehicleMovement, id);
		return new ResponseEntity<String>(db + " id VehicleMovement is updated", HttpStatus.OK);
	}

}
