package com.bcits.jpawithhibernate.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.bean.Test;

public class DeleteRating {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
		    transaction = manager.getTransaction();
			transaction.begin();
			Test test = manager.find(Test.class, 80);
			manager.remove(test);
			transaction.commit();
			System.out.println("deleted");
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
