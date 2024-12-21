/**
 * 
 */
package com.microservice.ranga.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ranga.dao.UserDao;
import com.microservice.ranga.dto.HelloWorldBean;
import com.microservice.ranga.dto.User;
import com.microservice.ranga.exception.UserNotFound;

/**
 * @author Tushar salunke
 *
 */

@RestController
public class HelloWorldController {

	
	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld(){
		return "Hello-world";
	}
	
	
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping("/Hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello-world");
	}
	
	@GetMapping("/users")
	public List<User> getusers(){
		return userDao.findAll();
	}
	@GetMapping("/users/{id}")
	public User getuser(@PathVariable Integer id){
		User user = userDao.findbyId(id);
		if(user == null)
			throw new UserNotFound("id : "+id);
		return user;
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<User> createUsers(@Valid @RequestBody User user){
		userDao.adUser(user);
		return ResponseEntity.created(null).build();
}
	
	
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable Integer id){
		User user = userDao.deleteById(id);
		if(user == null)
			throw new UserNotFound("id : "+id);
		return user;
	}

	
}
