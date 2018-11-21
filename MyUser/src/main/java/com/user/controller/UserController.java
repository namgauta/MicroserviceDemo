package com.user.controller;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.repo.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {

	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;	
	@Autowired
	private AmqpTemplate at;
	@Autowired
	private UserRepository ur;
	
	@GetMapping("/users")
	@CrossOrigin("*")
	public List<User> getUsers(){
		return ur.findAll();
	}
	@PostMapping("/saveUser")
	public List<User> saveUser(@RequestBody User user) {
		ur.save(user);
		at.convertAndSend(exchange, routingkey, user);
		return ur.findAll();
		
	}
	@DeleteMapping("/delete/{accNo}")
	public List<User> deleteUser(@PathVariable("accNo") int accNo) {
		User u=ur.findByAccNo(accNo);
		ur.delete(u);
		return ur.findAll();
	}
	
}
