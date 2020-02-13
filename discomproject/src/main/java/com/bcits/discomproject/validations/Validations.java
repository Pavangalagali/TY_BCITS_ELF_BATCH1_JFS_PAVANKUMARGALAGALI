package com.bcits.discomproject.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.EmployeeMaster;

/*
*   validations 
*/

public class Validations {

	public boolean rrValidation(String str) {

		if (str.length() >= 3 && str.length() < 11) {
			return true;
		}
		return false;

	}// end of rrNumber validation

	public boolean nameValidation(String name) {

		if (name != null && !name.isEmpty()) {
			if (name.matches("[a-z]*") || name.matches("[A-Z][a-z]*")) {
				return true;
			}

		}
		return false;
	}// end of nameValidation

	public boolean supportValidation(String support) {
		if (support.length() > 2001) {
			return false;
		}
		return true;
	}// end of support validation

	public boolean validatePhoneNumber(String phoneNumber) {
		Pattern phoneNumFormat = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		Matcher match = phoneNumFormat.matcher(phoneNumber);
		return (match.find() && match.group().equals(phoneNumber));
	}// end of phone number validation

	public boolean validateNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validatePassword(String password) {
		if (password != null && password.length() >= 4) {
			return true;
		}
		return false;

	}// end of validation for password

	public boolean validateAddress(String address) {
		if (address != null && !address.isEmpty()) {
			return true;
		}
		return false;
	}// end of validation for address

	public boolean validateEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);

		if (email == null) {
			return false;
		}

		return pattern.matcher(email).matches();
	}// end of email validation

	public boolean validateConsumerDeatils(ConsumerMaster master) {
		System.out.println("inside validation");
		if (nameValidation(master.getFirstName()) && nameValidation(master.getLastName())
				&& rrValidation(master.getRrNumber()) && validateEmail(master.getEMail())
				&& validatePhoneNumber(master.getPhoneNumber() + "") && validateNumber(master.getHouseNo() + "")
				&& validateAddress(master.getAddress1()) && validateAddress(master.getAddress2())
				&& validatePassword(master.getPassword())) {

			System.out.println(" validation done");
			return true;
		}
		return false;
	}// end consumer details validation

	public boolean validateEmployeeName(String name) {
		String expression = "^[a-zA-Z\\s]+";
		return name.matches(expression);
	}

	public boolean validateEmployeeDeatils(EmployeeMaster master) {
		System.out.println("inside employee details validation");
		if (validateEmployeeName(master.getName()) && validateNumber(master.getId() + "")
				&& validateEmail(master.getEMail()) && validatePassword(master.getPassword())
				&& validateAddress(master.getRole())) {
			System.out.println("success");
			return true;
		}
		return false;
	}
}
