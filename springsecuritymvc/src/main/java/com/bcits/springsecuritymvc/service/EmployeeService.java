package com.bcits.springsecuritymvc.service;

import java.util.List;

import com.bcits.springsecuritymvc.beans.EmployeeInfo;

public interface EmployeeService {
	public boolean register(EmployeeInfo info);

	public EmployeeInfo getEmployee(int empId);

	public List<EmployeeInfo> getAllEmployee();

}
