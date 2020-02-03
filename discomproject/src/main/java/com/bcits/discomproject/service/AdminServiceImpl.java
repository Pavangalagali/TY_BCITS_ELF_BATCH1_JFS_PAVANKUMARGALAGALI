package com.bcits.discomproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomproject.beans.EmployeeMaster;
import com.bcits.discomproject.dao.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO dao;
	
	@Override
	public EmployeeMaster authenticate(int id, String password) {
		EmployeeMaster employeeMaster = dao.find(id);
		if(employeeMaster!=null) {
			return dao.authenticate(id, password);
		}else {
			return null;
		}
	}

	@Override
	public boolean grantEmployeeAccess(EmployeeMaster master,String pwd) {
		
		if(dao.find(master.getId()) == null && master.getPassword().equals(pwd) ) {
		return dao.grantEmployeeAccess(master);
		}
		return false;
		
	}

	@Override
	public boolean revokeEmployeeAccess(int id) {
	return	dao.revokeEmployeeAccess(id);

	}

	@Override
	public List<EmployeeMaster> getAll() {
		
		return dao.getAll();
	}

}
