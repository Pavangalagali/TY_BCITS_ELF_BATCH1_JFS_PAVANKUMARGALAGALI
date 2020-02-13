package com.bcits.discomproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.beans.SupportRequest;
import com.bcits.discomproject.dao.ConsumerDAO;
import com.bcits.discomproject.validations.Validations;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerDAO  dao;
	
	@Autowired
	private Validations validations;
	
	@Override
	public boolean signUpConsumer(ConsumerMaster consumerMaster, String confirmpwd) {
	
		if(validations.validateConsumerDeatils(consumerMaster)) {
			System.out.println("validated successfully");
			
			if(consumerMaster.getPassword().equals(confirmpwd)) {
				return dao.signUpConsumer(consumerMaster);
			}
		}		
		return false;
	}

	@Override
	public ConsumerMaster authenticate(String rrNumber, String password) {
		if(validations.rrValidation(rrNumber) && validations.validatePassword(password) ) {
		return dao.authenticate(rrNumber, password);
		}
		return null;
	}

	@Override
	public List<MonthlyConsumption> consumptions(String rrNumber) {
		return dao.consumptions(rrNumber);
	}

	@Override
	public CurrentBill currentBill(String rrNumber) {
		return dao.currentBill(rrNumber);
	}

	@Override
	public boolean billPayment(String rrNumber) {
		
		return dao.billPayment(rrNumber);
	}

	@Override
	public boolean supportRequest(String rrNumber, String msg) {
		if(msg.length() > 2001) {
			return false;			
		}else {
			return dao.supportRequest(rrNumber, msg);
		}
	}

	@Override
	public List<SupportRequest> getSupportRequest(String rrNumber) {
		return dao.getSupportRequest(rrNumber);
	}

}
