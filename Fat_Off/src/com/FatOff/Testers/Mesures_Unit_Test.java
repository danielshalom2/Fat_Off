package com.FatOff.Testers;

import java.text.DecimalFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.FatOff.Model.Measures;


public final class Mesures_Unit_Test   {
	
	private static Measures testM=new Measures(18,(float) 75.0,180,50,50,50,"Male","active");;
	private static Measures testF=new Measures(18,(float) 75.0,180,50,50,50,"Female","active");
//	Measures testM=new Measures(18,(float) 75.0,180,50,50,50,"Male","active");
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Test class measures");
		//Measures testM=new Measures(18,(float) 75.0,180,50,50,50,"Male","active");
//		Measures(int age, float weight, float height, float wrist, float waist, float thigh, String gender, String activity)
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Test class measures finish");
	}

	
	@Test
	void testCalcBMI() {
		Assertions.assertEquals(23.1,Double.parseDouble(new DecimalFormat("##.#").format(testM.getBmi())),"Test Bmi Calc");
}
	@Test
	void testCalcMaleEER() {
		Assertions.assertEquals(2953.3,Double.parseDouble(new DecimalFormat("##.#").format(testM.getEer())),"Test Bmi Eer");
	}
	@Test
	void testCalcFemaleEER() {
		Assertions.assertEquals(2428.0,Double.parseDouble(new DecimalFormat("##.#").format(testF.getEer())),"Test Bmi Eer");
	}

	@Test
	void testCalcPhysicMale() {
		Assertions.assertEquals("Wide",testM.getPhysique(),"Test Bmi Physique");
	}
	void testCalcPhysicFemale() {
		Assertions.assertEquals("Wide",testF.getPhysique(),"Test Bmi Physique");
	}

}
