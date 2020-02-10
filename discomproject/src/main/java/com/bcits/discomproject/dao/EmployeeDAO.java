package com.bcits.discomproject.dao;

import java.util.List;

import com.bcits.discomproject.beans.BillHistory;
import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;

public interface EmployeeDAO {

	public boolean generateBill(CurrentBill  bill);
	
	public List<ConsumerMaster> getAllConsumers(String region);
	
	public List<SupportRequest> getSupportRequest(String rrNumber);

	 public boolean generateResponse(SupportPk supportPk,String response);
	 
	 public List<CurrentBill> currentBills (String region);
	 
	 public boolean sendMail(String rrNumber);
	 
	 public List<BillHistory> getCollectedBill(String region);
	 
	 public List<Object[]> getEstimation(String region);
	 
	 public List<Object[]> getPaidBills(String region);
	 
	 public List<Object[]> getPendingBills(String region);
}
