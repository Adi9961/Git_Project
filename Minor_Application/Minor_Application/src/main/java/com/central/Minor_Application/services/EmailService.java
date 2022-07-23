package com.central.Minor_Application.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.central.Minor_Application.model.EmailRequest;

@Service
//@ConfigurationProperties(prefix = "spring.mail")
public class EmailService {
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Value("${spring.account.recepient}")
	private String to;
	
	public boolean sendEmail() throws MessagingException {
		
		boolean f = false;
		
		//String from = "adityaagupta9961@gmail.com";
		String subject = "Delete_Account";
		String message = "Pls delete my account";
		//String password = "dgunqfyjsekqobio";
		
		String host = "smtp.gmail.com";
		
		System.getProperty("mail.service.status");
		System.setProperty("mail.service.status", "running");
		Properties propertiese = System.getProperties();
		System.out.println("Propertiese"+ " "+propertiese);
		
		propertiese.put("mail.smtp.host", host);
		propertiese.put("mail.smtp.port", 587);
		propertiese.put("mail.smtp.starttls.enable", "true");
		propertiese.put("mail.smtp.auth", "true");
		
	//	Session session = Session.getInstance(propertiese, new Authenticator() {
			
		//	 @Override
		  //      protected PasswordAuthentication getPasswordAuthentication() {
		    //        return new PasswordAuthentication("adityaagupta9961@gmail.com", "jtfxwvndnmtzkmws");
		      //  }
			
	//	});
		
		Session session = Session.getDefaultInstance(propertiese, null);
		Transport transport = session.getTransport("smtp");
		transport.connect(host, from, password);
		
		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		
		try {
			
			m.setFrom(from);
			m.setRecipients(Message.RecipientType.TO, to);
			m.setSubject(subject);
			m.setText(message);
			
			transport.sendMessage(m,m.getAllRecipients());
			
			System.out.println("Email sent successfully....."+ " "+ to);
			f = true;
			System.setProperty("mail.service.status", "done");
			transport.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

}
