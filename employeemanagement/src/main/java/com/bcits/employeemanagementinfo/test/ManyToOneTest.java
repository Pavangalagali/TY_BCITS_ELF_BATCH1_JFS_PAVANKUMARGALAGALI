package com.bcits.employeemanagementinfo.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagement.manytoone.AddressPk;
import com.bcits.employeemanagement.manytoone.EmployeeAddressInfo;
import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

public class ManyToOneTest {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		PrimaryInfo primary = new PrimaryInfo();

		EmployeeAddressInfo address = new EmployeeAddressInfo();
		AddressPk addressPK = new AddressPk();

		primary.setEmpId(26);
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

		addressPK.setEmpId(26);
		addressPK.setAddressType("local");

		address.setAddress(addressPK);
		address.setHouseNo(4020);
		address.setAddress1("c/o nagaraj a");
		address.setAddress2("basav nilaya");
		address.setLandmark("near gandhi chowk");

		address.setPincode(587663);
		address.setPrimaryInfo(primary);
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			
			  PrimaryInfo primaryInfo = manager.find(PrimaryInfo.class, 26);
			  System.out.println(primaryInfo.getAddressInfo().get(0).getAddress1());
			  System.out.println(primaryInfo.getAddressInfo().get(0).getAddress2());
			 
			

			transaction.begin();
//			manager.persist(address);

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
