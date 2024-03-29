package com.yuvraj.CarService.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
@Component
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Transient
	private List<Person> persons;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int id, String name, List<Person> persons) {
		super();
		this.id = id;
		this.name = name;
		this.persons = persons;
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
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", persons=" + persons + "]";
	}
	
	
}
