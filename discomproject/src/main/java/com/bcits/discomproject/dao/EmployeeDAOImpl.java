package com.bcits.discomproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;

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

	@Override
	public boolean generateBill(CurrentBill bill) {
		boolean isGenerated = false;
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ConsumerMaster consumerMaster = dao.find(bill.getRrNumber());
		String type = consumerMaster.getConsumerType();
		Double init = bill.getInitialUnits();
		Double fnl = bill.getFinalUnits();
		try {
			transaction.begin();
			bill.setAmount(generate.generateBill(type, init, fnl));
			bill.setFinalUnits(fnl);
			bill.setInitialUnits(init);
			bill.setUnitsConsumed(fnl - init);
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
		String getSup =" from SupportRequest where rrNumber=:rr and support=:sup";
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

}
