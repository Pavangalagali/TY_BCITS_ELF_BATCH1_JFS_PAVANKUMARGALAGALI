package com.bcits.discomproject.dao;

import java.util.List;

import com.bcits.discomproject.beans.EmployeeMaster;

public interface AdminDAO {

	public EmployeeMaster authenticate(int id, String password);
	
	public boolean grantEmployeeAccess(EmployeeMaster master);
	
	public boolean revokeEmployeeAccess(int id);

	public EmployeeMaster find(int id);
	
	public List<EmployeeMaster> getAll();
}
