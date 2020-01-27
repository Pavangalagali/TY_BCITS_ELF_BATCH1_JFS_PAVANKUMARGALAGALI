package com.bcits.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}// end of initBinder()

	@Autowired
	@Qualifier("service1")
	private EmployeeService service;

	@GetMapping("/login")
	public String displayLoginForm() {
		return "empLoginForm";
	}// end of displaylogin()

	@PostMapping("/login")
	public String authenticate(int empId, String password, ModelMap map, HttpServletRequest req) {

		EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);
		if (employeeInfoBean != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedEmpInfo", employeeInfoBean);
			return "employeeHome";
		} else {
			// invalid credentials
			map.addAttribute("errMsg", "Invalid Credentials");
			return "empLoginForm";
		}
	}// end of authenticate()

	@GetMapping("/searchEmpForm")
	public String displaySearchForm(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			// invalid session
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		} else {
			// valid session
			return "searchEmpForm";
		}
	}// end of displaySearchForm()

	@GetMapping("/search")
	public String searchEmployee(int empId, HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("loggedEmpInfo") != null) {
			// valid session

			EmployeeInfoBean bean = service.getEmployee(empId);

			if (bean != null) {
				modelMap.addAttribute("employeeInfoBean", bean);
			} else {
				modelMap.addAttribute("errMsg", "Employee Id Not Found");
			}
			return "searchEmpForm";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLoginForm";
		}

	}// end of searchEmployee()

	@GetMapping("/deleteEmpForm")
	public String displayDeleteForm(
			@SessionAttribute(name = "loggedEmpInfo", required = false) EmployeeInfoBean infoBean, ModelMap map) {
		if (infoBean != null) {
			// valid session
			return "deleteEmpForm";
		} else {
			// invalid session
			map.addAttribute("errMsg", "Please Login First");
			return "empLoginForm";
		}
	}// end of displayDeleteForm()

	@GetMapping("/delete")
	public String deleteEmployee(int empId,
			@SessionAttribute(name = "loggedEmpInfo", required = false) EmployeeInfoBean infoBean, ModelMap modelMap) {

		if (infoBean != null) {
			// valid sesssion
			if (service.deleteEmployee(empId)) {
				// deleted successfully
				modelMap.addAttribute("msg", "deleted successfully");
			} else {
				modelMap.addAttribute("errMsg", "Entered Id Does Not Exist");
			}
			return "deleteEmpForm";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLoginForm";
		}

	}// end of deleteEmployee();

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {

		session.invalidate();
		map.addAttribute("errMsg", "logged out successfully");
		return "empLoginForm";
	}// end of logout()

	@GetMapping("/seeAllEmployee")
	public String getAllEmployee(@SessionAttribute(name = "loggedEmpInfo", required = false) EmployeeInfoBean infoBean,
			ModelMap modelMap) {
		if (infoBean != null) {
			List<EmployeeInfoBean> infoBeans = service.getAllEmployees();
			if (infoBeans != null) {
				modelMap.addAttribute("infoBeans", infoBeans);
			} else {
				modelMap.addAttribute("errMsg", "NO Employee Found");
			}
			return "seeAllEmployee";

		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLoginForm";
		}
	}// end of seeEmployee()

	@GetMapping("/addEmployee")
	public String getAddEmployeeForm(
			@SessionAttribute(name = "loggedEmpInfo", required = false) EmployeeInfoBean infoBean, ModelMap modelMap) {
		if (infoBean != null) {
			// valid session
			return "insertEmployee";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLoginForm";
		}
	}// end of getAddEmployeeFOrm();

	@PostMapping("/addEmployee")
	public String addEmployee(EmployeeInfoBean employeeBean,
			@SessionAttribute(name = "loggedEmpInfo", required = false) EmployeeInfoBean infoBean, ModelMap modelMap) {
		if (infoBean != null) {
			if (service.addemployee(employeeBean)) {
				modelMap.addAttribute("msg", "added successfully");
			} else {
				modelMap.addAttribute("errMsg", "this Employee Record Already exists!");
			}
			return "insertEmployee";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLoginForm";
		}
	}// end of addEmployee()

	@GetMapping("/updateEmployee")
	public String getUpdateForm(@SessionAttribute(name = "loggedEmpInfo", required = false) EmployeeInfoBean infoBean,
			ModelMap modelMap) {
		if (infoBean != null) {
			// valid Session
			modelMap.addAttribute("empId", infoBean.getEmpId());
			return "updateEmployee";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLoginForm";
		}
	}// end of getUpdateForm()

	@PostMapping("/updateEmp")
	public String upadteEmployee(EmployeeInfoBean employeeBean,
			@SessionAttribute(name = "loggedEmpInfo", required = false) EmployeeInfoBean infoBean, ModelMap modelMap) {
		if (infoBean != null) {
			// valid Session
			if (service.updateEmployee(employeeBean)) {
				modelMap.addAttribute("msg", "Updated successfully");
			} else {
				modelMap.addAttribute("errMsg", "Employee Id not Found");
			}
			return "updateEmployee";
		} else {
			// invalid session
			modelMap.addAttribute("errMsg", "Please Login First");
			return "empLoginForm";
		}
	}// end of updateEmployee()

}// end of class