package Webshop;

import java.util.ArrayList;
import java.util.TreeSet;

public class Catalog {

	private ArrayList<Product> productList = new ArrayList<>();
	private TreeSet<String> categories = new TreeSet<>();

	public ArrayList<Product> searchProduct(String query) {
		ArrayList<Product> searchResultList = new ArrayList<>();

		for (Product product : productList) {
			if (product.getName().matches("(.*)" + query.toLowerCase() + "(.*)")) {
				searchResultList.add(product);
			}
		}

		return searchResultList;
	}

	public TreeSet<String> getCategories() {
		return categories;
	}

	public Product getProduct(int productId) {
		for (Product product : productList) {
			if (product.getId() == productId) {
				return product;
			}
		}
		return null;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public ArrayList<Product> getCategory(String category) {
		ArrayList<Product> products = new ArrayList<>();
		for (Product product : productList) {
			if (product.getCategory().equals(category)) {
				products.add(product);
			}
		}
		return products;
	}
}
