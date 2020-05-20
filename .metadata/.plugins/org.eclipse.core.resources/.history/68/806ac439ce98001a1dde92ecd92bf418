/**
 * This class represent any Admin which will be created in the Fat_Off project
 * 
 * @author Fat_Off Development Team
 *@version 1.0
 */
import java.util.*;

public class Admin extends Nutritionist {
	
	private ArrayList<Nutritionist> nutriList;


	/**
	 * @param firstName the Admin first name
	 * @param lastName the Admin last name
	 * @param phoneNumber the Admin phone number
	 * @param emailAddress the Admin email address
	 * @param id the Admin id
	 * @param licenseId the Admin license id
	 * @param emailAppPass the Admin email application password
	 * @param password the Admin password to the system
	 */
	
	public Admin(String firstName, String lastName, String phoneNumber, String emailAddress, String id, int licenseId,
			String emailAppPass, String password) {
		super(firstName, lastName, phoneNumber, emailAddress, id, licenseId, emailAppPass, password);
		setNutriList(new ArrayList<Nutritionist>());
	}
	/**
	 * 
	 * 
	 * @return the List of nutritionist
	 */

	public ArrayList<Nutritionist> getNutriList() {
		return nutriList;
	}

	/**
	 * 
	 * @param nutriList set a list of nutritionist
	 */
	public void setNutriList(ArrayList<Nutritionist> nutriList) {
		this.nutriList = nutriList;
	}
	
	/**
	 * 
	 * @param cust assign a customer to nutritionist
	 * @param nutri nutritionist to assigned a customer to
	 */
	public void assignCustumer(Customer cust,Nutritionist nutri )
	{
		nutri.addCustomer(cust);
	}
	
	public void deleteNut(Nutritionist nutri)
	{
		this.nutriList.remove(nutri);
	}
	
	public void createNut(String firstName, String lastName, String phoneNumber, String emailAddress, String id, int licenseId,
			String emailAppPass, String password)	{
		this.nutriList.add(new Nutritionist(firstName,lastName,phoneNumber,emailAddress,id,licenseId,emailAppPass,password));
	}
	

}
