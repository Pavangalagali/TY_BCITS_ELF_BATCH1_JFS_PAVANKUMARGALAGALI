package com.bcits.discomproject.service;

import java.util.Date;
import java.util.List;

import com.bcits.discomproject.beans.BillHistory;
import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;

public interface EmployeeService {

	public boolean generateBill(CurrentBill  bill);
	
	public List<ConsumerMaster> getAllConsumers(String region);
	
	public List<SupportRequest> getSupportRequest(String rrNumber);
	
	 public boolean generateResponse(SupportPk supportPk,String response);
	 
	 public List<CurrentBill> currentBills (String region);
	 
	 public boolean sendMail(String rrNumber);
	 
	 public List<BillHistory> getCollectedBill(String region);
	 
	 public List<Object[]> getPaidBills(String region);
	 
	 public List<Object[]> getPendingBills(String region);
	 
	 public List<SupportRequest> getAllRequestSupport(String region);
	 
	 public boolean updateDueBill(String rrNumber,Date date);
}
