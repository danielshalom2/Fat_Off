package com.FatOff.Testers;

import java.io.IOException;

import com.FatOff.Model.Admin;
import com.FatOff.Model.Customer;
import com.FatOff.Model.SaveRestore;

public class AdminTester {

	public static void main(String[] args) {
		
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
		
		

	}

}
