package com.FatOff.Model;

import java.io.Serializable;

/**
 * This class represents the measures that will be taken from a customer in each his session with a nutritionist.
 * 
 * @author Fat Off Development Team
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class Measures implements Serializable {
	private float weight;
	private float height;
	private float wrist;
	private float waist;
	private float thigh;
	private float bmi;
	private float eer;
	private String activity;
	private String physique;

	/**
	 * Constructor -- Initializes a session instance.
	 * 
	 * @param age    The age of the customer
	 * @param weight The weight of the customer
	 * @param height The height of the customer
	 * @param wrist  The wrist of the customer
	 * @param waist  The waist of the customer
	 * @param thigh  The thigh of the customer
	 */
	public Measures(int age, float weight, float height, float wrist, float waist, float thigh, String gender, String activity) {
		this.setWeight(weight);
		this.setHeight(height);
		this.setWrist(wrist);
		this.setWaist(waist);
		this.setThigh(thigh);
		this.setActivity(activity);
		calcBMI();
		calcEER(gender, age, calcPA(gender));
		calcPhysic(gender);
	}

	/**
	 * Default Constructor -- Initializes an empty session instance.
	 */
	public Measures() {}

	/**
	 * this function calculate the BMI of the customer
	 * 
	 * @param weight of the customer
	 * @param height of the customer
	 * 
	 */
	public void calcBMI() {

		this.setBmi(this.weight / (this.height * this.height));
	}

	/**
	 * this function calculate the EER measure of the customer
	 * 
	 * @param gender of the customer
	 * @param age    of the customer (years)
	 * @param PA     of the customer
	 * @param height of the customer
	 * @param weight of the customer
	 * 
	 */
	public void calcEER(String gender, int age, float PA) {
		if (gender.equalsIgnoreCase("Male")) {
			this.setEer((float) (662.0 - (9.53 * age) + (PA * (15.91) * this.weight) + (539.6 * this.height)));
		} else {
			this.setEer((float) (354.0 - (6.91 * age) + (PA * (9.36) * this.weight) + (726 * this.height)));
		}
	}

	/**
	 * this function calculate the Physique of the customer
	 * 
	 * @param gender of the customer
	 */
	public void calcPhysic(String gender) {
		float physique = this.height / this.wrist;
		if (gender.equalsIgnoreCase("female")) {
			if (physique > 10.4)
				this.setPhysique("Narrow");

			else if (physique <= 10.4 && physique >= 9.6)
				this.setPhysique("Medium");
			else
				this.setPhysique("Wide");
		} else {
			if (physique > 10.9)
				this.setPhysique("Narrow");
			else if (physique <= 10.9 && physique >= 9.9)
				this.setPhysique("Medium");
			else
				this.setPhysique("Wide");
		}

	}

	public float calcPA(String gender) {
		float Pa = 0;
		if (this.activity.equalsIgnoreCase("sedentary"))
			Pa = 1;
		else if (this.activity.equalsIgnoreCase("low active")) {
			if (gender.equalsIgnoreCase("male")) {
				Pa = (float) 1.11;

			} else
				Pa = (float) 1.12;
		}

		else if (this.activity.equalsIgnoreCase("active")) {
			if (gender.equalsIgnoreCase("male")) {
				Pa = (float) 1.25;

			} else
				Pa = (float) 1.27;
		} else {
			if (gender.equalsIgnoreCase("male")) {
				Pa = (float) 1.48;

			} else
				Pa = (float) 1.45;
		}

		return Pa;
	}

	/**
	 * @return the bmi
	 */
	public float getBmi() {
		return bmi;
	}

	/**
	 * @param bmi the bmi to set
	 */
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}


	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @param height the weight to set
	 */
	public void setHeight(float height) {
		if ((int) height > 3)

			this.height = (float) (height / 100.0);

		else
			this.height = height;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * @return the waist
	 */
	public float getWaist() {
		return waist;
	}

	/**
	 * @param waist the waist to set
	 */
	public void setWaist(float waist) {
		this.waist = waist;
	}

	/**
	 * @return the thigh
	 */
	public float getThigh() {
		return thigh;
	}

	/**
	 * @param thigh the thigh to set
	 */
	public void setThigh(float thigh) {
		this.thigh = thigh;
	}

	/**
	 * @return the eer
	 */
	public float getEer() {
		return eer;
	}

	/**
	 * @param eer the eer to set
	 */
	public void setEer(float eer) {
		this.eer = eer;
	}

	/**
	 * @return the physique
	 */
	public String getPhysique() {
		return physique;
	}

	/**
	 * @param physique the physique to set
	 */
	public void setPhysique(String physique) {
		this.physique = physique;
	}

	/**
	 * @return the wrist
	 */
	public float getWrist() {
		return wrist;
	}

	/**
	 * @param wrist the wrist to set
	 */
	public void setWrist(float wrist) {
		this.wrist = wrist;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
