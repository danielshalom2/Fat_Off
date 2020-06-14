package com.FatOff.Controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.FatOff.Model.Customer;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

/**
 * This class is a controller which was created in order to provide the GUI
 * classes a minimal API to the logical Customer and SaveRestore classes in the
 * model package
 * 
 * @author Fat Off Development Team
 * @version 1.0
 */
public class CustomerController {

	/**
	 * This method is responsible for creating and storing a new Customer instance
	 * to file in the given path (pathToCustomer).
	 * 
	 * @param fName          The first name of the customer to create
	 * @param lName          The last name of the customer to create
	 * @param phone          The phone number of the customer to create
	 * @param email          The email address of the customer to create
	 * @param id             The ID of the customer to create
	 * @param bDate          The birth date of the customer to create
	 * @param gender         The gender of the customer to create
	 * @param pathToCustomer The path to the FileSystem folder to store the Customer
	 *                       instance in
	 * @return The newly created Customer instance
	 */
	public static Customer createCustomer(String fName, String lName, String phone, String email, String id, Date bDate,
			String gender, String pathToCustomer) {

		// Initialize a Customer instance
		Customer cust = new Customer(fName, lName, phone, email, id, gender, bDate);

		// Initialize the store to file procedure
		SaveRestore<Customer> saveCust = new SaveRestore<Customer>(cust, pathToCustomer);
		try {
			saveCust.storeCustomer(pathToCustomer, cust);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cust;
	}

	/**
	 * This method is responsible for finding the right path to the customer. It
	 * searches in both Admin (as the admin also can have customers) and Dietitians
	 * folders.
	 * 
	 * @param nut            The dietitian to which this customer assigned to
	 * @param custFolderName The folder name of the desired customer to find the
	 *                       path to
	 * @return The path to the desired customer
	 */
	public static String pathToType(Nutritionist nut, String custFolderName) {

		// A string representation of the default folder name for the given Nutritionist
		String folderName = nut.getFirstName() + "_" + nut.getLastName() + "_" + nut.getId();

		// File instances for both paths (Admin and Dieticions) to search in
		File pathToDieticion = new File(SaveRestore.getPath() + "/Dieticions");
		File pathToAdmin = new File(SaveRestore.getPath() + "/Admin");

		// The path string to be returned
		String pathToReturn = "";

		// Scan Admin customers folder
		for (String desired : pathToAdmin.list()) {
			if (desired.equals(".DS_Store")) {
				continue;
			}
			if (desired.equals(folderName)) {
				pathToReturn = pathToAdmin.toString() + "/" + folderName + "/Customers/" + custFolderName;
				break;
			}

		}
		// Scan the given dietitian customers folder
		if (pathToReturn.equals("")) {
			for (String desired : pathToDieticion.list()) {
				if (desired.equals(".DS_Store")) {
					continue;
				}

				if (desired.equals(folderName)) {
					pathToReturn = pathToDieticion.toString() + "/" + folderName + "/Customers/" + custFolderName;
					break;
				}

			}

		}

		return pathToReturn;
	}

	/**
	 * This method is responsible for calculating the age of the customer in years.
	 * 
	 * @param cust The Customer instance to calc the age for
	 * @return The age of the customer in years with one number after the decimal
	 *         point
	 */
	public static String calcAge(Customer cust) {

		// The dates to calc the difference between
		Date today = new Date();
		Date custDate = cust.getDateOfBirth();

		// The difference in days (Calculated from seconds)
		int diff = (int) ((today.getTime() - custDate.getTime()) / (24 * 60 * 60 * 1000));

		return new DecimalFormat("##.#").format((double) diff / 365);
	}

	/**
	 * This method is responsible for re-assignment of customers from one dietitian
	 * to another.
	 * 
	 * @param srcPath  The path in the FileSystem of the customer to move
	 * @param destPath The path in the FileSystem of the dietitian to move the
	 *                 customer to
	 */
	public static void moveFolder(File srcPath, File destPath) {

		try {
			FileUtils.copyDirectory(srcPath, destPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Run over the files and the directories under the source folder.
		// Releases the file pointer from the memory in order to e able to delete it.
		File[] finlist = srcPath.listFiles();
		for (int n = 0; n < finlist.length; n++) {
			if (finlist[n].isFile()) {
				System.gc();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				finlist[n].delete();
			}
		}
		try {
			// Delete the source directory after it was copied to the new location
			FileUtils.deleteDirectory(srcPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
