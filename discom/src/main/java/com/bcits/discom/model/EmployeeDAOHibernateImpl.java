package com.bcits.discom.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.discom.bean.EmployeeMaster;

public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("discomPeristence");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	@Override
	public EmployeeMaster getEmployee(int id, String pwd) {

		String jpql = " from EmployeeMaster where id=:id and password=:pwd";
		Query query = manager.createQuery(jpql);
		query.setParameter("id", id);
		query.setParameter("pwd", pwd);
		try {
			EmployeeMaster master = (EmployeeMaster) query.getSingleResult();
			return master;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean provideAccess(EmployeeMaster master) {

		try {
			transaction.begin();
			manager.persist(master);
			transaction.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
