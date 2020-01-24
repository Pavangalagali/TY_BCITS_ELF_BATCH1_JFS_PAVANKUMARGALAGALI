package com.bcits.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDeligationController {

	@GetMapping("/redirect")
	public String redirectRequest() {

		return "redirect:https://www.youtube.com";

	}// end of redirectRequest()

	@GetMapping("/forward")
	public String forwardRequest() {
		return "forward:loginForm";
	}
}// end of class
