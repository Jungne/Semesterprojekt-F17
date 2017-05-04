package Webshop;

import java.util.ArrayList;
import java.util.TreeSet;

public class Catalog {

	private ArrayList<Product> productList;
	private TreeSet<String> categories;
	private DatabaseInterface databaseInterface;

	public Catalog() {
		this.productList = new ArrayList<>();
		this.categories = new TreeSet<>();
		this.databaseInterface = new FileSearcher();
		setCategories();

		FileSearcher.loadEntireCatalog(this);
	}

	public ArrayList<Product> searchProduct(String query) {
		ArrayList<Product> searchResultList = new ArrayList<>();

		for (Product product : productList) {
			if (product.getName().matches("(.*)" + query.toLowerCase() + "(.*)")) {
				searchResultList.add(product);
			}
		}

		return searchResultList;
		//TODO - This should be done in DatabaseInterface. Load the resultList into productList. Then return productList.
	}

	public TreeSet<String> getCategories() {
		return (TreeSet<String>) categories.clone();
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public Product getProduct(int productId) {
		return databaseInterface.getProduct(productId);
	}

	public ArrayList<Product> getCategory(String category) {
		if (category.equals("None")) {
			return (ArrayList<Product>) getProductList().clone();
		}
		ArrayList<Product> products = new ArrayList<>();
		for (Product product : productList) {
			if (product.getCategory().equals(category)) {
				products.add(product);
			}
		}
		return products;
	}

	/**
	 * Loads all categories into the TreeSet of categories.
	 */
	private void setCategories() {
		categories.addAll(databaseInterface.getCategories());
		categories.add("None");
	}
}
