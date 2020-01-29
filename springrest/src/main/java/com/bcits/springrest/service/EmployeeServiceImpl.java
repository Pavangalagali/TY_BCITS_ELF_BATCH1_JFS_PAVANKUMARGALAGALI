package com.bcits.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springrest.beans.EmployeeInfoBean;
import com.bcits.springrest.customeception.EmployeeException;
import com.bcits.springrest.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		System.out.println("\n\n\n\nService -1 \n\n\n\n");
		return dao.authenticate(empId, password);
	}

	@Override
	public boolean addemployee(EmployeeInfoBean infoBean) {
		if (infoBean.getEmpId() < 1) {

			return false;
		}

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
		if (infoBean.getEmpId() < 1) {
			return false;
		} else {

			if (dao.getEmployee(infoBean.getEmpId()) != null) {
				return dao.updateEmployee(infoBean);
			} else {
				return false;
			}
		}

	}// end od update

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if (empId < 1) {
			throw new EmployeeException("Invalid Id");
		}
		
		return dao.getEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

}