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
	public ArrayList<Product> getAllEnrichedProducts() {
		return Catalog.getAllEnrichedProducts();
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

		//Saves the customer and the given shoppingBasket in the database
		if (!createCustomer(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, shoppingBasket, true)) {
			return false;
		}

		//Sets the current customer to the newly signed up customer
		this.customer = getCustomer(email);
		return true;
	}

	@Override
	public boolean login(String email, String code) {
		Customer customer = getCustomer(email);

		//Checks if email if exist
		if (customer == null) {
			return false;
		}

		//Checks if code is correct
		if (code.equals(customer.getCode())) {
			return false;
		}

		//Sets the current customer to the now logged in customer
		this.customer = customer;
		return true;
	}

	private boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ShoppingBasket shoppingBasket, boolean includesEmptyBasket) {
		//Creates customer if email is unique
		boolean isCreated = databaseInterface.createCustomer(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, includesEmptyBasket);
		if (!isCreated) {
			return false;
		}

		this.customer = getCustomer(email);

		//Adds the orderLines to the new Basket if there is any
		if (shoppingBasket == null || shoppingBasket.isEmpty()) {
			return true;
		}
		for (OrderLine orderLine : shoppingBasket.getOrderLines()) {
			addProductToBasket(customer.getFirstShoppingBasket().getId(), orderLine.getProduct().getId(), orderLine.getAmount());
		}

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
		LinkedList<HashMap<String, String>> orderLinesMap = databaseInterface.getBasketsOrderLines(basketId);
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
		if (this.customer != null || this.customer.isRegisted()) {
			return this.customer;
		}
		return null;
	}

	@Override
	public ArrayList<ShoppingBasket> getShoppingBaskets() {
		if (this.customer != null || this.customer.isRegisted()) {
			return this.customer.getShoppingBaskets();
		}
		return null;
	}

	@Override
	public void createBasket() {
		if (this.customer != null || this.customer.isRegisted()) {
			//Creates a new empty shoppingBasket
			databaseInterface.createBasket(this.customer.getId());

			//Reloads the customer (preferably a new shoppingBasket should just be created direcly, but I don't know how to get the basketId that is just created)
			this.customer = getCustomer(this.customer.getEmail());
		}
	}

	@Override
	public void removeBasket(int basketId) {
		if (this.customer != null || this.customer.isRegisted()) {
			//Removes the basket from the database
			databaseInterface.remove(basketId);

			//Finds the shoppingBasket that is refered to
			ShoppingBasket shoppingBasket = this.customer.getShoppingBasket(basketId);

			//Removes that shoppingBasket
			this.customer.removeShoppingBasket(shoppingBasket);
		}
	}

	@Override
	public boolean addProductToBasket(int basketId, int productId, int amount) {
		//Adds product to database
		databaseInterface.addProductToBasket(basketId, productId, amount);

		//Finds the shoppingBasket that is refered to
		ShoppingBasket shoppingBasket2 = this.customer.getShoppingBasket(basketId);

		//Adds product to that shoppingBasket
		shoppingBasket2.addProduct(Catalog.getProduct(productId), amount);
		return true;
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
		//Check if any information is null and if there is anything in shoppingBasket
		if (email == null || firstName == null || lastName == null || address == null || postalCode == null || city == null || country == null || shoppingBasket == null || shoppingBasket.isEmpty()) {
			return null;
		}

		//Tries to create the customer
		if (!createCustomer(email, null, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, null, false)) {
			return null;
		}

		//Gets the newly signed up customer
		Customer customer = getCustomer(email);

		//Creates the order
		OrderHistory.createOrder(customer, shoppingBasket);

		//Returns the latest order on that customer, which is the order just created
		return OrderHistory.getLatestOrder(customer);
	}

	@Override
	public boolean checkOut(int basketId) {
		//Gets the shoppingBasket that is refered to by basketId
		ShoppingBasket shoppingBasket = null;
		for (ShoppingBasket s : this.customer.getShoppingBaskets()) {
			if (basketId == s.getId()) {
				shoppingBasket = s;
			}
		}

		//Checks if the basket exist and if there is anything in the basket
		if (shoppingBasket == null || shoppingBasket.isEmpty()) {
			return false;
		}

		//Create order from local customer and shoppingBasket(gained from basketId)
		boolean isCreated = OrderHistory.createOrder(customer, shoppingBasket);
		if (!isCreated) {
			return false;
		}

		//Deletes the shoppingBasket locally
		removeBasket(basketId);
		return true;
	}

}
