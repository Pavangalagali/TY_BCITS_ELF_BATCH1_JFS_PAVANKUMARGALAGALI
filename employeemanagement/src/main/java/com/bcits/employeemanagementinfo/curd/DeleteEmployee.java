package com.bcits.employeemanagementinfo.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

public class DeleteEmployee {
	public static void main(String[] args) {
		EntityManager manager=  null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		    manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			PrimaryInfo info = manager.find(PrimaryInfo.class, 189);
		manager.remove(info);
			transaction.commit();
			System.out.println("recored deleted");
		} catch (Exception e) {
			e.printStackTrace();
			if(transaction!=null) {
			transaction.rollback();
			}
		}finally {
			if(manager!=null) {
				manager.close();
			}
		}
	}
}
