package com.bcits.jdbcapp.abstraction;

public class ClassX implements Connection {

	@Override
	public Statement createStatement() {
	
		return new ClassC();
	}

}
