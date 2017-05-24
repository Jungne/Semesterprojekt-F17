package DBManager;

import DAM.DAMImage;
import Webshop.Customer2;
import Webshop.Order;
import Webshop.Product;
import Webshop.ShoppingBasket;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;
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
	public Product getProduct(int productId) {
		Product product = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM products, categories\n"
							+ "WHERE categories.id = categoryid AND products.id = " + productId);
			ResultSet components = ps.executeQuery();
			product = productHandler.getProduct(components);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return product;
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM products, categories\n"
							+ "WHERE categories.id = categoryid");
			ResultSet components = ps.executeQuery();
			products = productHandler.getProducts(components);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return products;
	}

	@Override
	public ArrayList<Product> findProducts(String query) {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM Products\n"
							+ "WHERE LOWER(name) LIKE '%" + query.toLowerCase() + "%'");
			ResultSet components = ps.executeQuery();
			products = productHandler.getProducts(components);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return products;
	}

	@Override
	public TreeSet<String> getCategories() {
		TreeSet<String> categories = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT name FROM Categories");
			ResultSet components = ps.executeQuery();
			categories = productHandler.getCategories(components);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error");
		}
		return categories;
	}

	@Override
	public ArrayList<Product> getCategory(String category) {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM Products, categories\n"
							+ "WHERE categories.name = '" + category + "' AND products.categoryid = categories.id");
			ResultSet components = ps.executeQuery();
			products = productHandler.getProducts(components);
			System.out.println(category);
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("error");
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return products;
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
	public boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country) {
		try {
			//Checks if email is unique
			ResultSet existingEmail = executeQuery("SELECT email FROM Customers WHERE email = '" + email + "';");
			if (existingEmail.next()) {
				return false;
			}

			//Gets the next available id in Customers
			ResultSet maxCustomerId = executeQuery("SELECT max(id) FROM Customers;");
			maxCustomerId.next();
			int customerId = 1 + maxCustomerId.getInt(1);

			//Insert the new customer to the database
			String sql = "INSERT INTO Customers VALUES "
							+ "(" + customerId + ", '" + email + "', '" + code + "', "
							+ "'" + firstName + "', '" + lastName + "', " + phoneNumber + ", " + mobilePhoneNumber + ", "
							+ "'" + address + "', '" + postalCode + "', '" + city + "', '" + country + "');";
			executeUpdate(sql);
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	@Override
	public Customer2 getCustomer(String email, String code) {
		try {
			ResultSet customer = executeQuery("SELECT * FROM Customers WHERE email = '" + email + "' AND code = '" + code + "';");
			if (!customer.next()) {
				return null;
			}

			ShoppingBasket shoppingBasket = null;
			//Something where OrderLines are made from the ProductsInBaskets table from the first basket the customer have in Baskets

			return new Customer2(customer.getInt("id"), customer.getString("email"),
							customer.getString("code"), customer.getString("firstName"),
							customer.getString("lastName"), customer.getInt("phoneNumber"),
							customer.getInt("mobilePhoneNumber"), customer.getString("address"),
							customer.getString("postalCode"), customer.getString("city"),
							customer.getString("country"), shoppingBasket);
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

}
