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

    public static PIMProduct createPIMProduct(HashMap<String, String> productMap) {
	int productId = Integer.parseInt(productMap.get("productId"));
	String productName = productMap.get("productName");
	String categoryName = productMap.get("categoryName");
	String description = productMap.get("description");
	double price = Double.parseDouble(productMap.get("price"));
	ArrayList<byte[]> imageFiles = new ArrayList<>();

	return new PIMProduct(productId, productName, categoryName, description, price, imageFiles);
    }
    
    public static ArrayList<PIMProduct> createPIMProducts(LinkedList<HashMap<String, String>> productsMapList) {
	ArrayList<PIMProduct> pimProducts = new ArrayList<>();
	for (HashMap<String, String> productMap : productsMapList) {
	    pimProducts.add(createPIMProduct(productMap));
	}
	return pimProducts;
    }

    public static PIMage createPIMage(HashMap<String, String> pimImageMap) {
	int imageID = Integer.parseInt(pimImageMap.get("imageID"));
	String imageName = pimImageMap.get("imageName");
	String categoryName = pimImageMap.get("categoryName");
	byte[] image = databaseInterface.getImage(imageID);

	return new PIMage(imageID, imageName, categoryName, image);
    }

    public static ArrayList<PIMage> createPIMages(LinkedList<HashMap<String, String>> pimImageMapList) {
	ArrayList<PIMage> PIMImageList = new ArrayList<>();

	for (HashMap<String, String> pimImageMap : pimImageMapList) {
	    int imageID = Integer.parseInt(pimImageMap.get("imageID"));
	    String imageName = pimImageMap.get("imageName");
	    String categoryName = pimImageMap.get("categoryName");
	    byte[] image = databaseInterface.getImage(imageID);

	    PIMImageList.add(new PIMage(imageID, imageName, categoryName, image));
	}

	return PIMImageList;
    }
}
