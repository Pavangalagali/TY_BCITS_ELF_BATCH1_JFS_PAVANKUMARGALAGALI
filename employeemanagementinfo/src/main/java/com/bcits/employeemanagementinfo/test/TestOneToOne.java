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
		SecondaryInfo secondary = new SecondaryInfo();

		primary.setEmpId(199);
		primary.setName("Maran");
		primary.setMobileNo(8986525632L);
		primary.setMaildId("maranamurali@bcits.com");
		primary.setBirthDate(java.sql.Date.valueOf("1989-12-19"));
		primary.setJoiningDate(java.sql.Date.valueOf("2011-02-20"));
		primary.setDesignation("Developer");
		primary.setBloodGroup("A+");
		primary.setSalary(55000);
		primary.setDeptId(30);
		primary.setMgrId(10);

		secondary.setAge(22);
		secondary.setGender("male");
		secondary.setGovtId("8889-2222-5465");
		secondary.setGuardianNname("kishore");
		secondary.setGuardianContact(9988912323l);
		secondary.setIsMarried("yes");
		secondary.setJobLocation("Banglore");
		secondary.setNationality("Indian");
		secondary.setPersonalEmail("muralomapped@gmail.com");
		secondary.setPrimaryInfo(primary);
		primary.setSecondaryInfo(secondary);
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
//			manager.persist(primary);
			 PrimaryInfo info =manager.find(PrimaryInfo.class, 199);
			System.out.println(info.getEmpId());
			System.out.println(info.getName());
			System.out.println(info.getSecondaryInfo().getJobLocation());
			//System.out.println("record saved");
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
