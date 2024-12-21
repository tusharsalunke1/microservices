package com.microservice.ranga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.ranga.dto.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
