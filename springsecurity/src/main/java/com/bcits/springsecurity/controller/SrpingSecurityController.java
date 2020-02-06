package com.bcits.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SrpingSecurityController {

	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}

	@GetMapping("/adminHome")
	public String getAdminHome() {
		return "adminHome";
	}

	@GetMapping("/userHome")
	public String getUserHome() {
		return "userHome";
	}

	@GetMapping("/login")
	public String getLoginForm() {
		return "loginForm";
	}
}
