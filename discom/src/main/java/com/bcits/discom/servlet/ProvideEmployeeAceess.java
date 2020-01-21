package com.bcits.discom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.discom.bean.EmployeeMaster;
import com.bcits.discom.model.EmployeeDAO;
import com.bcits.discom.model.EmployeeDAOHibernateImpl;

@WebServlet("/addEmp")
public class ProvideEmployeeAceess extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		if(session != null) {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String eMail =	req.getParameter("eMail");
		String designation =	req.getParameter("role");
		String region =	req.getParameter("region");
		String password = req.getParameter("password");

		EmployeeDAO dao = new EmployeeDAOHibernateImpl();
		EmployeeMaster employeeMaster = dao.getEmployee(id, password);
		
		if(employeeMaster == null) {
			
			EmployeeMaster master = new  EmployeeMaster();
			master.setId(id);
			master.setName(name);
			master.setEMail(eMail);
			master.setPassword(password);
			master.setRegion(region);
			master.setRole(designation);
			
			boolean success = dao.provideAccess(master);
			if(success) {
				req.setAttribute("msg", "Addedd succesfully");
				req.getRequestDispatcher("./adminPage.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "Something Went Wrong");
				req.getRequestDispatcher("./adminPage.jsp").forward(req, resp);
			}
			
			
			
		}else {
			req.setAttribute("msg", "already exists");
			req.getRequestDispatcher("./adminPage.jsp").forward(req, resp);
		}
		}else {
			req.setAttribute("msg", "session time out Login Again");
			req.getRequestDispatcher("./employeeLogin.jsp").forward(req, resp);
		}
	}

}
