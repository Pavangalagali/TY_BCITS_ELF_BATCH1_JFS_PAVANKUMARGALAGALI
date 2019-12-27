package com.bcits.checkedexception.customeuncheckedexception;

public class AgeLimitException extends RuntimeException {
	String msg = "age is less than 18";

	public AgeLimitException() {
		super();
	}

	public AgeLimitException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {

		return this.msg;
	}
}
