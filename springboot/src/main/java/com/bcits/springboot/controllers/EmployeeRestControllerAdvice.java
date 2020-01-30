package com.bcits.springboot.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bcits.springboot.beans.EmployeeResponse;
import com.bcits.springboot.exception.EmployeeException;

@RestControllerAdvice
public class EmployeeRestControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponse handleEmployeeException(EmployeeException exception) {
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(501);
		response.setMessage("exception");
		response.setDescription(exception.getMessage());
		return response;
	}

}
