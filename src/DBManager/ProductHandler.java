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
	    PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price, imagefiles.imagefile\n"
		    + "FROM products, categories, images, imagefiles\n"
		    + "WHERE categories.id = products.categoryid AND products.id = " + productID);
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

    public ResultSet findProducts(Connection connection, String query, int categoryID) {
	ResultSet productsResultSet = null;
	try {
	    PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
		    + "FROM Products, categories\n"
		    + "WHERE LOWER(products.name) LIKE '%" + query.toLowerCase() + "%' AND products.categoryID = categories.id AND products.categoryID = " + categoryID);
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

    public ResultSet getProductsInCategory(Connection connection, String category) {
	ResultSet productsResultSet = null;
	try {
	    PreparedStatement ps = connection.prepareStatement("SELECT products.name, products.id, categories.name, description, price\n"
		    + "FROM Products, categories\n"
		    + "WHERE categories.name = '" + category + "' AND products.categoryid = categories.id");
	    productsResultSet = ps.executeQuery();
	} catch (SQLException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	    System.out.println("error");
	}
	return productsResultSet;
    }

    public void addProduct(Connection connection, int category, double price, String description, String name, ArrayList<Integer> imageList) {
	try {
	    //Getting new id for product 
	    PreparedStatement psId = connection.prepareStatement("SELECT max(id) FROM Products;");

	    ResultSet maxProductId = psId.executeQuery();
	    maxProductId.next();
	    int productId = 1 + maxProductId.getInt(1);

	    //Query inserting products  
	    PreparedStatement ps = connection.prepareStatement("INSERT INTO Products (id, name, categoryId, description, price) VALUES (" + productId + ", " + name + ", " + category + ", " + description + ", " + price + ")");
	    ps.executeUpdate();

	    //Query inserting images
	    PreparedStatement psImages = connection.prepareStatement("UPDATE Images SET productId = '" + productId + "' WHERE id = '?'");

	    for (Integer i : imageList) {
		psImages.setInt(1, i);
		psImages.executeUpdate();
	    }

	} catch (SQLException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

}
