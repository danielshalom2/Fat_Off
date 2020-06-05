package com.FatOff.Controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.FatOff.Model.Admin;
import com.FatOff.Model.Customer;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;
import com.FatOff.View.InitialWin;

public class CustomerController {

	public CustomerController() {

	}

	public static Customer createCustomer(String fName, String lName, String phone, String email, String id,
			String gender, String pathToCustomer) {
		System.out.println("From customer controller + " + pathToCustomer);

		Customer cust = new Customer(fName, lName, phone, email, id, gender);
		SaveRestore<Customer> saveCust = new SaveRestore<Customer>(cust, pathToCustomer);

		try {
			saveCust.storeCustomer(pathToCustomer, cust);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cust;
	}

	public static String pathToType(Nutritionist nut) {
		String folderName = nut.getFirstName() + "_" + nut.getLastName() + "_" + nut.getId();
		System.out.println(folderName);
		File pathToDieticion = new File(SaveRestore.getPath() + "/Dieticion");
		File pathToAdmin = new File(SaveRestore.getPath() + "/Admin");
		System.out.println(pathToAdmin.toString() + " " + pathToDieticion.toString());
		String pathToReturn = "";
		System.out.println("from path to type");
		for (String desired : pathToAdmin.list()) {
			System.out.println(desired);
			if (desired.equals(".DS_Store")) {
				System.out.println(desired);
				continue;
			}
			if (desired.equals(folderName)) {
				System.out.println(desired);
				pathToReturn = pathToAdmin.toString() + "/" + folderName;
				break;
			}

		}
		System.out.println(pathToReturn);
		if (pathToReturn.equals("")) {
			for (String desired : pathToDieticion.list()) {
				System.out.println(desired);
				if (desired.equals(".DS_Store")) {
					System.out.println(desired);
					continue;
				}

				if (desired.equals(folderName)) {
					System.out.println(desired);
					pathToReturn = pathToDieticion.toString() + "/" + folderName;
					break;
				}

			}

		}
		
		System.out.println("print before leave function");
		System.out.println(pathToReturn);
		return pathToReturn;
	}
}
