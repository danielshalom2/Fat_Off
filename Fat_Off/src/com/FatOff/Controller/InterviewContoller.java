/**
 * 
 */
package com.FatOff.Controller;

import java.io.FileNotFoundException;

import com.FatOff.Model.Customer;
import com.FatOff.Model.IntroductoryMeeting;
import com.FatOff.Model.SaveRestore;
import com.itextpdf.text.DocumentException;

/**
 * @author borism
 *
 */
public class InterviewContoller {

	public InterviewContoller() {}

	public static void createIntroMeeting(String WhyGoToNut , String WhatTarget, String HaveYouBeenToNut, String someoneSent,
											String StomackIssue , String TypicalDay, String YesterdayEat, String Allergies,
											String DislikeFood, String Medication, String concentrationIssue, String gainedLostWeight, 
											Customer cust , String path) throws FileNotFoundException, DocumentException {
	
		IntroductoryMeeting intro = new IntroductoryMeeting();
		intro.setAllergies(Allergies);
		intro.setConcentrationIssue(concentrationIssue);
		intro.setDislikeFood(DislikeFood);
		intro.setGainedLostWeight(gainedLostWeight);
		intro.setHaveYouBeenToNut(HaveYouBeenToNut);
		intro.setMedication(Medication);
		intro.setSomeoneSentYou(someoneSent);
		intro.setStomackIssue(StomackIssue);
		intro.setTypicalDay(TypicalDay);
		intro.setWhatTarget(WhatTarget);
		intro.setWhyGoToNut(WhyGoToNut);
		intro.setYesterdayEat(YesterdayEat);
		
		cust.setPesronalInterview(intro);
		
		SaveRestore<Customer> saveIntro = new SaveRestore<Customer>(cust, "");
		
		
		
		saveIntro.storeInterviewToPdf(path+"/Customers");
	}

}
