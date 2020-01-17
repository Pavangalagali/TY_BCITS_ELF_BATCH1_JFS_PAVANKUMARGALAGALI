package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ServletDate extends HttpServlet {

	  public ServletDate() {
	System.out.println("instantiation phase");
	} 
	  
	 @Override
	public void init() throws ServletException {
		 System.out.println("initialisation phase");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		Date date = new Date();

		ServletConfig config = getServletConfig();
		String myConfigParamVal = config.getInitParameter("ServletName");
		
		ServletContext context = getServletContext();
		String myContextVal = context.getInitParameter("appName");
		
		// code to generate dynamic response
		resp.setContentType("text/html");
//		resp.setHeader("refresh", "1");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Current Date and Time is :- " + date + "</h1>");
		out.print("<h1> Application name = "+myContextVal+"<h1>");
		out.print("<h1> Servlet name = "+myConfigParamVal+"<h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
	@Override
	public void destroy() {
		
		System.out.println("destruction phase");
	}
}
