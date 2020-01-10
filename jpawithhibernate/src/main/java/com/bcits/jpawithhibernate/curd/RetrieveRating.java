package com.bcits.jpawithhibernate.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.bean.Test;

public class RetrieveRating {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		Test test =manager.getReference(Test.class, 10);
		System.out.println(test.getMid());
		System.out.println(test.getMovieName());
		System.out.println(test.getMovieRating());
		manager.close();
	}
}
