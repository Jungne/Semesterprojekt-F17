package DBManager;

import Webshop.Customer;
import Webshop.Order;
import Webshop.OrderLine;
import Webshop.ShoppingBasket;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager implements DatabaseInterface {

	private Connection connection;
	private ProductHandler productHandler;
	private ImageHandler imageHandler;
	private OrderHandler orderHandler;
	private static DBManager dbManager = null;

	private DBManager() {
		String url = "jdbc:postgresql://localhost:5432/semesterprojekt";
		String user = "postgres";
		String password = "1234";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}

		connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection to database successful!");
		} catch (SQLException ex) {
			System.out.println("Connection to database failed.");
		}

		productHandler = new ProductHandler(connection);
		imageHandler = new ImageHandler(connection);
		orderHandler = new OrderHandler(connection);

		//Tables are created and data is inserted.
		//dropTables();
		//setUpTables();
		//insertData();
	}

	public static DBManager getInstance() {
		if (dbManager == null) {
			dbManager = new DBManager();
		}
		return dbManager;
	}

	private void execute(String query) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.execute(query);
		}
	}

	private void executeUpdate(String query) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(query);
		}
	}

	private ResultSet executeQuery(String query) throws SQLException {
		return connection.createStatement().executeQuery(query);
	}

	@Override
	public HashMap<String, String> getProduct(int productID) {
		return productHandler.getProduct(productID);
	}

	@Override
	public LinkedList<HashMap<String, String>> getAllProducts() {
		return productHandler.getAllProducts();
	}

	@Override
	public LinkedList<HashMap<String, String>> findProducts(String query, int categoryID) {
		return productHandler.findProducts(query, categoryID);
	}

	@Override
	public LinkedHashMap<String, Integer> getCategories() {
		return productHandler.getCategories();
	}

	@Override
	public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
		return productHandler.createProduct(name, category, description, price, imageIdList);
	}

	@Override
	public Order getLatestOrder(int customerId) {
		return orderHandler.getLatestOrder(customerId);
	}

	@Override
	public boolean createOrder(Order order) {
		return orderHandler.createOrder(order);
	}

	@Override
	public byte[] getImage(int imageID) {
		return imageHandler.getImageFile(imageID);
	}

	@Override
	public ArrayList<byte[]> getImages(int productID) {
		return imageHandler.getImageFiles(productID);
	}

	@Override
	public HashMap<String, String> getDAMImage(int imageId) {
		return imageHandler.getDAMImage(imageId);
	}

	@Override
	public LinkedList<HashMap<String, String>> getAllImages() {
		return imageHandler.getAllImages();
	}

	@Override
	public boolean createImage(String name, String category, InputStream imageFile) {
		return imageHandler.createImage(name, category, imageFile);
	}

	@Override
	public boolean deleteImage(int imageId) {
		return imageHandler.deleteImage(imageId);
	}

	@Override
	public int getCustomerId(String email) {
		try {
			ResultSet customerSet = executeQuery("SELECT customerId FROM Customers WHERE email = '" + email + "'");
			if (!customerSet.next()) {
				return -1;
			}
			return customerSet.getInt(1);
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return -1;
		}
	}

	@Override
	public HashMap<String, String> getCustomer(String email) {
		try {
			HashMap<String, String> customerMap = new HashMap<>();

			//Gets customer and stores the attributes for later
			ResultSet customerSet = executeQuery("SELECT * FROM Customers WHERE email = '" + email + "'");
			if (!customerSet.next()) {
				return null;
			}

			int customerId = customerSet.getInt("customerId");

			//Adds all attributes except basketIds to customerMap
			customerMap.put("customerId", customerId + "");
			customerMap.put("code", customerSet.getString("code"));
			customerMap.put("firstName", customerSet.getString("firstName"));
			customerMap.put("lastName", customerSet.getString("lastName"));
			customerMap.put("phoneNumber", customerSet.getString("phoneNumber"));
			customerMap.put("mobilePhoneNumber", customerSet.getString("mobilePhoneNumber"));
			customerMap.put("address", customerSet.getString("address"));
			customerMap.put("postalCode", customerSet.getString("postalCode"));
			customerMap.put("city", customerSet.getString("city"));
			customerMap.put("country", customerSet.getString("country"));

			//Gets basketIds for this customer
			ResultSet basketIdSet = executeQuery("SELECT basketId FROM Baskets WHERE customerId = " + customerId);

			//Stores all basketIds in a String in the form "1-2-3-4" where each number is an id
			String basketIds = "";
			while (basketIdSet.next()) {
				basketIds += basketIdSet.getString(1) + "-";
			}
			if (!basketIds.equals("")) {
				basketIds = basketIds.substring(0, basketIds.length() - 1);
			}

			//Adds basketIds to customerMap
			customerMap.put("basketIds", basketIds);

			return customerMap;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public Customer getCustomer(String email, String code) {
		try {
			//Gets customer and stores the attributes for later
			ResultSet customerSet = executeQuery("SELECT * FROM Customers WHERE email = '" + email + "' AND code = '" + code + "'");
			if (!customerSet.next()) {
				return null;
			}

			int customerId, phoneNumber, mobilePhoneNumber;
			String firstName, lastName, address, postalCode, city, country;

			customerId = customerSet.getInt("customerId");
			firstName = customerSet.getString("firstName");
			lastName = customerSet.getString("lastName");
			phoneNumber = customerSet.getInt("phoneNumber");
			mobilePhoneNumber = customerSet.getInt("mobilePhoneNumber");
			address = customerSet.getString("address");
			postalCode = customerSet.getString("postalCode");
			city = customerSet.getString("city");
			country = customerSet.getString("country");

			ArrayList<ShoppingBasket> shoppingBaskets = getShoppingBaskets(customerId);

			return new Customer(customerId, email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, shoppingBaskets);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	private ArrayList<ShoppingBasket> getShoppingBaskets(int customerId) {
		try {
			ResultSet basketSet = executeQuery("SELECT basketId FROM Baskets WHERE customerId = " + customerId);

			ArrayList<ShoppingBasket> shoppingBaskets = new ArrayList<>();
			while (basketSet.next()) {
				shoppingBaskets.add(getShoppingBasket(basketSet.getInt(1)));
			}

			return shoppingBaskets;

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	private ShoppingBasket getShoppingBasket(int basketId) {
		try {
			ResultSet orderLineSet = executeQuery("SELECT productId, amount FROM ProductsInBaskets WHERE basketId = " + basketId);

			ArrayList<OrderLine> orderLines = new ArrayList<>();
			while (orderLineSet.next()) {
				int productId = orderLineSet.getInt(1);
				int amount = orderLineSet.getInt(2);
				//TODO
				//orderLines.add(new OrderLine(getProduct(productId), amount));
			}

			return new ShoppingBasket(basketId, orderLines);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public boolean createCustomer(Customer customer, ShoppingBasket shoppingBasket) {
		try {
			//Checks if email is unique
			ResultSet existingEmail = executeQuery("SELECT email FROM Customers WHERE email = '" + customer.getEmail() + "'");
			if (existingEmail.next()) {
				return false;
			}

			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customers "
							+ "(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country) "
							+ "VALUES (email, ?, ?, ?, phoneNumber, mobilePhoneNumber, ?, ?, ?, ?)");

			//Checks for all attributes whether they are null are not
			setStringParameter(preparedStatement, 1, customer.getCode());
			setStringParameter(preparedStatement, 2, customer.getFirstName());
			setStringParameter(preparedStatement, 3, customer.getLastName());
			setStringParameter(preparedStatement, 4, customer.getAddress());
			setStringParameter(preparedStatement, 5, customer.getPostalCode());
			setStringParameter(preparedStatement, 6, customer.getCity());
			setStringParameter(preparedStatement, 7, customer.getCountry());

			preparedStatement.executeUpdate();

			//Gets the customerId
			ResultSet customerSet = executeQuery("SELECT customerId FROM Customers WHERE email = '" + customer.getEmail() + "'");
			customerSet.next();
			int customerId = customerSet.getInt(1);

			//Check if shoppingBasket is null. If null then it means that this is a unregisted customer made via checkOut. Otherwise it's made via SignUp
			if (shoppingBasket == null) {
				return true;
			}

			//Insert the new basket to the database
			executeUpdate("INSERT INTO Baskets (customerId) VALUES (" + customerId + ")");

			//Returns if shoppingBasket is empty
			if (shoppingBasket.isEmpty()) {
				return true;
			}

			//Get the basketId
			ResultSet basketSet = executeQuery("SELECT basketId FROM Baskets WHERE customerId = " + customerId);
			basketSet.next();
			int basketId = basketSet.getInt(1);

			//Insert the products from the shoppingBasket into to the database
			for (OrderLine orderLine : shoppingBasket.getOrderLines()) {
				executeUpdate("INSERT INTO ProductsInBaskets (basketId, productId, amount) VALUES ("
								+ basketId + ", "
								+ orderLine.getProduct().getId() + ", "
								+ orderLine.getAmount() + ")");
			}

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	private void setStringParameter(PreparedStatement preparedStatement, int parameterIndex, String parameter) {
		try {
			if (parameter == null) {
				preparedStatement.setNull(parameterIndex, Types.VARCHAR);
			} else {
				preparedStatement.setString(parameterIndex, parameter);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Sets up all tables in the database if they not already exists.
	 */
	public void setUpTables() {
		try {
			for (String query : Data.createTableQueries) {
				execute(query);
			}
		} catch (SQLException ex) {
			System.out.println("Failed creating tables: " + ex);
		}
	}

	/**
	 * Drops all tables in the database.
	 */
	public void dropTables() {
		try {
			for (String query : Data.dropTableQueries) {
				execute(query);
			}
		} catch (SQLException ex) {
			System.out.println("Failed dropping tables: " + ex);
		}
	}

	/**
	 * Inserts categories and products into the database.
	 */
	public void insertData() {
		try {
			for (String query : Data.insertIntoQueries) {
				executeUpdate(query);
			}
		} catch (SQLException ex) {
			System.out.println("Failed dropping tables: " + ex);
		}
	}
}
