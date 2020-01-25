package com.bcits.springmvc.dao;

import java.util.List;

import com.bcits.springmvc.beans.EmployeeInfoBean;

public interface EmployeeDAO {

	public EmployeeInfoBean authenticate(int empId, String password);

	public boolean addemployee(EmployeeInfoBean infoBean);

	public boolean deleteEmployee(int empId);

	public boolean updateEmployee(EmployeeInfoBean infoBean);

	public EmployeeInfoBean getEmployee(int empId);

	public List<EmployeeInfoBean> getAllEmployees();
}
