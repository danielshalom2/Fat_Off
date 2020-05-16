/**
 * This class represents any person object in the Fat_Off project
 * 
 * @author Fat_Off Development Team
 * @version 1.0
 *
 */


public class Person {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String id;
	
	/**	
	 * @param firstName the persons first name
	 * @param lastName the persons last name
	 * @param phoneNumber the persons phone number
	 * @param emailAddress the persons email address
	 * @param id the persons id number
	 */
	public Person(String firstName, String lastName, String phoneNumber, String emailAddress, String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return a string representation of the class
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", id=" + id + "]";
	}
}
