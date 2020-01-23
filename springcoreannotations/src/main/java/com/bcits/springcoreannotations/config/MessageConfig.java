package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.MessageBean;
import com.bcits.springcoreannotations.interfaces.postprocessors.MyBeanFactoryPostProcessor;
import com.bcits.springcoreannotations.interfaces.postprocessors.MyBeanPostProcessor;

@Configuration
public class MessageConfig {
	@Bean(name = "messageBean")
	public MessageBean getMessageBean() {
		MessageBean bean = new MessageBean();
		bean.setMessage("Now you are learning  Spring Core ");
		return bean;
	}

	@Bean
	public MyBeanPostProcessor getMyBeanPP() {
		return new MyBeanPostProcessor();

	}
	
	@Bean
	public MyBeanFactoryPostProcessor getMyBFPP() {
		return new MyBeanFactoryPostProcessor();
	}
}
