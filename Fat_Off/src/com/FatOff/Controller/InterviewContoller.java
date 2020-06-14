package com.FatOff.Controller;

import java.io.FileNotFoundException;

import com.FatOff.Model.Customer;
import com.FatOff.Model.IntroductoryMeeting;
import com.FatOff.Model.SaveRestore;
import com.itextpdf.text.DocumentException;

/**
 * This class is a controller which was created in order to provide the GUI
 * classes a minimal API to the logical IntroductoryMeeting and SaveRestore
 * classes in the view package
 * 
 * @author Fat Off Developers Team
 * @version 1.0
 */
public class InterviewContoller {

	/**
	 * This method is responsible for creating the IntroductoryMeeting object and
	 * inject its initiate the storeToPDF procedure from SaveRestore
	 * 
	 * @param WhyGoToNut         Question_1
	 * @param WhatTarget         Question_2
	 * @param HaveYouBeenToNut   Question_3
	 * @param someoneSent        Question_4
	 * @param StomackIssue       Question_5
	 * @param TypicalDay         Question_6
	 * @param YesterdayEat       Question_7
	 * @param Allergies          Question_8
	 * @param DislikeFood        Question_9
	 * @param Medication         Question_10
	 * @param concentrationIssue Question_11
	 * @param gainedLostWeight   Question_12
	 * @param cust               The Customer that had the interview
	 * @param path               The path in the FileSystem for the customers folder
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public static void createIntroMeeting(String WhyGoToNut, String WhatTarget, String HaveYouBeenToNut,
			String someoneSent, String StomackIssue, String TypicalDay, String YesterdayEat, String Allergies,
			String DislikeFood, String Medication, String concentrationIssue, String gainedLostWeight, Customer cust,
			String path) throws FileNotFoundException, DocumentException {

		// Initialize the IntroductoryMeeting instance
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

		// Initiate the restore to PDF file procedure
		SaveRestore<Customer> saveIntro = new SaveRestore<Customer>(cust, "");
		saveIntro.storeInterviewToPdf(path + "/Customers");
	}

}
