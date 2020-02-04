package com.bcits.discomproject.service;

import java.util.List;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;

public interface EmployeeService {

	public boolean generateBill(CurrentBill  bill);
	
	public List<ConsumerMaster> getAllConsumers(String region);
	
	public List<SupportRequest> getSupportRequest(String rrNumber);
	
	 public boolean generateResponse(SupportPk supportPk,String response);
}
