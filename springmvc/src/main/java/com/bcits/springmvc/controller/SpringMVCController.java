package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bcits.springmvc.beans.UserBean;

@Controller
public class SpringMVCController {

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public ModelAndView displayMessage() {

		ModelAndView modelAndView = new ModelAndView();
		/* modelAndView.setViewName("/WEB-INF/view/message.jsp"); */ // when view resolver is not configured
		modelAndView.setViewName("message");
		return modelAndView;
	}// end of displayMessage()

	@RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
	public ModelAndView searchEmployee(HttpServletRequest request) {

		String empIdVal = request.getParameter("empId");

		ModelAndView modelAndView = new ModelAndView();
		/* modelAndView.setViewName("/WEB-INF/view/searchEmployee.jsp"); */// when view resolver is not configured
		modelAndView.setViewName("searchEmployee");
		request.setAttribute("empId", empIdVal);

		return modelAndView;
	} // end of searchEmployee()

	@RequestMapping(path = "/loginForm", method = RequestMethod.GET)
	public ModelAndView displayLoginForm() {
		ModelAndView view = new ModelAndView();
		/* view.setViewName("/WEB-INF/view/loginForm.jsp"); */ // when view resolver is not configured
		view.setViewName("loginForm");

		return view;
	}// end of displayLoginForm()

	@RequestMapping(path = "/login1", method = RequestMethod.POST)
	public ModelAndView login1(HttpServletRequest request, ModelAndView modelAndView) {
		int empId = Integer.parseInt(request.getParameter("empId"));
		String password = request.getParameter("password");

		modelAndView.addObject("empId", empId);
		modelAndView.addObject("pwd", password);

		/* modelAndView.setViewName("/WEB-INF/view/userDetails.jsp"); */// when view resolver is not configured
		modelAndView.setViewName("userDetails");
		return modelAndView;

	}// end of login1()

	@PostMapping("/login2")
	public ModelAndView login2(@RequestParam(name = "") int empId, @RequestParam(name = "") String password,
			ModelAndView modelAndView) {

		modelAndView.addObject("empId", empId);
		modelAndView.addObject("pwd", password);
//		modelAndView.setViewName("/WEB-INF/view/userDetails.jsp");//when view resolver is not configured
		modelAndView.setViewName("userDetails");
		return modelAndView;
	}// end of login2()

	@PostMapping("/login3")
	public String login3(int empId, String password, ModelMap modelMap) {
		modelMap.addAttribute("empId", empId);
		modelMap.addAttribute("pwd", password);

		return "userDetails";
	}// end of login3()

	@PostMapping("/login4")
	public String login4(UserBean userBean, String name, ModelMap modelMap) {
		modelMap.addAttribute("userBean", userBean);
		modelMap.addAttribute("name", name);

		/* return "/WEB-INF/view/userDetails2.jsp"; */ // when view resolver is not configured
		return "userDetails2";
	}// end of login4()

}
