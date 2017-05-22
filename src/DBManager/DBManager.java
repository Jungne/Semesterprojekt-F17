package DBManager;

import Webshop.DatabaseInterface;
import Webshop.Order;
import Webshop.Product;
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

/**
 *
 * @author jungn
 */
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

	@Override
	public Product getProduct(int productId) {
		Product product = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT product.name, product.id, category.name, description, price\n"
							+ "FROM product, category\n"
							+ "WHERE category.id = categoryid AND product.id = " + productId);
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
			PreparedStatement ps = connection.prepareStatement("SELECT product.name, product.id, category.name, description, price\n"
							+ "FROM product, category\n"
							+ "WHERE category.id = categoryid");
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
			PreparedStatement ps = connection.prepareStatement("SELECT product.name, product.id, category.name, description, price\n"
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
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Products WHERE LOWER(category) = '" + category.toLowerCase() + "'");
			ResultSet components = ps.executeQuery();
			products = productHandler.getProducts(components);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("error");
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return products;
	}

	@Override
	public boolean saveOrder(Order order) {
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
	private void setUpTables() {
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
	private void dropTables() {
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
	private void insertData() {
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
	public void addImage(String imagePath, String title, int category) {
		ImageHandler.addImage(connection, imagePath, title, category);
	}

	/**
	 * get images from databse
	 *
	 * @return ResultSet
	 */
	public ResultSet getImages() {
		return ImageHandler.getImages(connection);
	}

	@Override
	public Image getImage() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
