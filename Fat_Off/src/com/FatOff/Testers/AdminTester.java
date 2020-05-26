package com.FatOff.Testers;

import java.io.File;
import java.io.IOException;

import com.FatOff.Model.Admin;
import com.FatOff.Model.Customer;
import com.FatOff.Model.SaveRestore;

public class AdminTester {

	public static void main(String[] args) {
		
		String path;
		final File pathToFatOff;
		final File pathToDieticion;
		final File pathToAdmin;
		final String os = System.getProperty("os.name");
		
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
		
		Admin adm = new Admin("danie", "sdfa", "1243155111", "dasdas@gmasil.com", "123456", 123,
				"dgsadfgasdfgasfdg", "123456");
		
		adm.addCustomer(new Customer("vlad", "gasin", "1233", 
							"boobies@gmail.com", "123", "Unknown"));
		SaveRestore<Admin> temp = new SaveRestore<Admin>(adm,SaveRestore.getPath());
		try {
			temp.storeToFile("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin adm2 = null;
		Admin artem = null;
		try {
			adm2 = (Admin)SaveRestore.restoreFromFile("danie_sdfa_123456", "Admin", SaveRestore.getPath());
			artem = (Admin)SaveRestore.restoreFromFile("artem_soldin_300000999", "Admin", SaveRestore.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(adm2.getCustomersList());
		System.out.println(artem.getFirstName() + " " + artem.getLastName() + " " + artem.getPhoneNumber());
		
		artem.setPhoneNumber("0505050050");
		
		
		SaveRestore<Admin> temp2 = new SaveRestore<Admin>(artem,SaveRestore.getPath());
		try {
			temp.storeToFile("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Admin artem2 = null;
		
		try {
			artem2 = (Admin)SaveRestore.restoreFromFile("artem_soldin_300000999", "Admin", SaveRestore.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(artem.getFirstName() + " " + artem.getLastName() + " " + artem.getPhoneNumber());

	}

}
