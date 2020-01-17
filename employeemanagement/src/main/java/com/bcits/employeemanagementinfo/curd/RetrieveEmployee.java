package com.bcits.employeemanagementinfo.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.employeemanagementinfo.bean.PrimaryInfo;

public class RetrieveEmployee {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager manager = factory.createEntityManager();
		PrimaryInfo primaryInfo = manager.getReference(PrimaryInfo.class, 10);


		System.out.println("employee id              => "+ primaryInfo.getEmpId());
		System.out.println("employee name            => "+ primaryInfo.getName());
		System.out.println("employee mail            => "+primaryInfo.getMaildId());
		System.out.println("employee mobile number   => "+primaryInfo.getMobileNo());
		System.out.println("employee designation     => "+primaryInfo.getDesignation());
		System.out.println("employee salary          => "+primaryInfo.getSalary());
		System.out.println("employee date of birth   => "+primaryInfo.getBirthDate());
		System.out.println("employee date of joining => "+primaryInfo.getJoiningDate());
		System.out.println("employee department id   => "+primaryInfo.getDeptId());
		System.out.println("employee blood group     => "+primaryInfo.getBloodGroup());
		System.out.println("employee manager id      => "+primaryInfo.getMgrId());
		System.out.println("-------------------------------");
		manager.close();
	}
}
