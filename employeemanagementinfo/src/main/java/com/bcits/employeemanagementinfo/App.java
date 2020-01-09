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
        primary.setEmpid(187);
        primary.setName("naveen");
        primary.setMobileno(9865986587l);
        primary.setOfficial_maildid("naveenhuman@bcits.com");
        primary.setDate_of_birth(java.sql.Date.valueOf("1994-11-15"));
        primary.setDate_of_joining(java.sql.Date.valueOf("2017-04-19"));
        primary.setDesignation("developer");
        primary.setBlood_group("AB-");
        primary.setSalary(45000);
        primary.setDeptid(10);
        primary.setMgrid(10);
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
