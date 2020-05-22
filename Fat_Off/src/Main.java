import com.FatOff.View.*;

import java.io.File;
import java.nio.file.Path;

import com.FatOff.Controller.*;
import com.FatOff.Model.*;

//
public class Main {

		// TODO Auto-generated constructor stub
	public static void main(String[] args) {
		
		System.getProperties().list(System.out);
		String path;
		final File pathToFatOff;
		final String os = System.getProperty("os.name");

		
		if(!os.toLowerCase().startsWith("windows")) {
			path = System.getProperty("user.home") + "/Documents/.fat_off";
			pathToFatOff = new File(path);
			boolean test = pathToFatOff.mkdir();
			System.out.println(test);
			
		}
		else {
			System.out.println("Failed");
		}
		

	}

}
