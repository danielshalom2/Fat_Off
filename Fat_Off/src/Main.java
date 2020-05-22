import com.FatOff.View.*;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Path;

//import com.FatOff.Controller.*;
import com.FatOff.Model.*;

//
public class Main {

	// TODO Auto-generated constructor stub
	public static void main(String[] args) {
		// SignInWin sign = new SignInWin();
		// System.getProperties().list(System.out);
		String path;
		final File pathToFatOff;
		final File pathToDieticion;
		final File pathToCustomer;
		final String os = System.getProperty("os.name");

		if (!os.toLowerCase().startsWith("windows"))
			path = System.getProperty("user.home") + "/Documents/.fat_off";

		else
			path = System.getProperty("user.home") + "/.fat_off";

		pathToFatOff = new File(path);
		pathToDieticion = new File(path + "/Dieticions");
		pathToCustomer = new File(path + "/Customer");
		if (!pathToFatOff.exists())
		{
			pathToFatOff.mkdir();
			pathToCustomer.mkdir();
			pathToDieticion.mkdir();
		}
	
	}

}
