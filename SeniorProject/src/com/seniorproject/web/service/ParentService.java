package com.seniorproject.web.service;

import java.math.BigDecimal;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.seniorproject.web.pojo.User.Status;
import com.seniorproject.web.utils.Constants;
import com.seniorproject.web.utils.GMailAuthenticator;

public class ParentService extends Constants {

	public void sendDecisionEmail(String email, Status status) {

	        String subject = DECISION_EMAIL_SUBJECT;
	        String body = "Sorry buddy you have been rejected!";	        
	        sendFromGMail(email, subject, body);
	    }
	
	public void sendDecisionEmail(String email, Status status, BigDecimal amount) {
		
        String subject = DECISION_EMAIL_SUBJECT;
        String body = "Congratulations! You've been approved for $" + amount;
        sendFromGMail(email, subject, body);
    }

	    private static void sendFromGMail(String email, String subject, String body) {
	        Properties props = System.getProperties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", GMAIL_HOST);
	        props.put("mail.smtp.port", GMAIL_HOST_PORT);
	        
	        GMailAuthenticator gmailAuthenticator = new GMailAuthenticator (
	        		OUTGOING_EMAIL_ACCT_USERNAME,
	        		OUTGOING_EMAIL_ACCT_PASSWORD);
	        Session session = Session.getInstance(props, gmailAuthenticator);

	        try {
		        	MimeMessage message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(OUTGOING_EMAIL_ADDRESS));
		            message.setRecipients(Message.RecipientType.TO,
		    				InternetAddress.parse("to-" + email));
		            message.setSubject(subject);
		            message.setText(body);
		            Transport.send(message);
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
	    }
}