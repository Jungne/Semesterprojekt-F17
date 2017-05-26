package DAM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javafx.scene.image.Image;

public class FileHandler {

    DatabaseInterface databaseInterface;

    public FileHandler() {
        databaseInterface = DBManager.getInstance();
    }

    public DAMImage getDAMImage(int id) {
        HashMap<String, String> damImageMap = databaseInterface.getDAMImage(id);

        String title = damImageMap.get("title");
        int imageID = Integer.parseInt(damImageMap.get("imageID"));
        String categoryName = damImageMap.get("categoryName");
        Image image = databaseInterface.getImage(imageID);
        int productID;
        if (damImageMap.get("productID") == null) {
            productID = -1;
        } else {
            productID = Integer.parseInt(damImageMap.get("productID"));
        }

        return new DAMImage(title, imageID, categoryName, image, productID);
    }

    public ArrayList<DAMImage> getDAMImages() {
        ArrayList<DAMImage> damImageList = new ArrayList<>();
        LinkedList<HashMap<String, String>> damImageMapList = databaseInterface.getDAMImages();

        for (HashMap<String, String> damImageMap : damImageMapList) {
            String title = damImageMap.get("title");
            int imageID = Integer.parseInt(damImageMap.get("imageID"));
            String categoryName = damImageMap.get("categoryName");
            Image image = databaseInterface.getImage(imageID);
            int productID;
            if (damImageMap.get("productID") == null) {
                productID = -1;
            } else {
                productID = Integer.parseInt(damImageMap.get("productID"));
            }
            damImageList.add(new DAMImage(title, imageID, categoryName, image, productID));
        }

        return damImageList;
    }
}
