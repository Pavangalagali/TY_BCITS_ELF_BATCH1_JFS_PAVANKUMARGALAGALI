package com.bcits.discomproject.service;

import java.util.List;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.beans.SupportRequest;

public interface ConsumerService {

	public boolean signUpConsumer(ConsumerMaster consumerMaster, String confirmpwd);

	public ConsumerMaster authenticate(String rrNumber, String password);

	public List<MonthlyConsumption> consumptions(String rrNumber);
	
	public CurrentBill currentBill(String rrNumber);
	
	public boolean billPayment(String rrNumber);
	
	public boolean supportRequest(String rrNumber, String msg);
	
	public List<SupportRequest> getSupportRequest(String rrNumber);
	
	
}
