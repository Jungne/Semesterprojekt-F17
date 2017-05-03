package Webshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class WebshopController implements WebshopInterface {

	private Catalog catalog;
	private Customer customer;

	public WebshopController() throws IOException {
		this.catalog = new Catalog();
	}

	@Override
	public List<Product> findProduct(String query) {
		return catalog.searchProduct(query);
	}

	@Override
	public TreeSet<String> getCategories() {
		return catalog.getCategories();
	}

	@Override
	public Product getProduct(int id) {
		return catalog.getProduct(id);
	}

	@Override
	public ArrayList<Product> getProductList() {
		return catalog.getProductList();
	}

	@Override
	public Order checkOut() {
		return customer.checkOut();
	}
}
