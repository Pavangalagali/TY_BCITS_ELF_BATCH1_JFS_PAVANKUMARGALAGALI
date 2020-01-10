package com.bcits.employeemanagementinfo.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

public class RetrieveEmployee {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager manager = factory.createEntityManager();
		PrimaryInfo info = manager.getReference(PrimaryInfo.class, 10);

		System.out.println("id           ==> " + info.getEmpid());
		System.out.println("name         ==> " + info.getName());
		System.out.println("designation  ==> " + info.getDesignation());
		System.out.println("department id ==> " + info.getDeptid());
		System.out.println("mobile number ==>" + info.getMobileno());
		System.out.println("maild id     ==> " + info.getOfficial_maildid());
		System.out.println("salary       ==> " + info.getSalary());
		System.out.println("manager id   ==> " + info.getMgrid());
		System.out.println("blood group  ==> " + info.getBlood_group());
		System.out.println("DOB          ==> " + info.getDate_of_birth());
		System.out.println("DOJ          ==> " + info.getDate_of_joining());
		System.out.println("-------------------------------");
		manager.close();
	}
}
