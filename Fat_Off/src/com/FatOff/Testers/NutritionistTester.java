package com.FatOff.Testers;

import java.util.Date;

import com.FatOff.Model.Customer;
import com.FatOff.Model.Nutritionist;

public class NutritionistTester {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nutritionist test1 = new Nutritionist("Olga", "Yerishev", "0526550000", "Olgay@gmail.com", "319588888", 50886, "123456");
		System.out.println("Test 1 dietician creation "+test1+"\n");
		
		test1.addCustomer(new Customer("Boris", "Mand", "0509588864", "borism@infinidat.com", "306953746", "male" , new Date("07/10/1987")));
		
		System.out.println("Test 2 dietician creation "+test1.getCustomersList()+"\n");
		
		test1.addCustomer(new Customer("Alex", "Mand", "0509588864", "Alexm@infinidat.com", "306953747", "male",new Date("07/10/1992")));
		System.out.println("Test 3 dietician creation "+test1.getCustomersList()+"\n");
		
		
		
	}

}
