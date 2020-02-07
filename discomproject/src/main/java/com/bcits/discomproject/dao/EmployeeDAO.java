package com.bcits.discomproject.dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;
import com.bcits.discomproject.service.BillCollected;

public interface EmployeeDAO {

	public boolean generateBill(CurrentBill  bill);
	
	public List<ConsumerMaster> getAllConsumers(String region);
	
	public List<SupportRequest> getSupportRequest(String rrNumber);

	 public boolean generateResponse(SupportPk supportPk,String response);
	 
	 public List<CurrentBill> currentBills (String region);
	 
	 public boolean sendMail(String rrNumber);
	 
	 public List<MonthlyConsumption> getCollectedBill(Date date, String region);
	 
	 public ResultSet getMonthlyConsumption(String region);
}
