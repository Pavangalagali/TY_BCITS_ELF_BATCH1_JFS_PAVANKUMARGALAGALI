package com.bcits.discomproject.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.service.ConsumerService;

@Controller
public class ConsumerController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}// end of initBinder()

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
	public String authenticate(String rrNumber, String password, ModelMap map, HttpServletRequest req) {
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
	}// end of login()

	@GetMapping("/monthlyConsumption")
	public String getMonthlyConsumption(
			@SessionAttribute(name = "consumerInfo", required = false) ConsumerMaster consumerMaster, ModelMap map) {
		if (consumerMaster != null) {
			List<MonthlyConsumption> consumptions = service.consumptions(consumerMaster.getRrNumber());
			if (consumptions != null) {
				map.addAttribute("mc", consumptions);

			} else {
				map.addAttribute("msg", "no records available");
			}
			return "consumerHome";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "consumerLogin";
		}

	}// end of monthlyconsumption

	@GetMapping("/billHistory")
	public String getBillHistory(
			@SessionAttribute(name = "consumerInfo", required = false) ConsumerMaster consumerMaster, ModelMap map) {
		if (consumerMaster != null) {
			List<MonthlyConsumption> consumptions = service.consumptions(consumerMaster.getRrNumber());
			if (consumptions != null) {
				map.addAttribute("bill", consumptions);

			} else {
				map.addAttribute("msg", "no records available");
			}
			return "consumerHome";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "consumerLogin";
		}

	}// end of getbillHistory()

	@GetMapping("/currentBill")
	public String getCurrentBill(
			@SessionAttribute(name = "consumerInfo", required = false) ConsumerMaster consumerMaster, ModelMap map) {
		if (consumerMaster != null) {
			CurrentBill currentBill = service.currentBill(consumerMaster.getRrNumber());
			if (currentBill != null) {
				map.addAttribute("currentBill", currentBill);

			} else {
				map.addAttribute("msg", "This Month Bill Not generated yet");
			}
			return "consumerHome";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "consumerLogin";
		}
	}// end of getCurrentBill()

	@GetMapping("/payment")
	public String paymentPage(@SessionAttribute(name = "consumerInfo", required = false) ConsumerMaster consumerMaster,
			ModelMap map) {
		if (consumerMaster != null) {
			return "paymentPage";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "consumerLogin";
		}
	}// end of paymentPage()

	@GetMapping("/paymentDone")
	public String payment(@SessionAttribute(name = "consumerInfo", required = false) ConsumerMaster consumerMaster,
			ModelMap map) {
		if (consumerMaster != null) {
			if (service.billPayment(consumerMaster.getRrNumber())) {
				map.addAttribute("msg", "Paid Successfully");
			} else {
				map.addAttribute("msg", "Unable to process try later");
			}
			return "consumerHome";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "consumerLogin";
		}
	}// end of getCurrentBill()

	@PostMapping("/sendSupport")
	public String sendSupportRequest(
			@SessionAttribute(name = "consumerInfo", required = false) ConsumerMaster consumerMaster,String support, ModelMap map) {
		if (consumerMaster != null) {
			if (service.supportRequest(consumerMaster.getRrNumber(), support)) {
				map.addAttribute("msg", "support Requested");
			} else {
				map.addAttribute("msg", "Unable to process try later");
			}
			return "consumerHome";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "consumerLogin";
		}
	}

}
