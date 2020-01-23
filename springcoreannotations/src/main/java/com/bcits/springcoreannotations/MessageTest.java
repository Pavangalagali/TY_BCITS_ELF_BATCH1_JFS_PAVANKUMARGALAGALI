package com.bcits.springcoreannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.MessageBean;
import com.bcits.springcoreannotations.config.MessageConfig;

public class MessageTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
		((ConfigurableApplicationContext)context).registerShutdownHook();
		MessageBean bean = context.getBean(MessageBean.class);

		System.out.println(bean.getMessage());

	}// end of main

}// end of class
