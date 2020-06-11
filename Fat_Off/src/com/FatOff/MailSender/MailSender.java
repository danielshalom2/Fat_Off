
package com.FatOff.MailSender;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import com.FatOff.Controller.AdminController;
import com.FatOff.Model.Admin;
import com.FatOff.Model.SaveRestore;

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
	private javax.mail.Authenticator auth;

	/**
	 * Constructor -- builds an MailSender object that initializes a session with
	 * the SMTP server and initializes the required parameters
	 * 
	 * @param from        The sender address
	 * @param to          The recipient address
	 * @param displayName The sender display name
	 * @param password    The GMail application password
	 */

	public MailSender(String displayName, String to) {

		this.from = getAdminEmailAddress();
		this.displayName = displayName;
		this.to = to;
		this.password = getAdminAppPass();

		// Create authenticator for GMail connection
		this.auth = new Authenticator() {
			// override the getPasswordAuthentication method
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
		props.put("mail.smtp.ssl.trust", "*");

		// Create and SMTP session and authentication
		session = Session.getDefaultInstance(props, this.auth);
	}

	public void sendValidationCode(int validationCode) {

		try

		{
			MimeMessage message = new MimeMessage(this.session);
			message.setFrom(new InternetAddress(this.from, this.displayName));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
			message.setSubject("Fat_Off Reset Password Requeuest");

			message.setText("This is a reset password request for Fat_Off project!\r" + "Your validation code is: "
					+ validationCode + "\r\r" + "Wish you all the best\rThe Fat_Off Project");

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

		} catch (MessagingException | UnsupportedEncodingException mex) {
			mex.printStackTrace();
		}
	}

	public void sendSessionSummary(String pathToFile, String custName, String nutName, String nutEmail, String nutPhone)
			throws AddressException, MessagingException, UnsupportedEncodingException {

		LocalDateTime now = LocalDateTime.now();

		// Create the message object with the sender and the recipient address and set
		// the message subject
		Message message = new MimeMessage(this.session);
		message.setFrom(new InternetAddress(this.from, this.displayName));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
		message.setSubject("Dietician Session Summary");

		// Create the message part and set the message body
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText("Dear " + custName + ",\r\r"
				+ "After our plesent meeting and after we talked and decided on our goal, "
				+ "now we arrived to the hard  but very important part.\r"
				+ "In the attached file, you will find our session summary, "
				+ "your current measures and the suggested menu until the next session.\r\r"
				+ "For any farther questions you have or if you need any advise, "
				+ "please feel free to contact me and I will happily assist you if I can.\r\rLooking forward to our next session.\r\r\r"
				+ "Best Regards,\r" + nutName + "\rEmail Address: " + nutEmail + "\rPhone Number: " + nutPhone);

		// Create multipart message with the message and the attachment
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Adding the attachments
		messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(pathToFile);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName("Session_" + DateTimeFormatter.ofPattern("dd/MM/YYYY").format(now).toString()+".pdf");
		multipart.addBodyPart(messageBodyPart);

		// Send the complete message parts
		message.setContent(multipart);

		// Send the message
		Transport.send(message);
	}

	private String getAdminAppPass() {
		String adminName = "";
		File adminToRestore = new File(SaveRestore.getPath() + "/Admin");
		String[] desired = adminToRestore.list();
		for (int i = 0; i < desired.length; i++) {
			if (!desired[i].equals(".DS_Store"))
				adminName = desired[i];
		}
		Admin adm = AdminController.restoreAdmin(adminName);
		return adm.getEmailAppPass();
	}

	private String getAdminEmailAddress() {
		String adminName = "";
		File adminToRestore = new File(SaveRestore.getPath() + "/Admin");
		String[] desired = adminToRestore.list();
		for (int i = 0; i < desired.length; i++) {
			if (!desired[i].equals(".DS_Store"))
				adminName = desired[i];
		}
		Admin adm = AdminController.restoreAdmin(adminName);
		return adm.getEmailAddress();
	}
}
