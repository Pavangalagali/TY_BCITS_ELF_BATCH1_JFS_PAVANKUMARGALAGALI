package com.javawork.third;

public class Driver {
    
	Object car;

    public void drive(Object car)
    {
    	if(car instanceof Audi) {
    		System.out.println("Driver is driving Audi");
    	}else {
    		System.out.println("Driver is driving Benz");
    	}
    }
}
