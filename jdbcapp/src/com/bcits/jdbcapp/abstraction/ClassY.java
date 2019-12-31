package com.bcits.jdbcapp.abstraction;

public class ClassY implements Connection {

	@Override
	public Statement createStatement() {
	
		return new ClassB();
	}

}
