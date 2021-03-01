package com.anurag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.entities.VehicleMovement;

public interface IVehicleMovementRepository extends JpaRepository<VehicleMovement, Integer>{

}
