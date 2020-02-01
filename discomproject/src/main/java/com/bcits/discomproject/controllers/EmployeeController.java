package com.bcits.discomproject.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.dao.ConsumerDAO;

@Controller
public class EmployeeController {

	@Autowired
	private ConsumerDAO service;
	
	@GetMapping("/employeeLogin")
	public String displayLogin() {
		return "employeeLogin";
	}// end of displayLogin()
	
	@PostMapping("/employeeLogin")
	public String authenticate(String rrNumber, String password, ModelMap map, HttpServletRequest req) {
		ConsumerMaster consumerMaster = service.authenticate(rrNumber, password);
		if (consumerMaster != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("consumerInfo", consumerMaster);
			CurrentBill currentBill = service.currentBill(consumerMaster.getRrNumber());
			map.addAttribute("currentBill", currentBill);
			return "consumerHome";
		} else {
			// invalid credentials
			map.addAttribute("errMsg", "Invalid Credentials");
			return "consumerLogin";
		}
	}// end of login()
	
	
}
