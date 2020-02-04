package com.bcits.discomproject.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.bcits.discomproject.beans.EmployeeMaster;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;
import com.bcits.discomproject.dao.ConsumerDAO;
import com.bcits.discomproject.dao.EmployeeDAO;
import com.bcits.discomproject.service.ConsumerService;
import com.bcits.discomproject.service.EmployeeService;

@Controller
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}// end of initBinder()

	@Autowired
	private ConsumerService service;

	@Autowired
	private EmployeeService empService;

	

	@GetMapping("/employeeLogin")
	public String getLoginForm() {
		return "employeeLogin";
	}// end of getLoginForm()

	@GetMapping("/curentBillPage")
	public String showCurrentBill(String rrNumber, @SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		if (master != null) {
			List<MonthlyConsumption> consumptions = service.consumptions(rrNumber);
			if (consumptions == null) {
				map.addAttribute("msg", "No current details found");
			} else {
				map.addAttribute("consumptions", consumptions);
			}
			map.addAttribute("rrNumber", rrNumber);
			return "currentBill";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of showcurrentBill()

	@PostMapping("/generateBill")
	public String generateBill(CurrentBill currentBill, @SessionAttribute("admin") EmployeeMaster master,
			ModelMap map) {
		if (master != null) {
			if (empService.generateBill(currentBill)) {
				map.addAttribute("msg", "generated bill successfully for "+currentBill.getRrNumber());
				return "employeeHome";
			}else {
				map.addAttribute("errMsg", "Entered Improper Deatils try again ");
				return "currentBill";
			}
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of generatebill

	@GetMapping("/getSearchResult")
	public String getResult(String rrNumber, @SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		if (master != null) {
			List<MonthlyConsumption> consumptions = service.consumptions(rrNumber);
			List<SupportRequest> requests = empService.getSupportRequest(rrNumber);
			if (consumptions == null) {
				map.addAttribute("support", requests);

				map.addAttribute("msg", "No current details found");
			} else {
				map.addAttribute("consumptions", consumptions);
				map.addAttribute("support", requests);
			}
			map.addAttribute("rrNumber", rrNumber);
			return "searchResult";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}//end of getResult()

	@GetMapping("/getAll")
	public String showAllConsumers( @SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		if (master != null) {
			List<ConsumerMaster> consumers = empService.getAllConsumers(master.getRegion());
			if (consumers != null) {
				map.addAttribute("consumers",consumers);
			} else {		
				map.addAttribute("msg","No Consumer Found");
			}
			return "showAllConsumers";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}//end of showAllConsumer();
	
	@PostMapping("/generateResponse")
	public  String response(SupportPk supportPk,String response,@SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		System.out.println(supportPk+" "+response);
		if (master != null) {
			empService.generateResponse(supportPk,response);
			List<SupportRequest> requests = empService.getSupportRequest(supportPk.getRrNumber());
			map.addAttribute("support", requests);
			return "searchResult";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}
	
}
