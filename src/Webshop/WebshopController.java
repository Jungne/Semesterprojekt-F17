package Webshop;

import DBManager.DatabaseInterface;
import java.io.IOException;
import java.util.ArrayList;
import DBManager.DBManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

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
	public ArrayList<Product> findProducts(String query, int categoryId) {
		return Catalog.findProducts(query, categoryId);
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
		//this.customer = databaseInterface.getCustomer(email);
		return true;
	}

	@Override
	public boolean login(String email, String code) {
		Customer customer = getCustomer(email);

		//Checks if email/code combination was valid
		//TODO
		//Sets the current customer to the now logged in customer
		this.customer = customer;
		return true;
	}

	private Customer getCustomer(String email) {
		//Gets the customer as a map and is then converted to Customer
		HashMap<String, String> customerMap = databaseInterface.getCustomer(email);
		if (customerMap == null) {
			return null;
		}
		Customer customer = Converter.toCustomer(customerMap);

		//Gets all basketIds for that customer
		ArrayList<Integer> basketIds = databaseInterface.getBasketIds(customer.getId());
		if (basketIds == null || basketIds.isEmpty()) {
			return customer;
		}

		for (int basketId : basketIds) {
			customer.getShoppingBaskets().add(getShoppingBasket(basketId));
		}

		return customer;
	}

	private ShoppingBasket getShoppingBasket(int basketId) {
		LinkedList<HashMap<String, String>> orderLinesMap = databaseInterface.getOrderLines(basketId);
		ShoppingBasket shoppingBasket = new ShoppingBasket(basketId, new ArrayList<>());

		for (HashMap<String, String> orderLineMap : orderLinesMap) {
			int productId = Integer.parseInt(orderLineMap.get("productId"));
			int amount = Integer.parseInt(orderLineMap.get("amount"));
			shoppingBasket.addProduct(Catalog.getProduct(productId), amount);
		}

		return shoppingBasket;
	}

	@Override
	public Customer getCustomer() {
		if (this.customer.isRegisted()) {
			return this.customer;
		}
		return null;
	}

	@Override
	public ArrayList<ShoppingBasket> getShoppingBaskets() {
		if (this.customer.isRegisted()) {
			return this.customer.getShoppingBaskets();
		}
		return null;
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
	public Order getLatestOrder() {
		return OrderHistory.getLatestOrder(this.customer);
	}

	/**
	 * Checkout for an unregisted customer. The ShoppingBasket is exoected to be
	 * recieved from the GUI. The order that was made doing this checkout is
	 * returned. Null is returned if checkout failed.
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
	 * @param shoppingBasket
	 * @return
	 */
	@Override
	public Order checkOut(String email, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ShoppingBasket shoppingBasket) {
		//Check if any information is null and if there is anything in basket
		if (email == null || firstName == null || lastName == null || address == null || postalCode == null || city == null || country == null || shoppingBasket.isEmpty()) {
			return null;
		}

		//Tries to create the customer
		if (!databaseInterface.createCustomer(new Customer(email, null, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country), null)) {
			return null;
		}

		//Gets the newly signed up customer
		//Customer newCustomer = databaseInterface.getCustomer(email);
		//
		//Creates and saves the order in database and returnes the information about the order
		//if (!OrderHistory.createOrder(newCustomer, customer.getFirstShoppingBasket())) {
		//	return -1;
		//}
		//Still needs to fix getLatestOrder() and createOrder() back in OrderHandler
		//Destroy local customer and initiate new unregisted customer
		//TODO
		//
		//Returns the customerId of the newly signed up customer
		//return databaseInterface.getCustomerId(email);
		return null;
	}

	@Override
	public boolean checkOut(int basketId) {
		//Check if there is anything in the basket
		//Create order from local customer and shoppingBasket(gained from basketId) and then return the orderInfo -> createOrder(customerid, shoppingBasket)
		//Delete that basket locally and in the datebase
		return false;
	}

}
