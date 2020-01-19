package com.bcits.discom.servlet;

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

import com.bcits.discom.bean.ConsumerMaster;
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rrNumVal = req.getParameter("rrNumber");
		String firstNameVal = req.getParameter("fName");
		String lastNameVal = req.getParameter("lName");
		String emailVal = req.getParameter("eMail");
		String typeVal = req.getParameter("type");
		int houseNumVal = Integer.parseInt(req.getParameter("houseNo"));
		String address1Val = req.getParameter("addresss1");
		String address2Val = req.getParameter("addresss2");
		String regionVal = req.getParameter("region");
		String password = req.getParameter("password");
		Long phoneNum = Long.parseLong(req.getParameter("number"));
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("discomPeristence");
		EntityManager manager = managerFactory.createEntityManager();
		ConsumerMaster consumerMaster =	manager.find(ConsumerMaster.class, rrNumVal);
		EntityTransaction transaction = manager.getTransaction();
		if(consumerMaster == null) {
			try {
				ConsumerMaster master = new ConsumerMaster();
				master.setFirstName(firstNameVal);
				master.setLastName(lastNameVal);
				master.setRrNumber(rrNumVal);
				master.setConsumerType(typeVal);
				master.setEMail(emailVal);
				master.setPhoneNumber(phoneNum);
				master.setHouseNo(houseNumVal);
				master.setAddress1(address1Val);
				master.setAddress2(address2Val);
				master.setRegion(regionVal);
				master.setPassword(password);
				transaction.begin();
				manager.persist(master);
				transaction.commit();
				out.print("<html>");
				out.print("<body>");
				out.print("<h1 style='color:green'> Sign Up successful!!</h1> ");
				out.print("</body>");
				out.print("</html>");
				req.getRequestDispatcher("./consumerLogin.html").include(req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
				if (transaction != null) {
					transaction.rollback();
				}
				out.print("<html>");
				out.print("<body>");
				out.print("<h1 style='color:red'> Something Went Wrong tray Again</h1> ");
				out.print("</body>");
				out.print("</html>");
				req.getRequestDispatcher("./consumerSignUp.html").include(req, resp);
			}
			
		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("<h1 style='color:red'> User Already Exists</h1> ");
			out.print("</body>");
			out.print("</html>");
			
			req.getRequestDispatcher("./consumerSignUp.html").include(req, resp);
		}
		manager.close();
		managerFactory.close();
	}
}
