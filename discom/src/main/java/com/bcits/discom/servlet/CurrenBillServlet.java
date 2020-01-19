package com.bcits.discom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.discom.bean.ConsumerMaster;
import com.bcits.discom.bean.CurrentBill;

@WebServlet("/currentBill")
public class CurrenBillServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("discomPeristence");
		EntityManager manager = managerFactory.createEntityManager();
		
		out.print("<html>");
		out.print("<body>");
		if (session != null) {
			ConsumerMaster master =(ConsumerMaster) session.getAttribute("consumer");
			out.print("<h1 style='color:orange'>"+master.getFirstName()+" "+master.getLastName()+ "</h1> ");
			CurrentBill currentBill = manager.find(CurrentBill.class, master.getRrNumber());
			out.print("<tr>"+
			 "<th>RR Number</th>"+
			   "<th>Readings Taken On</th>"+
			   "<th>Intial Units</th>"+
			   "<th>Final Units</th>"+
			   "<th>Total Units</th>"+
			   "<th>Amount</th>"+
			   "<th>Due Date</th>"+
			  "</tr><br>");
			  out.print("<tr>"+
			    "<td>"+currentBill.getRrNumber()+"</td>"+
			    "<td>"+currentBill.getReadingsTakenOn()+"</td>"+
			    "<td>"+currentBill.getInitialUnits()+"</td>"+
			    "<td>"+currentBill.getFinalUnits()+"</td>"+
			    "<td>"+currentBill.getUnitsConsumed()+"</td>"+
			    "<td>"+currentBill.getAmount()+"</td>"+
			    "<td>"+currentBill.getDueDate()+"</td>"+
			    "</tr><br>");
			  out.print("<a>"+"Pay Now"+" </a>");
		}else {
			out.print("<h1 style='color:blue'>Please login again</h1> ");
			req.getRequestDispatcher("./consumerLogin.html").include(req, resp);
		}
		out.print("</body>");
		out.print("</html>");
		manager.close();
		managerFactory.close();
	}
}















