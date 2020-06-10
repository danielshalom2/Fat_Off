package com.FatOff.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.FatOff.MailSender.MailSender;
import com.FatOff.Model.Customer;
import com.FatOff.Model.Measures;
import com.FatOff.Model.SaveRestore;
import com.FatOff.Model.Session;
import com.itextpdf.text.DocumentException;

public class SessionMeasureController {
	
	public static boolean storeSession(Session sess, Customer cust, String pathToNut, String sessionSummary,
										String breakfast, String snack1, String lunch, 
										String snack2, String dinner, String nutName , String nutMail , String nutPhone) throws IOException, DocumentException, AddressException, MessagingException {
		sess.setSessionSummary(sessionSummary);
		sess.setBreakfast(breakfast);
		sess.setSnack1(snack1);
		sess.setLunch(lunch);
		sess.setSnack2(snack2);
		sess.setDinner(dinner);
		
		String custFolderName = cust.getFirstName() + "_" + cust.getLastName() + "_" + cust.getId();
		String pathToSessions = pathToNut + custFolderName + "/Sessions";
		
		SaveRestore<Session> save = new SaveRestore<Session>(sess , "");
		
		boolean stored = save.storeSessions(pathToSessions, sess);
		String sessionPdfPath = craeteSessionPdf(sess , cust, pathToSessions);
		MailSender sendSess = new MailSender(nutName, cust.getEmailAddress());
		sendSess.sendSessionSummary(sessionPdfPath, cust.getFirstName()+" "+cust.getLastName(), nutName, nutMail, nutPhone);
		return stored;
	}
	
	public static String craeteSessionPdf(Session sess , Customer cust, String pathToSession) throws FileNotFoundException, DocumentException {
		
		SaveRestore<Customer> save = new SaveRestore<Customer>(cust , "");
		
		return save.storeSessionToPdf(sess,pathToSession);
	}
}
