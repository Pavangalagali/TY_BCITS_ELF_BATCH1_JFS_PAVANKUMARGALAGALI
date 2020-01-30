package com.bcits.discomproject.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.service.ConsumerService;

@Controller
public class ConsumerController {

	@Autowired
	private ConsumerService service;

	@GetMapping("/consumerLogin")
	public String displayLogin() {
		return "consumerLogin";
	}// end of displayLogin()

	@GetMapping("/signUp")
	public String displaySignUp() {
		return "consumerSignup";
	}// end of displaySignUp()

	@PostMapping("/userSignup")
	public String consumerSignUp(ConsumerMaster consumerMaster, String confirmPwd, ModelMap map) {
		if (service.signUpConsumer(consumerMaster, confirmPwd)) {
			map.addAttribute("msg", "sigup successfull login now!!!");
			return "consumerLogin";
		} else {
			map.addAttribute("errMsg", "this user exist already");
			return "consumerSignup";
		}
	}// end of consumerSignup()

	@PostMapping("/consumerLogin")
	public String authenticate(String rrNumber, String password, ModelMap map,HttpServletRequest req) {
		ConsumerMaster consumerMaster = service.authenticate(rrNumber, password);
		if (consumerMaster != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("consumerInfo", consumerMaster);
			return "consumerHome";
		} else {
			// invalid credentials
			map.addAttribute("errMsg", "Invalid Credentials");
			return "consumerLogin";
		}
	}

}
