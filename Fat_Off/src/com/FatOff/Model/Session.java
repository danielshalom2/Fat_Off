package com.FatOff.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * This class represent any Session which will be created in the Fat_Off project
 * 
 * @author Fat_Off Development Team
 *@version 1.0
 */
import java.util.*;


public class Session implements Serializable{
	private String SessionDate;
	private String EditIntrudation;
	
	public Session() {
		LocalDateTime now = LocalDateTime.now();
		setSessionDate(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(now));
	}
	
	public void AddCustomerMeasures()// need to write.
	{
		
	}
	
	public void SendEmail()// need to write.
	{
		
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
	 * @return the editIntrudation
	 */
	public String getEditIntrudation() {
		return EditIntrudation;
	}
	/**
	 * @param editIntrudation the editIntrudation to set
	 */
	public void setEditIntrudation(String editIntrudation) {
		EditIntrudation = editIntrudation;
	}

}
