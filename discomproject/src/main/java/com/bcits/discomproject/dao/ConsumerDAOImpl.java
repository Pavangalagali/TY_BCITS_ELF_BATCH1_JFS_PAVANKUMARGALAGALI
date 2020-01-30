package com.bcits.discomproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomproject.beans.ConsumerMaster;

@Repository
public class ConsumerDAOImpl implements ConsumerDAO {

	@PersistenceUnit
	private EntityManagerFactory managerFactory;

	@Override
	public boolean signUpConsumer(ConsumerMaster consumerMaster) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(consumerMaster);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isAdded;
	}

	@Override
	public ConsumerMaster authenticate(String rrNumber, String password) {
		EntityManager manager = managerFactory.createEntityManager();
		ConsumerMaster consumerBean = manager.find(ConsumerMaster.class, rrNumber);

		if (consumerBean != null && consumerBean.getPassword().equals(password)) {
			return consumerBean;
		} else {
			return null;
		}
	}

}
