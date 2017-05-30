package Webshop;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Catalog {

	private static DatabaseInterface databaseInterface = DBManager.getInstance();

	public static Product getProduct(int productId) {
		return getProductIncludingImageFiles(databaseInterface.getProduct(productId));
	}

	public static ArrayList<Product> getAllProducts() {
		ArrayList<Product> products = new ArrayList<>();

		for (HashMap<String, String> productMap : databaseInterface.getAllProducts()) {
			//Adds the product to the list of products
			products.add(getProductIncludingImageFiles(productMap));
		}

		return products;
	}

	public static LinkedHashMap<String, Integer> getCategories() {
		return databaseInterface.getCategories();
	}

	public static ArrayList<Product> findProducts(String query, int categoryId) {
		ArrayList<Product> products = new ArrayList<>();

		for (HashMap<String, String> productMap : databaseInterface.findProducts(query, categoryId)) {
			//Adds the product to the list of products
			products.add(getProductIncludingImageFiles(productMap));
		}

		return products;
	}

	private static Product getProductIncludingImageFiles(HashMap<String, String> productMap) {
		Product product = Converter.toProduct(productMap);

		//Should now add imageFiles
		ArrayList<byte[]> imageFiles = databaseInterface.getImages(product.getId());
		for (byte[] imageFile : imageFiles) {
			product.addImageFile(imageFile);
		}

		return product;
	}

}
