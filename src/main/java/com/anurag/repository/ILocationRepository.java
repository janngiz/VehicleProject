package com.anurag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.entities.Location;

public interface ILocationRepository extends JpaRepository<Location, Integer> {

}
