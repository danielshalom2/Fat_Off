package com.FatOff.MailSender;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * This is an email sender class. It responsible for creating an email SMTP
 * session. Setting all the required parameters for sending mails and confirming
 * that it was sent.
 * 
 * @author FatOff development team
 */
public class MailSender {

	private final String HOST = "smtp.gmail.com";
	private final int PORT = 587;

	private String from;
	private String displayName;
	private String to;
	private String password;
	private Properties props;
	private Session session;
	private Authenticator auth;

	/**
	 * Constructor -- builds an MailSender object that initializes a session with 
	 * the SMTP server and initializes the required parameters
	 * 
	 * @param from The sender address
	 * @param to The recipient address
	 * @param displayName The sender display name
	 * @param password The GMail application password
	 */
	public MailSender(String from , String displayName , String to , String password) {
		
		this.from = from;
		this.displayName = displayName;
		this.to = to;
		this.password = password;
		
		// Create authenticator for GMail connection
		this.auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};
		
		// Set the properties for the SMTP session
		props = System.getProperties();
		props.setProperty("mail.smtp.host", this.HOST);
		props.put("mail.smtp.port", this.PORT);
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable", "true");
		
		// Create and SMTP session and authentication
		session = Session.getDefaultInstance(props, this.auth);
	}
	
	public void sendValidationCode (int validationCode) {
		
	try

	{
		MimeMessage message = new MimeMessage(this.session);
		message.setFrom(new InternetAddress(this.from, this.displayName));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
		message.setSubject("Fat_Off Reset Password Requeuest");

		BodyPart part = new MimeBodyPart();
		part.setText("This is a reset password request for Fat_Off project!\r"
				+ "Your validation code is: " + validationCode + "\r\r"
				+"Wish you all the best\rThe Fat_Off Project");

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
			transport.connect(this.HOST, from, password);
			transport.close();
			Transport.send(message);
			System.out.println("message sent successfully....");
		} catch (AuthenticationFailedException e) {
			System.out.println("Connection unsuccessful");
		}
		;

	}catch(MessagingException|
	UnsupportedEncodingException mex)
	{
		mex.printStackTrace();
	}
	}


}
