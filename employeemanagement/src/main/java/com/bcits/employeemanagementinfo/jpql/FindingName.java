package com.bcits.employeemanagementinfo.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindingName {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select name from  PrimaryInfo ";
		Query query = manager.createQuery(jpql);
		List<String> list = query.getResultList();
		for (String primaryInfo : list) {
			System.out.println(primaryInfo);
		}
		manager.close();
	}
}
