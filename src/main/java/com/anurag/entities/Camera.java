package com.anurag.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Camera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	@NotBlank(message = "details can't be blank")
	@Column(unique = true, nullable = false)
	@Size(min = 2,max = 100, message = "details must be minimum 2 characters and maximum 100 characters long")
	private String details;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "location_id")

	 @JsonBackReference
	private Location location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Camera(int id, String details, Location location) {
		super();
		this.id = id;
		this.details = details;
		this.location = location;
	}

	public Camera() {
		super();
		// TODO Auto-generated constructor stub
	}

}
