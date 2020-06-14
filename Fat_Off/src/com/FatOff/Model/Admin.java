package com.FatOff.Model;

import java.util.*;

/**
 * This class represent the Admin(Office manager) which will be created in the
 * Fat_Off project software.
 * 
 * @author Fat Off Development Team
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Admin extends Nutritionist {

	private ArrayList<Nutritionist> nutriList;
	private String emailAppPass;

	/**
	 * Constructor -- Initializes an Admin instance.
	 * 
	 * @param firstName    the Admin first name
	 * @param lastName     the Admin last name
	 * @param phoneNumber  the Admin phone number
	 * @param emailAddress the Admin email address
	 * @param id           the Admin id
	 * @param licenseId    the Admin license id
	 * @param emailAppPass the Admin email application password
	 * @param password     the Admin password to the system
	 */

	public Admin(String firstName, String lastName, String phoneNumber, String emailAddress, String id, int licenseId,
			String emailAppPass, String password) {
		super(firstName, lastName, phoneNumber, emailAddress, id, licenseId, password);
		setNutriList(new ArrayList<Nutritionist>());
		this.emailAppPass = emailAppPass;
	}

	/**
	 * Copy Constructor -- Initializes an Admin instance and copies the attributes
	 * from a given Admin instance.
	 * 
	 * @param other Another Admin instance to copy the attributes from
	 */
	public Admin(Admin other) {
		// Initialize super object
		super(other.getFirstName(), other.getLastName(), other.getPhoneNumber(), other.getEmailAddress(), other.getId(),
				other.getLicenseId(), other.getPassword());

		// Initialize local private variables
		setNutriList(new ArrayList<Nutritionist>());
		this.emailAppPass = other.getEmailAppPass();
	}

	/**
	 * This method is responsible for retrieving a list of nutritionists who report
	 * to the Admin.
	 * 
	 * @return the List of nutritionist
	 */

	public ArrayList<Nutritionist> getNutriList() {
		return nutriList;
	}

	public String getEmailAppPass() {
		return emailAppPass;
	}

	/**
	 * This method is responsible for setting a list of nutritionists who report to
	 * the Admin.
	 * 
	 * @param nutriList set a list of nutritionist
	 */
	public void setNutriList(ArrayList<Nutritionist> nutriList) {
		this.nutriList = nutriList;
	}

	/**
	 * This method is responsible for assigning a customer to a nutritionist.
	 * 
	 * @param cust  assign a customer to nutritionist
	 * @param nutri nutritionist to assigned a customer to
	 */
	public void assignCustumer(Customer cust, Nutritionist nutri) {
		nutri.addCustomer(cust);
	}

	/**
	 * This method is responsible for deleting a nutritionist.
	 * 
	 * @param nutri the nutritionist to delete
	 */
	public void deleteNut(Nutritionist nutri) {
		this.nutriList.remove(nutri);
	}

	/**
	 * This method is responsible for creating a nutritionist.
	 * 
	 * @param firstName    The first name of the nutritionist to create
	 * @param lastName     The last name of the nutritionist to create
	 * @param phoneNumber  The phone number of the nutritionist to create
	 * @param emailAddress The email address of the nutritionist to create
	 * @param id           The ID of the nutritionist to create
	 * @param licenseId    The license ID of the nutritionist to create
	 * @param password     The password of the nutritionist to create
	 */
	public void createNut(String firstName, String lastName, String phoneNumber, String emailAddress, String id,
			int licenseId, String emailAppPass, String password) {
		this.nutriList.add(new Nutritionist(firstName, lastName, phoneNumber, emailAddress, id, licenseId, password));
	}

}
