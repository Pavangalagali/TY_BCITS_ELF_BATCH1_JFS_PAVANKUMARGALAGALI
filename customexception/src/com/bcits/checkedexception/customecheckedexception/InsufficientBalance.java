package com.bcits.checkedexception.customecheckedexception;

public class InsufficientBalance extends Exception {
	String msg="insfficient amount";

	public InsufficientBalance() {
		super();
	}

	public InsufficientBalance(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {

		return this.msg;
	}
}
