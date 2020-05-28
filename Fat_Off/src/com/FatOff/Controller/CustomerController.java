package com.FatOff.Controller;

import java.io.IOException;

import com.FatOff.Model.Customer;
import com.FatOff.Model.SaveRestore;

public class CustomerController {
	
	public CustomerController() {
		
	}
	
	public static Customer createCustomer(String fName , String lName , String phone , String email , String id , String gender , String pathToCustomer) {
		
		Customer cust = new Customer(fName, lName, phone, email, id, gender);
		SaveRestore<Customer> saveCust = new SaveRestore<Customer>(cust , SaveRestore.getPath());
		
		try {
			saveCust.storeCustomer(pathToCustomer, cust);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cust;
	}
}
