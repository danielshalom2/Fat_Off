package com.FatOff.Testers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.FatOff.Controller.CustomerController;
import com.FatOff.Model.Customer;

import java.text.DecimalFormat;
import java.util.Date;
class CustController_Test {

	private Customer testC = new Customer("FirstC","LastC" , "555", "testC@c.com", "3", "male",new Date("07/10/1987"));
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Test class customer controller");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Test class customer controller finish");

	}

	/*@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}*/

	@Test
	void testCalcAge() {
		Assertions.assertEquals(32.9,Double.parseDouble(CustomerController.calcAge(testC)) ,"Test calcAge");
	}

}
