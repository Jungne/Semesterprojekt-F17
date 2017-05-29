package DAM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAMManager {

	private DatabaseInterface databaseInterface;

	public DAMManager() {
		databaseInterface = DBManager.getInstance();
	}

	public boolean createImage(String name, String category, String imagePath) {
		try {
			InputStream imageFile = new FileInputStream(new File(imagePath));
			return databaseInterface.createImage(name, category, imageFile);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(DAMManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public ArrayList<DAMImage> getDAMImages() {
	    return FileHandler.createDAMImages(databaseInterface.getAllImages());
	}

	public boolean deleteImage(int imageId) {
		return databaseInterface.deleteImage(imageId);
	}
}
