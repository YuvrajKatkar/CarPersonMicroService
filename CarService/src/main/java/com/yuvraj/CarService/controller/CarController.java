package com.yuvraj.CarService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuvraj.CarService.PersonCommunicationService;
import com.yuvraj.CarService.entity.Car;
import com.yuvraj.CarService.entity.Person;
import com.yuvraj.CarService.repo.CarRepo;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarRepo repo;
	
	@Autowired
	private PersonCommunicationService personCommunicationService;
	@PostMapping("/saveCar")
	public Car saveCar(@RequestBody Car car) {
		return repo.save(car);
	}
	@GetMapping("/getById/{id}")
	public Car getById(@PathVariable int id) {
		Optional<Car> optional = repo.findById(id);
		if(optional.isPresent()) {
			List<Person> persons = personCommunicationService.getByCarId(id);
			Car car = optional.get();
			car.setPersons(persons);
			return car;
		}
		return null;
	}
	@GetMapping("/getAll")
	public List<Car> getAll(){
		List<Car> cars = repo.findAll();
		List<Car>  actualCars = cars.stream().map(car->{
			List<Person> persons = personCommunicationService.getByCarId(car.getId());
			car.setPersons(persons);
			return car;
		}).toList();
		return actualCars;
	}
}
