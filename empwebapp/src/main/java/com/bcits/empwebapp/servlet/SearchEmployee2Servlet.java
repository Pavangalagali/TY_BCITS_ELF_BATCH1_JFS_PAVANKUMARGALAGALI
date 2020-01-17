package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.bean.PrimaryInfo;

@WebServlet("/findEmployee")
public class SearchEmployee2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empIdVal = req.getParameter("empId");
		int empId = Integer.parseInt(empIdVal);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();

		PrimaryInfo info = manager.find(PrimaryInfo.class, empId);

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		if (info != null) {

			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:green'> Employee ID " + empId + " Found</h1>");
			out.println("<br>Employee name = " + info.getName());
			out.println("<br>Employee designation = " + info.getDesignation());
			out.println("<br>Employee salary = " + info.getSalary());
			out.println("<br>Employee Mobile no = " + info.getMobileNum());
			out.println("</body>");
			out.println("</html>");
		} else {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'> Employee ID " + empId + " Not Found<h1>");
			out.println("</body>");
			out.println("</html>");

		}
		manager.close();
		factory.close();
	}
}
