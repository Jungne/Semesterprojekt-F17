package DAM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class DAMManager {

	private DatabaseInterface databaseInterface;
        private FileHandler fileHandler;

	public DAMManager() {
		databaseInterface = DBManager.getInstance();
                fileHandler = new FileHandler();
	}

	public void addImage(String imagePath, String title, int category) {
		databaseInterface.createImage(imagePath, title, category);
	}

	public Image getImage(int id) {
		return databaseInterface.getImage(id);
	}

	public ArrayList<Image> getImages() {
		return databaseInterface.getImages();
	}

	public DAMImage getDAMImage(int id) {
		return fileHandler.getDAMImage(id);
	}

	public ArrayList<DAMImage> getDAMImages() {
		return fileHandler.getDAMImages();
	}

	public void deleteImage(int id) {
		databaseInterface.deleteImage(id);
	}
}
