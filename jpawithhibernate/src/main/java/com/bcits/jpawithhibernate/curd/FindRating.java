package com.bcits.jpawithhibernate.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernate.bean.Test;

public class FindRating {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		Test test = manager.find(Test.class, 20);
		System.out.println(test.getMid());
		System.out.println(test.getMovieName());
		System.out.println(test.getMovieRating());
		manager.close();
	}
}
