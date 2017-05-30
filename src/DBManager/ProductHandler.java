package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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

	public HashMap<String, String> getProduct(int productID) {
		try {
			HashMap<String, String> productMap = new HashMap<>();

			ResultSet productResultSet = executeQuery("SELECT productId, productName, "
							+ "categoryName, description, price FROM Products NATURAL JOIN "
							+ "Categories WHERE productId = " + productID + ";");
			productResultSet.next();
			//Maps the resultset to a hashmap
			productMap = mapProduct(productResultSet);

			return productMap;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public LinkedList<HashMap<String, String>> getAllProducts() {
		try {
			LinkedList<HashMap<String, String>> productsMapList = new LinkedList<>();
			ResultSet productsResultSet = executeQuery("SELECT productId, productName, categoryName, description, price FROM Products NATURAL JOIN Categories");

			//Maps the resultset to a HashMap.
			productsMapList = mapProducts(productsResultSet);
			return productsMapList;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public LinkedList<HashMap<String, String>> getAllEnrichedProducts() {
		try {
			LinkedList<HashMap<String, String>> productsMapList = new LinkedList<>();
			ResultSet productsResultSet = executeQuery("SELECT productId, productName, categoryName, description, price FROM Products NATURAL JOIN Categories WHERE NOT description = '' ORDER BY productId");

			//Maps the resultset to a HashMap.
			productsMapList = mapProducts(productsResultSet);
			return productsMapList;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public LinkedList<HashMap<String, String>> findProducts(String query, int categoryID) {
		try {
			LinkedList<HashMap<String, String>> productsMapList = new LinkedList<>();
			ResultSet productsResultSet;
			if (categoryID == -1) {
				productsResultSet = executeQuery("SELECT productId, productName, categoryName, description, price FROM Products NATURAL JOIN Categories "
								+ "WHERE LOWER(productName) LIKE '%" + query.toLowerCase() + "%'");
			} else {
				productsResultSet = executeQuery("SELECT productId, productName, categoryName, description, price FROM Products NATURAL JOIN Categories "
								+ "WHERE LOWER(productName) LIKE '%" + query.toLowerCase() + "%' AND categoryId = " + categoryID);
			}

			//Maps the resultset to a HashMap.
			productsMapList = mapProducts(productsResultSet);

			return productsMapList;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public LinkedHashMap<String, Integer> getCategories() {
		LinkedHashMap<String, Integer> categories = new LinkedHashMap<>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT categoryName, categoryid FROM categories");
			ResultSet components = ps.executeQuery();
			while (components.next()) {
				categories.put(components.getString(1), components.getInt(2));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error");
		}
		return categories;
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

	public boolean editProduct(int productId, String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
		try {
			//Gets the categoryId
			ResultSet categoryIdSet = executeQuery("SELECT categoryId FROM Categories WHERE categoryName = '" + category + "'");
			categoryIdSet.next();
			int categoryId = categoryIdSet.getInt(1);

			//Updates the product
			executeUpdate("UPDATE products "
							+ "SET productName = '" + name + "', categoryId = " + categoryId + ", description = '" + description + "', price = " + price + " "
							+ "WHERE productId = " + productId);

			//Update Images to references to this product
			for (int imageId : imageIdList) {
				executeUpdate("UPDATE Images SET productId = " + productId + " WHERE imageId = " + imageId);
			}

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error saving changes");
			return false;
		}
	}

	/**
	 * productsResultSet.next() must be called before calling this method, to
	 * position the ResultSet correctly for mapping.
	 *
	 * @param productsResultSet
	 * @return a Product mapped to a HashMap
	 */
	public HashMap<String, String> mapProduct(ResultSet productsResultSet) {
		HashMap<String, String> productMap = new HashMap<>();

		try {
			//Maps the resultset to a HashMap.
			productMap.put("productId", productsResultSet.getString(1));
			productMap.put("productName", productsResultSet.getString(2));
			productMap.put("categoryName", productsResultSet.getString(3));
			productMap.put("description", productsResultSet.getString(4));
			productMap.put("price", productsResultSet.getString(5));

		} catch (SQLException ex) {
			Logger.getLogger(ProductHandler.class.getName()).log(Level.SEVERE, null, ex);
		}

		return productMap;
	}

	/**
	 * Repeatedly call the mapProduct method and adds the products to a LinkedList
	 * for easy iteration.
	 *
	 * @param productsResultSet
	 * @return a LinkedList containing products mapped to HashMaps.
	 */
	public LinkedList<HashMap<String, String>> mapProducts(ResultSet productsResultSet) {
		LinkedList<HashMap<String, String>> productsMapList = new LinkedList<>();

		try {
			//Maps the resultset to a HashMap.
			while (productsResultSet.next()) {
				productsMapList.add(mapProduct(productsResultSet));
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProductHandler.class.getName()).log(Level.SEVERE, null, ex);
		}

		return productsMapList;
	}

}
