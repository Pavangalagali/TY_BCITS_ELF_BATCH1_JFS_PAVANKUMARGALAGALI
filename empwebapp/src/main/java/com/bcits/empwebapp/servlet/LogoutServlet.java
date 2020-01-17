package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Invalidation of session
		
		HttpSession session = req.getSession(false);
		 PrintWriter out = resp.getWriter();
		 if (session != null) {
			session.invalidate();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:orange'> Successfully logged out</h1>");
			out.println("</body>");
			out.println("</html>");
			
			req.getRequestDispatcher("./loginForm.html").include(req, resp);
		}
	}
}
