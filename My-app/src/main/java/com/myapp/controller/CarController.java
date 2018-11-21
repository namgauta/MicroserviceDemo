package com.myapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.Car;
import com.myapp.repo.CarRepository;

@RestController
@CrossOrigin(origins = "*")
public class CarController {

	@Autowired
	CarRepository cr;
	
	@PostMapping("/save")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> save(@RequestBody Car car) {
		cr.save(car);
		return new ResponseEntity<String>("Car created",HttpStatus.CREATED);
	}
	
	@GetMapping("/cars")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Car>> getAll(){
		return new ResponseEntity<List<Car>>(cr.findAll(),HttpStatus.OK);
	}
	
}
