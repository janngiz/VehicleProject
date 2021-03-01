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

import com.anurag.entities.Location;

import com.anurag.service.ILocationService;


@RestController
@RequestMapping("/location")
class LocationController {

	@Autowired
	ILocationService locationService;

	@PostMapping("/save")
	public ResponseEntity<String> saveLocation(@RequestBody Location location) {
		Integer id = locationService.saveLocation(location);
		return new ResponseEntity<String>(id + " id is saved", HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Location>> getAllLocation() {
		List<Location> list = locationService.getAllLocation();
		return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Location> getById(@PathVariable Integer id) {
		Location Location = locationService.getLocationById(id);
		return new ResponseEntity<Location>(Location, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		locationService.deleteLocationById(id);
		return new ResponseEntity<String>(id + " id Location is deleted", HttpStatus.OK);
	}

	@PutMapping("/updateById/{id}")
	public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody Location Location) {
		Integer db = locationService.updateLocationById(Location, id);
		return new ResponseEntity<String>(db + " id Location is updated", HttpStatus.OK);
	}

}
