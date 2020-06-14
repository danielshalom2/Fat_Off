package com.FatOff.Controller;

import java.io.IOException;

import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

/**
 * This class is a controller which was created in order to provide the GUI
 * classes a minimal API to the logical Admin and SaveRestore classes in the
 * view package
 * 
 * @author Fat Off Development Team
 * @version 1.0
 */
public class NutritionistController {

	/**
	 * This method is responsible for creating a Nutritionist instance and calling
	 * its store to file procedure.
	 * 
	 * @param firstName    The dietitians first name
	 * @param lastName     The dietitians last name
	 * @param phoneNumber  The dietitians phone number
	 * @param emailAddress The dietitians email address
	 * @param id           The dietitians ID
	 * @param licenseId    The dietitians license ID
	 * @param password     The dietitians password
	 * @return true if the dietitian was successfully stored to a file in the
	 *         FileSystem. false if not
	 */
	public static boolean createNutritionist(String firstName, String lastName, String phoneNumber, String emailAddress,
			String id, int licenseId, String password) {

		// Initialize a Nutritionist instance
		Nutritionist nut = new Nutritionist(firstName, lastName, phoneNumber, emailAddress, id, licenseId, password);
		// Call the store to file procedure
		return storeNutritionist(nut);

	}

	/**
	 * This method is responsible for initiating the store to file procedure from
	 * SaveRestore class
	 * 
	 * @param nut The Nutritionist instance to store to file
	 * @return true if the dietitian was successfully stored to a file in the
	 *         FileSystem. false if not
	 */
	public static boolean storeNutritionist(Nutritionist nut) {
		try {

			// Initialize a SaveRestore instance and call the storeToFile procedure
			SaveRestore<Nutritionist> saveNut = new SaveRestore<Nutritionist>(nut, SaveRestore.getPath() + "/");
			saveNut.storeToFile("");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is responsible for initiating the restore from file procedure
	 * from SaveRestore class
	 * 
	 * @param NutName The name of the Nutritionist to restore
	 * @return An instance of a Nutritionist class
	 */
	public static Nutritionist restoreNut(String NutName) {
		Nutritionist nut = null;
		try {
			nut = (Nutritionist) SaveRestore.restoreFromFile(NutName, "Nutritionist");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nut;
	}

}
