package com.bcits.employeemanagementinfo.test;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;
import com.bcits.employeemanagementinfo.manytoone.EducationPk;
import com.bcits.employeemanagementinfo.manytoone.EmployeeEducationInfo;

public class ManyToOneEducation {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		List<EmployeeEducationInfo> list = new ArrayList<EmployeeEducationInfo>();
		
		EmployeeEducationInfo info = new EmployeeEducationInfo();
		EmployeeEducationInfo info1 = new EmployeeEducationInfo();
		PrimaryInfo primary = new PrimaryInfo();
		EducationPk pk1 = new EducationPk();
		EducationPk pk = new EducationPk();
	
		primary.setEmpId(68);
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
		
		
		pk.setEmpId(68);
		pk.setEducationType("SSLC");
		info.setEducation(pk);
		info.setCollegeName("BEC");
		info.setPercentage(88.9);
		info.setStream("EC");
		info.setUniversity("CBSE");
		info.setYearOfPassout(2019);
		info.setPrimaryInfo(primary);
		
		pk1.setEmpId(68);
		pk1.setEducationType("Degree");
		info1.setEducation(pk1);
		info1.setCollegeName("BVB");
		info1.setPercentage(88.9);
		info1.setStream("EC");
		info1.setUniversity("VTU");
		info1.setYearOfPassout(2019);
		info1.setPrimaryInfo(primary);
		
		list.add(info);
		list.add(info1);
		
		
		primary.setEducationInfo(list);
		
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			
			/*
			 * PrimaryInfo primaryInfo = manager.find(PrimaryInfo.class, 80);
			 * System.out.println(primaryInfo.getEducationInfo().get(1).getCollegeName());
			 * System.out.println(primaryInfo.getEducationInfo().get(1).getYearOfPassout());
			 * System.out.println(primaryInfo.getEducationInfo().get(1).getStream());
			 * System.out.println(primaryInfo.getEducationInfo().get(1).getUniversity());
			 */
			
			/*
			 * addressInfo.setPrimaryInfo(primaryInfo); manager.persist(addressInfo);
			 */
			transaction.begin();
			manager.persist(primary);
			/*
			 * PrimaryInfo primary = manager.find(PrimaryInfo.class, 80);
			 * info.setPrimaryInfo(primary);
			 */
//			manager.persist(info);
			
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
