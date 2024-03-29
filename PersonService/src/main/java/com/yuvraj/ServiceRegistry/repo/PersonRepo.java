package com.yuvraj.ServiceRegistry.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuvraj.ServiceRegistry.entity.Person;
@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>{

	List<Person> findByCarId(int id);

}
