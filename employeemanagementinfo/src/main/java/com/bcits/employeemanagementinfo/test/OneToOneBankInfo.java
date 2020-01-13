package com.bcits.employeemanagementinfo.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;
import com.bcits.employeemanagementinfo.onetoone.EmployeeBankInfo;
import com.bcits.employeemanagementinfo.onetoone.SecondaryInfo;

public class OneToOneBankInfo {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		PrimaryInfo primary = new PrimaryInfo();
		EmployeeBankInfo bankInfo = new EmployeeBankInfo();

		primary.setEmpId(10);
		primary.setName("Arun");
		primary.setMobileNo(8987672222L);
		primary.setMaildId("arunkiran@bcits.com");
		primary.setBirthDate(java.sql.Date.valueOf("1990-03-15"));
		primary.setJoiningDate(java.sql.Date.valueOf("2019-09-02"));
		primary.setDesignation("Tester");
		primary.setBloodGroup("AB+");
		primary.setSalary(25000);
		primary.setDeptId(20);
		primary.setMgrId(20);

		
		bankInfo.setBankName("Canara Bank");
		bankInfo.setBranchName("BTR");
		bankInfo.setAccountNo(10100111945l);
		bankInfo.setIfscCode("CNR00101110");
		bankInfo.setPrimary(primary);
		primary.setBankInfo(bankInfo);
		

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
