package com.bcits.employeemanagementinfo.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;
import com.bcits.employeemanagementinfo.onetoone.SecondaryInfo;

public class TestOneToOne {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		PrimaryInfo primary = new PrimaryInfo();
		primary.setEmpId(199);
		primary.setName("kishan");
		primary.setMobileNo(8986598850L);
		primary.setMaildId("shivaraj123@bcits.com");
		primary.setBirthDate(java.sql.Date.valueOf("1980-09-11"));
		primary.setJoiningDate(java.sql.Date.valueOf("2014-07-28"));
		primary.setDesignation("Manager");
		primary.setBloodGroup("A-");
		primary.setSalary(75000);
		primary.setDeptId(10);
		primary.setMgrId(20);

		SecondaryInfo secondary = new SecondaryInfo();
		secondary.setAge(40);
		secondary.setGender("male");
		secondary.setGovtId("8998-6532-5465");
		secondary.setGuardianNname("ravikanth");
		secondary.setGuardianContact(9988998989l);
		secondary.setIsMarried("yes");
		secondary.setJobLocation("Banglore");
		secondary.setNationality("Indian");
		secondary.setPersonalEmail("yahoooo@gmail.com");
		primary.setSecondary(secondary);
		secondary.setPrimaryInfo(primary);
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(primary);
			System.out.println("record saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}
}
