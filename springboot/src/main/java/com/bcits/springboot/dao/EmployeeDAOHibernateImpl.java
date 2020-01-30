package com.bcits.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springboot.beans.EmployeeInfoBean;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory managerFactory;

//	@PersistenceContext
//	private EntityManager manager;

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
	}// End of addEmployee()

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
	}// End of deleteEmployee()

	@Override
	public boolean updateEmployee(EmployeeInfoBean infoBean) {
		boolean isUpdated = false;
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			EmployeeInfoBean bean = manager.find(EmployeeInfoBean.class, infoBean.getEmpId());

			if (!infoBean.getName().isEmpty() && infoBean.getName() != null) {
				bean.setName(infoBean.getName());
			}
			if (infoBean.getMobileNum() != null) {
				bean.setMobileNum(infoBean.getMobileNum());
			}
			if (!infoBean.getMaildId().isEmpty() && infoBean.getMaildId() != null) {
				bean.setMaildId(infoBean.getMaildId());
			}
			if (infoBean.getBirthDate() != null) {
				bean.setBirthDate(infoBean.getBirthDate());
			}
			if (infoBean.getJoiningDate() != null) {
				bean.setJoiningDate(infoBean.getJoiningDate());
			}
			if (!infoBean.getDesignation().isEmpty() && infoBean.getDesignation() != null) {
				bean.setDesignation(infoBean.getDesignation());
			}
			if (!infoBean.getBloodGroup().isEmpty() && infoBean.getBloodGroup() != null) {
				bean.setBloodGroup(infoBean.getBloodGroup());
			}
			if (!infoBean.getPassword().isEmpty() && infoBean.getPassword() != null) {
				bean.setPassword(infoBean.getPassword());
			}
			if (infoBean.getDeptId() != null) {
				bean.setDeptId(infoBean.getDeptId());
			}
			if (infoBean.getMgrId() != null) {
				bean.setMgrId(infoBean.getMgrId());
			}
			if (infoBean.getSalary() != null) {
				bean.setSalary(infoBean.getSalary());
			}
			transaction.commit();

			isUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}
		manager.close();
		return isUpdated;
	}// End of updateEmployee()

	@Override
	public EmployeeInfoBean getEmployee(int empId) {

		EntityManager manager = managerFactory.createEntityManager();

		EmployeeInfoBean infoBean = manager.find(EmployeeInfoBean.class, empId);

		manager.close();
		return infoBean;
	}// End of getEmployee()

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {

		EntityManager manager = managerFactory.createEntityManager();

		String jpql = " from EmployeeInfoBean ";
		Query query = manager.createQuery(jpql);

		List<EmployeeInfoBean> employeeInfoBeans = query.getResultList();
		manager.close();

		return employeeInfoBeans;
	}// end of getAll()

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {

		EntityManager manager = managerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = getEmployee(empId);
		manager.close();
		if (employeeInfoBean != null && employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;
		} else {
			return null;
		}
	}// end of authenticate

}
