package com.bcits.discomproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.discomproject.beans.EmployeeMaster;
import com.bcits.discomproject.dao.AdminDAO;
import com.bcits.discomproject.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping("/logOut")
	public String logOut(HttpSession httpSession, ModelMap map) {
		httpSession.invalidate();
		map.addAttribute("msg", "Logged out successfully");
		return "home";
	}// end of logout()

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}// end of getHome()

	@PostMapping("/empLogin")
	public String adminLogin(int id, String password, HttpServletRequest req, ModelMap map) {
		EmployeeMaster master = service.authenticate(id, password);
		if (master != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("admin", master);
			if (master.getRole().equals("admin")) {
				return "adminHome";
			} else {
				return "employeeHome";
			}
		} else {
			map.addAttribute("errMsg", "invalid crendentials");
			return "employeeLogin";
		}
	}// end of employeeLogin()

	@GetMapping("/empGrant")
	public String getGrantPage(@SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		if (master != null) {
			return "grantPage";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "employeeLogin";
		}
	}// end of getGrantPage()

	@GetMapping("/revoke")
	public String getEmployeeDetails(@SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		if (master != null) {
			List<EmployeeMaster> masters = service.getAll();
			if (masters != null) {
				map.addAttribute("employees", masters);
			} else {
				map.addAttribute("msg", "No Employee has Access");
			}
			return "adminHome";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "employeeLogin";
		}
	}// end of getEmployeeDetails()

	@GetMapping("/revokeEmployee")
	public String revokAccess(int id, @SessionAttribute("admin") EmployeeMaster master, ModelMap map) {
		if (master != null) {
			if (service.revokeEmployeeAccess(id)) {
				List<EmployeeMaster> masters = service.getAll();
				if (masters != null) {
					map.addAttribute("employees", masters);
				}
			} else {
				map.addAttribute("msg", "No Employee has Access");
			}
			return "adminHome";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "employeeLogin";
		}
	}// end of revokeAccess();

	@PostMapping("/grantAccess")
	public String provideAccess(EmployeeMaster employee, String pwd, @SessionAttribute("admin") EmployeeMaster master,
			ModelMap map) {
		if (master != null) {
			if (service.grantEmployeeAccess(employee, pwd)) {
				map.addAttribute("msg", "Provided Access Successfully");
			} else {
				map.addAttribute("errMsg", "password MissMatch");
			}
			return "adminHome";
		} else {
			map.addAttribute("errMsg", "Session Time out!! Login Again");
			return "employeeLogin";
		}

	}// end of provideAccess

}// end of class
