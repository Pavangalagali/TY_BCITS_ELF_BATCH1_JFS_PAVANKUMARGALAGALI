package com.bcits.springcore.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBean implements InitializingBean,DisposableBean{

	public MessageBean() {
		System.out.println("its instantiation phase");
	}

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * public void init() { System.out.println("its initialization phase"); }
	 */
	/*
	 * public void destroy() { System.out.println("its distruction phase"); }
	 */
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("inside init phase");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroying...!");		
	}
}
