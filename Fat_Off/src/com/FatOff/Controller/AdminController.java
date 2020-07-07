package com.FatOff.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.FatOff.Model.Admin;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

/**
 * This class is a controller which was created in order to provide the GUI
 * classes a minimal API to the logical Admin and SaveRestore classes in the
 * model package
 * 
 * @author Fat Off Development Team
 * @version 1.0
 */
public class AdminController {

	/**
	 * This method initializes an Admin instance, and calls the store method to
	 * store it to a file in the default path.
	 * 
	 * @param firstName    The first name of the new Admin
	 * @param lastName     The last name of the new Admin
	 * @param phoneNumber  The phone number of the new Admin
	 * @param emailAddress The email address of the new Admin
	 * @param id           The id of the new Admin
	 * @param licenseId    The license id of the new Admin
	 * @param emailAppPass An application second factor password (allows to send
	 *                     mails from the admin's Mail)
	 * @param password     The password of the new Admin
	 * @return true if the Admin was successfully store to the storage. false if not
	 */
	public static boolean createAdmin(String firstName, String lastName, String phoneNumber, String emailAddress,
			String id, int licenseId, String emailAppPass, String password) {

		// Creating an Admin instance
		Admin adm = Admin.getAdmin(firstName, lastName, phoneNumber, emailAddress, id, licenseId, emailAppPass, password);

		// Initiating store to file procedure
		return storeAdmin(adm);

	}

	/**
	 * This method is responsible for storing Admin objects to files. Stores them in
	 * a default path.
	 * 
	 * @param adm The Admin instance to store as file
	 * @return true if the Admin was successfully store to the storage. false if not
	 */
	public static boolean storeAdmin(Admin adm) {
		try {

			// Initiating store to file procedure
			SaveRestore<Admin> saveAdmin = new SaveRestore<Admin>(adm, SaveRestore.getPath() + "/");
			saveAdmin.storeToFile("");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is responsible for the restoration of Admin instance from file.
	 * 
	 * @param adminName The name of the desired Admin to restore
	 * @return An Admin instance that was restored from file
	 */
	public static Admin restoreAdmin(String adminName) {
		Admin adm = null;
		try {
			// Call the restoreFromFile method which is defined in the SaveRestore class
			adm = (Admin) SaveRestore.restoreFromFile(adminName, "Admin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adm;
	}

	/**
	 * This method is responsible for restoring from the file system all the
	 * instances of nutritionists that reports to the admin. This is used for the
	 * admin to be able to assign customers from one dietitian to another.
	 * 
	 * @return An ArrayList of Nutirtionist Objects
	 * @throws IOException
	 */
	public static ArrayList<Nutritionist> getNutsList() throws IOException {

		// Initializes a File object that holds the path to the Dietitians folders
		File path = new File(SaveRestore.getPath() + "/" + "Dieticions");
		// Initializes the ArrayList to insert the dietitians to return
		ArrayList<Nutritionist> nutsList = new ArrayList<Nutritionist>();
		if (path.list() == null) {
			return nutsList;
		}
		for (String file : path.list()) {
			// .DS_Store is a default file in MacOS folders and it needs to be ignored
			if (file.equals(".DS_Store")) {
				continue;
			}
			// Add the restored Nutritionist instance to the list in each iteration
			nutsList.add((Nutritionist) SaveRestore.restoreFromFile(file, "Nutritionist"));
		}

		return nutsList;
	}

}
