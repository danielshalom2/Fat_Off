package com.FatOff.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;

/**
 * This class represent any Introduction Meeting which will be created in the
 * Fat_Off project
 * 
 * @author Fat_Off Development Team
 * @version 1.0
 */

public class SaveRestore<T> {

	private T obj;
	private String path;
	private File pathToDietitionDir;
	private File pathToAdminDir;
	private File pathToCustDir;
	private static String pathToDieticions;
	private ObjectOutputStream writeFile;
	private FileOutputStream pathToObj;
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font blackFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public SaveRestore(T obj, String path) {
		this.obj = obj;
		pathToDieticions = path + "/Dieticions";
	}

	public void storeToFile(String dietition) throws IOException {

		if (this.obj.getClass().toString().contains("Nutritionist")) {
			this.storeNutritionist(path, (Nutritionist) this.obj);
		} else if (this.obj.getClass().toString().contains("Admin")) {
			this.storeAdmin((Admin) this.obj);
		} else if (this.obj.getClass().toString().contains("Customer")) {
			this.storeCustomer(pathToDieticions, (Customer) this.obj);
		}

	}

	public void storeNutritionist(String path, Nutritionist nut) throws IOException {
		String temp_path = ((Nutritionist) this.obj).getFirstName() + "_" + ((Nutritionist) this.obj).getLastName()
				+ "_" + ((Nutritionist) this.obj).getId();
		pathToDietitionDir = new File(pathToDieticions + "/" + temp_path);
		pathToCustDir = new File(pathToDietitionDir + "/Customers");
		if (!pathToDietitionDir.exists()) // folder Nutritionist else create
		{
			pathToDietitionDir.mkdir();
			pathToCustDir.mkdir();
		}
		try // insert data to file
		{
			pathToObj = new FileOutputStream(pathToDietitionDir + "/" + temp_path + ".txt");
			writeFile = new ObjectOutputStream(pathToObj);
			writeFile.writeObject(this.obj);
			writeFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Customer cust : nut.getCustomersList()) {
			this.storeCustomer(pathToDieticions + "/" + temp_path + "/Customers", cust);
		}

	}

	public void storeAdmin(Admin adm) throws IOException {
		File pathToFatOff;
		File pathToDieticion;
		File pathToAdmin;
		String path = getPath();

		pathToFatOff = new File(path);
		pathToDieticion = new File(path + "/Dieticions");
		pathToAdmin = new File(path + "/Admin");
		if (!pathToFatOff.exists()) {
			pathToFatOff.mkdir();
			pathToAdmin.mkdir();
			pathToDieticion.mkdir();
		}
		String temp_path = ((Admin) this.obj).getFirstName() + "_" + ((Admin) this.obj).getLastName() + "_"
				+ ((Admin) this.obj).getId();
		pathToAdminDir = new File(pathToAdmin + "/" + temp_path);
		pathToCustDir = new File(pathToAdminDir + "/Customers");
		if (!pathToAdminDir.exists()) // folder Admin else create
		{
			pathToAdminDir.mkdir();
			pathToCustDir.mkdir();
		}
		try // insert data to file
		{
			pathToObj = new FileOutputStream(pathToAdminDir + "/" + temp_path + ".txt");
			writeFile = new ObjectOutputStream(pathToObj);
			writeFile.writeObject(this.obj);
			writeFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Customer cust : adm.getCustomersList()) {
			this.storeCustomer(pathToAdmin + "/" + temp_path + "/Customers", cust);
		}

	}

