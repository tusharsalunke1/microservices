package com.microservice.ranga.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Component;

import com.microservice.ranga.dto.User;
import com.microservice.ranga.exception.UserNotFound;

@Component
public class UserDao {

	private static List<User> users = new ArrayList<>();
	public  static int i = 5;

	static{
		users.add(new User(1, "vaibhav", LocalDate.now().minusYears(20)));
		users.add(new User(2, "Tushar", LocalDate.now().minusYears(50)));
		users.add(new User(3, "deven", LocalDate.now().minusYears(27)));
		users.add(new User(5, "Rushikesh", LocalDate.now().minusYears(25)));
	}
	public List<User> findAll(){
		return users;
	}
	
	public User findbyId(int id){
		Predicate <? super User > predicate = user ->user.getId().equals(id);
		User user =  users.stream().filter(predicate).findFirst().orElse(null);

		return user;
	}
	
	public User adUser(User user){
			i=i++;
			user.setId(++i);
			users.add(user);
		return user;
	}
	public User deleteById(int id){
		Predicate <? super User > predicate = user ->user.getId().equals(id);
		User user =  users.stream().filter(predicate).findFirst().orElse(null);
			users.remove(user);
		return user;
	}
	 
}
