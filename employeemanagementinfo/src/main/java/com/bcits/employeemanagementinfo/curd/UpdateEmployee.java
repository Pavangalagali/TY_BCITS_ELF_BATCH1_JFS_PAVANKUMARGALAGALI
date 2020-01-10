package com.bcits.employeemanagementinfo.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

public class UpdateEmployee {

	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			PrimaryInfo info = manager.find(PrimaryInfo.class, 10);
			info.setName("kiran");
			info.setSalary(60500);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
