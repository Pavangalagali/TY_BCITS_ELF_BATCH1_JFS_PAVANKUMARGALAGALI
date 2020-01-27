package com.bcits.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {

	@Bean
	public LocalEntityManagerFactoryBean getManagerFactory() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("emsPeristenceUnit");
		return bean;
	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean getEntityManger() {
//		LocalContainerEntityManagerFactoryBean  factoryBean = new LocalContainerEntityManagerFactoryBean();
//		factoryBean.setPersistenceUnitName("emsPeristenceUnit");
//		return factoryBean;
//	}

}