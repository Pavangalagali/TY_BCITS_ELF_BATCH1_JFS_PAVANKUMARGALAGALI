package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bcits.springcoreannotations.beans.EmployeeBean;


@Configuration
public class EmployeeConfig2 {

	@Bean
	public EmployeeBean getEmployeeBean() {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setName("Sai");
		employeeBean.setAge(22);
//		employeeBean.setDepartmentBean(getDepartmentBean());
		return employeeBean;
	}

}
