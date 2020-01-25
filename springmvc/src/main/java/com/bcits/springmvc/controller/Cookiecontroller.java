package com.bcits.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class Cookiecontroller {

	@GetMapping("/cookiePage")
	public String showCookiePage() {

		return "cookiesPage";
	}

	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse resp, ModelMap map) {
		Cookie cookie = new Cookie("empName", "Sai");
		resp.addCookie(cookie);

		map.addAttribute("msg", "cookie created successfully");
		return "cookiesPage";
	}

	@GetMapping("/readCookie")
	public String displayCookie(@CookieValue(name = "empName", required = false) String employeeName, ModelMap map) {
		if (employeeName != null) {

			map.addAttribute("msg", "Cookie value Is " + employeeName);
		} else {
			map.addAttribute("errMsg", "Cookie Not Present");
		}

		return "cookiesPage";
	}
}
