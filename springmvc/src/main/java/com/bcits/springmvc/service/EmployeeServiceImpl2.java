package com.bcits.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.dao.EmployeeDAO;

@Service(value = "service2")
public class EmployeeServiceImpl2 implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		System.out.println("\n\n\n\nService -2 \n\n\n\n");
		return dao.authenticate(empId, password);
	}

	@Override
	public boolean addemployee(EmployeeInfoBean infoBean) {

		return dao.addemployee(infoBean);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		if (empId < 1) {

			return false;
		}
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean infoBean) {

		return dao.updateEmployee(infoBean);
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if (empId < 1) {
			return null;
		}
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
