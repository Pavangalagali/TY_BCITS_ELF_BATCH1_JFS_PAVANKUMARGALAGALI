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

import com.bcits.discomproject.beans.BillHistory;
import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.beans.EmployeeMaster;
import com.bcits.discomproject.beans.MonthlyConsumption;
import com.bcits.discomproject.beans.SupportPk;
import com.bcits.discomproject.beans.SupportRequest;
import com.bcits.discomproject.dao.ConsumerDAO;
import com.bcits.discomproject.dao.EmployeeDAO;
import com.bcits.discomproject.service.BillCollected;
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
	public String showCurrentBill(String rrNumber,
			@SessionAttribute(name = "admin", required = false) EmployeeMaster master, ModelMap map) {
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
	public String generateBill(CurrentBill currentBill,
			@SessionAttribute(name = "admin", required = false) EmployeeMaster master, ModelMap map) {
		if (master != null) {
			if (empService.generateBill(currentBill)) {
				if (empService.sendMail(currentBill.getRrNumber())) {
					map.addAttribute("msg",
							"generated bill successfully for " + currentBill.getRrNumber() + " and sent mail");
				} else {
					map.addAttribute("msg",
							"generated bill successfully for " + currentBill.getRrNumber() + "Failed to send mail");
				}
				return "employeeHome";
			} else {
				map.addAttribute("errMsg", "Entered Improper Deatils try again ");
				return "currentBill";
			}
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of generatebill

	@GetMapping("/getSearchResult")
	public String getResult(String rrNumber, @SessionAttribute(name = "admin", required = false) EmployeeMaster master,
			ModelMap map) {
		if (master != null) {
			if (empService.checkForSameRegion(master.getRegion(), rrNumber)) {
				List<MonthlyConsumption> consumptions = service.consumptions(rrNumber);
				List<SupportRequest> requests = empService.getSupportRequest(rrNumber);
				if (consumptions == null) {
					map.addAttribute("support", requests);
					map.addAttribute("msg", "No current details found");
				} else {
					map.addAttribute("consumptions", consumptions);
					map.addAttribute("support", requests);
				}
			} else {
				map.addAttribute("errMsg", "This Consumer is not from your region");
			}
			map.addAttribute("rrNumber", rrNumber);
			return "searchResult";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of getResult()

	@GetMapping("/getAll")
	public String showAllConsumers(@SessionAttribute(name = "admin", required = false) EmployeeMaster master,
			ModelMap map) {
		if (master != null) {
			List<ConsumerMaster> consumers = empService.getAllConsumers(master.getRegion());
			if (consumers != null) {
				map.addAttribute("consumers", consumers);
			} else {
				map.addAttribute("msg", "No Consumer Found");
			}
			return "showAllConsumers";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of showAllConsumer();

	@PostMapping("/generateResponse")
	public String response(SupportPk supportPk, String response,
			@SessionAttribute(name = "admin", required = false) EmployeeMaster master, ModelMap map) {

		if (master != null) {
			empService.generateResponse(supportPk, response);
			List<SupportRequest> requests = empService.getSupportRequest(supportPk.getRrNumber());
			map.addAttribute("support", requests);
			return "searchResult";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of response()

	@GetMapping("/generatedBills")
	public String getGeneratedBills(@SessionAttribute(name = "admin", required = false) EmployeeMaster master,
			ModelMap map) {

		if (master != null) {
			List<CurrentBill> bills = empService.currentBills(master.getRegion());
			if (bills != null) {
				map.addAttribute("currentBill", bills);
			} else {
				map.addAttribute("msg", "Bills Are not Generated Yet");
			}
			return "generatedBills";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of generatedBills()

	@GetMapping("/empHome")
	public String getHome(@SessionAttribute(name = "admin", required = false) EmployeeMaster master, ModelMap map) {
		if (master != null) {
			return "employeeHome";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of getHome();

	@GetMapping("/monthlyRevenue")
	public String getMOMRevenuePage(@SessionAttribute(name = "admin", required = false) EmployeeMaster master,
			ModelMap map) {
		if (master != null) {
			map.addAttribute("paid", empService.getPaidBills(master.getRegion()));
			map.addAttribute("pending", empService.getPendingBills(master.getRegion()));
			return "monthlyRevenue";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of getMOMRevenuePage

	@GetMapping("/collected")
	public String getCollectedBill(@SessionAttribute(name = "admin", required = false) EmployeeMaster master,
			ModelMap map) {

		if (master != null) {
			List<BillHistory> collected = empService.getCollectedBill(master.getRegion());
			if (collected != null) {

				map.addAttribute("collected", collected);
			} else {
				map.addAttribute("errMsg", "No Consumer paid the bill this month");
			}
			return "billCollected";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of getCollectedBill()

	@GetMapping("/requestSupport")
	public String getSupportRequests(@SessionAttribute(name = "admin", required = false) EmployeeMaster master,
			ModelMap map) {
		if (master != null) {
			List<SupportRequest> requests = empService.getAllRequestSupport(master.getRegion());
			if (requests != null) {
				map.addAttribute("support", requests);
			} else {
				map.addAttribute("errMsg", "No Consumer paid the bill this month");
			}
			return "requestSupport";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of getSupportRequests()

	@PostMapping("/generateSupport")
	public String sendResponse(SupportPk supportPk, String response,
			@SessionAttribute(name = "admin", required = false) EmployeeMaster master, ModelMap map) {
		if (master != null) {
			empService.generateResponse(supportPk, response);
			List<SupportRequest> requests = empService.getAllRequestSupport(master.getRegion());
			map.addAttribute("support", requests);
			return "requestSupport";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of sendResponse();

	@PostMapping("/UpdateDueBill")
	public String updateDue(String rrNumber, Date date,
			@SessionAttribute(name = "admin", required = false) EmployeeMaster master, ModelMap map) {

		if (master != null) {
			if (empService.updateDueBill(rrNumber, date)) {
				map.addAttribute("msg", "Updated successfully");

			} else {
				map.addAttribute("errMsg", "Could not update try later");
			}
			List<MonthlyConsumption> consumptions = service.consumptions(rrNumber);
			map.addAttribute("consumptions", consumptions);
			return "searchResult";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "home";
		}
	}// end of sendResponse();
}
