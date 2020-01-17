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
@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empIdVal = req.getParameter("empId");
		String nameVal = req.getParameter("name");
		String mobileVal = req.getParameter("mobileNum");
		String salaryVal =	req.getParameter("salary");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		
		try {
			transaction.begin();
			PrimaryInfo info = manager.find(PrimaryInfo.class, Integer.parseInt(empIdVal));
			info.setName(nameVal);
			info.setMobileNum(Long.parseLong(mobileVal));
			info.setSalary(Double.parseDouble(salaryVal));
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		factory.close();
		
PrintWriter out = resp.getWriter();
		
		
		out.println("<html>");
		out.println("<body>");
		if(isAdded) {
			out.println("<h1> Employee with "+empIdVal+" Updated Succesfully</h1>");
		}else {
			out.println("<h1 style='color:red'> Employee with "+empIdVal+" could not be updated</h1>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
