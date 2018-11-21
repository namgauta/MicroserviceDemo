package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.person.model.Person;
import com.person.repo.PersonRepo;

@RestController
@CrossOrigin("*")
public class PersonController {

	@Autowired
	private PersonRepo pr;
	@GetMapping("/persons")
	@CrossOrigin("*")
	public List<Person> getUsers(){
		return pr.findAll();
	}
	@PostMapping("/save")
	@CrossOrigin("*")
	public List<Person> saveUser(@RequestBody Person user) {
		pr.save(user);
		return pr.findAll();
		
	}
	@DeleteMapping("/delete/{id}")
	@CrossOrigin("*")
	public List<Person> deleteUser(@PathVariable("id") int id) {
		Person u=pr.findById(id);
		pr.delete(u);
		return pr.findAll();
	}
	@GetMapping("/person/{id}")
	@CrossOrigin("*")
	public Person getUser(@PathVariable("id") int id){
		return pr.findById(id);
	}
}
