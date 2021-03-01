package com.anurag.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;

@Entity
public class VehicleMovement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "location_id")
	private Location location;
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "camera_id")
	private Camera camera;
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	public VehicleMovement(Integer id, Vehicle vehicle, Location location, Camera camera) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.location = location;
		this.camera = camera;
	}
	public VehicleMovement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
