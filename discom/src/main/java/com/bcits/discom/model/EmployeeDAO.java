package com.bcits.discom.model;

import com.bcits.discom.bean.EmployeeMaster;

public interface EmployeeDAO {
	
	EmployeeMaster getEmployee(int id, String pwd);
	boolean provideAccess(EmployeeMaster master);
}
