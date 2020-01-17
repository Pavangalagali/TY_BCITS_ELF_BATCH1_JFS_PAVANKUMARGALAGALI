package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.bean.PrimaryInfo;

@WebServlet("/getAll")
public class RetrieveAllDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();

		String jpql = " from PrimaryInfo";

		Query query = manager.createQuery(jpql);

		List<PrimaryInfo> list = query.getResultList();

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		if (list != null) {
			out.println("<html>");
			out.println("<body>");
			for (PrimaryInfo primaryInfo : list) {
				out.println("<br>Employee ID " + primaryInfo.getEmpId());
				out.println("<br>Employee name = " + primaryInfo.getName());
				out.println("<br>Employee salary = " + primaryInfo.getSalary());
				out.println("<br>Employee designation = " + primaryInfo.getDesignation());
				out.println("<br>Employee Mobile no = " + primaryInfo.getMobileNum());
				out.println("<br>--------------------------------------------------------");

			}
			out.println("</body>");
			out.println("</html>");
		} else {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'> Employee Details Not Found<h1>");
			out.println("</body>");
			out.println("</html>");
		}
		manager.close();
		factory.close();
	}
}
