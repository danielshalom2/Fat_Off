package com.FatOff.Model;
import com.FatOff.MailSender.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Session implements Serializable{
	
	private String SessionDate;
	private int sessionNum;
	
	public Session(int sessionNum) {
		LocalDateTime now = LocalDateTime.now();
		setSessionDate(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(now));
		setSessionNum(sessionNum);
		
	}
	
	public void AddCustomerMeasures(Customer cust , Measures meas)// need to write.
	{
		cust.addMeasures(meas, this.sessionNum);
	}
	
	public void SendEmail()// need to write.
	{
		//MailSender mail = new MailSender();
	}
	
	public void SummarySession()// need to write.
	{
		
	}
	
	/**
	 * @return the sessionDate
	 */
	public String getSessionDate() {
		return SessionDate;
	}
	/**
	 * @param string the sessionDate to set
	 */
	public void setSessionDate(String string) {
		SessionDate = string;
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


}
