package com.bcits.springrestjaxb.jasontest;

import java.io.File;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.bean.EmployeeInfoBean;

public class EmployeeJASONMarshallingTest {

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
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("employeejson3.json"), infoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
