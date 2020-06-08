package com.FatOff.Controller;

import java.io.File;
import java.io.IOException;

import com.FatOff.Model.Customer;
import com.FatOff.Model.SaveRestore;
import com.FatOff.Model.Session;

public class SessionMeasureController {
	
	public static boolean storeSession(Session sess , Customer cust , String pathToNut) throws IOException {
		String custFolderName = cust.getFirstName() + "_" + cust.getLastName() + "_" + cust.getId();
		String pathToSessions = pathToNut + custFolderName + "/Sessions";
		
		SaveRestore<Session> save = new SaveRestore<Session>(sess , "");
		
		return save.storeSessions(pathToSessions, sess);
	}
}
