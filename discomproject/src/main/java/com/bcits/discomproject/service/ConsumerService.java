package com.bcits.discomproject.service;

import com.bcits.discomproject.beans.ConsumerMaster;

public interface ConsumerService {

	public boolean signUpConsumer(ConsumerMaster consumerMaster, String confirmpwd);

	public ConsumerMaster authenticate(String rrNumber, String password);
}
