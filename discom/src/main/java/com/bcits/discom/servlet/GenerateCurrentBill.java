package com.bcits.discom.servlet;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import com.bcits.discom.bean.ConsumerMaster;
import com.bcits.discom.bean.CurrentBill;

@WebServlet("/generateBill")
public class GenerateCurrentBill extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rrNumber = req.getParameter("rr");
		Double initial = Double.parseDouble(req.getParameter("inl"));
		Double finalReading = Double.parseDouble(req.getParameter("fnl"));
		Double total = Double.parseDouble(req.getParameter("total"));
		String dateVal = req.getParameter("date");
		String dueDateVal = req.getParameter("dueDate");
		
		HttpSession httpSession = req.getSession(false);
		
		if (httpSession != null) {
			
		double amount = 0;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("discomPeristence");
		EntityManager  manager =    factory.createEntityManager();
		EntityTransaction entityTransaction = manager.getTransaction();
		ConsumerMaster master =	manager.find(ConsumerMaster.class, rrNumber);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date dueDate =null;
		try {
			date = dateFormat.parse(dateVal);
			dueDate = dateFormat.parse(dueDateVal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(master != null) {
			CurrentBill bill = new CurrentBill();
			bill.setRrNumber(rrNumber);
			bill.setFinalUnits(finalReading);
			bill.setInitialUnits(initial);
			bill.setAmount(amount);
			bill.setDueDate(dueDate);
			bill.setReadingsTakenOn(date);
			bill.setUnitsConsumed(total);
			entityTransaction.begin();
			manager.persist(bill);
			entityTransaction.commit();
			req.setAttribute("msg", "generated ..");
			req.getRequestDispatcher("./empHome.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "something went wrong");
			req.getRequestDispatcher("./empHome.jsp").forward(req, resp);
		}
		
	 }else {
		 req.setAttribute("msg", "something went wrong");
			req.getRequestDispatcher("./employeeLogin.jsp").forward(req, resp);
	 }
	}
}
