package Webshop;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Catalog {

	private static DatabaseInterface databaseInterface = DBManager.getInstance();

	public static Product getProduct(int productId) {
		Product product = Converter.toProduct(databaseInterface.getProduct(productId));
		//Should now add imageFiles
		ArrayList<InputStream> images = databaseInterface.getImages(productId);
	}

	public static ArrayList<Product> getAllProducts() {
		return mapProducts(databaseInterface.getAllProducts());
	}

	public static LinkedHashMap<String, Integer> getCategories() {
		return databaseInterface.getCategories();
	}

	public static ArrayList<Product> findProducts(String query, int categoryID) {
		return mapProducts(databaseInterface.findProducts(query, categoryID));
	}

	private static Product mapProduct(HashMap<String, String> productMap) {
		String productName = productMap.get("productName");
		int productID = Integer.parseInt(productMap.get("productID"));
		String categoryName = productMap.get("categoryName");
		String description = productMap.get("description");
		double price = Double.parseDouble(productMap.get("price"));
		ArrayList<byte[]> images = databaseInterface.getImages(productID);
		Product product = new Product(productID, productName, categoryName, description, price, images);
		return product;
	}

	private static ArrayList<Product> mapProducts(LinkedList<HashMap<String, String>> productsMapList) {
		ArrayList<Product> products = new ArrayList<>();

		//Iterates through the list to create the products.
		for (HashMap<String, String> productMap : productsMapList) {
			//Adds the product to the list of products
			products.add(mapProduct(productMap));
		}

		return products;
	}

}
