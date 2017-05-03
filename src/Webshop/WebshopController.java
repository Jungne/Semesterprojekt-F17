package Webshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class WebshopController implements WebshopInterface {

	private Catalog catalog;
	private Customer customer;

	public WebshopController() throws IOException {
		this.catalog = new Catalog();
		this.customer = new Customer("Test Testerson", "test@test.com", 12345678);
	}

	@Override
	public ArrayList<Product> findProduct(String query) {
		return catalog.searchProduct(query);
	}

	@Override
	public TreeSet<String> getCategories() {
		return catalog.getCategories();
	}

	@Override
	public ArrayList<Product> getCategory(String category) {
		return catalog.getCategory(category);
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

	@Override
	public void addProductToBasket(int productId, int amount) {
		customer.addProductToBasket(getProduct(productId), amount);
	}

	@Override
	public void removeProduct(int productId) {
		customer.removeProduct(getProduct(productId));
	}

	@Override
	public void setProductAmount(int productId, int amount) {
		customer.setProductAmount(getProduct(productId), amount);
	}

	@Override
	public ShoppingBasket getShoppingBasket() {
		return customer.getShoppingBasket();
	}

}
