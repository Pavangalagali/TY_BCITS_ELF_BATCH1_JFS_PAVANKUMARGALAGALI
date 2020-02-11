package com.bcits.discomproject.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.discomproject.beans.BillHistory;
import com.bcits.discomproject.beans.BillHistoryPk;
import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.beans.MonthlyConsumptionPk;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;
import com.bcits.discomproject.utility.SendMail;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory managerFactory;

	@Autowired
	private ConsumerDAO dao;

	@Autowired
	private GeneratBill generate;

	@Autowired
	private EmployeeDAO empDao;

	SendMail mail = new SendMail();

	@Override
	public boolean generateBill(CurrentBill bill) {
		boolean isGenerated = false;
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		ConsumerMaster consumerMaster = dao.find(bill.getRrNumber());

		String region = consumerMaster.getRegion();
		String type = consumerMaster.getConsumerType();

		Double init = bill.getInitialUnits();
		Double fnl = bill.getFinalUnits();

		try {
			transaction.begin();
			CurrentBill currentBill = manager.find(CurrentBill.class, bill.getRrNumber());
			if (currentBill != null) {
				BillHistoryPk billHistoryPk = new BillHistoryPk();

				billHistoryPk.setDate(new Date());
				billHistoryPk.setRrNumber(currentBill.getRrNumber());

				BillHistory billHistory = new BillHistory();

				billHistory.setBill(currentBill.getAmount());
				billHistory.setBillHistoryPk(billHistoryPk);
				billHistory.setRegion(currentBill.getRegion());
				billHistory.setStatus("not paid");

				MonthlyConsumptionPk consumptionPk = new MonthlyConsumptionPk();
				consumptionPk.setDate(new Date());
				consumptionPk.setRrNumber(currentBill.getRrNumber());

				MonthlyConsumption consumption = new MonthlyConsumption();
				consumption.setConsumptionPk(consumptionPk);
				consumption.setBill(currentBill.getAmount());
				consumption.setStatus("not paid");
				consumption.setFinalUnits(currentBill.getFinalUnits());
				consumption.setPreviousUnits(currentBill.getInitialUnits());
				consumption.setTakenOn(currentBill.getReadingsTakenOn());
				consumption.setTotalUnits(currentBill.getUnitsConsumed());

				manager.persist(consumption);
				manager.persist(billHistory);
				manager.remove(currentBill);

				init = currentBill.getFinalUnits();
			}

			System.out.println(fnl);
			System.out.println(init);

			bill.setAmount(generate.generateBill(type, init, fnl));
			bill.setFinalUnits(fnl);
			bill.setInitialUnits(init);
			bill.setUnitsConsumed(fnl - init);
			bill.setRegion(region);
			manager.persist(bill);
			transaction.commit();
			isGenerated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isGenerated;
	}// end of generateBill();

	@Override
	public List<ConsumerMaster> getAllConsumers(String region) {
		List<ConsumerMaster> consumers = null;
		EntityManager manager = managerFactory.createEntityManager();
		String getConsumer = " from ConsumerMaster where region =:region";
		Query query = manager.createQuery(getConsumer);
		query.setParameter("region", region);
		try {
			consumers = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consumers;
	}// end of getAllConsumer()

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

	@Override
	public boolean generateResponse(SupportPk supportPk, String response) {
		boolean isGenerated = false;
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String getSup = " from SupportRequest where rrNumber=:rr and support=:sup";
		Query query = manager.createQuery(getSup);
		query.setParameter("rr", supportPk.getRrNumber());
		query.setParameter("sup", supportPk.getSupport());
		try {
			transaction.begin();
			SupportRequest request = (SupportRequest) query.getSingleResult();
			request.setResponse(response);
			transaction.commit();
			isGenerated = true;

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		return isGenerated;

	}// end of

	@Override
	public List<CurrentBill> currentBills(String region) {
		List<CurrentBill> bills = null;
		EntityManager manager = managerFactory.createEntityManager();
		String getCurrentBill = " from CurrentBill where region =:region ";
		Query query = manager.createQuery(getCurrentBill);
		query.setParameter("region", region);
		try {
			bills = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return bills;
	}// end of currrentBills()

	@Override
	public boolean sendMail(String rrNumber) {
		EntityManager manager = managerFactory.createEntityManager();
		CurrentBill bill = manager.find(CurrentBill.class, rrNumber);
		if (mail.sendMail(bill)) {
			return true;
		}
		return false;
	}

	@Override
	public List<BillHistory> getCollectedBill(String region) {

		EntityManager manager = managerFactory.createEntityManager();
		String getCollectedBill = " from BillHistory Where region =:region and status=:paid";

		Query query = manager.createQuery(getCollectedBill);

		query.setParameter("region", region);
		query.setParameter("paid", "paid");

		List<BillHistory> billHistories = query.getResultList();
		System.out.println(billHistories);
		return billHistories;
	}


	@Override
	public List<Object[]> getPaidBills(String region) {
		EntityManager manager = managerFactory.createEntityManager();
		try {
			String jpql = " select sum(bill), DATE_FORMAT(billHistoryPk.date,'%Y-%m') from BillHistory "
					+ " where region=:region and status='paid' GROUP BY MONTH(billHistoryPk.date) ";
			Query query = manager.createQuery(jpql);
			query.setParameter("region", region);
			List<Object[]> paidBills = query.getResultList();
			return paidBills;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Object[]> getPendingBills(String region) {
		EntityManager manager = managerFactory.createEntityManager();
		try {
			String jpql =" select sum(bill), DATE_FORMAT(billHistoryPk.date,'%Y-%m') from BillHistory "
					+ " where region=:region and status='not paid' GROUP BY MONTH(billHistoryPk.date) ";
			Query query = manager.createQuery(jpql);
			query.setParameter("region", region);
			List<Object[]> pendingBill = query.getResultList();
			System.out.println();
			return pendingBill;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SupportRequest> getAllRequestSupport(String region) {
		EntityManager manager = managerFactory.createEntityManager();
		try {
			String jpql =" from SupportRequest where supportPk.rrNumber in"
					+ " ( select rrNumber from ConsumerMaster where region=:region) ";
			Query query = manager.createQuery(jpql);
			query.setParameter("region", region);
			List<SupportRequest> requests = query.getResultList();
			System.out.println();
			return requests;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateDueBill(String rrNumber, Date date) {
		System.out.println(rrNumber +" "+date);
		boolean isUpdated = false;
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();;
			String jpql =" from BillHistory Where billHistoryPk.rrNumber =:rrNumber and "
					+ " DATE_FORMAT(billHistoryPk.date, '%c-%d-%Y')=DATE_FORMAT(:date, '%c-%d-%Y') "
					+ " and status ='not paid' ";
			Query query = manager.createQuery(jpql);
			query.setParameter("rrNumber",rrNumber);
			query.setParameter("date", date);
			
			String jpql2 =" from MonthlyConsumption Where consumptionPk.rrNumber =:rrNumber and "
					+ " DATE_FORMAT(consumptionPk.date, '%c-%d-%Y')=DATE_FORMAT(:date, '%c-%d-%Y')"
					+ " and status='not paid'";
			Query query2 = manager.createQuery(jpql2);
			query2.setParameter("rrNumber",rrNumber);
			query2.setParameter("date", date);
			
			BillHistory billHistory = (BillHistory) query.getSingleResult();
			billHistory.setStatus("paid");
			
			MonthlyConsumption consumption = (MonthlyConsumption) query2.getSingleResult();
			consumption.setStatus("paid");
			
			transaction.commit();
			isUpdated= true;
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	
		return isUpdated;
	}

	

}
