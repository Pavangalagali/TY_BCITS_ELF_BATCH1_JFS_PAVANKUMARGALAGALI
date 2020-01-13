package com.bcits.employeemanagementinfo.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;
import com.bcits.employeemanagementinfo.manytomany.ProjectInfo;

public class ManyToMany {
	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;

		PrimaryInfo primary = new PrimaryInfo();
//		PrimaryInfo primary2 = new PrimaryInfo();

		ProjectInfo info = new ProjectInfo();
		ProjectInfo info1 = new ProjectInfo();
		ArrayList<ProjectInfo> primaryInfos = new ArrayList<ProjectInfo>();
		ArrayList<PrimaryInfo> primaryIn = new ArrayList<PrimaryInfo>();
		primaryIn.add(primary);
		

		info.setPid(66);
		info.setProjrctName("e-ems");
		info.setTechnologies("java");
		info.setStartDate(java.sql.Date.valueOf("2010-10-11"));
		info.setEndDate(java.sql.Date.valueOf("2012-11-11"));
		info.setLocation("banglore");
	     info.setList(primaryIn);
		
		
		
		info1.setPid(57);
		info1.setProjrctName("HS");
		info1.setTechnologies("java");
		info1.setStartDate(java.sql.Date.valueOf("2010-10-11"));
		info1.setEndDate(java.sql.Date.valueOf("2012-11-11"));
		info1.setLocation("banglore");
		info1.setList(primaryIn);
		
		primaryInfos.add(info);
		primaryInfos.add(info1);
		
		primary.setEmpId(99);
		primary.setName("Arjun");
		primary.setMobileNo(900525632L);
		primary.setMaildId("alluarjun@bcits.com");
		primary.setBirthDate(java.sql.Date.valueOf("1990-08-25"));
		primary.setJoiningDate(java.sql.Date.valueOf("2019-02-17"));
		primary.setDesignation("Developer");
		primary.setBloodGroup("A+");
		primary.setSalary(45000);
		primary.setDeptId(30);
		primary.setMgrId(10);
		primary.setProject(primaryInfos);
		
		/*
		 * primary2.setEmpId(53); primary2.setName("karan");
		 * primary2.setMobileNo(8990085632L);
		 * primary2.setMaildId("karanarjun@bcits.com");
		 * primary2.setBirthDate(java.sql.Date.valueOf("1993-11-11"));
		 * primary2.setJoiningDate(java.sql.Date.valueOf("2018-11-20"));
		 * primary2.setDesignation("Tester"); primary2.setBloodGroup("B+");
		 * primary2.setSalary(25000); primary2.setDeptId(20); primary2.setMgrId(20);
		 */

//		primaryInfos.add(primary);
		/* primaryInfos.add(primary2); */


		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(primary);
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
