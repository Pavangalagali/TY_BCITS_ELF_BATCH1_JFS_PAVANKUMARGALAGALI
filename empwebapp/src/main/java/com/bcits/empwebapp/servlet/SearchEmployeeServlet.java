package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empId = req.getParameter("empId");
		
		resp.setContentType("text/html");
		
		ServletConfig config = getServletConfig();
		String myConfigParamVal = config.getInitParameter("ServletName");
		
//		ServletContext context = getServletContext();
		ServletContext context = req.getServletContext();
		String myContextVal = context.getInitParameter("appName");
		
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.print("<h1> Employee Id :- "+empId+"</h1>");
		out.print("Employee Name = kiran <br>");
		out.print("Employee Age = 21 <br>");
		out.print("Designation = SD <br>");
		out.print("Salary = 30000/-<br>");
		out.print("<h1> Application name = "+myContextVal+"<h1>");
		out.print("<h1> Servlet name = "+myConfigParamVal+"<h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
