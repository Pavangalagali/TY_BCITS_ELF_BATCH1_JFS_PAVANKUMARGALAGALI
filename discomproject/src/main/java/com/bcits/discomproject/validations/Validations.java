package com.bcits.discomproject.validations;

public class Validations {

	public  boolean rrValidation(String str) {
		
		if(str.length()>=3 && str.length()<11) {
			return true;
		}
		return false;

	}

	public  boolean nameValidation(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean supportValidation(String support) {
		if(support.length() > 2001) {
			return false;
		}
		return true;
	}
	
	public boolean validatePhoneNumber() {
		
		return true;
	}
}
