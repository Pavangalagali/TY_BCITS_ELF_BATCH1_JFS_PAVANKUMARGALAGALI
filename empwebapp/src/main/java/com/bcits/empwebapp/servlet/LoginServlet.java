package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.bean.PrimaryInfo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//validation of form data
		int empId = Integer.parseInt(req.getParameter("empId"));
		String password = req.getParameter("password");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		String jpql = "from PrimaryInfo where empId =:emp and password=:pwd";
		Query query = manager.createQuery(jpql);
		query.setParameter("emp", empId);
		query.setParameter("pwd", password);

		PrimaryInfo primaryInfo = null;
		try {
			primaryInfo = (PrimaryInfo) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		factory.close();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (primaryInfo != null) {
			//validation successful
			//creating the session
			HttpSession session = req.getSession(true);
			session.setAttribute("primaryInfo", primaryInfo);
			
			//setting maxInactiveInterval
			session.setMaxInactiveInterval(60);
			out.print("<h1> Welcome " + primaryInfo.getName() + "</h1>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("./homePage.html");
			dispatcher.include(req, resp);

		} else {
			out.print("<h1 style='color=red'>Wrong Credentials</h1>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("./loginForm.html");
			dispatcher.include(req, resp);
		}
		out.println("</body>");
		out.println("</html>");
	}// end of post
}// end of class
