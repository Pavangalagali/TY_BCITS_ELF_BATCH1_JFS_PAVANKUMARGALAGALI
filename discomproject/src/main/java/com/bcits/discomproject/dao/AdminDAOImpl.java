package com.bcits.discomproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.discomproject.beans.EmployeeMaster;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private EntityManagerFactory factoty;

	@Override
	public EmployeeMaster find(int id) {
		EntityManager manager = factoty.createEntityManager();
		EmployeeMaster employeeMaster = manager.find(EmployeeMaster.class, id);
		return employeeMaster;
	}// end of find()

	@Override
	public EmployeeMaster authenticate(int id, String password) {
		EntityManager manager = factoty.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		EmployeeMaster employeeMaster = manager.find(EmployeeMaster.class, id);
		if (employeeMaster != null && employeeMaster.getPassword().equals(password)) {
			try {
				String jpql = "select count(*) from ConsumerMaster where region=:region ";
				Query query = manager.createQuery(jpql);
				query.setParameter("region", employeeMaster.getRegion());
				employeeMaster.setConsumerCount((Long) query.getSingleResult());
				transaction.commit();
				return employeeMaster;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}// end of authentication()

	@Override
	public boolean grantEmployeeAccess(EmployeeMaster master) {
		boolean isGranted = false;
		EntityManager manager = factoty.createEntityManager();
		master.setConsumerCount((long) 0);
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();

			manager.persist(master);
			transaction.commit();
			isGranted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isGranted;
	}// end of grantEmployeeAccess()

	@Override
	public boolean revokeEmployeeAccess(int id) {
		boolean isRevoked = false;
		EntityManager manager = factoty.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			EmployeeMaster master = manager.find(EmployeeMaster.class, id);
			manager.remove(master);
			transaction.commit();
			isRevoked = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isRevoked;
	}// end of revokeEmployeeAccess()

	@Override
	public List<EmployeeMaster> getAll() {
		EntityManager manager = factoty.createEntityManager();
		String jpql = " from EmployeeMaster where role != 'admin' ";
		Query query = manager.createQuery(jpql);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;

		}
	}// end of getAll()

}// end of class
