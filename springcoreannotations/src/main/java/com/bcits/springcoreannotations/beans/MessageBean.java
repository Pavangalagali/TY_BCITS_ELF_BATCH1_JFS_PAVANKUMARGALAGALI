package com.bcits.springcoreannotations.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class MessageBean implements InitializingBean,DisposableBean{

	public MessageBean() {
		System.out.println("in its instantiation phase.!");
	}
	
	private String message;


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("in its init phase");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("in its destruction phase");
	}

}
