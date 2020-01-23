package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bcits.springcoreannotations.beans.EmployeeBean;

@Configuration
public class EmployeeConfig {
	/*
	 * @Bean public EmployeeBean getEmployeeBean() { EmployeeBean bean = new
	 * EmployeeBean(); bean.setName("akash"); bean.setAge(23); return bean; }
	 * //singleton
	 */

	@Bean
	//@Scope("prototype")
	public EmployeeBean getEmployeeBean() { // setting scope to non-singleton
		return new EmployeeBean();
	}

}// end of class
