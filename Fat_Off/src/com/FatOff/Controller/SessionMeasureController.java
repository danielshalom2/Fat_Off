
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

/**
 * This class is a controller which was created in order to provide the GUI
 * classes a minimal API to the logical Session, Measures and SaveRestore
 * classes in the view package. It is able to generate report for several of the
 * measure parameters in the session. Also responsible for storing the session
 * summary to a PDF file and send it to the customer by email.
 * 
 * @author Fat Off Development Team
 * @version 1.0
 */
public class SessionMeasureController {

	/**
	 * This method is responsible for storing a given session in a given path of a
	 * given customer. It is also initiating a store to PDF procedure of the session
	 * summary and initiates sending it to the customer by email.
	 * 
	 * 
	 * @param sess           The session object to store
	 * @param cust           The customer this session is for
	 * @param pathToNut      The path to the dietitian folder
	 * @param sessionSummary The session summary field
	 * @param breakfast      The suggested breakfast
	 * @param snack1         The suggested first snack
	 * @param lunch          The suggested lunch
	 * @param snack2         The suggested second snack
	 * @param dinner         The suggested dinner
	 * @param nutName        The name of the nutritionist the customer assigned to
	 * @param nutMail        The email address of the nutritionist the customer
	 *                       assigned to
	 * @param nutPhone       The phone number of the nutritionist the customer
	 *                       assigned to
	 * @return true if the session was successfully stored to a file in the
	 *         FileSystem. false if not
	 * @throws IOException
	 * @throws DocumentException
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static boolean storeSession(Session sess, Customer cust, String pathToNut, String sessionSummary,
			String breakfast, String snack1, String lunch, String snack2, String dinner, String nutName, String nutMail,
			String nutPhone) throws IOException, DocumentException, AddressException, MessagingException {
		// Set the relevant parameters to the session
		sess.setSessionSummary(sessionSummary);
		sess.setBreakfast(breakfast);
		sess.setSnack1(snack1);
		sess.setLunch(lunch);
		sess.setSnack2(snack2);
		sess.setDinner(dinner);

		// Determining the path to the folder of where to store the session
		String custFolderName = cust.getFirstName() + "_" + cust.getLastName() + "_" + cust.getId();
		String pathToSessions = pathToNut + custFolderName + "/Sessions";

		// Initiate a store to file procedure which stores as an object file and as a
		// PDF file.
		SaveRestore<Session> save = new SaveRestore<Session>(sess, "");
		boolean stored = save.storeSessions(pathToSessions, sess);
		String sessionPdfPath = craeteSessionPdf(sess, cust, pathToSessions);

		// Initiates an email send to the customer with the session summary attached
		MailSender sendSess = new MailSender(nutName, cust.getEmailAddress());
		sendSess.sendSessionSummary(sessionPdfPath, cust.getFirstName() + " " + cust.getLastName(), nutName, nutMail,
				nutPhone);
		return stored;
	}

	/**
	 * This method is responsible for initiating a session PDF creation.
	 * 
	 * @param sess          The session to store to PDF
	 * @param cust          The customer to which the session relates to
	 * @param pathToSession The path to the FileSystem folder to store the PDF
	 * @return The path to the stored PDF
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public static String craeteSessionPdf(Session sess, Customer cust, String pathToSession)
			throws FileNotFoundException, DocumentException {

		// Initiate the Save procedure for the PDF creation
		SaveRestore<Customer> save = new SaveRestore<Customer>(cust, "");
		return save.storeSessionToPdf(sess, pathToSession);
	}

	/**
	 * This method is responsible for generation a BMI progress report. It
	 * calculates the progress in percents between one session to the following and
	 * calculates the total progress between the first session and the last one.
	 * 
	 * @param sessList An ArrayList of sessions to run over
	 * @return An arrayList of Doubles with the percents representations
	 */
	public static ArrayList<Double> generateBmiProgressReport(ArrayList<Session> sessList) {

		// Initialize an ArraList which will hold the percents
		ArrayList<Double> progress = new ArrayList<>();

		// Sort the given sessions list in order to calculate everything correctly
		Collections.sort(sessList);

		/*
		 * Convert the sessions list to an array in order to run over it without an
		 * iterator
		 */
		Object[] sessArray = sessList.toArray();

		for (int i = 1; i < sessArray.length; i++) {
			// Calculate the BMI difference between two following sessions
			double bmiDiff = ((Session) sessArray[i]).getMeasures().getBmi()
					- ((Session) sessArray[i - 1]).getMeasures().getBmi();
			// Calculate the percentage of the difference
			double precentDiff = (bmiDiff / ((Session) sessArray[i - 1]).getMeasures().getBmi()) * 100;
			// Add the calculate percentage to the list
			progress.add(new Double(precentDiff));
		}

		// Calculate the BMI difference between the first and the last sessions
		double totalDiff = ((Session) sessArray[sessArray.length - 1]).getMeasures().getBmi()
				- ((Session) sessArray[0]).getMeasures().getBmi();
		// Calculate the percentage of the difference
		double totalPrecentDiff = (totalDiff / ((Session) sessArray[0]).getMeasures().getBmi()) * 100;
		// Add the total percentage to the list
		progress.add(new Double(totalPrecentDiff));
		return progress;
	}

	/**
	 * This method is responsible for generation a waist progress report. It
	 * calculates the progress in percents between one session to the following and
	 * calculates the total progress between the first session and the last one.
	 * 
	 * @param sessList An ArrayList of sessions to run over
	 * @return An arrayList of Doubles with the percents representations
	 */
	public static ArrayList<Double> generateWaistProgressReport(ArrayList<Session> sessList) {

		// Initialize an ArraList which will hold the percents
		ArrayList<Double> progress = new ArrayList<>();

		// Sort the given sessions list in order to calculate everything correctly
		Collections.sort(sessList);

		/*
		 * Convert the sessions list to an array in order to run over it without an
		 * iterator
		 */
		Object[] sessArray = sessList.toArray();

		for (int i = 1; i < sessArray.length; i++) {
			// Calculate the Waist difference between two following sessions
			double waistDiff = ((Session) sessArray[i]).getMeasures().getWaist()
					- ((Session) sessArray[i - 1]).getMeasures().getWaist();
			// Calculate the percentage of the difference
			double precentDiff = (waistDiff / ((Session) sessArray[i - 1]).getMeasures().getWaist()) * 100;
			// Add the calculate percentage to the list
			progress.add(new Double(precentDiff));
		}
		// Calculate the BMI difference between the first and the last sessions
		double totalDiff = ((Session) sessArray[sessArray.length - 1]).getMeasures().getWaist()
				- ((Session) sessArray[0]).getMeasures().getWaist();
		// Calculate the percentage of the difference
		double totalPrecentDiff = (totalDiff / ((Session) sessArray[0]).getMeasures().getWaist()) * 100;
		// Add the total percentage to the list
		progress.add(new Double(totalPrecentDiff));
		return progress;
	}
}
