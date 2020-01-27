package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcits.springmvc.customexception.EmployeeException;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	public String handleEmployeeException(EmployeeException employeeException, HttpServletRequest req) {
		req.setAttribute("errMsg", employeeException.getMessage());
		return "errorPage";

	}
}
