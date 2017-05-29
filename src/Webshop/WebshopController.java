package Webshop;

import DBManager.DatabaseInterface;
import java.io.IOException;
import java.util.ArrayList;
import DBManager.DBManager;
import java.util.LinkedHashMap;

public class WebshopController implements WebshopInterface {

	private DatabaseInterface databaseInterface;
	private Customer customer;

	public WebshopController() throws IOException {
		this.databaseInterface = DBManager.getInstance();
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
		if (!databaseInterface.createCustomer(new Customer(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country), shoppingBasket)) {
			return false;
		}

		//Sets the current customer to the newly signed up customer
		this.customer = databaseInterface.getCustomer(email);
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
	public Order getLatestOrder(int customerId) {
		return databaseInterface.getLatestOrder(customerId);
	}

	/**
	 * Checkouts an unregisted customer. When checkout happens a customer is
	 * created. That customers id is returned. -1 is returned if checkout failes.
	 *
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param mobilePhoneNumber
	 * @param address
	 * @param postalCode
	 * @param city
	 * @param country
	 * @return the customerId of the customer that was created when checkout
	 * happened. -1 is returned if checkout failes.
	 */
	@Override
	public int checkOut(String email, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country) {
		//Check if any information is null and if there is anything in basket
		if (email == null || firstName == null || lastName == null || address == null || postalCode == null || city == null || country == null || customer.getFirstShoppingBasket().isEmpty()) {
			return -1;
		}

		//Tries to create the customer
		if (!databaseInterface.createCustomer(new Customer(email, null, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country), null)) {
			return -1;
		}

		//Gets the newly signed up customer
		Customer newCustomer = databaseInterface.getCustomer(email);

		//Creates and saves the order in database and returnes the information about the order
		if (!OrderHistory.createOrder(newCustomer, customer.getFirstShoppingBasket())) {
			return -1;
		}
		//Still needs to fix getLatestOrder() and createOrder() back in OrderHandler

		//Destroy local customer and initiate new unregisted customer
		//TODO
		//
		//Returns the customerId of the newly signed up customer
		return databaseInterface.getCustomerId(email);
	}

	@Override
	public boolean checkOut(int basketId) {
		//Check if there is anything in the basket
		//Create order from local customer and shoppingBasket(gained from basketId) and then return the orderInfo -> createOrder(customerid, shoppingBasket)
		//Delete that basket locally and in the datebase
		return false;
	}

}
