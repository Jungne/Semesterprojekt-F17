package Webshop;

import DBManager.DatabaseInterface;
import java.io.IOException;
import java.util.ArrayList;
import DBManager.DBManager;
import java.util.LinkedHashMap;

public class WebshopController implements WebshopInterface {

	private DatabaseInterface databaseInterface;
	private Catalog catalog;
	private OrderHistory orderHistory;
	private Customer customer;

	public WebshopController() throws IOException {
		this.databaseInterface = DBManager.getInstance();
		this.catalog = new Catalog();
		this.orderHistory = new OrderHistory();
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
		return Catalog.getProduct(productId);
	}

	/**
	 * Returns an arraylist containing all products in the catalog.
	 *
	 * @return an arraylist containing all products in the catalog.
	 */
	@Override
	public ArrayList<Product> getAllProduct() {
		return Catalog.getAllProducts();
	}

	@Override
	public ArrayList<Product> findProducts(String query, int categoryID) {
		return Catalog.findProducts(query, categoryID);
	}

	@Override
	public LinkedHashMap<String, Integer> getCategories() {
		return Catalog.getCategories();
	}

	@Override
	public boolean signUp(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ShoppingBasket shoppingBasket) {
		//Checks if all parameters are valid
		if (email == null || code == null || firstName == null || lastName == null || address == null || city == null || country == null) {
			return false;
		}

		//Saves the customer in the database
		if (!databaseInterface.createCustomer(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, shoppingBasket)) {
			return false;
		}

		//Sets the current customer to the newly signed up customer
		this.customer = databaseInterface.getCustomer(email, code);
		return true;
	}

	@Override
	public boolean login(String email, String code) {
		Customer customer = databaseInterface.getCustomer(email, code);

		//Checks if email/code combination was valid
		if (customer == null) {
			return false;
		}

		//Sets the current customer to the now logged in customer
		this.customer = customer;
		return true;
	}

	@Override
	public Customer getCustomer() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ShoppingBasket getShoppingBasket() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean addProductToBasket(int productId, int amount) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean setProductAmount(int productId, int amount) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void removeProduct(int productId) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void emptyShoppingBasket() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ArrayList<ShoppingBasket> getShoppingBaskets() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void createBasket() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void removeBasket(int basketId) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean addProductToBasket(int basketId, int productId, int amount) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean setProductAmount(int basketId, int productId, int amount) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean removeProduct(int basketId, int productId) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void emptyShoppingBasket(int basketId) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Order checkOut(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country) {
		//If code is given
		//
		//Check if all information is valid (also is email unique?)and then check if there is anything in basket
		//Fill and createCustomer and then return customerId (create customer without any baskets)
		//Create order from customerid and basket and then return orderInfo -> createOrder(customerId, shoppingBasket)
		//Destroy local customer and initiate new unregisted customer
		//
		//Check if any information is null and if there is anything in basket
		if (email == null || firstName == null || lastName == null || address == null || postalCode == null || city == null || country == null || customer.getFirstShoppingBasket().isEmpty()) {
			return null;
		}

		//Tries to create the customer
		if (!databaseInterface.createCustomer(email, null, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, null)) {

		}

		return null;
	}

	@Override
	public Order checkOut(int basketId) {
		//Check if there is anything in the basket
		//Create order from local customer and shoppingBasket(gained from basketId) and then return the orderInfo -> createOrder(customerid, shoppingBasket)
		//Delete that basket locally and in the datebase
		return null;
	}

}
