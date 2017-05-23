package DAM;

import DBManager.DBManager;
import Webshop.DatabaseInterface;
import java.sql.ResultSet;
import javafx.scene.image.Image;

public class DAMManager {

    DatabaseInterface databaseInterface;

    public DAMManager() {
        databaseInterface = DBManager.getInstance();
    }

    public void addImage(String imagePath, String title, int category) {
        databaseInterface.addImage(imagePath, title, category);
    }

    public ResultSet getImage() {
        return databaseInterface.getImages();
    }
}
