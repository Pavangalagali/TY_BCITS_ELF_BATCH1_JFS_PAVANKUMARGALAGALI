package com.bcits.employeemanagementinfo.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

public class FindEmployee {
	public static void main(String[] args) {
		PrimaryInfo primaryInfo = new PrimaryInfo();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		primaryInfo = entityManager.find(PrimaryInfo.class, 10);

		System.out.println("employee id              => "+ primaryInfo.getEmpid());
		System.out.println("employee name            => "+ primaryInfo.getName());
		System.out.println("employee mail            => "+primaryInfo.getOfficial_maildid());
		System.out.println("employee mobile number   => "+primaryInfo.getMobileno());
		System.out.println("employee designation     => "+primaryInfo.getDesignation());
		System.out.println("employee salary          => "+primaryInfo.getSalary());
		System.out.println("employee date of birth   => "+primaryInfo.getDate_of_birth());
		System.out.println("employee date of joining => "+primaryInfo.getDate_of_joining());
		System.out.println("employee department id   => "+primaryInfo.getDeptid());
		System.out.println("employee blood group     => "+primaryInfo.getBlood_group());
		System.out.println("employee manager id      => "+primaryInfo.getMgrid());
		entityManager.close();
	} // end of main
} // end of class
