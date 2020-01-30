package com.bcits.discomproject.dao;

import com.bcits.discomproject.beans.ConsumerMaster;

public interface ConsumerDAO {

	public boolean signUpConsumer(ConsumerMaster consumerMaster);

	public ConsumerMaster authenticate(String rrNumber, String password);

}
