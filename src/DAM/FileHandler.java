package DAM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FileHandler {

    private static DatabaseInterface databaseInterface = DBManager.getInstance();

    public static ArrayList<DAMImage> createDAMImages(LinkedList<HashMap<String, String>> damImageMapList) {
	ArrayList<DAMImage> damImageList = new ArrayList<>();

	for (HashMap<String, String> damImageMap : damImageMapList) {
	    int imageID = Integer.parseInt(damImageMap.get("imageID"));
	    String imageName = damImageMap.get("imageName");
	    String categoryName = damImageMap.get("categoryName");
	    byte[] image = databaseInterface.getImage(imageID);

	    damImageList.add(new DAMImage(imageID, imageName, categoryName, image));
	}

	return damImageList;
    }

}
