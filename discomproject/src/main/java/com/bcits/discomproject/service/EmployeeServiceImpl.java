package com.bcits.discomproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomproject.beans.BillHistory;
import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;
import com.bcits.discomproject.dao.ConsumerDAO;
import com.bcits.discomproject.dao.EmployeeDAO;
import com.bcits.discomproject.validations.Validations;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Autowired
	private ConsumerDAO consumer;

	@Autowired
	private Validations validations;
	
	@Override
	public boolean generateBill(CurrentBill bill) {
		if (consumer.find(bill.getRrNumber()) != null) {
			if(bill.getFinalUnits() > bill.getInitialUnits()) {	
				System.out.println("generating");
				return dao.generateBill(bill);
			}
			return false;
		}
		return false;
	}

	@Override
	public List<ConsumerMaster> getAllConsumers(String region) {

		return dao.getAllConsumers(region);
	}

	@Override
	public List<SupportRequest> getSupportRequest(String rrNumber) {
		if (consumer.find(rrNumber) != null) {
			return dao.getSupportRequest(rrNumber);
		}
		return null;
	}

	@Override
	public boolean generateResponse(SupportPk supportPk, String response) {
		if(validations.supportValidation(response)) {
		return dao.generateResponse(supportPk, response);
		}
		return false;
	}

	@Override
	public List<CurrentBill> currentBills(String region) {
		return dao.currentBills(region);
	}

	@Override
	public boolean sendMail(String rrNumber) {

		return dao.sendMail(rrNumber);
	}

	@Override
	public List<BillHistory> getCollectedBill(String region) {

		return dao.getCollectedBill(region);

	}

	@Override
	public List<Object[]> getPaidBills(String region) {

		return dao.getPaidBills(region);
	}

	@Override
	public List<Object[]> getPendingBills(String region) {

		return dao.getPendingBills(region);
	}

	@Override
	public List<SupportRequest> getAllRequestSupport(String region) {
		
		return dao.getAllRequestSupport(region);
	}

	@Override
	public boolean updateDueBill(String rrNumber, Date date) {
		
		return dao.updateDueBill(rrNumber, date);
	}

	@Override
	public boolean checkForSameRegion(String region, String rrNumber) {
		ConsumerMaster consumerMaster = consumer.find(rrNumber);
		if(region.equals(consumerMaster.getRegion())) {
			return true;
		}
		return false;
	}
}
