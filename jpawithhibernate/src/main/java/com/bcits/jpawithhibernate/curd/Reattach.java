package com.bcits.jpawithhibernate.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.bcits.jpawithhibernate.bean.Test;

public class Reattach {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Test test = manager.find(Test.class, 10);
			System.out.println(manager.contains(test));
			manager.detach(test);
			System.out.println(manager.contains(test));
			Test reattach = manager.merge(test);
			System.out.println("executed");
			reattach.setMovieName("HouseFull");
			reattach.setMovieRating("worst");
			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
		}
		
	}
}
