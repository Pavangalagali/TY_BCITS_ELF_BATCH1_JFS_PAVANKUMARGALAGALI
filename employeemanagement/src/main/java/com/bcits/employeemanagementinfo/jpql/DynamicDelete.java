package com.bcits.employeemanagementinfo.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicDelete {

	public static void main(String[] args) {
		EntityManager manager= null;
		EntityTransaction  transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = " delete from PrimaryInfo where empid =:id";
			Query query = manager.createQuery(jpql);
			query.setParameter("id", 189);
			int count = query.executeUpdate();
			System.out.println(" deleted rows " + count);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			manager.close();
		}
	}
}
