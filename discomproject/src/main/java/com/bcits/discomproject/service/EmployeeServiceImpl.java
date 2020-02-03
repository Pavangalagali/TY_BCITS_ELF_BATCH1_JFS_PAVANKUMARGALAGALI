package com.bcits.discomproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomproject.beans.CurrentBill;
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
		if(consumer.find(bill.getRrNumber())!= null) {
			
			return dao.generateBill(bill);
		}
		return false;
	}

}
