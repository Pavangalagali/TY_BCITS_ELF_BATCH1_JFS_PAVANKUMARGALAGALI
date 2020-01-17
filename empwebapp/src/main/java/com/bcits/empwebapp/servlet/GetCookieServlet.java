package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		for (Cookie cookie : cookies) {
			out.print("<h2> cookie name = " +cookie.getName());
			out.print("<br> cookie value = " +cookie.getValue()+"</h2>");
		}
	}
}
