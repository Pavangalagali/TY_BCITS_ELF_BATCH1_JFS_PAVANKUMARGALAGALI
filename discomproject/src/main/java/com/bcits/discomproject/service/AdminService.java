package com.bcits.discomproject.service;

import java.util.List;

import com.bcits.discomproject.beans.EmployeeMaster;

public interface AdminService {

	public EmployeeMaster authenticate(int id, String password);
	
	public boolean grantEmployeeAccess(EmployeeMaster master,String pwd);
	
	public boolean revokeEmployeeAccess(int id);
	
	public List<EmployeeMaster> getAll();
}
