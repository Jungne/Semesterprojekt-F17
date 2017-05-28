package Webshop;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Catalog {

	private static DatabaseInterface databaseInterface = DBManager.getInstance();

	public static Product getProduct(int productId) {
		return databaseInterface.getProduct(productId);
	}

	public static ArrayList<Product> getAllProducts() {
		return databaseInterface.getAllProducts();
	}

	public static ArrayList<Product> findProducts(String query, int categoryID) {
		return databaseInterface.findProducts(query, categoryID);
	}

	public static LinkedHashMap<String, Integer> getCategories() {
		return databaseInterface.getCategories();
	}

}
