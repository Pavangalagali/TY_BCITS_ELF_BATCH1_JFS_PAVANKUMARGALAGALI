package com.bcits.employeemanagementinfo.test;


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
		
		
		EmployeeEducationInfo info = new EmployeeEducationInfo();
		EmployeeEducationInfo info1 = new EmployeeEducationInfo();

		EducationPk pk = new EducationPk();
	
		pk.setEmpId(80);
		pk.setEducationType("Degree");
		info.setEducation(pk);
		info.setCollegeName("BVB");
		info.setPercentage(88.9);
		info.setStream("EC");
		info.setUniversity("VTU");
		info.setYearOfPassout(2019);
		
		
		
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			
			 PrimaryInfo primaryInfo = manager.find(PrimaryInfo.class, 80);
			 System.out.println(primaryInfo.getEducationInfo().get(1).getCollegeName());
			 System.out.println(primaryInfo.getEducationInfo().get(1).getYearOfPassout());
			 System.out.println(primaryInfo.getEducationInfo().get(1).getStream());
			 System.out.println(primaryInfo.getEducationInfo().get(1).getUniversity());
			 
			
			/*
			 * addressInfo.setPrimaryInfo(primaryInfo); manager.persist(addressInfo);
			 */
			transaction.begin();
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
