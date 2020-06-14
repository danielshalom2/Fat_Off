package com.FatOff.Model;

import java.io.Serializable;
import java.util.*;

/**
 * This class represent any customer which will be created in the Fat_Off
 * project software.
 * 
 * @author Fat_Off Development Team
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Customer extends Person implements Serializable {

	private String gender;
	private ArrayList<Session> sessions;
	private IntroductoryMeeting pesronalInterview;
	final private Date dateOfBirth;

	/**
	 * Constructor -- Initializes a Customer instance with its attributes.
	 * 
	 * @param firstName    the customers' first name
	 * @param lastName     the customers' last name
	 * @param phoneNumber  the customers' phone number
	 * @param emailAddress the customers' email address
	 * @param id           the customers' is
	 * @param gender       the customers' gender
	 */
	public Customer(String firstName, String lastName, String phoneNumber, String emailAddress, String id,
			String gender, Date bDate) {
		// super class constructor
		super(firstName, lastName, phoneNumber, emailAddress, id);
		// initialization of the local private variable
		this.gender = gender;
		dateOfBirth = bDate;
		this.setSessions(new ArrayList<Session>());
		this.pesronalInterview = null;
	}

	/**
	 * This method is responsible for retrieving the gender of the customer.
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * This method is responsible for setting the gender of the customer.
	 * 
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * This method is responsible for retrieving the personal interview of the
	 * customer.
	 * 
	 * @return the pesronalInterview
	 */
	public IntroductoryMeeting getPesronalInterview() {
		return pesronalInterview;
	}

	/**
	 * This method is responsible for setting the personal interview of the
	 * customer.
	 * 
	 * @param pesronalInterview the pesronalInterview to set
	 */
	public void setPesronalInterview(IntroductoryMeeting pesronalInterview) {
		this.pesronalInterview = pesronalInterview;
	}

	/**
	 * This method is responsible for retrieving the date of birth of the customer.
	 * 
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * This method is responsible for retrieving the sessions list of the customer.
	 * 
	 * @return the sessions list of the customer
	 */
	public ArrayList<Session> getSessions() {
		return sessions;
	}

	/**
	 * This method is responsible for setting the sessions list of the customer.
	 * 
	 * @param session the session to set
	 */
	public void setSessions(ArrayList<Session> session) {
		this.sessions = session;
	}

	/**
	 * @return a string representation of the customer object.
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}
