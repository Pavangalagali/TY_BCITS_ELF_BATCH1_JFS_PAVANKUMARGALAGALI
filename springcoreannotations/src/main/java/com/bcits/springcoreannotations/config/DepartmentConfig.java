package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.DepartmentBean;

@Configuration
public class DepartmentConfig {
	@Bean(name = "dev")
	public DepartmentBean getDeptDev() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(101);
		departmentBean.setDeptName("dev");

		return departmentBean;
	}// end of getDeptDev

	@Bean(name = "hr")
//	@Primary
	public DepartmentBean getDeptHR() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(102);
		departmentBean.setDeptName("HR");

		return departmentBean;
	}// end of getDeptHR

	@Bean(name = "acc")
	public DepartmentBean getDeptAccount() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(104);
		departmentBean.setDeptName("Account");

		return departmentBean;
	}// end of getDeptAccount

}
