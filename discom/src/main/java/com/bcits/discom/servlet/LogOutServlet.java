package com.bcits.discom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 HttpSession session = req.getSession(false);
		 
		 if (session != null) {
			session.invalidate();
			req.setAttribute("msg", "logged out successfully");
			req.getRequestDispatcher("./employeeLogin.jsp").forward(req, resp);
		}
		 
	}
}
