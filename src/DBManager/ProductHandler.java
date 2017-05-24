package DBManager;

import Webshop.Product;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductHandler {

	public Product getProduct(Connection connection, int productID) {
		Product product = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM products, categories\n"
							+ "WHERE categories.id = categoryid AND products.id = " + productID);
			ResultSet productResultSet = ps.executeQuery();
			product = mapProduct(productResultSet);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return product;
	}

	public ArrayList<Product> getProducts(Connection connection) {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM products, categories\n"
							+ "WHERE categories.id = categoryid");
			ResultSet productResultSet = ps.executeQuery();
			products = mapProducts(productResultSet);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return products;
	}
	
	public ArrayList<Product> findProducts(Connection connection, String query) {
	    ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
							+ "FROM Products\n"
							+ "WHERE LOWER(name) LIKE '%" + query.toLowerCase() + "%'");
			ResultSet productsResultSet = ps.executeQuery();
			products = mapProducts(productsResultSet);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return products;
	}

	public TreeSet<String> getCategories(Connection connection) {
	    TreeSet<String> categories = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT name FROM Categories");
			ResultSet components = ps.executeQuery();
			while (components.next()) {
			categories.add(components.getString(1));
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
