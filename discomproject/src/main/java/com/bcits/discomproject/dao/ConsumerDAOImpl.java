package com.bcits.discomproject.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomproject.beans.BillHistory;
import com.bcits.discomproject.beans.BillHistoryPk;
import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
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
		String jpql = "from MonthlyConsumption where rrNumber=:rr ";
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
			consumption.setFinalUnits(bill.getFinalUnits());
			consumption.setBill(bill.getAmount());
			consumption.setPreviousUnits(bill.getInitialUnits());
			consumption.setStatus("paid");
			consumption.setTotalUnits(bill.getUnitsConsumed());
			consumption.setTakenOn(bill.getReadingsTakenOn());
			
		    BillHistory billHistory = new BillHistory();

		    BillHistoryPk billHistoryPk = new BillHistoryPk();
		    
		    billHistoryPk.setDate(new Date());
		    billHistoryPk.setRrNumber(rrNumber);
		    
		    billHistory.setBillHistoryPk(billHistoryPk);
		    billHistory.setBill(bill.getAmount());
		    billHistory.setRegion(bill.getRegion());
		    billHistory.setStatus("paid");
		    
		    manager.persist(billHistory);
			manager.persist(consumption);
			manager.remove(bill);
			transaction.commit();
			isPaid = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		return isPaid;
	}// end of billPayment()

	@Override
	public boolean supportRequest(String rrNumber, String msg) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		SupportRequest support = new SupportRequest();
		SupportPk supportPk = new SupportPk();
		try {
			supportPk.setRrNumber(rrNumber);
			supportPk.setSupport(msg);
			support.setSupportPk(supportPk);
			support.setResponse("");
			support.setDate(new Date());
			transaction.begin();
			manager.persist(support);
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

	@Override
	public List<SupportRequest> getSupportRequest(String rrNumber) {

		List<SupportRequest> requests = null;
		EntityManager manager = managerFactory.createEntityManager();
		String getRequest = " from SupportRequest where rrNumber=:rrNumber";
		Query query = manager.createQuery(getRequest);
		query.setParameter("rrNumber", rrNumber);
		requests = query.getResultList();
		manager.close();
		return requests;
	}// end of

}
