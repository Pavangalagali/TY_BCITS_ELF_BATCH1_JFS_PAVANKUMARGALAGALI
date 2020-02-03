package com.bcits.discomproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.EmployeeMaster;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.dao.ConsumerDAO;
import com.bcits.discomproject.dao.EmployeeDAO;
import com.bcits.discomproject.service.ConsumerService;
import com.bcits.discomproject.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private ConsumerService service;
	
	@Autowired
	private EmployeeService empService; 
	
	@Autowired
	private EmployeeDAO employeeService;
	@GetMapping("/employeeLogin")
	public String getLoginForm() {
		return "employeeLogin";
	}// end of getLoginForm()
	
	@GetMapping("/curentBillPage")
	public String showCurrentBill(String rrNumber,@SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		if(master != null) {
			List<MonthlyConsumption> consumptions = service.consumptions(rrNumber);
			if(consumptions == null) {
				map.addAttribute("msg", "No current details found");
			}else {
				map.addAttribute("consumptions", consumptions)	;
			}
			return "currentBill";
		}else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}//end of showcurrentBill()
	
	@PostMapping("/generateBill")
	public String generateBill(CurrentBill currentBill,@SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		if(master != null) {
			if(employeeService.generateBill(currentBill)) {
				map.addAttribute("msg", "generated successfully");
			}
			return "employeeHome";
		}else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}//end of generatebill
	
	@GetMapping("/getSearchResult")
	public String  getResult(String rrNumber,@SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		if(master != null) {
			List<MonthlyConsumption> consumptions = service.consumptions(rrNumber);
			if(consumptions == null) {
				map.addAttribute("msg", "No current details found");
			}else {
				map.addAttribute("consumptions", consumptions)	;
			}
			return "searchResult";
		}else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}
	
}
