package DAM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javafx.scene.image.Image;

public class FileHandler {

    private static DatabaseInterface databaseInterface = DBManager.getInstance();

    public FileHandler() {
        databaseInterface = DBManager.getInstance();
    }

    public ArrayList<DAMImage> getDAMImages() {
        ArrayList<DAMImage> damImageList = new ArrayList<>();
        LinkedList<HashMap<String, String>> damImageMapList = databaseInterface.getAllImages();

        for (HashMap<String, String> damImageMap : damImageMapList) {
            int imageID = Integer.parseInt(damImageMap.get("imageID"));
            String imageName = damImageMap.get("imageName");
            String categoryName = damImageMap.get("categoryName");
            InputStream image = databaseInterface.getImage(imageID);
            
            damImageList.add(new DAMImage(imageID, imageName, categoryName, image));
        }

        return damImageList;
    }
}
