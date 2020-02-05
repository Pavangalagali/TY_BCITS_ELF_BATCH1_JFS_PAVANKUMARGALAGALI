package com.bcits.discomproject.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.MonthlyConsumption;
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
	public BillCollected getCollectedBill(String date, String region) {
		Date newDate = null;
		try {
			newDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<MonthlyConsumption> list = dao.getCollectedBill(date, region);
		Double estimation = 0.0;
		Double collected = 0.0;
		if (list != null) {
			for (MonthlyConsumption monthlyConsumption : list) {
				if (monthlyConsumption.getStatus().equals("paid")) {
					collected += monthlyConsumption.getBill();
				}
			}
		}
		System.out.println("collected Bill" + collected);
		List<CurrentBill> bills = dao.currentBills(region);
		if (bills != null) {
			for (CurrentBill currentBill : bills) {
				estimation = estimation + currentBill.getAmount();
			}
		}
		estimation = estimation + collected;
		BillCollected collection = new BillCollected();
		collection.setCollected(collected);
		collection.setEstimaation(estimation);
		collection.setDate(newDate);
		
		return collection;
		
	}
}
