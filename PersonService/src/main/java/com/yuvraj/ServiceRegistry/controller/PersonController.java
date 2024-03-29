package com.yuvraj.ServiceRegistry.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuvraj.ServiceRegistry.entity.Person;
import com.yuvraj.ServiceRegistry.repo.PersonRepo;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonRepo repo;
	
	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person) {
		return repo.save(person);
	}
	@GetMapping("/getAll")
	public List<Person> getAll(){
		return repo.findAll();
	}
	@GetMapping("/getById/{id}")
	public Person getById(@PathVariable int id) {
		Optional<Person> optional=  repo.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	@GetMapping("/getByCarId/{id}")
	public List<Person> getByCarId(@PathVariable int id){
		return repo.findByCarId(id);
	}
}
