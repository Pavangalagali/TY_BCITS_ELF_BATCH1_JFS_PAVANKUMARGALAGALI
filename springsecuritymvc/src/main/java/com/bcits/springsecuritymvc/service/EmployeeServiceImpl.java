package com.bcits.springsecuritymvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bcits.springsecuritymvc.beans.EmployeeInfo;
import com.bcits.springsecuritymvc.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean register(EmployeeInfo info) {
		if(info.getEmpId() < 1) {
			return false;
		}
		if (info != null) {
			info.setPassword(passwordEncoder.encode(info.getPassword()));
		}
		return dao.register(info);
	}

	@Override
	public EmployeeInfo getEmployee(int empId) {
		if (empId < 1) {
			return null;
		}
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfo> getAllEmployee() {
		return dao.getAllEmployee();
	}

	
	
}
