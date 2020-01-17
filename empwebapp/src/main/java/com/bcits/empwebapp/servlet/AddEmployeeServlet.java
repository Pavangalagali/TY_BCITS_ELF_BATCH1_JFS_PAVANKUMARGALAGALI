package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get the data form
		String empIdVal = req.getParameter("empId");
		String nameVal = req.getParameter("name");
		String mobileVal = req.getParameter("mobileNum");
		String mailVal = req.getParameter("maildId");
		String birthDateVal = req.getParameter("birthDate");
		String JoinDateVal = req.getParameter("joiningDate");
		String designationVal = req.getParameter("designation");
		String bloodGroupVal = req.getParameter("bloodGroup");
		String salaryVal =	req.getParameter("salary");
		String deptIdval =	req.getParameter("deptId");
		String mgrIdval =	req.getParameter("mgrId");
		String passwordVal=req.getParameter("password");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = null;
		Date joiningDate =null;
		try {
			birthDate = dateFormat.parse(birthDateVal);
			joiningDate = dateFormat.parse(JoinDateVal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrimaryInfo info = new PrimaryInfo();
		info.setEmpId(Integer.parseInt(empIdVal));
		info.setName(nameVal);
		info.setMobileNum(Long.parseLong(mobileVal));
		info.setMaildId(mailVal);
		info.setBirthDate(birthDate);
		info.setJoiningDate(joiningDate);
		info.setDesignation(designationVal);
		info.setBloodGroup(bloodGroupVal);
		info.setSalary(Double.parseDouble(salaryVal));
		info.setDeptId(Integer.parseInt(deptIdval));
		info.setMgrId(Integer.parseInt(mgrIdval));
		info.setPassword(passwordVal);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(info);
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
			out.println("<h1> Employee "+empIdVal+" Added Succesfully</h1>");
		}else {
			out.println("<h1 style='color:red'> Employee "+empIdVal+" Already Exist</h1>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}


















