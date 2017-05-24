package DBManager;

import Webshop.Product;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductHandler {

	public ResultSet getProduct(Connection connection, int productID) {
		ResultSet productResultSet = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM products, categories\n"
							+ "WHERE categories.id = categoryid AND products.id = " + productID);
			productResultSet = ps.executeQuery();
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productResultSet;
	}

	public ResultSet getAllProducts(Connection connection) {
	    ResultSet productsResultSet = null;
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM products, categories\n"
							+ "WHERE categories.id = categoryid");
			productsResultSet = ps.executeQuery();

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productsResultSet;
	}
	
	public ResultSet findProducts(Connection connection, String query) {
	    ResultSet productsResultSet = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM Products, categories\n"
							+ "WHERE LOWER(products.name) LIKE '%" + query.toLowerCase() + "%' AND products.categoryID = categories.id");
			productsResultSet = ps.executeQuery();

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productsResultSet;
	}

	public LinkedHashMap<String, Integer> getCategories(Connection connection) {
	    LinkedHashMap<String, Integer> categories = new LinkedHashMap<>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT name, id FROM categories");
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
	
	public ArrayList<Product> getProductsInCategory(Connection connection, String category) {
	    ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM Products, categories\n"
							+ "WHERE categories.name = '" + category + "' AND products.categoryid = categories.id");
			ResultSet productsResultSet = ps.executeQuery();
			products = mapProducts(productsResultSet);
			System.out.println(category);
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("error");
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return products;
	}
	
	private Product mapProduct(ResultSet productResultSet) throws SQLException, IOException {
		productResultSet.next();
		return new Product(productResultSet.getString(1), productResultSet.getInt(2), productResultSet.getString(3), productResultSet.getString(4), productResultSet.getDouble(5));
	}
	
	private ArrayList<Product> mapProducts(ResultSet productsResultSet) throws SQLException, IOException {
		ArrayList<Product> products = new ArrayList<>();
		while (productsResultSet.next()) {
			products.add(new Product(productsResultSet.getString(1), productsResultSet.getInt(2), productsResultSet.getString(3), productsResultSet.getString(4), productsResultSet.getDouble(5)));
		}
		return products;
	}
}
