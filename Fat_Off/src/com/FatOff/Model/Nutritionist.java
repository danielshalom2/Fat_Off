package com.FatOff.Model;

import java.io.Serializable;
import com.FatOff.MailSender.*;
import java.util.*;

/**
 * This class represents the nutritionists which will use the Fat_Off project
 * 
 * @author Fat_Off Development Team (Vlad , Galia, Daniel , Boris)
 * @version 1.0
 *
 */

public class Nutritionist extends Person implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -4702547271836868397L;
	private int licenseId;
	private String emailAppPass;
	private String password;
	private ArrayList<Customer> customersList;

	/**
	 * @param firstName    the nutritionists' first name
	 * @param lastName     the nutritionists' last name
	 * @param phoneNumber  the nutritionists' phone number
	 * @param emailAddress the nutritionists' email address
	 * @param id           the nutritionists' id
	 * @param licenseId    the nutritionists' license id
	 * @param emailAppPass the nutritionists' email application password
	 * @param password     the nutritionists' password to the system
	 */
	public Nutritionist(String firstName, String lastName, String phoneNumber, String emailAddress, String id,
			int licenseId, String emailAppPass, String password) {
		// Initialize super object
		super(firstName, lastName, phoneNumber, emailAddress, id);

		// Initialize local private variables
		this.licenseId = licenseId;
		this.emailAppPass = emailAppPass;
		this.password = password;
		customersList = new ArrayList<Customer>();
	}

	public Nutritionist(Nutritionist other) {
		// Initialize super object
		super(other.getFirstName(), other.getLastName(), other.getPhoneNumber(), other.getEmailAddress(),
				other.getId());

		// Initialize local private variables
		this.licenseId = other.licenseId;
		this.emailAppPass = other.emailAppPass;
		this.password = other.password;
		customersList = new ArrayList<Customer>();
	}

	/**
	 * @return the licenseId
	 */

	public int getLicenseId() {
		return licenseId;
	}

	/**
	 * @param licenseId the licenseId to set
	 */
	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}

	/**
	 * @return the customersList
	 */
	public ArrayList<Customer> getCustomersList() {
		return customersList;
	}

	/**
	 * @param customersList the customersList to set
	 */
	public void setCustomersList(ArrayList<Customer> customersList) {
		this.customersList = customersList;
	}

	/**
	 * @param newPass the new password to set
	 */
	public void setPassword(String newPass) {
		this.password = newPass;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * @param emailAppPass the emailAppPass to set
	 */
	public void setEmailAppPass(String emailAppPass) {
		this.emailAppPass = emailAppPass;
	}

	public String getEmailAppPass() {
		return emailAppPass;
	}

	/**
	 * 
	 * @param customerToAdd the customer that need to be added to the list
	 */
	public void addCustomer(Customer customerToAdd) {
		System.out.println("Adding Cust");
		this.customersList.add(customerToAdd);
	}

	public String resetPassword() { 

		int validation = new Random().nextInt(999999) + 100000;
		MailSender email = new MailSender(this.getEmailAddress(),"Fat_Off_Password_Reset",this.getEmailAddress(),this.getEmailAppPass());
		email.sendValidationCode(validation);
	
		return String.valueOf(validation);
	}
}

