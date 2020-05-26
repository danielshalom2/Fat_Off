package com.FatOff.Controller;

import java.io.IOException;

import com.FatOff.Model.Admin;
import com.FatOff.Model.Nutritionist;
import com.FatOff.Model.SaveRestore;

public class NutritionistController {
	
	
	public static Nutritionist restoreNut(String NutName) {
		Nutritionist nut = null;
		try {
			nut = (Nutritionist)SaveRestore.restoreFromFile(NutName, "Nutritionist", SaveRestore.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nut;
	}


}
