package com.FatOff.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This class represent any Introduction Meeting which will be created in the Fat_Off project
 * 
 * @author Fat_Off Development Team
 *@version 1.0
 */

public class SaveRestore <T> {
	
	private T obj;
	private String path ;
	private File pathToDir;
	final private String pathToDieticions;
	private ObjectOutputStream writeFile;
	private FileOutputStream pathToObj;
	public SaveRestore (T obj ,String path) {
		this.obj=obj;
		this.path=path;
		pathToDieticions=path + "/Dieticions";
	}


	
	public void SaveObject() {//need to write
		
	}
	
	public boolean storeToFile() throws IOException  {
		
		if(this.obj.getClass().toString().contains("Nutritionist")) {
			pathToDir= new File (pathToDieticions+ "/" + ((Nutritionist) this.obj).getId());
			System.out.println(path.toString());
			System.out.println(pathToDieticions.toString());
			System.out.println(pathToDir.toString());
			System.out.println(pathToDir.exists());
			if(!pathToDir.exists()) //folder Nutritionist else create
			{
				pathToDir.mkdir();
			}
			
			try //insert data to file
			{ 
				pathToObj = new FileOutputStream (pathToDieticions +"/"+ ((Nutritionist) this.obj).getId() +"/"+((Nutritionist) this.obj).getId() +".txt");
				writeFile =new ObjectOutputStream (pathToObj);
				writeFile.writeObject(this.obj);
				writeFile.close();
			} 
			
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(this.obj.getClass().toString().contains("Measures")) {
			
		}
		if(this.obj.getClass().toString().contains("Customer")) {
			
		}
		if(this.obj.getClass().toString().contains("IntroductoryMeeting")) {
			
		}
		if(this.obj.getClass().toString().contains("Session")) {
			
		}
		if(this.obj.getClass().toString().contains("Admin")) {
			
		}
		
	
		return false;
	}
	
}
