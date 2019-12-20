/**
 * 
 */
package com.javawork.third;


public class Main4 {

	/**
	 * creating diver class object;
	 * passing the audi or benz object to driver object;
	 */
	public static void main(String[] args) {
		
		Driver d1 = new Driver();
		d1.drive(new Audi());
		
		Driver d2 = new Driver();
		d2.drive(new Benz());

	}

}
