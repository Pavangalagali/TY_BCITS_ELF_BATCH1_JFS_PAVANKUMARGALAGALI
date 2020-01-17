package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/myGenericServlet")
public class MyGenericServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String nameVal = req.getParameter("eName");
		
		PrintWriter writer = res.getWriter();
		
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h1> Welcome to Generic Servlet :)<h1>");
		writer.print("<h2> Employee Name : "+ nameVal+"<h2>");
		writer.print("<html>");
		writer.print("<html>");
	}

}
