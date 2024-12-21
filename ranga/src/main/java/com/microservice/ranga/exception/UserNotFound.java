package com.microservice.ranga.exception;

//@ResponseStatus(code= HttpStatus.NOT_FOUND)
//@ControllerAdvice
public class UserNotFound extends RuntimeException {

	public UserNotFound(String message){
		super(message);
	}
}
