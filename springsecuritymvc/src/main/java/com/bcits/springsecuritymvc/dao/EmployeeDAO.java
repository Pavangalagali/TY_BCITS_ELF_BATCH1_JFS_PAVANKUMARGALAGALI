package com.bcits.springsecuritymvc.dao;

import java.util.List;

import com.bcits.springsecuritymvc.beans.EmployeeInfo;

public interface EmployeeDAO {
	
	public boolean register(EmployeeInfo  info);
	
	public EmployeeInfo getEmployee(int empId);
	
	public List<EmployeeInfo> getAllEmployee();
	
	
}
