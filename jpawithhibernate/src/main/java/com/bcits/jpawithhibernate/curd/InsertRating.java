package com.bcits.jpawithhibernate.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.bean.Test;

public class InsertRating {
	public static void main(String[] args) {
		Test test = new Test();
		test.setMid(90);
		test.setMovieName("Temper");
		test.setMovieRating("Good");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(test);
		System.out.println("record saved");
		//transaction.commit();
		manager.close();

	}
}
