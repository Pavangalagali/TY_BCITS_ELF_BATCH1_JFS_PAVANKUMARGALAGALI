package com.bcits.springrestjaxb.jasontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.bean.EmployeeInfoBean;

public class EmployeeJSONUnmarshalling {

	public static void main(String[] args) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			EmployeeInfoBean infoBean = mapper.readValue(new File("employeejson1.json"), EmployeeInfoBean.class);

			System.out.println("Name : " + infoBean.getName());
			System.out.println("ID   : " + infoBean.getEmpId());
			System.out.println("DOB  : " + infoBean.getBirthDate());
			System.out.println("Role : " + infoBean.getDesignation());
			System.out.println("salary : " + infoBean.getSalary());
			System.out.println("password : " + infoBean.getPassword());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
