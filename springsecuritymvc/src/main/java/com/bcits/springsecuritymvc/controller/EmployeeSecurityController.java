package com.bcits.springsecuritymvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.springsecuritymvc.beans.EmployeeInfo;
import com.bcits.springsecuritymvc.service.EmployeeService;

@Controller
public class EmployeeSecurityController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}

	@GetMapping("/register")
	public String getregisterForm() {
		return "register";
	}

	@PostMapping("/register")
	public String register(EmployeeInfo info, ModelMap map) {
		boolean isRegistered = service.register(info);
		if (isRegistered) {
			map.addAttribute("msg", "Registred Successfully");
		} else {
			map.addAttribute("errMsg", "Registration failed");
		}
		return "register";
	}

	@GetMapping("/adminHome")
	public String getAdmonHome() {
		return "adminHome";
	}

	@GetMapping("/userHome")
	public String getuserHome() {
		return "userHome";
	}

	@GetMapping("/getEmployeeForm")
	public String getSearchForm() {
		return "searchPage";
	}

	@GetMapping("/getEmployee")
	public String getEmployee(int empId, ModelMap map) {
		EmployeeInfo employeeInfo = service.getEmployee(empId);
		map.addAttribute("employeeInfo", employeeInfo);
		return "searchPage";
	}
	
	@GetMapping("/getAllEMployee")
	public String getAllEmployee(ModelMap map) {
		map.addAttribute("employees", service.getAllEmployee());
		return "getAllEmployee";
	}
}
