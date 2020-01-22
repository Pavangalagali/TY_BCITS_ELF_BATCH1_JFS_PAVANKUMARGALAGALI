package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.MessageBean;

public class MessageTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// ((ConfigurableApplicationContext) context).registerShutdownHook();

		MessageBean messageBean = (MessageBean) context.getBean("message");

		System.out.println(messageBean.getMessage());

		((AbstractApplicationContext) context).close();
	}
}
