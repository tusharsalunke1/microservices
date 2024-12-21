package com.microservice.ranga.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<UserNotFound> userNotFound(UserNotFound ex){
		return new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
	}
}
