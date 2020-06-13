package com.FatOff.Testers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.FatOff.Controller.CustomerController;
import com.FatOff.Model.Customer;

import java.util.Date;
class CustController_Test {

	@SuppressWarnings("deprecation")
	private Customer testC = new Customer("FirstC","LastC" , "555", "testC@c.com", "3", "male",new Date("07/10/1987"));
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Test class customer controller");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Test class customer controller finish");

	}

	@Test
	void testCalcAge() {
		Assertions.assertEquals(32.9,Double.parseDouble(CustomerController.calcAge(testC)) ,0.2);
	}

}
