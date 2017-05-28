package DBManager;

import DAM.DAMImage;
import Webshop.Customer;
import Webshop.Order;
import Webshop.OrderLine;
import Webshop.Product;
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
import java.util.LinkedHashMap;
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
	public Product getProduct(int productID) {
		return productHandler.getProduct(productID);
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		return productHandler.getAllProducts();
	}

	@Override
	public ArrayList<Product> findProducts(String query, int categoryID) {
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
	public boolean createOrder(Order order) {
		return orderHandler.createOrder(order);
	}

	@Override
	public DAMImage getImage(int imageId) {
		return imageHandler.getImage(imageId);
	}

	@Override
	public ArrayList<DAMImage> getAllImages() {
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
	public boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ShoppingBasket shoppingBasket) {
		try {
			//Checks if email is unique
			ResultSet existingEmail = executeQuery("SELECT email FROM Customers WHERE email = '" + email + "'");
			if (existingEmail.next()) {
				return false;
			}

			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customers "
							+ "(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country) "
							+ "VALUES (email, ?, ?, ?, phoneNumber, mobilePhoneNumber, ?, ?, ?, ?)");

			//Checks for all attributes whether they are null are not
			setStringParameter(preparedStatement, 1, code);
			setStringParameter(preparedStatement, 2, firstName);
			setStringParameter(preparedStatement, 3, lastName);
			setStringParameter(preparedStatement, 4, address);
			setStringParameter(preparedStatement, 5, postalCode);
			setStringParameter(preparedStatement, 6, city);
			setStringParameter(preparedStatement, 7, country);

			preparedStatement.executeUpdate();

			//Gets the customerId
			ResultSet customerSet = executeQuery("SELECT customerId FROM Customers WHERE email = '" + email + "'");
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

	@Override
	public Customer getCustomer(String email, String code) {
		try {
			//Gets customer and stores the attributes for later
			ResultSet customer = executeQuery("SELECT * FROM Customers WHERE email = '" + email + "' AND code = '" + code + "'");
			if (!customer.next()) {
				return null;
			}

			int customerId, phoneNumber, mobilePhoneNumber;
			String firstName, lastName, address, postalCode, city, country;

			customerId = customer.getInt("customerId");
			firstName = customer.getString("firstName");
			lastName = customer.getString("lastName");
			phoneNumber = customer.getInt("phoneNumber");
			mobilePhoneNumber = customer.getInt("mobilePhoneNumber");
			address = customer.getString("address");
			postalCode = customer.getString("postalCode");
			city = customer.getString("city");
			country = customer.getString("country");

			ArrayList<ShoppingBasket> shoppingBaskets = getShoppingBaskets(customerId);

			return new Customer(customerId, email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, shoppingBaskets);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class
							.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(DBManager.class
							.getName()).log(Level.SEVERE, null, ex);
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
				orderLines.add(new OrderLine(getProduct(productId), amount));
			}

			return new ShoppingBasket(basketId, orderLines);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class
							.getName()).log(Level.SEVERE, null, ex);
			return null;
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
