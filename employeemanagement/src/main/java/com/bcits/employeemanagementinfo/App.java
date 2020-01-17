package com.bcits.employeemanagementinfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

public class App 
{
    public static void main( String[] args )
    {
        PrimaryInfo primary =new PrimaryInfo();
        primary.setEmpId(187);
        primary.setName("naveen");
        primary.setMobileNo(9865986587l);
        primary.setMaildId("naveenhuman@bcits.com");
        primary.setBirthDate(java.sql.Date.valueOf("1994-11-15"));
        primary.setJoiningDate(java.sql.Date.valueOf("2017-04-19"));
        primary.setDesignation("developer");
        primary.setBloodGroup("AB-");
        primary.setSalary(45000);
        primary.setDeptId(10);
        primary.setMgrId(10);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(primary);
		System.out.println("record saved");
		transaction.commit();
		manager.close();
        
        
        
    }
}
