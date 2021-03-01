package com.anurag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.entities.Camera;
import com.anurag.exception.RequiredNotFoundException;
import com.anurag.repository.ICameraRepository;

@Service
public class CameraServiceImp implements ICameraService {

	@Autowired
	ICameraRepository cameraRepo;
	
	@Override
	public Integer saveCamera(Camera camera) {
	Integer id =	cameraRepo.save(camera).getId();
		return id;
	}

	@Override
	public List<Camera> getAllCamera() {
    List<Camera> list = cameraRepo.findAll();
		return list;
	}

	@Override
	public Camera getCameraById(Integer id) {
		Optional<Camera> opt =  cameraRepo.findById(id);
		
		Camera  camera = opt.orElseThrow(
				()-> new RequiredNotFoundException("Camera not found")
				);
		return camera;
	}

	@Override
	public Integer updateCameraById(Camera camera, Integer id) {
		camera.setId(id);
		Integer db = cameraRepo.save(camera).getId();
		return db;
	}

	@Override
	public void deleteCameraById(Integer id) {
	 Camera camera =	getCameraById(id);
		cameraRepo.delete(camera);

	}

}
