package com.yuvraj.CarService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yuvraj.CarService.entity.Person;


@FeignClient(name="personservice")
public interface PersonCommunicationService {
	@PostMapping("/person/savePerson")
	public Person savePerson(@RequestBody Person person);
	@GetMapping("/person/getAll")
	public List<Person> getAll();
	@GetMapping("/person/getById/{id}")
	public Person getById(@PathVariable int id) ;
	@GetMapping("/person/getByCarId/{id}")
	public List<Person> getByCarId(@PathVariable int id);
}
