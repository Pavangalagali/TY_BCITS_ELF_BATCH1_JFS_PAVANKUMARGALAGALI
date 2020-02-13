package com.bcits.discomproject.utility;

import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcits.discomproject.beans.ConsumerMaster;
import com.bcits.discomproject.beans.CurrentBill;
import com.bcits.discomproject.dao.ConsumerDAO;
import com.bcits.discomproject.service.ConsumerService;

public class SendMail {

	// @Autowired
//	private ConsumerDAO service;

	public boolean sendMail(CurrentBill currentBill) {

//		ConsumerMaster consumerMaster = service.find(currentBill.getRrNumber());
//		String to = consumerMaster.getEMail();

		System.out.println("Sending Mail...");

		final String username = "pavankumargalagali@gmail.com";
		final String password = "9008575613";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dueDate = dateFormat.format(currentBill.getDueDate());
		String date = dateFormat.format(currentBill.getReadingsTakenOn());

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("prashulshetty307@gmail.com"));
			message.setSubject("Bill for this month");
			message.setText("Dear Consumer," + "\n\n This  Month you have Consumed " + currentBill.getUnitsConsumed()
					+ " units" + "\n\n So the total Bill will be rupees " + currentBill.getAmount()
					+ "\n\n The Due Date will be " + dueDate + "\n\n" + "\n\n" + "Statmented On " + date
					+ "\n\nHappy To Help");

			Transport.send(message);

			System.out.println("Done");
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;

	}// End of main()
	
	public void sendReceipt(CurrentBill currentBill) {

//		ConsumerMaster consumerMaster = service.find(currentBill.getRrNumber());
//		String to = consumerMaster.getEMail();

		System.out.println("Sending Mail...");

		final String username = "pavankumargalagali@gmail.com";
		final String password = "9008575613";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dueDate = dateFormat.format(currentBill.getDueDate());
		String date = dateFormat.format(currentBill.getReadingsTakenOn());

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("devrajacharya9860@gmail.com"));
			message.setSubject("Payment Successful");
			message.setText("Dear Consumer," + 
			          "\n\n As the  Bill was statmented on  " + date
					 + "\n\n The total bill of  " + currentBill.getAmount() + " rupees is successfully paid "		
					 +" \n\n if you have any complaint :\n\n"+
					 "\n\n Call Us  : XXXXXXXXX "+
					 "\n\n visit : www.discome.com "
					+ "\n\nHappy To Help");

			Transport.send(message);

			System.out.println("Done");
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		

	}// End of main()

}// End of class
