import java.util.*;

public class Admin extends Nutritionist {
	
	private ArrayList<Nutritionist> nutriList;

	public Admin(String firstName, String lastName, String phoneNumber, String emailAddress, String id, int licenseId,
			String emailAppPass, String password) {
		super(firstName, lastName, phoneNumber, emailAddress, id, licenseId, emailAppPass, password);
		setNutriList(new ArrayList<Nutritionist>());
	}

	public ArrayList<Nutritionist> getNutriList() {
		return nutriList;
	}

	public void setNutriList(ArrayList<Nutritionist> nutriList) {
		this.nutriList = nutriList;
	}
	
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
