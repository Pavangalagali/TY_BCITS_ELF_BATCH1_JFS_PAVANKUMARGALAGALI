package com.bcits.discom.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.discom.bean.EmployeeMaster;

@WebServlet("/empLogin")
public class EmployeeLogin extends HttpServlet {
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("discomPeristence");
		EntityManager manager = managerFactory.createEntityManager();
		String jpql = " from EmployeeMaster where id=:id and password=:pwd ";
		Query query = manager.createQuery(jpql);
		query.setParameter("id", id);
		query.setParameter("pwd", password);
		EmployeeMaster employeeMaster;
		HttpSession session = null;
			try {
				employeeMaster	=(EmployeeMaster)query.getSingleResult();
				if(employeeMaster.getRole().equalsIgnoreCase("admin")) {
					session = req.getSession(true);
					session.setAttribute("admin", employeeMaster);
				req.getRequestDispatcher("./adminPage.jsp").forward(req, resp);	
				}else {
					session = req.getSession(true);
					session.setAttribute("officer", employeeMaster);
					req.getRequestDispatcher("./empHome.jsp").forward(req, resp);	
				}
			}catch (Exception e) {
				req.setAttribute("msg", "wrong Credentials");
				req.getRequestDispatcher("./employeeLogin.jsp").forward(req, resp);
			}
							
		
		manager.close();
		managerFactory.close();
	}
}
