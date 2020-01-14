package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 class DateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// java code to generate current date and time(dynamic)
		Date date = new Date();
		
		//code to generate dynamic response
		resp.setContentType("text/html");
//		resp.setHeader("refresh", "1");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Current Date and Time is :- "+date+"</h1>");
		out.println("</body>");
		out.println("</html>");
		
	} // end of doGet
}// end of class
