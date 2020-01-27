package com.bcits.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.customexception.EmployeeException;
import com.bcits.springmvc.dao.EmployeeDAO;

@Service(value = "service1")
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
			throw new EmployeeException("Invalid Employee ID");
		}
		EmployeeInfoBean infoBean = dao.getEmployee(empId);
		if(infoBean == null) {
			throw new EmployeeException("Employee ID Not Found");
		}
		return infoBean;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
