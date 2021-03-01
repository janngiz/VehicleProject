package com.anurag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.entities.Camera;

public interface ICameraRepository extends JpaRepository<Camera, Integer> {

}
