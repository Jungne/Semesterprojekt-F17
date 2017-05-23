package Webshop;

import DBManager.DatabaseInterface;
import java.util.ArrayList;
import java.util.TreeSet;

public class Catalog {

	private DatabaseInterface databaseInterface;

	public Catalog(DatabaseInterface databaseInterface) {
		this.databaseInterface = databaseInterface;
	}

	public ArrayList<Product> getAllProducts() {
		return databaseInterface.getAllProducts();
	}

	public Product getProduct(int productId) {
		return databaseInterface.getProduct(productId);
	}

	/**
	 * @return a TreeSet<String> of all categories that exist.
	 */
	public TreeSet<String> getCategories() {
		return databaseInterface.getCategories();
	}

	public ArrayList<Product> getCategory(String category) {
		return databaseInterface.getCategory(category);
	}

	public ArrayList<Product> findProducts(String query) {
		return databaseInterface.findProducts(query);
	}
}
