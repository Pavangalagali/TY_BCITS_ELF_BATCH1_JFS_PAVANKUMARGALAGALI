package com.bcits.employeemanagementinfo.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

public class InsertEmployee {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		PrimaryInfo primary = new PrimaryInfo();
		primary.setEmpId(182);
		primary.setName("magadeera");
		primary.setMobileNo(8986598000L);
		primary.setMaildId("deera123@bcits.com");
		primary.setBirthDate(java.sql.Date.valueOf("1992-10-10"));
		primary.setJoiningDate(java.sql.Date.valueOf("2014-03-12"));
		primary.setDesignation("tester");
		primary.setBloodGroup("B-");
		primary.setSalary(25000);
		primary.setDeptId(20);
		primary.setMgrId(20);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(primary);
			System.out.println("record saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}
}
