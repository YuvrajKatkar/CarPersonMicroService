package com.yuvraj.CarService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuvraj.CarService.entity.Car;
@Repository
public interface CarRepo extends JpaRepository<Car, Integer>{

}
