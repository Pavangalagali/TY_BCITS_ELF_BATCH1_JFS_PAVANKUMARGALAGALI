package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.bean.PrimaryInfo;

@WebServlet("/getEmployee")
public class GetEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// validating session
		HttpSession session = req.getSession(false);

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		if (session != null) {
			String empIdVal = req.getParameter("empId");
			int empId = Integer.parseInt(empIdVal);

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
			EntityManager manager = factory.createEntityManager();

			PrimaryInfo info = manager.find(PrimaryInfo.class, empId);

			if (info != null) {
				// active session
				// result found
				PrimaryInfo primaryInfo =(PrimaryInfo) session.getAttribute("primaryInfo");
				out.println("<html>");
				out.println("<body>");
				
				out.print("<h1> Welcome "+primaryInfo.getName()+"!<h1>");
				
				out.println("<a href='./homePage.html'> HOME <a>");
				out.println("<h3 style='color:green'> Employee ID " + empId + " Found</h3>");
				out.println("<br>Employee name = " + info.getName());
				out.println("<br>Employee designation = " + info.getDesignation());
				out.println("<br>Employee salary = " + info.getSalary());
				out.println("<br>Employee Mobile no = " + info.getMobileNum());
				out.println("</body>");
				out.println("</html>");
			} else {
				// active session
				// result not found
				out.println("<html>");
				out.println("<body>");
				out.println("<h1 style='color:red'> Employee ID " + empId + " Not Found<h1>");
				out.println("</body>");
				out.println("</html>");

			}
			manager.close();
			factory.close();
		} else {
			// Inactive session
			// back to login page
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'> Please Login First</h1>");
			out.println("</body>");
			out.println("</html>");

			req.getRequestDispatcher("./loginForm.html").include(req, resp);
		}
	}
}
