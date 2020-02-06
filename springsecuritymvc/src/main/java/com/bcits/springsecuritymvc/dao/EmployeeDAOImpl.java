package com.bcits.springsecuritymvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springsecuritymvc.beans.EmployeeInfo;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean register(EmployeeInfo info) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		boolean isRegistered = false;

		try {
			transaction.begin();
			manager.persist(info);
			transaction.commit();
			isRegistered = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		return isRegistered;
	}

	@Override
	public EmployeeInfo getEmployee(int empId) {

		EntityManager manager = factory.createEntityManager();
		EmployeeInfo employeeInfo = manager.find(EmployeeInfo.class, empId);
		manager.close();
		return employeeInfo;
	}

	@Override
	public List<EmployeeInfo> getAllEmployee() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery(" from EmployeeInfo ");
		List<EmployeeInfo> infos = query.getResultList();
		manager.close();

		return infos;
	}

}
