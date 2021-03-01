package com.anurag.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Location {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	

	@NotBlank(message = "location name can't be blank")
	@Column(unique = true, nullable = false)
	@Size(min = 2,max = 100, message = "location name must be minimum 2 characters and maximum 100 characters long")
	
	String locationName;
	
	@OneToMany(mappedBy ="location")
	@JsonManagedReference
	private List<Camera> cameras;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<Camera> getCameras() {
		return cameras;
	}

	public void setCameras(List<Camera> cameras) {
		this.cameras = cameras;
	}

	public Location(int id, String locationName, List<Camera> cameras) {
		super();
		this.id = id;
		this.locationName = locationName;
		this.cameras = cameras;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
