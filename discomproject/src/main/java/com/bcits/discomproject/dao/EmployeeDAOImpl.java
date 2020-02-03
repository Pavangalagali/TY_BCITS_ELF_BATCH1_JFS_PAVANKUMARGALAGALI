package com.bcits.discomproject.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory managerFactory;
	
	@Autowired
	private ConsumerDAO dao;


	@Override
	public boolean generateBill(CurrentBill bill) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ConsumerMaster consumerMaster = dao.find(bill.getRrNumber());
		String region = consumerMaster.getRegion();
		Double init = bill.getInitialUnits();
		Double fnl = bill.getFinalUnits();
		try {
			transaction.begin();
			bill.setAmount(GeneratBill.generateBill(region, init, fnl));
			bill.setFinalUnits(fnl);
			bill.setInitialUnits(init);
			bill.setUnitsConsumed(fnl - init);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
