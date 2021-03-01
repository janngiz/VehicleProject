package com.anurag.service;

import java.util.List;

import com.anurag.entities.Camera;

public interface ICameraService {
	
	Integer saveCamera(Camera camera);

	List<Camera> getAllCamera();

	Camera getCameraById(Integer id);

	Integer updateCameraById(Camera camera, Integer id);

	void deleteCameraById(Integer id);
}
