package com.anurag.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	

	@NotBlank(message = "number can't be blank")
	@Column(unique = true, nullable = false)
	@Size(min = 2,max = 10, message = "number must be minimum 2 characters and maximum 10 characters long")
	private String number;
	

	@NotBlank(message = "color can't be blank")
	@Column(unique = true, nullable = false)
	@Size(min = 2,max = 20, message = "color must be minimum 2 characters and maximum 20 characters long")
	private String color;
	

	@NotBlank(message = "name can't be blank")
	@Column(unique = true, nullable = false)
	@Size(min = 2,max = 50, message = "Name must be minimum 2 characters and maximum 50 characters long")
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vehicle(int id, String number, String color, String name) {
		super();
		this.id = id;
		this.number = number;
		this.color = color;
		this.name = name;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
