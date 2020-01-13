package com.bcits.employeemanagementinfo.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;
import com.bcits.employeemanagementinfo.manytoone.EmployeeAddressInfo;
import com.bcits.employeemanagementinfo.manytoone.EmployeeAddressPK;

public class ManyToOneTest {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		PrimaryInfo primary = new PrimaryInfo();
		EmployeeAddressPK addressPK = new EmployeeAddressPK();
		EmployeeAddressInfo addressInfo = new EmployeeAddressInfo();

		primary.setEmpId(20);
		primary.setName("yogesh");
		primary.setMobileNo(8989696856L);
		primary.setMaildId("yogeshtech@bcits.com");
		primary.setBirthDate(java.sql.Date.valueOf("1996-02-14"));
		primary.setJoiningDate(java.sql.Date.valueOf("2019-10-27"));
		primary.setDesignation("Tester");
		primary.setBloodGroup("B+");
		primary.setSalary(25000);
		primary.setDeptId(40);
		primary.setMgrId(20);

		addressPK.setEmpId(20);
		addressPK.setAddressType("local");

		addressInfo.setAdressPk(addressPK);
		addressInfo.setHouseNo("4020");
		addressInfo.setAddress1("c/o nagaraj a");
		addressInfo.setAddress2("basav nilaya");
		addressInfo.setLandMark("near gandhi chowk");
		addressInfo.setCity("Vijaypura");
		addressInfo.setPincode(587663);
		addressInfo.setPrimaryInfo(primary);
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			PrimaryInfo primaryInfo = manager.find(PrimaryInfo.class, 20);
			System.out.println(primaryInfo.getAddress().get(0).getAddress1());
			System.out.println(primaryInfo.getAddress().get(0).getAddress2());
			System.out.println(primaryInfo.getAddress().get(0).getCity());
			System.out.println(primaryInfo.getAddress().get(0).getPincode());
			
			/*
			 * addressInfo.setPrimaryInfo(primaryInfo); manager.persist(addressInfo);
			 */
			transaction.begin();
			
			
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
