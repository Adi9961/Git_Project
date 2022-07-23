package com.central.Minor_Application.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.central.Minor_Application.services.EmailService;

@RestController
@RequestMapping("/s")
public class EmailSenderController {
	
	@Autowired
	private EmailService emailService;
	
	//This REST API is to sent the email
	@PostMapping("/public/email")
	public ResponseEntity<?> sendEmail() throws MessagingException {
		boolean result = this.emailService.sendEmail();
		if(result) {
			return ResponseEntity.ok("Email has been sent successfully to delete your account....Schrack team will connect with you soon");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent...");
		}
		
	}
	
	//Above method id to sent email

}
