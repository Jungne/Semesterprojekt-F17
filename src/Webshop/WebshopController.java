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
	
	/**
	 * Returns an ArrayList containing the results of the search with the input String as query.
	 * @param query a String to be compared to the names of the products.
	 * @return arraylist containing all products with part of the query in the name.
	 */
	@Override
	public ArrayList<Product> findProduct(String query) {
		return catalog.searchProduct(query);
	}

	/**
	 * Returns a treeSet containing all the product categories as strings.
	 * @return a treeset containing all the product categories as strings.
	 */
	@Override
	public TreeSet<String> getCategories() {
		return catalog.getCategories();
	}

	/**
	 * Returns an arraylist containing all products in the specified categories.
	 * @param category the category of which all products wil be returned.
	 * @return an arraylist containing all the products in the specified category.
	 */
	@Override
	public ArrayList<Product> getCategory(String category) {
		return catalog.getCategory(category);
	}

	/**
	 * Returns the product with the specified id.
	 * @param id the id of the product to be returned.
	 * @return the product with the specified id.
	 */
	@Override
	public Product getProduct(int id) {
		return catalog.getProduct(id);
	}

	/**
	 * Returns an arraylist containing all products in the catalog.
	 * @return an arraylist containing all products in the catalog.
	 */
	@Override
	public ArrayList<Product> getProductList() {
		return catalog.getProductList();
	}

	/**
	 * Returns an order created from the shoppingbasket of the customer.
	 * @return an order with the products in the customers shoppingbasket.
	 */
	@Override
	public Order checkOut() {
		return customer.checkOut();
	}

	/**
	 * Adds a product to the customers shoppingbasket.
	 * @param productId the id of the product to be added.
	 * @param amount the amount to be added.
	 */
	@Override
	public boolean addProductToBasket(int productId, int amount) {
		return customer.getShoppingBasket().addProduct(getProduct(productId), amount);
	}

	/**
	 * Removes the product with the specified id from the shoppingbasket.
	 * @param productId the id of the product to be removed.
	 */
	@Override
	public void removeProduct(int productId) {
		customer.getShoppingBasket().removeProduct(getProduct(productId));
	}

	/**
	 * Sets the amount of a product in the basket.
	 * @param productId the id of the product to be set.
	 * @param amount the amount to be set.
	 */
	@Override
	public boolean setProductAmount(int productId, int amount) {
		return customer.getShoppingBasket().setProductAmount(getProduct(productId), amount);
	}

	/**
	 * Returns the customers shoppingbasket.
	 * @return the shoppingbasket of the customer.
	 */
	@Override
	public ShoppingBasket getShoppingBasket() {
		return customer.getShoppingBasket();
	}
}
