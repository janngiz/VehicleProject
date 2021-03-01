package com.anurag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.entities.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

}
