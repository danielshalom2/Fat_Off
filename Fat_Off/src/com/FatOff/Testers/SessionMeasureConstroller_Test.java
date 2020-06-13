package com.FatOff.Testers;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.FatOff.Controller.SessionMeasureController;
import com.FatOff.Model.Measures;
import com.FatOff.Model.Session;

class SessionMeasureConstroller_Test {

	private static ArrayList<Session> sessList = new ArrayList<Session>();
	private static Measures meas1 = new Measures();
	private static Measures meas2 = new Measures();
	private static Measures meas3 = new Measures();
	private static Measures meas4 = new Measures();
	private static Measures meas5 = new Measures();
	private static Measures meas6 = new Measures();
	private static Measures meas7 = new Measures();

	private static Session sess1 = new Session(1);
	private static Session sess2 = new Session(2);
	private static Session sess3 = new Session(3);
	private static Session sess4 = new Session(4);
	private static Session sess5 = new Session(5);
	private static Session sess6 = new Session(6);
	private static Session sess7 = new Session(7);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Test class SessionMeasureController");
		sess1.setMeasures(meas1);
		sess2.setMeasures(meas2);
		sess3.setMeasures(meas3);
		sess4.setMeasures(meas4);
		sess5.setMeasures(meas5);
		sess6.setMeasures(meas6);
		sess7.setMeasures(meas7);
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Test class customer controller finish");

	}

	/*
	 * @BeforeEach void setUp() throws Exception { }
	 */
	 
	@AfterEach void tearDown() throws Exception { 
		sessList.clear();
	}

	@Test
	void testBmiReport1() {
		System.out.println("Testing BMI Report with sorted list");
		
		// Set Height for the list of the sessions
		sess1.getMeasures().setHeight(175);
		sess2.getMeasures().setHeight(175);
		sess3.getMeasures().setHeight(175);
		sess4.getMeasures().setHeight(175);
		sess5.getMeasures().setHeight(175);
		sess6.getMeasures().setHeight(175);
		sess7.getMeasures().setHeight(175);
		
		// Set Weight for the list of the sessions
		sess1.getMeasures().setWeight(90);
		sess1.getMeasures().calcBMI();
		sess2.getMeasures().setWeight(87);
		sess2.getMeasures().calcBMI();
		sess3.getMeasures().setWeight(85);
		sess3.getMeasures().calcBMI();
		sess4.getMeasures().setWeight(86);
		sess4.getMeasures().calcBMI();
		sess5.getMeasures().setWeight(83);
		sess5.getMeasures().calcBMI();
		sess6.getMeasures().setWeight(80);
		sess6.getMeasures().calcBMI();
		sess7.getMeasures().setWeight(82);
		sess7.getMeasures().calcBMI();
		
		// Insert the Sessions to the List
		sessList.add(sess1);
		sessList.add(sess2);
		sessList.add(sess3);
		sessList.add(sess4);
		sessList.add(sess5);
		sessList.add(sess6);
		sessList.add(sess7);
		
		// function check -- > (num2 - num1)/num1*100
		Double[] expected = {-3.33332,-2.29884,1.17646,-3.4885,-3.61434,2.50003,-8.89026};
		ArrayList<Double> report1 = SessionMeasureController.generateBmiProgressReport(sessList);
		
		Assertions.assertEquals(expected[0], report1.get(0), 0.01);
		Assertions.assertEquals(expected[1], report1.get(1), 0.01);
		Assertions.assertEquals(expected[2], report1.get(2), 0.01);
		Assertions.assertEquals(expected[3], report1.get(3), 0.01);
		Assertions.assertEquals(expected[4], report1.get(4), 0.01);
		Assertions.assertEquals(expected[5], report1.get(5), 0.01);
		Assertions.assertEquals(expected[6], report1.get(6), 0.01);

	}
	
	@Test
	void testBmiReport2() {
		System.out.println("Testing BMI Report with not sorted list");
		
		// Set Height for the list of the sessions
		sess1.getMeasures().setHeight(175);
		sess2.getMeasures().setHeight(175);
		sess3.getMeasures().setHeight(175);
		sess4.getMeasures().setHeight(175);
		sess5.getMeasures().setHeight(175);
		sess6.getMeasures().setHeight(175);
		sess7.getMeasures().setHeight(175);
		
		// Set Weight for the list of the sessions
		sess1.getMeasures().setWeight(90);
		sess1.getMeasures().calcBMI();
		sess2.getMeasures().setWeight(87);
		sess2.getMeasures().calcBMI();
		sess3.getMeasures().setWeight(85);
		sess3.getMeasures().calcBMI();
		sess4.getMeasures().setWeight(86);
		sess4.getMeasures().calcBMI();
		sess5.getMeasures().setWeight(83);
		sess5.getMeasures().calcBMI();
		sess6.getMeasures().setWeight(80);
		sess6.getMeasures().calcBMI();
		sess7.getMeasures().setWeight(82);
		sess7.getMeasures().calcBMI();
		
		// Insert the Sessions to the List
		sessList.add(sess5);
		sessList.add(sess4);
		sessList.add(sess2);
		sessList.add(sess1);
		sessList.add(sess3);
		sessList.add(sess7);
		sessList.add(sess6);
		
		// function check -- > (num2 - num1)/num1*100
		Double[] expected = {-3.33332,-2.29884,1.17646,-3.4885,-3.61434,2.50003,-8.89026};
		ArrayList<Double> report2 = SessionMeasureController.generateBmiProgressReport(sessList);
		
		Assertions.assertEquals(expected[0], report2.get(0), 0.01);
		Assertions.assertEquals(expected[1], report2.get(1), 0.01);
		Assertions.assertEquals(expected[2], report2.get(2), 0.01);
		Assertions.assertEquals(expected[3], report2.get(3), 0.01);
		Assertions.assertEquals(expected[4], report2.get(4), 0.01);
		Assertions.assertEquals(expected[5], report2.get(5), 0.01);
		Assertions.assertEquals(expected[6], report2.get(6), 0.01);
		
	}
	
	@Test
	void testWaistReport1() {
		System.out.println("Testing Waist Report with sorted list");
		
		// Set Weight for the list of the sessions
		sess1.getMeasures().setWaist(90);
		sess2.getMeasures().setWaist(87);
		sess3.getMeasures().setWaist(85);
		sess4.getMeasures().setWaist(86);
		sess5.getMeasures().setWaist(83);
		sess6.getMeasures().setWaist(80);
		sess7.getMeasures().setWaist(82);
		
		// Insert the Sessions to the List
		sessList.add(sess1);
		sessList.add(sess2);
		sessList.add(sess3);
		sessList.add(sess4);
		sessList.add(sess5);
		sessList.add(sess6);
		sessList.add(sess7);
		
		// function check -- > (num2 - num1)/num1*100
		Double[] expected = {-3.33333,-2.29885,1.17647,-3.48837,-3.61445,2.5,-8.88888};
		ArrayList<Double> report3 = SessionMeasureController.generateWaistProgressReport(sessList);
		
		Assertions.assertEquals(expected[0], report3.get(0), 0.01);
		Assertions.assertEquals(expected[1], report3.get(1), 0.01);
		Assertions.assertEquals(expected[2], report3.get(2), 0.01);
		Assertions.assertEquals(expected[3], report3.get(3), 0.01);
		Assertions.assertEquals(expected[4], report3.get(4), 0.01);
		Assertions.assertEquals(expected[5], report3.get(5), 0.01);
		Assertions.assertEquals(expected[6], report3.get(6), 0.01);
		
	}

	@Test
	void testWaistReport2() {
		System.out.println("Testing Waist Report with not sorted list");
		
		// Set Weight for the list of the sessions
		sess1.getMeasures().setWaist(90);
		sess2.getMeasures().setWaist(87);
		sess3.getMeasures().setWaist(85);
		sess4.getMeasures().setWaist(86);
		sess5.getMeasures().setWaist(83);
		sess6.getMeasures().setWaist(80);
		sess7.getMeasures().setWaist(82);
		
		// Insert the Sessions to the List
		sessList.add(sess4);
		sessList.add(sess2);
		sessList.add(sess7);
		sessList.add(sess5);
		sessList.add(sess1);
		sessList.add(sess6);
		sessList.add(sess3);
		
		// function check -- > (num2 - num1)/num1*100
		Double[] expected = {-3.33333,-2.29885,1.17647,-3.48837,-3.61445,2.5,-8.88888};
		ArrayList<Double> report3 = SessionMeasureController.generateWaistProgressReport(sessList);
		
		Assertions.assertEquals(expected[0], report3.get(0), 0.01);
		Assertions.assertEquals(expected[1], report3.get(1), 0.01);
		Assertions.assertEquals(expected[2], report3.get(2), 0.01);
		Assertions.assertEquals(expected[3], report3.get(3), 0.01);
		Assertions.assertEquals(expected[4], report3.get(4), 0.01);
		Assertions.assertEquals(expected[5], report3.get(5), 0.01);
		Assertions.assertEquals(expected[6], report3.get(6), 0.01);
		
	}
}
