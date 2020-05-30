package com.FatOff.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
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
		if (!custDir.exists()) {
			custDir.mkdir();
		}
		try {
			this.storeSessions(path + "/" + tempCustPath + "/", cust);
			this.storeMeasures(path + "/" + tempCustPath + "/", cust);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	private void storeSessions(String path, Customer cust) throws IOException {

		try {
			pathToObj = new FileOutputStream(path + "Sessions.txt");
			writeFile = new ObjectOutputStream(pathToObj);
			writeFile.writeObject(cust.getSessionsMap());
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
	private void storeMeasures(String path, Customer cust) throws IOException {

		try {
			pathToObj = new FileOutputStream(path + "Measures.txt");
			writeFile = new ObjectOutputStream(pathToObj);
			writeFile.writeObject(cust.getMeasuresMap());
			writeFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
			addTitlePage(newDoc, (Customer) obj);
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
				nut = new Admin((Admin) ois.readObject());
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

	public static ArrayList<Customer> restoreCustomers(String pathToCust) throws IOException {
		File path = new File(pathToCust);
		ArrayList<Customer> custList = new ArrayList<Customer>();
		if (path.list() == null) {
			return custList;
		}
		for (String file : path.list()) {
			if (file.equals(".DS_Store")) {
				continue;
			}
			fis = new FileInputStream(path + "/" + file + "/" + file + ".txt");
			ois = new ObjectInputStream(fis);
			try {
				custList.add((Customer) ois.readObject());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return custList;
	}

	public static String getPath() {
		String path;
		String os = System.getProperty("os.name");
		if (!os.toLowerCase().startsWith("windows"))
			path = System.getProperty("user.home") + "/Documents/.fat_off";

		else
			path = System.getProperty("user.home") + "/.fat_off";
		return path;
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

	private static void addTitlePage(Document document, Customer cust)
			throws DocumentException, MalformedURLException, IOException {
		LocalDateTime now = LocalDateTime.now();

		try {
			document.open();

			Image image = Image.getInstance("Image/imgonline-com-ua-resize-5aRADIEx30404X17.png");

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
		preface.add(new Paragraph("Introductory Meeting", catFont));

		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface.add(new Paragraph(
				"Report generated by: FatOff, " + DateTimeFormatter.ofPattern("dd/MM/YYYY").format(now).toString(), //$NON-NLS-2$
																													// //$NON-NLS-3$
				smallBold));

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
//		Section subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getWhyGoToNut()));
////
//		subPara = new Paragraph("What is your goal?", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getWhatTarget()));
		catPart = new Paragraph(new Paragraph("2. What is your goal?", subFont));
		subPara = new Paragraph(intro.getWhatTarget(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
//
//		subPara = new Paragraph("Has someone pushed you to go to a dietician? Please elaborate..", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getSomeoneSentYou()));
		catPart = new Paragraph(
				new Paragraph("3. Has someone pushed you to go to a dietician? Please elaborate..", subFont));
		subPara = new Paragraph(intro.getSomeoneSentYou(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
//
//		subPara = new Paragraph("Have you ever started a process with a dietician? Please elaborate..", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getHaveYouBeenToNut()));
		catPart = new Paragraph(
				new Paragraph("4. Have you ever started a process with a dietician? Please elaborate..", subFont));
		subPara = new Paragraph(intro.getHaveYouBeenToNut(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
//
//		subPara = new Paragraph("Do you have troubles with concentrating recently?", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getConcentrationIssue()));
		catPart = new Paragraph(new Paragraph("5. Do you have troubles with concentrating recently?", subFont));
		subPara = new Paragraph(intro.getConcentrationIssue(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
//
//		subPara = new Paragraph("Have you recently gained or lost weight unexpectedly?", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getGainedLostWeight()));
		catPart = new Paragraph(new Paragraph("6. Have you recently gained or lost weight unexpectedly?", subFont));
		subPara = new Paragraph(intro.getGainedLostWeight(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
//
//		subPara = new Paragraph("Where there any digestion problems (diarrhea, vomiting, Lack of appetite)?", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getStomackIssue()));
		catPart = new Paragraph(new Paragraph(
				"7. Where there any digestion problems (diarrhea, vomiting, Lack of appetite)?", subFont));
		subPara = new Paragraph(intro.getStomackIssue(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
//
//		subPara = new Paragraph("Typical day (Wakeup time, daily activity, work hours, work type," + "\n"
//				+ "sport actvity (How often))...", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getTypicalDay()));
		catPart = new Paragraph(new Paragraph("8. Typical day (Wakeup time, daily activity, work hours, work type,"
				+ "\n" + "sport actvity (How often))...", subFont));
		subPara = new Paragraph(intro.getTypicalDay(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
//

//		subPara = new Paragraph("Describe what you ate yesterday (or any other specific day).", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getYesterdayEat()));
		catPart = new Paragraph(
				new Paragraph("9. Describe what you ate yesterday (or any other specific day).", subFont));
		subPara = new Paragraph(intro.getYesterdayEat(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

//		subPara = new Paragraph("Do you have any alergies? Please elaborate..", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getAllergies()));
		catPart = new Paragraph(new Paragraph("10. Do you have any alergies? Please elaborate..", subFont));
		subPara = new Paragraph(intro.getAllergies(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
//
//		subPara = new Paragraph("Are there any food product you don't like? Please elaborate..", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getDislikeFood()));
		catPart = new Paragraph(
				new Paragraph("11. Are there any food product you don't like? Please elaborate..", subFont));
		subPara = new Paragraph(intro.getDislikeFood(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);
//
//		subPara = new Paragraph("Are there any backgroud diseases? Any medications you take?", subFont);
//		subCatPart = catPart.addSection(subPara);
//		subCatPart.add(new Paragraph(intro.getMedication()));
		catPart = new Paragraph(
				new Paragraph("12. Are there any backgroud diseases? Any medications you take?", subFont));
		subPara = new Paragraph(intro.getMedication(), blackFont);
		document.add(catPart);
		document.add(subPara);
		addEmptyLine(subPara, 1);

	}

	// add a list
//        createList(subCatPart);
//        Paragraph paragraph = new Paragraph();
//        addEmptyLine(paragraph, 5);
//        subCatPart.add(paragraph);
//
//        // add a table
//        //createTable(subCatPart);
//
//        // now add all this to the document
//        document.add(catPart);
//
//        // Second parameter is the number of the chapter
//        catPart = new Chapter(new Paragraph(anchor), 1);
//
//        subPara = new Paragraph("Subcategory", subFont);
//        subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("This is a very important message"));
//
//        // now add all this to the document
//        document.add(catPart);

//    }

//    private static void createTable(Section subCatPart)
//            throws BadElementException {
//        PdfPTable table = new PdfPTable(3);
//
//        // t.setBorderColor(BaseColor.GRAY);
//        // t.setPadding(4);
//        // t.setSpacing(4);
//        // t.setBorderWidth(1);
//
//        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//
//        c1 = new PdfPCell(new Phrase("Table Header 2"));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//
//        c1 = new PdfPCell(new Phrase("Table Header 3"));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//        table.setHeaderRows(1);
//
//        table.addCell("1.0");
//        table.addCell("1.1");
//        table.addCell("1.2");
//        table.addCell("2.1");
//        table.addCell("2.2");
//        table.addCell("2.3");
//
//        subCatPart.add(table);
//
//    }

//    private static void createList(Section subCatPart) {
//        List list = new List(true, false, 10);
//        list.add(new ListItem("First point"));
//        list.add(new ListItem("Second point"));
//        list.add(new ListItem("Third point"));
//        subCatPart.add(list);
//    }

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}