package com.FatOff.Testers;

import java.io.File;
import java.io.IOException;

import com.FatOff.Model.*;

public class SaveRestoreTester {

	public static void main(String[] args) {
		
//		System.getProperties().list(System.out);
		String path;
		final File pathToFatOff;
		final File pathToDieticion;
		final File pathToAdmin;
		final String os = System.getProperty("os.name");
		
		// #######################################################################################
		// ################## Creation of default path directories for the objects ###############
		// #######################################################################################
		if (!os.toLowerCase().startsWith("windows"))
			path = System.getProperty("user.home") + "/Documents/.fat_off";

		else
			path = System.getProperty("user.home") + "/.fat_off";

		pathToFatOff = new File(path);
		pathToDieticion = new File(path + "/Dieticions");
		pathToAdmin = new File(path + "/Admin");
		if (!pathToFatOff.exists()) {
			pathToFatOff.mkdir();
			pathToAdmin.mkdir();
			pathToDieticion.mkdir();
		}
		
		// #######################################################################################
		// #################################### Test 1 ###########################################
		// #######################################################################################
		
		System.out.println("TEST 1 ----- TESTING SAVE NUTRITIONIST WITHOUT CUSTOMERS\n"
						+ "##########################################################\n");
		Nutritionist test1 = new Nutritionist("Galia", "Shalos", "144", "fdgsdf", "123", 456, "gdf", "123");
		SaveRestore<Nutritionist> savetest = new SaveRestore<Nutritionist>(test1, path);
		
		try { savetest.storeToFile(""); }
		catch (IOException e) { e.printStackTrace(); }
		
		String temp_path = test1.getFirstName() + "_" + test1.getLastName() + "_" + test1.getId();
		File testFile_1 = new File(pathToDieticion+"/"+temp_path);
		
		if(!testFile_1.exists()) System.out.println("------> Dietition folder creation failed ..");
		else System.out.println("------> Dietition folder created ..");
		
		testFile_1 = new File(pathToDieticion+"/"+temp_path+"/"+temp_path+".txt");
		
		if(!testFile_1.exists()) System.out.println("------> Dietition file creation failed ..");
		else System.out.println("------> Dietition file created ..");
		
		System.out.println("\nTEST 1 ----- FINISHED \n"
				+ "##########################################################\n\n\n");
		
		
		
		// #######################################################################################
		// #################################### Test 2 ###########################################
		// #######################################################################################
		System.out.println("TEST 2 ----- TESTING RESTORE NUTRITIONIST WITHOUT CUSTOMERS\n"
							+ "##########################################################\n");
		temp_path = test1.getFirstName() + "_" + test1.getLastName() + "_" + test1.getId();
		Nutritionist test2 = null;
		System.out.println("------> Test 2 before restore: " + test2);
		System.out.println("------> Temp Path is: " + temp_path);
		
		try { test2 = (Nutritionist)SaveRestore.restoreFromFile(temp_path, "Nutritionist", path); } 
		catch (IOException e) { e.printStackTrace(); }
		
		System.out.println("------> Test 2 after restore: \n"
							+ "------------> test2 first name similar To test1 first name: " + (test1.getFirstName().equals(test2.getFirstName()))
							+ "\n------------> test2 last name similar To test1 last name: " + (test2.getLastName().equals(test1.getLastName()))
							+ "\n------------> test2 phone similar To test1 phone: " + (test2.getPhoneNumber().equals(test1.getPhoneNumber()))
							+ "\n------------> test2 email similar To test1 email: " + (test2.getEmailAddress().equals(test1.getEmailAddress()))
							+ "\n------------> test2 phone similar To test1 phone: " + (test2.getLicenseId() == test1.getLicenseId())
							+ "\n------------> test2 ID similar To test1 ID: " + (test2.getId().equals(test1.getId())+"\n"));
		System.out.println("TEST 2 ----- FINISHED\n"
				+ "##########################################################\n");

		
		
		// #######################################################################################
		// #################################### Test 3 ###########################################
		// #######################################################################################
		
		System.out.println("TEST 3 ----- TESTING SAVE RESTORE NUTRITIONIST WITH CUSTOMERS\n"
				+ "##########################################################\n");
		Nutritionist test3 = null;
		test2.addCustomer(new Customer("Boris", "Mand", "0509588864", "borism@infinidat.com", "306953746", "male"));
		test2.addCustomer(new Customer("Alex", "Les", "0509345345", "alexl@infinidat.com", "306953816", "male"));
		
		System.out.println("------> The Customers are: " + test2.getCustomersList());
		
		SaveRestore<Nutritionist> savetest2 = new SaveRestore<Nutritionist>(test2, path);
		
		try { savetest2.storeToFile(""); } 
		catch (IOException e) { e.printStackTrace(); }
	
		System.out.println("------> Test 3 before restore " + test3);
		try { test3 = (Nutritionist)SaveRestore.restoreFromFile("Galia_Shalos_123", "Nutritionist", path); } 
		catch (IOException e) { e.printStackTrace(); }

		System.out.println("Test 3 after restore " + test3 + " " + test3.getPhoneNumber() + " " + test3.getCustomersList());
		
		System.out.println("TEST 3 ----- FINISHED\n"
				+ "##########################################################\n");
	}

}
