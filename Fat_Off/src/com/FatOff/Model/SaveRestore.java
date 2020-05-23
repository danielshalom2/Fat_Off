package com.FatOff.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class represent any Introduction Meeting which will be created in the
 * Fat_Off project
 * 
 * @author Fat_Off Development Team
 * @version 1.0
 */

public class SaveRestore<T> {

	private T obj;
	private String path;
	private File pathToDir;
	private static String pathToDieticions;
	private ObjectOutputStream writeFile;
	private FileOutputStream pathToObj;
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	public SaveRestore(T obj, String path) {
		this.obj = obj;
		this.path = path;
		pathToDieticions = path + "/Dieticions";
	}

	public void storeToFile() throws IOException {

		if (this.obj.getClass().toString().contains("Nutritionist")) {
			String temp_path = ((Nutritionist) this.obj).getFirstName() + "_" + ((Nutritionist) this.obj).getLastName()
					+ "_" + ((Nutritionist) this.obj).getId();
			pathToDir = new File(pathToDieticions + "/" + temp_path);
			if (!pathToDir.exists()) // folder Nutritionist else create
			{
				pathToDir.mkdir();
			}

			try // insert data to file
			{
				pathToObj = new FileOutputStream(pathToDir + "/" + temp_path + ".txt");
				// pathToObj = new FileOutputStream(pathToDieticions + "/" + temp_path + "/" +
				// temp_path + ".txt");
				writeFile = new ObjectOutputStream(pathToObj);
				writeFile.writeObject(this.obj);
				writeFile.close();
			}

			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.obj.getClass().toString().contains("Measures")) {

		}
		if (this.obj.getClass().toString().contains("Customer")) {

		}
		if (this.obj.getClass().toString().contains("IntroductoryMeeting")) {

		}
		if (this.obj.getClass().toString().contains("Session")) {

		}
		if (this.obj.getClass().toString().contains("Admin")) {

		}

	}

	public static Object restoreFromFile(String Name, String Type) throws IOException {

		if (Type == "Nutritionist") {
			File Dieticion = new File(pathToDieticions + "/" + Name + "/" + Name +".txt");
			if (!Dieticion.exists()) {
				System.out.println("File Not found");
			}
			fis = new FileInputStream(Dieticion);
			ois = new ObjectInputStream(fis);

		}
		try {
			return (Nutritionist) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

//	@SuppressWarnings("unchecked")
//	public  <T> Object RestoreFile(int i) throws IOException, ClassNotFoundException {
//	
//		T importObj;
//		try {
//			fis = new FileInputStream(pathToDieticions +"/"+ "i" +"/"+i +".txt");
//			ois = new ObjectInputStream(fis);
//			importObj = (T)ois.readObject();
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(((Nutritionist) importObj).getLicenseId());
//		return importObj;
//	}
}
