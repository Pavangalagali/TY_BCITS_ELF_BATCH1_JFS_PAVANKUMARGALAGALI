package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.bean.EmployeeInfoBean;

public class EmployeeMarshallingTest {

	public static void main(String[] args) {
		EmployeeInfoBean infoBean = new EmployeeInfoBean();
		infoBean.setBirthDate(new Date());
		infoBean.setBloodGroup("A-");
		infoBean.setDeptId(11);
		infoBean.setDesignation("ssd");
		infoBean.setEmpId(101);
		infoBean.setJoiningDate(new Date());
		infoBean.setMaildId("sai@gmail.com");
		infoBean.setMgrId(22);
		infoBean.setMobileNum(9876878789L);
		infoBean.setName("Sai");
		infoBean.setSalary((double) 60000);
		infoBean.setPassword("qwerty");

		JAXBContext context;
		try {
			context = JAXBContext.newInstance(EmployeeInfoBean.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(infoBean, System.out);
			marshaller.marshal(infoBean, new File("employeeInfo.xml"));

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
