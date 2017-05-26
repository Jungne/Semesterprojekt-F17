package DBManager;

import DAM.DAMImage;
import PIM.PIMProduct;
import Webshop.Customer2;
import Webshop.Order;
import Webshop.OrderLine;
import Webshop.Product;
import Webshop.ShoppingBasket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class DBManager implements DatabaseInterface {

	private Connection connection;
	private ProductHandler productHandler;
	private static DBManager dbManager = null;

	private DBManager() {
		productHandler = new ProductHandler();

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
	public ResultSet getProduct(int productID) {
		return productHandler.getProduct(connection, productID);
	}

	@Override
	public ResultSet getAllProducts() {
		return productHandler.getAllProducts(connection);
	}

	@Override
	public ResultSet findProducts(String query) {
		return productHandler.findProducts(connection, query);
	}

	@Override
	public ResultSet findProducts(String query, int categoryID) {
		return productHandler.findProducts(connection, query, categoryID);
	}

	@Override
	public LinkedHashMap<String, Integer> getCategories() {
		return productHandler.getCategories(connection);
	}

	@Override
	public ResultSet getProductsInCategory(String category) {
		return productHandler.getProductsInCategory(connection, category);

	}

	@Override
	public void addProduct(int category, double price, String description, String name, ArrayList<Integer> imageList) {
		productHandler.addProduct(connection, category, price, description, name, imageList);
	}

	@Override
	public boolean createOrder(Order order) {
		try {
			PreparedStatement ps = connection.prepareStatement(
							"INSERT INTO orders\n"
							+ "VALUES (?,?, CURRENT_TIMESTAMP,?)");
			ps.setInt(1, order.getId());
			ps.setInt(2, order.getCustomer().getId());
			ps.setString(3, order.getOrderStatus().name());
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return true;
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

	/**
	 * Add image to database
	 *
	 * @param imagePath
	 * @param title
	 * @param category
	 */
	@Override
	public void createImage(String imagePath, String title, int category) {
		ImageHandler.createImage(connection, imagePath, title, category);
	}

	@Override
	public Image getImage(int id) {
		return ImageHandler.getImage(connection, id);
	}

	/**
	 * get images from databse
	 *
	 * @return ResultSet
	 */
	@Override
	public ArrayList<Image> getImages() {
		return ImageHandler.getImages(connection);
	}

	@Override
	public ArrayList<Image> getImages(int productID) {
		return ImageHandler.getImages(connection, productID);
	}

	@Override
	public DAMImage getDAMImage(int id) {
		return ImageHandler.getDAMImage(connection, id);
	}

	@Override
	public ArrayList<DAMImage> getDAMImages() {
		return ImageHandler.getDAMImages(connection);
	}

	@Override
	public void deleteImage(int id) {
		ImageHandler.deleteImage(connection, id);
	}

	@Override
	public boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ShoppingBasket shoppingBasket) {
		try {
			//Checks if email is unique
			ResultSet existingEmail = executeQuery("SELECT email FROM Customers WHERE email = '" + email + "';");
			if (existingEmail.next()) {
				return false;
			}

			//Gets the next available id in Customers
			ResultSet maxCustomerId = executeQuery("SELECT max(customerId) FROM Customers;");
			maxCustomerId.next();
			int customerId = 1 + maxCustomerId.getInt(1);

			//Insert the new customer to the database
			String sql = "INSERT INTO Customers (customerId, email, code, firstName, "
							+ "lastName, phoneNumber, mobilePhoneNumber, address, postalCode, "
							+ "city, country) VALUES (" + customerId + ", '" + email + "', '"
							+ code + "', '" + firstName + "', '" + lastName + "', "
							+ phoneNumber + ", " + mobilePhoneNumber + ", '" + address + "', '"
							+ postalCode + "', '" + city + "', '" + country + "');";
			executeUpdate(sql);

			//Gets the next available id in Baskets
			ResultSet maxBasketId = executeQuery("SELECT max(basketId) FROM Baskets;");
			maxBasketId.next();
			int basketId = 1 + maxBasketId.getInt(1);

			//Insert the new basket to the database
			sql = "INSERT INTO Baskets (basketId, customerId) VALUES (" + basketId + ", " + customerId + ")";
			executeUpdate(sql);

			//Insert the products from the basket into to the database, if there is a basket
			if (shoppingBasket == null) {
				return true;
			}
			for (OrderLine orderLine : shoppingBasket.getBasketContent()) {
				sql = "INSERT INTO ProductsInBaskets (basketId, productId, amount) VALUES ("
								+ basketId + ", " + orderLine.getProduct().getId() + ", " + orderLine.getAmount() + ");";
				executeUpdate(sql);
			}

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	@Override
	public Customer2 getCustomer(String email, String code) {
		try {
			//Gets customer and stores the attributes for later
			ResultSet customer = executeQuery("SELECT * FROM Customers WHERE email = '" + email + "' AND code = '" + code + "';");
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

			//Gets all basketId's belonging to the customer
			ArrayList<Integer> basketIdList = new ArrayList<>();
			ResultSet basketIdSet = executeQuery("SELECT basketId FROM Baskets WHERE customerId = " + customerId + ";");
			while (basketIdSet.next()) {
				basketIdList.add(basketIdSet.getInt(1));
			}

			ArrayList<ShoppingBasket> shoppingBaskets = new ArrayList<>();
			for (int basketId : basketIdList) {
				shoppingBaskets.add(getShoppingBasket(basketId));
			}

			return new Customer2(customerId, email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, shoppingBaskets);
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	private ShoppingBasket getShoppingBasket(int basketId) {
		try {
			ShoppingBasket shoppingBasket = new ShoppingBasket();
			ResultSet orderLineSet = executeQuery("SELECT productId, amount FROM ProductsInBaskets WHERE basketId = " + basketId + ";");
			int productId, amount;
			while (orderLineSet.next()) {
				productId = orderLineSet.getInt(1);
				amount = orderLineSet.getInt(2);
				//OrderLine orderLine = new OrderLine(getProduct(productId), amount);
			}

			return shoppingBasket;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

}
