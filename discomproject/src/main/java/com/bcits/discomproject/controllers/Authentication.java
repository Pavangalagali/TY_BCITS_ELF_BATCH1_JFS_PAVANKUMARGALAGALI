package com.bcits.discomproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Authentication {

	@GetMapping("/logOut")
	public String logOut(HttpSession httpSession, ModelMap map) {
		httpSession.invalidate();
		map.addAttribute("msg", "Logged out successfully");
		return "home";
	}

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}

}
