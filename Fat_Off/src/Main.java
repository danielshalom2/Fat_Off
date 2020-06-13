
import java.io.File;
import com.FatOff.Model.SaveRestore;
import com.FatOff.View.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String path;
		final File pathToFatOff;
		
		pathToFatOff = new File(SaveRestore.getPath());
		if(!pathToFatOff.exists()) {
			new CreateAdminWin();
		}
		else {
			new SignInWin();
		}
	}
}