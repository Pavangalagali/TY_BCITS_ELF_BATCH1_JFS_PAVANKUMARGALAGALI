package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.bean.PrimaryInfo;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empIdVal = req.getParameter("empId");
		int empId = Integer.parseInt(empIdVal);

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		PrimaryInfo info = manager.find(PrimaryInfo.class, empId);

		if (info != null) {
			try {
				transaction.begin();
				manager.remove(info);
				transaction.commit();
				out.println("<html>");
				out.println("<body>");
				out.println("<h1 style='color:blue'> Employee ID " + empId + " Deleted<h1>");
				out.println("</body>");
				out.println("</html>");
			} catch (Exception e) {

				transaction.rollback();
				resp.sendError(200, "Something went wrong try later");
			}

		} else {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'> Employee ID " + empId + " Not Found<h1>");
			out.println("</body>");
			out.println("</html>");
		}

		manager.close();
		factory.close();
	}
}
