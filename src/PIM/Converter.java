/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIM;

import DAM.DAMImage;
import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Converter {
    private static DatabaseInterface databaseInterface = DBManager.getInstance();

    public static ArrayList<PIMage> createPIMages(LinkedList<HashMap<String, String>> damImageMapList) {
	ArrayList<PIMage> PIMImageList = new ArrayList<>();

	for (HashMap<String, String> damImageMap : damImageMapList) {
	    int imageID = Integer.parseInt(damImageMap.get("imageID"));
	    String imageName = damImageMap.get("imageName");
	    String categoryName = damImageMap.get("categoryName");
	    byte[] image = databaseInterface.getImage(imageID);

	    PIMImageList.add(new PIMage(imageID, imageName, categoryName, image));
	}

	return PIMImageList;
    }
}
