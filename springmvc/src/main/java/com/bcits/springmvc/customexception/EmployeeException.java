package com.bcits.springmvc.customexception;

public class EmployeeException extends RuntimeException {

	public EmployeeException(String message) {
		super(message);
	}
}
