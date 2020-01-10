package com.bcits.jpawithhibernate.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.bean.Test;

public class UpdateRating {
	public static void main(String[] args) {
		EntityManager manager =null;
		EntityTransaction transaction =null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		manager = factory.createEntityManager();
			 transaction = manager.getTransaction();
			transaction.begin();
			Test test =manager.find(Test.class, 10);
			test.setMovieRating("bad");
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
			
		}finally {
			manager.close();
		}
		
	}
}
