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
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.bean.PrimaryInfo;

@WebServlet("/getAll")
public class RetrieveAllDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if (session != null) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();

		String jpql = " from PrimaryInfo";

		Query query = manager.createQuery(jpql);

		List<PrimaryInfo> list = query.getResultList();


		if (list != null) {
			out.println("<html>");
			out.println("<body>");
			out.print("<h1> All Employee Deatils </h1>");
			out.println("<table");
			out.print("<tr>");
			out.println("<th> ID </th>");
			out.println("<th> Name </th>");
			out.println("<th> Salary </th>");
			out.println("<th> Designation </th>");
			out.println("<th> Number </th>");
			out.print("</tr");
			for (PrimaryInfo primaryInfo : list) {
				out.print("<br><tr>");
				out.println("<td>" + primaryInfo.getEmpId()+"</td>");
				out.println("<td>" + primaryInfo.getName()+"</td>");
				out.println("<td>" + primaryInfo.getSalary()+"</td>");
				out.println("<td>" + primaryInfo.getDesignation()+"</td>");
				out.println("<td>"+primaryInfo.getMobileNum()+"</td>");
				out.print("<tr>");

			}
			out.println("</table");
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
		}else {
			// back to login page
						out.println("<html>");
						out.println("<body>");
						out.println("<h1 style='color:red'> Please Login First</h1>");
						out.println("</body>");
						out.println("</html>");

						req.getRequestDispatcher("./loginForm.html").include(req, resp);
		}
	}
		
}
