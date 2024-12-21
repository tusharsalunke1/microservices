package com.microservice.ranga.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservice.ranga.entity.Post;


@Entity(name= "user_details")
public class User {

	@Id
	@GeneratedValue
	private Integer id ; 
	
	@Size(min=2)
	private String name;
	
	@Past
	private LocalDate birthDate;
	
	
	@OneToMany(mappedBy = "user")
	//@JsonIgnore
	private List<Post> post;
	
	
	public List<Post> getPost() {
		return post;
	}


	public void setPost(List<Post> post) {
		this.post = post;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public User(){
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
