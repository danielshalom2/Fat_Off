package com.FatOff.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.FatOff.MailSender.MailSender;
import com.FatOff.Model.Customer;
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
	
	public static ArrayList<Double> generateBmiProgressReport(ArrayList<Session> sessList) {
		
		ArrayList<Double> progress = new ArrayList<>();
		Collections.sort(sessList);
		Object[] sessArray = sessList.toArray();
		
		for(int i = 1 ; i < sessArray.length ; i++) {
			double bmiDiff = ((Session)sessArray[i]).getMeasures().getBmi() - ((Session)sessArray[i-1]).getMeasures().getBmi();
			double precentDiff = (bmiDiff/((Session)sessArray[i-1]).getMeasures().getBmi())*100;
			
			progress.add(new Double(precentDiff));
		}
		
		double totalDiff = ((Session)sessArray[sessArray.length-1]).getMeasures().getBmi() - ((Session)sessArray[0]).getMeasures().getBmi();
		double totalPrecentDiff = (totalDiff/((Session)sessArray[0]).getMeasures().getBmi())*100;
		progress.add(new Double(totalPrecentDiff));
		return progress;
	}
	
public static ArrayList<Double> generateWaistProgressReport(ArrayList<Session> sessList) {
		
		ArrayList<Double> progress = new ArrayList<>();
		Collections.sort(sessList);
		Object[] sessArray = sessList.toArray();
		
		for(int i = 1 ; i < sessArray.length ; i++) {
			double waistDiff = ((Session)sessArray[i]).getMeasures().getWaist() - ((Session)sessArray[i-1]).getMeasures().getWaist();
			double precentDiff = (waistDiff/((Session)sessArray[i-1]).getMeasures().getWaist())*100;
			
			progress.add(new Double(precentDiff));
		}
		double totalDiff = ((Session)sessArray[sessArray.length-1]).getMeasures().getWaist() - ((Session)sessArray[0]).getMeasures().getWaist();
		double totalPrecentDiff = (totalDiff/((Session)sessArray[0]).getMeasures().getWaist())*100;
		
		progress.add(new Double(totalPrecentDiff));
		return progress;
	}
}
