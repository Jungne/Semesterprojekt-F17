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

			return customerMap;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public ArrayList<Integer> getBasketIds(int customerId) {
		try {
			ArrayList<Integer> basketIds = new ArrayList<>();

			//Gets basketIds for this customer
			ResultSet basketIdSet = executeQuery("SELECT basketId FROM Baskets WHERE customerId = " + customerId);
			while (basketIdSet.next()) {
				basketIds.add(basketIdSet.getInt(1));
			}

			return basketIds;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public LinkedList<HashMap<String, String>> getBasketsOrderLines(int basketId) {
		try {
			LinkedList<HashMap<String, String>> orderLinesMap = new LinkedList<>();

			//Gets orderLines for this basket
			ResultSet orderLineSet = executeQuery("SELECT productId, amount FROM ProductsInBaskets WHERE basketId = " + basketId);
			while (orderLineSet.next()) {
				HashMap<String, String> orderLineMap = new HashMap<>();
				orderLineMap.put("productId", orderLineSet.getString(1));
				orderLineMap.put("amount", orderLineSet.getString(2));
				orderLinesMap.add(orderLineMap);
			}

			return orderLinesMap;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country) {
		try {
			//Checks if email is unique
			ResultSet existingEmail = executeQuery("SELECT email FROM Customers WHERE email = '" + email + "'");
			if (existingEmail.next()) {
				return false;
			}

			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customers "
							+ "(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country) "
							+ "VALUES ('" + email + "', ?, ?, ?, " + phoneNumber + ", " + mobilePhoneNumber + ", ?, ?, ?, ?)");

			//Checks for all attributes whether they are null are not
			setStringParameter(preparedStatement, 1, code);
			setStringParameter(preparedStatement, 2, firstName);
			setStringParameter(preparedStatement, 3, lastName);
			setStringParameter(preparedStatement, 4, address);
			setStringParameter(preparedStatement, 5, postalCode);
			setStringParameter(preparedStatement, 6, city);
			setStringParameter(preparedStatement, 7, country);

			preparedStatement.executeUpdate();

			//Creates an empty basket
			createBasket(getCustomerId(email));

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

	@Override
	public void createBasket(int customerId) {
		try {
			executeUpdate("INSERT INTO Baskets (customerId) VALUES (" + customerId + ")");
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public boolean addProductToBasket(int basketId, int productId, int amount) {
		try {
			executeUpdate("INSERT INTO ProductsInBaskets (basketId, productId, amount) VALUES (" + basketId + ", " + productId + ", " + amount + ")");
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	@Override
	public HashMap<String, String> getLatestOrder(int customerId) {
		return orderHandler.getLatestOrder(customerId);
	}

	@Override
	public LinkedList<HashMap<String, String>> getOrdersOrderLines(int orderId) {
		return orderHandler.getOrdersOrderLines(orderId);
	}

	@Override
	public boolean createOrder(int customerId, String orderStatus) {
		return orderHandler.createOrder(customerId, orderStatus);
	}

	@Override
	public boolean addProductToOrder(int orderId, int productId, int amount) {
		return orderHandler.addProductToOrder(orderId, productId, amount);
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
