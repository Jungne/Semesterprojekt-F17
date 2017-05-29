package PIM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.InputStream;
import java.util.ArrayList;

public class ProductSearch {

    private static DatabaseInterface databaseInterface = DBManager.getInstance();

    public static ArrayList<PIMProduct> getAllProducts() {
	databaseInterface = DBManager.getInstance();
	ArrayList<PIMProduct> productList = new ArrayList<PIMProduct>();
	LinkedList<HashMap<String, String>> productsMapList = databaseInterface.getAllProducts();

	for (HashMap<String, String> productMap : productsMapList) {
	    int productID = Integer.parseInt(productMap.get("productID"));
	    String productName = productMap.get("productName");
	    String categoryName = productMap.get("categoryName");
	    String description = productMap.get("description");
	    double price = Double.parseDouble(productMap.get("price"));
	    ArrayList<InputStream> images = databaseInterface.getImages(productID);
	    productList.add(new PIMProduct(productID, productName, categoryName, description, price, images));
	}
	return productList;
    }

}
