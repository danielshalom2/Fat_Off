package com.FatOff.Model;
import java.io.Serializable;
import java.time.LocalDateTime;


@SuppressWarnings("serial")
public class Session implements Serializable,Comparable<Session>{
	
	private LocalDateTime sessionDate;
	private int sessionNum;
	private Measures measures;
	private String sessionSummary;
	private String breakfast;
	private String snack1;
	private String lunch;
	private String snack2;
	private String dinner;
	
	public Session(int sessionNum) {
		sessionDate = LocalDateTime.now();
		setSessionNum(sessionNum);	
	}
	
	
	
	public void SendEmail()// need to write.
	{
		//MailSender mail = new MailSender();
	}
	
	
	
	/**
	 * @return the sessionDate
	 */
	public LocalDateTime getSessionDate() {
		return sessionDate;
	}
	/**
	 * @param string the sessionDate to set
	 */
	public void setSessionDate(LocalDateTime date) {
		sessionDate = date;
	}

	/**
	 * @return the sessionNum
	 */
	public int getSessionNum() {
		return sessionNum;
	}

	/**
	 * @param sessionNum the sessionNum to set
	 */
	public void setSessionNum(int sessionNum) {
		this.sessionNum = sessionNum;
	}

	/**
	 * @return the measures
	 */
	public Measures getMeasures() {
		return measures;
	}

	/**
	 * @param measures the measures to set
	 */
	public void setMeasures(Measures measures) {
		this.measures = measures;
	}

	/**
	 * @return the sessionSummary
	 */
	public String getSessionSummary() {
		return sessionSummary;
	}

	/**
	 * @param sessionSummary the sessionSummary to set
	 */
	public void setSessionSummary(String sessionSummary) {
		this.sessionSummary = sessionSummary;
	}

	/**
	 * @return the breakfast
	 */
	public String getBreakfast() {
		return breakfast;
	}

	/**
	 * @param breakfast the breakfast to set
	 */
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}



	/**
	 * @return the snack1
	 */
	public String getSnack1() {
		return snack1;
	}



	/**
	 * @param snack1 the snack1 to set
	 */
	public void setSnack1(String snack1) {
		this.snack1 = snack1;
	}



	/**
	 * @return the lunch
	 */
	public String getLunch() {
		return lunch;
	}



	/**
	 * @param lunch the lunch to set
	 */
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}



	/**
	 * @return the snack2
	 */
	public String getSnack2() {
		return snack2;
	}



	/**
	 * @param snack2 the snack2 to set
	 */
	public void setSnack2(String snack2) {
		this.snack2 = snack2;
	}



	/**
	 * @return the dinner
	 */
	public String getDinner() {
		return dinner;
	}



	/**
	 * @param dinner the dinner to set
	 */
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}



	@Override
	public int compareTo(Session sess) {
		// TODO Auto-generated method stub
		return this.sessionNum-sess.sessionNum;
	}


}
