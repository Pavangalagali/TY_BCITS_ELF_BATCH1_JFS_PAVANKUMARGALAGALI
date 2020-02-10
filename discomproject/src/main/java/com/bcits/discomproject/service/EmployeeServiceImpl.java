package com.bcits.discomproject.service;

import java.util.ArrayList;
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

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Autowired
	private ConsumerDAO consumer;

	@Override
	public boolean generateBill(CurrentBill bill) {
		if (consumer.find(bill.getRrNumber()) != null) {

			return dao.generateBill(bill);
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

		return dao.generateResponse(supportPk, response);
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
	public List<BillCollected> getMonthlyConsumption(String region) {

		return null;
	}
}
