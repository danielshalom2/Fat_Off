/**
 * 
 */
package com.FatOff.Controller;

import java.io.File;
import java.io.IOException;

import com.FatOff.Model.Admin;
import com.FatOff.Model.SaveRestore;

/**
 * @author borism
 *
 */
public class AdminController {

	/**
	 * 
	 */
	public AdminController() {
	}

	public static boolean createAdmin(String firstName, String lastName, String phoneNumber, String emailAddress,
			String id, int licenseId, String emailAppPass, String password) {
		try {
			Admin adm = new Admin(firstName, lastName, phoneNumber, emailAddress, id, licenseId, emailAppPass,
					password);
			SaveRestore<Admin> saveAdmin = new SaveRestore<Admin>(adm, SaveRestore.getPath() + "/");
			saveAdmin.storeToFile("");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean storeAdmin(Admin adm) {
		try {
			SaveRestore<Admin> saveAdmin = new SaveRestore<Admin>(adm, SaveRestore.getPath()+"/");
			saveAdmin.storeToFile("");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Admin restoreAdmin(String adminName) {
		Admin adm = null;
		try {
			adm = (Admin) SaveRestore.restoreFromFile(adminName, "Admin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adm;
	}

}
