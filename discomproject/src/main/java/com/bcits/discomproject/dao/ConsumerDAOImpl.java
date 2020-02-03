package com.bcits.discomproject.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.EmployeeMaster;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.beans.MonthlyConsumptionPk;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;

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

	@Override
	public List<MonthlyConsumption> consumptions(String rrNumber) {

		EntityManager manager = managerFactory.createEntityManager();
		String jpql = "from MonthlyConsumption where rrNumber=:rr";
		Query query = manager.createQuery(jpql);
		query.setParameter("rr", rrNumber);
		List<MonthlyConsumption> consumptions = query.getResultList();
		manager.close();
		return consumptions;
	}

	@Override
	public CurrentBill currentBill(String rrNumber) {
		EntityManager manager = managerFactory.createEntityManager();
		return manager.find(CurrentBill.class, rrNumber);

	}// end of crrentBill()

	@Override
	public boolean billPayment(String rrNumber) {
		boolean isPaid = false;
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			CurrentBill bill = manager.find(CurrentBill.class, rrNumber);
			MonthlyConsumption consumption = new MonthlyConsumption();

			MonthlyConsumptionPk pk = new MonthlyConsumptionPk();
			pk.setDate(new Date());
			pk.setRrNumber(rrNumber);
			consumption.setConsumptionPk(pk);
			consumption.setBill(bill.getAmount());
			consumption.setPreviousUnits(bill.getInitialUnits());
			consumption.setStatus("paid");
			consumption.setTotalUnits(bill.getUnitsConsumed());
			consumption.setTakenOn(bill.getReadingsTakenOn());

			manager.persist(consumption);
			manager.remove(bill);
			transaction.commit();
			isPaid = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		return isPaid;
	}

	@Override
	public boolean supportRequest(String rrNumber, String msg) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		SupportRequest request = new SupportRequest();
		SupportPk supportPk = new SupportPk();
		try {
			supportPk.setRrNumber(rrNumber);
			supportPk.setSupport(msg);
			request.setSupport(supportPk);
			transaction.begin();
			manager.persist(request);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}// end of supportRequest();

	@Override
	public ConsumerMaster find(String rrNumber) {
		EntityManager manager = managerFactory.createEntityManager();
		ConsumerMaster consumerMaster = manager.find(ConsumerMaster.class, rrNumber);
		return consumerMaster;
	}

}
