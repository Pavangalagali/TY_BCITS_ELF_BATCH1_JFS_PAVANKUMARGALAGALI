package com.bcits.discomproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsumerController {
	
	@GetMapping("/consumerLogin")
	public String displayLogin() {
		return "consumerLogin";
	}
	
	
}
