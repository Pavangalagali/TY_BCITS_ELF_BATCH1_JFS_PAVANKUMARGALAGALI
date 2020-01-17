package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookie = new Cookie("eName", "sai");
	  resp.addCookie(cookie);

		PrintWriter out = resp.getWriter();
		out.print("<h1> Cookie created Successfully!</h1><br>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("./cookiePage.html");
		dispatcher.include(req, resp);
	}
}
