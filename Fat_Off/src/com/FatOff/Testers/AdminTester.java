package com.FatOff.Testers;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.FatOff.Model.Admin;
import com.FatOff.Model.Customer;
import com.FatOff.Model.SaveRestore;

public class AdminTester {

	@SuppressWarnings("deprecation")
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
		
		Admin adm = Admin.getAdmin("danie", "sdfa", "1243155111", "dasdas@gmasil.com", "123456", 123,
				"dgsadfgasdfgasfdg", "123456");
		
		
		adm.addCustomer(new Customer("vlad", "gasin", "1233", 
							"boobies@gmail.com", "123", "Unknown" , new Date("12/08/1989")));
		SaveRestore<Admin> temp = new SaveRestore<Admin>(adm,SaveRestore.getPath());
		try {
			temp.storeToFile("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin adm2 = null;
		try {
			adm2 = (Admin)SaveRestore.restoreFromFile("danie_sdfa_123456", "Admin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(adm2.getPhoneNumber());
		
		
		adm2.setPhoneNumber("0505050050");
		
		
		SaveRestore<Admin> temp2 = new SaveRestore<Admin>(adm2,SaveRestore.getPath());
		try {
			temp2.storeToFile("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Admin test2 = null;
		
		try {
			test2 = (Admin)SaveRestore.restoreFromFile("danie_sdfa_123456", "Admin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(test2.getFirstName() + " " + test2.getLastName() + " " + test2.getPhoneNumber());

	}

}
