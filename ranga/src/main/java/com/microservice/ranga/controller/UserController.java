package com.microservice.ranga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ranga.dto.User;
import com.microservice.ranga.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository  userRepository;
	
	@GetMapping("/getAllUsers")
	public List<User> getAlUsers(){
		List<User>user = userRepository.findAll();
		return user;
		
	}
	@PostMapping("/adduser")
	public void addUsers(@RequestBody User user){
		try {
			userRepository.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
