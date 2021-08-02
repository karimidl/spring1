package com.server.hr.exceptions;

public class UserNotFoundException extends RuntimeException {
   
	public UserNotFoundException(String message) {
		super(message);
	}
}
