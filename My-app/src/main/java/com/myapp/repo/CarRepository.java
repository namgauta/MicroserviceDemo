package com.myapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.model.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	List<Car> findAll();
	
}
