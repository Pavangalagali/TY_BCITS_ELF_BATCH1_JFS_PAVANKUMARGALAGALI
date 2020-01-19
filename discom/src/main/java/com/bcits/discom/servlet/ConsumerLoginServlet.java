package com.bcits.discom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.discom.bean.ConsumerMaster;

@WebServlet("/login")
public class ConsumerLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rrNumVal = req.getParameter("rrNumber");
		String password = req.getParameter("password");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("discomPeristence");
		EntityManager manager = managerFactory.createEntityManager();
		String jpql = " from ConsumerMaster where rrNumber=:rr and password=:pwd ";
		Query query = manager.createQuery(jpql);
		query.setParameter("rr", rrNumVal);
		query.setParameter("pwd", password);

		out.print("<html>");
		out.print("<body>");
		try {
			ConsumerMaster master = (ConsumerMaster) query.getSingleResult();
			HttpSession session = req.getSession(true);
			session.setAttribute("consumer", master);
			out.print("<h1 style='color:orange'> WelCome "+master.getFirstName()+" "+master.getLastName()+ "</h1> ");
			req.getRequestDispatcher("./consumerHome.html").include(req, resp);	
	}catch (Exception e) {
		out.print("<h1 style='color:red'> Looks like you have entered worng password/RR Number </h1> ");
		req.getRequestDispatcher("./consumerlogin.html").include(req, resp);
	}
	out.print("</body>");
	out.print("</html>");
	manager.close();
	managerFactory.close();
	}
}
