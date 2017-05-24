package Webshop;

import DBManager.DatabaseInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
import DBManager.DBManager;
import java.util.LinkedHashMap;

public class WebshopController implements WebshopInterface {

	private DatabaseInterface databaseInterface;
	private Catalog catalog;
	private OrderHistory orderHistory;
	private Customer customer;

	public WebshopController() throws IOException {
		this.databaseInterface = DBManager.getInstance();
		this.catalog = new Catalog(databaseInterface);
		this.orderHistory = new OrderHistory(databaseInterface);
		this.customer = new Customer();
	}

	/**
	 * Returns the product with the specified id.
	 *
	 * @param productId the id of the product to be returned.
	 * @return the product with the specified id.
	 */
	@Override
	public Product getProduct(int productId) {
		return catalog.getProduct(productId);
	}

	/**
	 * Returns an arraylist containing all products in the catalog.
	 *
	 * @return an arraylist containing all products in the catalog.
	 */
	@Override
	public ArrayList<Product> getAllProduct() {
		return catalog.getAllProducts();
	}

	/**
	 * Returns an ArrayList containing the results of the search with the input
	 * String as query.
	 *
	 * @param query a String to be compared to the names of the products.
	 * @return arraylist containing all products with part of the query in the
	 * name.
	 */
	@Override
	public ArrayList<Product> findProducts(String query) {
		return catalog.findProducts(query);
	}

	/**
	 * Returns a treeSet containing all the product categories as strings.
	 *
	 * @return a treeset containing all the product categories as strings.
	 */
	@Override
	public LinkedHashMap<String, Integer> getCategories() {
		return catalog.getCategories();
	}

	/**
	 * Returns an arraylist containing all products in the specified category.
	 *
	 * @param category the category of which all products wil be returned.
	 * @return an arraylist containing all the products in the specified category.
	 */
	@Override
	public ArrayList<Product> getCategory(String category) {
		return catalog.getProductsInCategory(category);
	}

	/**
	 * Adds a product to the customers shoppingbasket.
	 *
	 * @param productId the id of the product to be added.
	 * @param amount the amount to be added.
	 * @return
	 */
	@Override
	public boolean addProductToBasket(int productId, int amount) {
		return customer.getShoppingBasket().addProduct(getProduct(productId), amount);
	}

	/**
	 * Removes the product with the specified id from the shoppingbasket.
	 *
	 * @param productId the id of the product to be removed.
	 */
	@Override
	public void removeProduct(int productId) {
		customer.getShoppingBasket().removeProduct(getProduct(productId));
	}

	/**
	 * Sets the amount of a product in the basket.
	 *
	 * @param productId the id of the product to be set.
	 * @param amount the amount to be set.
	 * @return
	 */
	@Override
	public boolean setProductAmount(int productId, int amount) {
		return customer.getShoppingBasket().setProductAmount(getProduct(productId), amount);
	}

	/**
	 * Returns the customers shoppingbasket.
	 *
	 * @return the shoppingbasket of the customer.
	 */
	@Override
	public ShoppingBasket getShoppingBasket() {
		return customer.getShoppingBasket();
	}

	/**
	 * Returns an order created from the shoppingbasket of the customer.
	 *
	 * @return an order with the products in the customers shoppingbasket.
	 */
	@Override
	public Order checkOut() {
		Order order = customer.checkOut();
		orderHistory.saveOrder(customer, order);
		return order;
	}

	@Override
	public Order checkOut(String name, String email, int phoneNumber, ShoppingBasket shoppingBasket) {
		customer = new Customer(name, email, phoneNumber, shoppingBasket);
		// TODO - Save customer
		return checkOut();
	}

	@Override
	public void emptyShoppingBasket() {
		customer.getShoppingBasket().empty();
	}

	@Override
	public boolean signUp(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country) {
		//Checks if all parameters are valid
		if (email == null || code == null || firstName == null || lastName == null || address == null || city == null || country == null) {
			return false;
		}

		//Saves the customer in the database
		if (!databaseInterface.createCustomer(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country)) {
			return false;
		}

		//Sets the current customer to the newly signed up customer
		//this.customer = databaseInterface.getCustomer(email, code);
		return true;
	}

	@Override
	public boolean login(String email, String code) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
