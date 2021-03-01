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

import com.anurag.entities.Camera;

import com.anurag.service.ICameraService;


@RestController
@RequestMapping("/camera")
class CameraController {

	@Autowired
	ICameraService cameraService;

	@PostMapping("/save")
	public ResponseEntity<String> saveCamera(@RequestBody Camera camera) {
		Integer id = cameraService.saveCamera(camera);
		return new ResponseEntity<String>(id + " id is saved", HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Camera>> getAllCamera() {
		List<Camera> list = cameraService.getAllCamera();
		return new ResponseEntity<List<Camera>>(list, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Camera> getById(@PathVariable Integer id) {
		Camera camera = cameraService.getCameraById(id);
		return new ResponseEntity<Camera>(camera, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		cameraService.deleteCameraById(id);
		return new ResponseEntity<String>(id + " id Camera is deleted", HttpStatus.OK);
	}

	@PutMapping("/updateById/{id}")
	public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody Camera camera) {
		Integer db = cameraService.updateCameraById(camera, id);
		return new ResponseEntity<String>(db + " id Camera is updated", HttpStatus.OK);
	}

}
