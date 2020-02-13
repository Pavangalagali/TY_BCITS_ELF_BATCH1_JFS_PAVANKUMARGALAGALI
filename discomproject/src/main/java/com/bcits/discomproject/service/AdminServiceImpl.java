package com.bcits.discomproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomproject.beans.EmployeeMaster;
import com.bcits.discomproject.dao.AdminDAO;
import com.bcits.discomproject.validations.Validations;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO dao;

	@Autowired
	private Validations validations;

	@Override
	public EmployeeMaster authenticate(int id, String password) {
		EmployeeMaster employeeMaster = dao.find(id);
		if (employeeMaster != null) {
			return dao.authenticate(id, password);
		} else {
			return null;
		}
	}

	@Override
	public boolean grantEmployeeAccess(EmployeeMaster master, String pwd) {
		if (validations.validateEmployeeDeatils(master)) {
			if (dao.find(master.getId()) == null && master.getPassword().equals(pwd)) {
				return dao.grantEmployeeAccess(master);
			}
		}
		return false;

	}

	@Override
	public boolean revokeEmployeeAccess(int id) {
		if(validations.validateNumber(id+"")) {
		return dao.revokeEmployeeAccess(id);
		}
		return false;

	}

	@Override
	public List<EmployeeMaster> getAll() {
		return dao.getAll();
	}

}
