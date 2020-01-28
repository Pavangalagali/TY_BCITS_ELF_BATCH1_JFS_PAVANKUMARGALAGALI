package com.bcits.springrestjaxb.apptest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.bean.EmployeeInfoBean;
import com.bcits.springrestjaxb.bean.UserInfo;

public class EmployeeUnMarshallingTest {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(UserInfo.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			EmployeeInfoBean infoBean = (EmployeeInfoBean) unmarshaller.unmarshal(new File("UserInfo.xml"));

			System.out.println("Name : " + infoBean.getName());
			System.out.println("ID   : " + infoBean.getEmpId());
			System.out.println("DOB  : " + infoBean.getBirthDate());
			System.out.println("Role : " + infoBean.getDesignation());
			System.out.println("salary : " + infoBean.getSalary());
		

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