	/**
	 * 
	 * @param path
	 * @param dietition
	 * @param cust
	 * @throws IOException
	 */
	public void storeCustomer(String path, Customer cust) throws IOException {
		String tempCustPath = cust.getFirstName() + "_" + cust.getLastName() + "_" + cust.getId();
		File custDir = new File(path + "/" + tempCustPath);
		File custSessions = new File(custDir + "/Sessions");
		if (!custDir.exists()) {
			custDir.mkdir();
			custSessions.mkdir();		
		}
		try {
			pathToObj = new FileOutputStream(custDir + "/" + tempCustPath + ".txt");
			writeFile = new ObjectOutputStream(pathToObj);
			writeFile.writeObject(cust);
			writeFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param path
	 * @param cust
	 * @throws IOException
	 */
	public boolean storeSessions(String path, Session session) throws IOException {
		File sessionFolder = new File(path + "/Session_" + session.getSessionNum());
		sessionFolder.mkdir();
		try {
			pathToObj = new FileOutputStream(sessionFolder + "/Session_" + session.getSessionNum() + ".txt");
			writeFile = new ObjectOutputStream(pathToObj);
			writeFile.writeObject(session);
			writeFile.close();
			if(!storeMeasures(sessionFolder, session.getMeasures())) {
				return false;
			}
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param path
	 * @param cust
	 * @throws IOException
	 */
	private boolean storeMeasures(File path, Measures meas) throws IOException {
		try {
			pathToObj = new FileOutputStream(path + "/Measures.txt");
			writeFile = new ObjectOutputStream(pathToObj);
			writeFile.writeObject(meas);
			writeFile.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void storeInterviewToPdf(String path) throws FileNotFoundException, DocumentException {
		String temp_path = ((Customer) obj).getFirstName() + "_" + ((Customer) obj).getLastName() + "_"
				+ ((Customer) obj).getId();
		FileOutputStream fos = new FileOutputStream(path + "/" + temp_path + "/Interview.pdf");
		Document newDoc = new Document();
		PdfWriter.getInstance(newDoc, fos);
		newDoc.open();
		try {
			addTitlePage(newDoc, (Customer) obj , "Introductory Meeting");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addInterviewContent(newDoc, ((Customer) obj).getPesronalInterview());
		newDoc.close();
	}
	
	public String storeSessionToPdf(Session sess, String pathToSession) throws FileNotFoundException, DocumentException {
		String temp_path = pathToSession + "/Session_" + sess.getSessionNum();
		String sessDate = DateTimeFormatter.ofPattern("dd-MM-YYYY").format(sess.getSessionDate()).toString();
		FileOutputStream fos = new FileOutputStream(temp_path + "/Session_" + sessDate +".pdf");
		Document newDoc = new Document();
		PdfWriter.getInstance(newDoc, fos);
		newDoc.open();
		try {
			addTitlePage(newDoc, (Customer) obj , "Session Summary");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addSessionContent(newDoc, sess);
		newDoc.close();
		return temp_path + "/Session_" + sessDate + ".pdf";
	}

	public static Object restoreFromFile(String name, String type) throws IOException {
		Object nut = null;

		if (type.equals("Nutritionist")) {
			pathToDieticions = getPath() + "/Dieticions";
			nut = (Nutritionist) nut;
		}

		else {
			pathToDieticions = getPath() + "/Admin";
			nut = (Admin) nut;
		}

		File pathToCustomers = new File(pathToDieticions + "/" + name + "/Customers/");
		File Dieticion = new File(pathToDieticions + "/" + name + "/" + name + ".txt");
		if (!Dieticion.exists()) {
			System.out.println("File " + Dieticion.toString() + "Not found");
		}
		fis = new FileInputStream(Dieticion);
		ois = new ObjectInputStream(fis);

		try {
			if (type.equals("Nutritionist")) {
				nut = new Nutritionist((Nutritionist) ois.readObject());
			} else
				nut = Admin.getCopiedAdmin((Admin) ois.readObject());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (type.equals("Nutritionist")) {
			((Nutritionist) nut).setCustomersList(restoreCustomers(pathToCustomers.toString()));
		} else {
			((Admin) nut).setCustomersList(restoreCustomers(pathToCustomers.toString()));
		}
		return nut;
	}

	private static ArrayList<Customer> restoreCustomers(String pathToCust) throws IOException {
		File path = new File(pathToCust);
		Customer cust;
		ArrayList<Customer> custList = new ArrayList<Customer>();
		if (path.list() == null) {
			System.out.println(path.list());
			return custList;
		}
		for (String file : path.list()) {
			if (file.equals(".DS_Store")) {
				continue;
			}
			fis = new FileInputStream(path + "/" + file + "/" + file + ".txt");
			ois = new ObjectInputStream(fis);
			try {
				cust = (Customer) ois.readObject();
				cust.setSessions(restoreSessions(path + "/" + file + "/Sessions"));
				custList.add(cust);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return custList;
	}
	
	private static ArrayList<Session> restoreSessions(String pathToSessions) throws IOException{
		File path = new File(pathToSessions);
		ArrayList<Session> sessList = new ArrayList<Session>();
		Session sess;
		if (path.list() == null) {
			System.out.println(path.list());
			return sessList;
		}
		for (String file : path.list()) {
			if (file.equals(".DS_Store")) {
				continue;
			}
			fis = new FileInputStream(path + "/" + file + "/" + file + ".txt");
			ois = new ObjectInputStream(fis);
			FileInputStream mfis = new FileInputStream(path + "/" + file + "/Measures.txt");
			@SuppressWarnings("resource")
			ObjectInputStream mois = new ObjectInputStream(mfis);
			try {
				sess = (Session)ois.readObject();
				sess.setMeasures((Measures)mois.readObject());
				sessList.add(sess);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sessList;
	}

	public static String getPath() {
		String path;
		String os = System.getProperty("os.name");
		if (!os.toLowerCase().startsWith("windows")) {
			path = System.getProperty("user.home") + "/Documents/.fat_off";
			//path = System.getProperty("user.home") + "/Documents/.fat_off_test";
		}
		else {
			path = System.getProperty("user.home") + "/.fat_off";
			//path = System.getProperty("user.home") + "/.fat_off_test";
		}
		return path;
	}

	public static String getNutPath(Nutritionist nut) {

		String folderName = nut.getFirstName() + "_" + nut.getLastName() + "_" + nut.getId();
		File pathToDieticion = new File(SaveRestore.getPath() + "/Dieticions");
		File pathToAdmin = new File(SaveRestore.getPath() + "/Admin");
		String pathToReturn = "";
		for (String desired : pathToAdmin.list()) {
			if (desired.equals(".DS_Store")) {
				continue;
			}
			if (desired.equals(folderName)) {
				pathToReturn = pathToAdmin.toString() + "/" + folderName + "/Customers/";
				break;
			}

		}
		if (pathToReturn.equals("")) {
			for (String desired : pathToDieticion.list()) {
				if (desired.equals(".DS_Store")) {
					continue;
				}

				if (desired.equals(folderName)) {
					pathToReturn = pathToDieticion.toString() + "/" + folderName + "/Customers/";
					break;
				}

			}

		}
		return pathToReturn;
	}


	// ############################################### PDF Writer
	// #################################################
	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
//    private static void addMetaData(Document document) {
//        document.addTitle("Introductory Meeting");
//        document.addSubject("Interview");
//        document.addKeywords("Java, PDF, iText");
//        document.addAuthor("Lars Vogel");
//        document.addCreator("Lars Vogel");
//    }

	private static void addTitlePage(Document document, Customer cust , String header)
			throws DocumentException, MalformedURLException, IOException {
		LocalDateTime now = LocalDateTime.now();

		try {
			document.open();

			Image image = Image.getInstance("Image/fat_off_logo.png");

			// set Absolute Position
			// image.setAbsolutePosition(220f, 550f);

			document.add(image);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph(header, catFont));

		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface.add(new Paragraph( "Report generated by: FatOff, " + DateTimeFormatter.ofPattern("dd/MM/YYYY").format(now).toString(), smallBold));

		addEmptyLine(preface, 2);
		preface.add(new Paragraph("The Customer: ", smallBold));

		addEmptyLine(preface, 1);

		preface.add(new Paragraph("Full Name: " + cust.getFirstName() + " " + cust.getLastName(), blackFont));
		preface.add(new Paragraph("Phone Number: " + cust.getPhoneNumber(), blackFont));
		preface.add(new Paragraph("Email Address: " + cust.getEmailAddress(), blackFont));
		preface.add(new Paragraph("Customer ID: " + cust.getId(), blackFont));
		preface.add(new Paragraph("Gender: " + cust.getGender(), blackFont));

		document.add(preface);
		// Start a new page
		document.newPage();
	}

	private static void addInterviewContent(Document document, IntroductoryMeeting intro) throws DocumentException {

		try {
			Image image = Image.getInstance("Image/imgonline-com-ua-resize-5aRADIEx30404X17.png");

			// set Absolute Position
			// image.setAbsolutePosition(220f, 550f);

			document.add(image);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Second parameter is the number of the chapter
		Paragraph catPart = new Paragraph(new Paragraph("1. Why have you decided to come to a dietician?", subFont));
		Paragraph subPara = new Paragraph(intro.getWhyGoToNut(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(new Paragraph("2. What is your goal?", subFont));
		subPara = new Paragraph(intro.getWhatTarget(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(
				new Paragraph("3. Has someone pushed you to go to a dietician? Please elaborate..", subFont));
		subPara = new Paragraph(intro.getSomeoneSentYou(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(
				new Paragraph("4. Have you ever started a process with a dietician? Please elaborate..", subFont));
		subPara = new Paragraph(intro.getHaveYouBeenToNut(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(new Paragraph("5. Do you have troubles with concentrating recently?", subFont));
		subPara = new Paragraph(intro.getConcentrationIssue(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(new Paragraph("6. Have you recently gained or lost weight unexpectedly?", subFont));
		subPara = new Paragraph(intro.getGainedLostWeight(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(new Paragraph(
				"7. Where there any digestion problems (diarhea, vomiting, Lack of appetite)?", subFont));
		subPara = new Paragraph(intro.getStomackIssue(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(new Paragraph("8. Typical day (Wakeup time, daily activity, work hours, work type,"
				+ "\n" + "sport actvity (How often))...", subFont));
		subPara = new Paragraph(intro.getTypicalDay(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph("9. Describe what you ate yesterday (or any other specific day).", subFont);
		subPara = new Paragraph(intro.getYesterdayEat(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph("10. Do you have any alergies? Please elaborate..", subFont);
		subPara = new Paragraph(intro.getAllergies(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(
				new Paragraph("11. Are there any food product you don't like? Please elaborate..", subFont));
		subPara = new Paragraph(intro.getDislikeFood(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(
				new Paragraph("12. Are there any backgroud diseases? Any medications you take?", subFont));
		subPara = new Paragraph(intro.getMedication(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

	}
	
	private static void addSessionContent(Document document, Session sess) throws DocumentException {
		Measures meas = sess.getMeasures();

		try {
			Image image = Image.getInstance("Image/imgonline-com-ua-resize-5aRADIEx30404X17.png");
			document.add(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Customer Measures:", catFont));

		addEmptyLine(preface, 1);

		preface.add(new Paragraph("Weight: " + meas.getWeight(), blackFont));
		preface.add(new Paragraph("Height: " + meas.getHeight(), blackFont));
		preface.add(new Paragraph("Waist: " + meas.getWeight(), blackFont));
		preface.add(new Paragraph("Thigh: " + meas.getThigh(), blackFont));
		preface.add(new Paragraph("Wrist: " + meas.getWrist(), blackFont));
		
		addEmptyLine(preface, 1);
		
		preface.add(new Paragraph("BMI: " + (new DecimalFormat("##.##").format((double) meas.getBmi())), blackFont));
		preface.add(new Paragraph("EER: " + (new DecimalFormat("##.##").format((double) meas.getEer())), blackFont));
		preface.add(new Paragraph("Activity Level: " + meas.getActivity(), blackFont));
		preface.add(new Paragraph("Physique: " + meas.getPhysique(), blackFont));
		
		addEmptyLine(preface, 3);

		document.add(preface);

		// Second parameter is the number of the chapter
		Paragraph catPart = new Paragraph(new Paragraph("Session " + sess.getSessionNum() + " Summary", subFont));
		Paragraph subPara = new Paragraph(sess.getSessionSummary(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 3);
		
		catPart = new Paragraph(new Paragraph("1. Breakfast suggestion:", subFont));
		subPara = new Paragraph(sess.getBreakfast(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(new Paragraph("2. Snack 1 suggestion:", subFont));
		subPara = new Paragraph(sess.getSnack1(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph("3. Lunch suggestion:", subFont);
		subPara = new Paragraph(sess.getLunch(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
	
		catPart = new Paragraph("4. Snack 2 suggestion:", subFont);
		subPara = new Paragraph(sess.getSnack2(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

		catPart = new Paragraph(new Paragraph("5. Dinner suggestion:", subFont));
		subPara = new Paragraph(sess.getDinner(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

	}


	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}