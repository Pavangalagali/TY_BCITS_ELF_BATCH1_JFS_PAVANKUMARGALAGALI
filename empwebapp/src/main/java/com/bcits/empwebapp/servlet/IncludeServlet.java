package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String url = "./date.html"; //(static resource)
		String url = "./currentDate"; //(dynamic resource)
	//	String url = "./date.html"; //(external resources are not allowed )
		
		PrintWriter out =resp.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>Hello User</h2>");
		out.print("</body>");
		out.print("</html>");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.include(req, resp);
	}
}
