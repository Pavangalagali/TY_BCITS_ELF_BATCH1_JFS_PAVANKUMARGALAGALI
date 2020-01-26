package com.bcits.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springmvc.beans.EmployeeInfoBean;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@PersistenceUnit
	EntityManagerFactory managerFactory;

	@Override
	public boolean addemployee(EmployeeInfoBean infoBean) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(infoBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {

		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isDeleted = false;
		EmployeeInfoBean infoBean = manager.find(EmployeeInfoBean.class, empId);

		if (infoBean != null) {
			try {
				transaction.begin();
				manager.remove(infoBean);
				transaction.commit();
				isDeleted = true;
			} catch (Exception e) {
				e.printStackTrace();
				transaction.rollback();
				isDeleted = false;
			}
			manager.close();
		}

		return isDeleted;
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean infoBean) {
		boolean isUpdated = false;
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			EmployeeInfoBean bean = manager.find(EmployeeInfoBean.class,infoBean.getEmpId());
			bean.setSalary(infoBean.getSalary());
			bean.setMobileNum(infoBean.getMobileNum());
			bean.setDesignation(infoBean.getDesignation());
			transaction.commit();
			isUpdated = true;
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}
		return isUpdated;
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {

		EntityManager manager = managerFactory.createEntityManager();

		EmployeeInfoBean infoBean = manager.find(EmployeeInfoBean.class, empId);

		manager.close();
		return infoBean;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {

		EntityManager manager = managerFactory.createEntityManager();

		String jpql = " from EmployeeInfoBean ";
		Query query = manager.createQuery(jpql);

		List<EmployeeInfoBean> employeeInfoBeans = query.getResultList();
		manager.close();

		return employeeInfoBeans;
	}//end of getAll()

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {

		EntityManager manager = managerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);

		if (employeeInfoBean != null && employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;
		} else {
			return null;
		}
	}//end of authenticate

}
