package DBManager;

import Webshop.Product;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductHandler {

	private Connection connection;
	private ImageHandler imageHandler;

	public ProductHandler(Connection connection) {
		this.connection = connection;
		this.imageHandler = new ImageHandler(connection);
	}

	private void executeUpdate(String query) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(query);
		}
	}

	private ResultSet executeQuery(String query) throws SQLException {
		return connection.createStatement().executeQuery(query);
	}

	public Product getProduct(int productID) {
		try {
			ResultSet productSet = executeQuery("SELECT productId, productName, "
							+ "categoryName, description, price FROM Products NATURAL JOIN "
							+ "Categories WHERE productId = " + productID + ";");

			ArrayList<InputStream> imageFiles = imageHandler.getImageFiles(productID);

			return new Product(productSet.getInt(1), productSet.getString(2), productSet.getString(3), productSet.getString(4), productSet.getDouble(5), imageFiles);
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public ArrayList<Product> getAllProducts() {
		try {
			ResultSet productSet = executeQuery("SELECT productId, productName, categoryName, description, price FROM Products NATURAL JOIN Categories");

			ArrayList<Product> products = new ArrayList<>();
			while (productSet.next()) {
				ArrayList<InputStream> imageFiles = imageHandler.getImageFiles(productSet.getInt(1));
				products.add(new Product(productSet.getInt(1), productSet.getString(2), productSet.getString(3), productSet.getString(4), productSet.getDouble(5), imageFiles));
			}

			return products;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public ArrayList<Product> findProducts(String query, int categoryID) {
		try {
			ResultSet productSet;
			if (categoryID == -1) {
				productSet = executeQuery("SELECT productId, productName, categoryName, description, price FROM Products NATURAL JOIN Categories "
								+ "WHERE LOWER(productName) LIKE '%" + query.toLowerCase() + "%' AND categoryId = " + categoryID);
			} else {
				productSet = executeQuery("SELECT productId, productName, categoryName, description, price FROM Products NATURAL JOIN Categories "
								+ "WHERE LOWER(productName) LIKE '%" + query.toLowerCase() + "%'");
			}

			ArrayList<Product> products = new ArrayList<>();
			while (productSet.next()) {
				ArrayList<InputStream> imageFiles = imageHandler.getImageFiles(productSet.getInt(1));
				products.add(new Product(productSet.getInt(1), productSet.getString(2), productSet.getString(3), productSet.getString(4), productSet.getDouble(5), imageFiles));
			}

			return products;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public LinkedHashMap<String, Integer> getCategories() {
		try {
			LinkedHashMap<String, Integer> categories = new LinkedHashMap<>();
			ResultSet categorySet = executeQuery("SELECT categoryId, categoryName FROM categories");

			while (categorySet.next()) {
				categories.put(categorySet.getString(2), categorySet.getInt(1));
			}

			return categories;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error");
			return null;
		}
	}

	public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
		try {
			//Creates new category if not exists
			ResultSet categoryNameSet = executeQuery("SELECT categoryName FROM Categories WHERE categoryName = '" + category + "'");
			if (!categoryNameSet.next()) {
				executeUpdate("INSERT INTO Categories (categoryName) VALUES ('" + category + "')");
			}

			//Gets the categoryId
			ResultSet categoryIdSet = executeQuery("SELECT categoryId FROM Categories WHERE categoryName = '" + category + "'");
			categoryIdSet.next();
			int categoryId = categoryIdSet.getInt(1);

			//Inserts the product
			executeUpdate("INSERT INTO Products (productName, categoryId, description, price) VALUES ('" + name + "', " + categoryId + ", '" + description + "', " + price + ")");

			//Gets the productId
			ResultSet productIdSet = executeQuery("SELECT productId FROM Products WHERE productName = '" + name + "'");
			productIdSet.next();
			int productId = productIdSet.getInt(1);

			//Update Images to references to this product
			for (int imageId : imageIdList) {
				executeUpdate("UPDATE Images SET productId = " + productId + " WHERE imageId = " + imageId);
			}

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

}
