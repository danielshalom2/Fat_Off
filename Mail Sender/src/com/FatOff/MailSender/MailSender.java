package com.FatOff.MailSender;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * This is an email sender class.
 * It responsible for creating an email SMTP session.
 * Setting all the required parameters for sending mails and confirming that it was sent.
 * 
 * @author FatOff development team
 */
public class MailSender {
	
	private final String HOST = "smtp.gmail.com";
	private final int PORT = 587;

	private Properties props;
	private Session session;
	private Authenticator auth;
	
	
	/**
	 * Constructor -- builds an MailSender object that initializes a session with 
	 * the SMTP server and initializes the required parameters
	 * 
	 * @param from The sender address
	 * @param to The recipient address
	 * @param name The sender display name
	 */
	public MailSender(String from , String name , String to , String password) {
		
		// Create authenticator for Gmail connection
		this.auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};
		
		// Set the properties for the smtp session
		props = System.getProperties();
		props.setProperty("mail.smtp.host", this.HOST);
		props.put("mail.smtp.port", this.PORT);
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable", "true");
		
		// Create and smtp settion and authentication
		session = Session.getDefaultInstance(props, this.auth);
		
		
		try{  
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from, "Fat_Off"));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	         message.setSubject("Ping"); 
	         
	         BodyPart part = new MimeBodyPart();
	         part.setText("This is a test mail from Fat_Off");
	         
	         Multipart multipart = new MimeMultipart();
	         multipart.addBodyPart(part);
	         part = new MimeBodyPart();
	         
	         String filename = "/Users/borism/Desktop/Infinidat-120.jpg";
	         
	         DataSource source = new FileDataSource(filename);
	         
	         part.setDataHandler(new DataHandler(source));
	         part.setFileName(filename);
	         multipart.addBodyPart(part);
	         message.setContent(multipart);
	         System.out.println("Message is ready");
	  
	         // Send message 
	         Transport transport;
	         try {
	        	 transport = session.getTransport("smtp");
	        	 transport.connect("smtp.gmail.com", from, password);
	        	 transport.close();
	        	 Transport.send(message);
		         System.out.println("message sent successfully...."); 
	         }catch (AuthenticationFailedException e) {System.out.println("Connection unsuccessful");};

	      }catch (MessagingException | UnsupportedEncodingException mex) {mex.printStackTrace();}
		
	}
	
}
