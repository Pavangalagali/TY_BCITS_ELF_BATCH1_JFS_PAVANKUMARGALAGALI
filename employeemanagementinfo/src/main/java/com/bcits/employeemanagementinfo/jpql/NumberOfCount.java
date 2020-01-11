package com.bcits.employeemanagementinfo.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NumberOfCount {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select count(*)  from PrimaryInfo ";
		Query query = manager.createQuery(jpql);
		Object count = query.getSingleResult();
		System.out.println("number of count " + count);
		manager.close();
	}
}
