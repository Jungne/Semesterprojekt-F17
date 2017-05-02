package Webshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class WebshopController implements WebshopInterface{

	private Catalog catalog;
	private Customer customer;

	public WebshopController() throws IOException {
		this.catalog = new Catalog();
	}

	public List<Product> findProduct(String query) {
		return catalog.searchProduct(query);
	}

	public TreeSet<String> getCategories() {
		return catalog.getCategories();
	}

	public Product getProduct(int id) {
		return catalog.getProduct(id);
	}

	public ArrayList<Product> getProductList() {
		return catalog.getProductList();
	}
}
