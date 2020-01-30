package com.bcits.discomproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.dao.ConsumerDAO;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerDAO  dao;
	
	@Override
	public boolean signUpConsumer(ConsumerMaster consumerMaster, String confirmpwd) {
	
		if(consumerMaster.getPassword().equals(confirmpwd)) {
			return dao.signUpConsumer(consumerMaster);
		}
		return false;
	}

	@Override
	public ConsumerMaster authenticate(String rrNumber, String password) {
		
		return dao.authenticate(rrNumber, password);
	}

}
