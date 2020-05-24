package com.FatOff.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
	private File pathToCustDir;
	private static String pathToDieticions; 
	private ObjectOutputStream writeFile;
	private FileOutputStream pathToObj;
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	public SaveRestore(T obj, String path) {
		this.obj = obj;
		pathToDieticions = path + "/Dieticions";
	}

	public void storeToFile(String dietition) throws IOException {

		if (this.obj.getClass().toString().contains("Nutritionist")) {
			this.storeNutritionist(path, (Nutritionist)this.obj);
		}
		else if(this.obj.getClass().toString().contains("Customer")) {
			this.storeCustomer(pathToDieticions, dietition, (Customer)this.obj);
		}

	}
	
	public void storeNutritionist(String path , Nutritionist nut) throws IOException {
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
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Customer cust : nut.getCustomersList()) {
			this.storeCustomer(pathToDieticions+"/" +temp_path+"/Customers", nut.getFirstName(), cust);
		}
		
	}
	/**
	 * 
	 * @param path
	 * @param dietition
	 * @param cust
	 * @throws IOException
	 */
	public void storeCustomer(String path, String dieticion, Customer cust) throws IOException {
		String tempCustPath = cust.getFirstName() + "_" + cust.getLastName() + "_" + cust.getId();
		File custDir = new File(path + "/" + tempCustPath);
		if(!custDir.exists()) {
			custDir.mkdir();
		}
		try {
			this.storeSessions(path + "/" + tempCustPath + "/" , cust);
			this.storeMeasures(path + "/" + tempCustPath + "/" , cust);
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
			pathToObj = new FileOutputStream(path+"Sessions.txt");
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
			pathToObj = new FileOutputStream(path+"Measures.txt");
			writeFile = new ObjectOutputStream(pathToObj);
			writeFile.writeObject(cust.getMeasuresMap());
			writeFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Object restoreFromFile(String name, String type, String path) throws IOException {
		Nutritionist nut = null;
		if (type == "Nutritionist") {
			pathToDieticions = path + "/Dieticions";
			File pathToCustomers = new File(pathToDieticions + "/" + name + "/Customers/");
			File Dieticion = new File(pathToDieticions + "/" + name + "/" + name + ".txt");
			if (!Dieticion.exists()) {
				System.out.println("File " + Dieticion.toString() + "Not found");
			}
			fis = new FileInputStream(Dieticion);
			ois = new ObjectInputStream(fis);
			
			try {
				nut = new Nutritionist((Nutritionist)ois.readObject());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			nut.setCustomersList(restoreCustomers(pathToCustomers.toString()));
		}
		return nut;
	}
		
	public static ArrayList<Customer> restoreCustomers(String pathToCust) throws IOException {
		File path = new File(pathToCust);
		ArrayList<Customer> custList = new ArrayList<Customer>();
		if(path.list() == null) {
			return custList;
		}
		for (String file : path.list()) {
			fis = new FileInputStream(path+"/"+file+"/"+file + ".txt");
			ois = new ObjectInputStream(fis);
			try {
				custList.add((Customer) ois.readObject());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return custList;
	}


}
