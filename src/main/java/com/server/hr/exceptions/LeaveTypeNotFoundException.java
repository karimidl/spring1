package com.server.hr.exceptions;

public class LeaveTypeNotFoundException extends RuntimeException {
   
	public LeaveTypeNotFoundException(String message) {
		super(message);
	}
}
