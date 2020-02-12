package com.bcits.discomproject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import com.bcits.discomproject.validations.Validations;

@Configuration
public class EntityManagerFactoryConfig {


	@Bean
	public LocalEntityManagerFactoryBean getManagerFactory() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("discomPeristence");
		return bean;
	}
	
	@Bean
	public Validations validations() {
		return new Validations();
	}
	
}
