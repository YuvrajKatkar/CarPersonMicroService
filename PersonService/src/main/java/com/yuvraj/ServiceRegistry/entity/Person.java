package com.yuvraj.ServiceRegistry.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int carId;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, int carId) {
		super();
		this.id = id;
		this.name = name;
		this.carId = carId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", carId=" + carId + "]";
	}
	
	
}
