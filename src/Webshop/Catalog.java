package Webshop;

import DBManager.DatabaseInterface;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Catalog {

    private DatabaseInterface databaseInterface;

    public Catalog(DatabaseInterface databaseInterface) {
	this.databaseInterface = databaseInterface;
    }

    public ArrayList<Product> getAllProducts() {
	ArrayList<Product> products = mapProducts(databaseInterface.getAllProducts());
	return products;
    }

    public Product getProduct(int productId) {
	Product product = mapProduct(databaseInterface.getProduct(productId));
	return product;
    }

    /**
     * @return a TreeSet<String> of all categories that exist.
     */
    public LinkedHashMap<String, Integer> getCategories() {
	return databaseInterface.getCategories();
    }

    public ArrayList<Product> getCategory(String category) {
	return databaseInterface.getCategory(category);
    }

    public ArrayList<Product> findProducts(String query) {
	return databaseInterface.findProducts(query);
    }

    private Product mapProduct(ResultSet productResultSet) {
	Product product = null;
	try {
	    productResultSet.next();
	    product = new Product(productResultSet.getString(1), productResultSet.getInt(2), productResultSet.getString(3), productResultSet.getString(4), productResultSet.getDouble(5));
	} catch (SQLException ex) {
	    Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
	}
	return product;
    }

    private ArrayList<Product> mapProducts(ResultSet productsResultSet) {
	ArrayList<Product> products = new ArrayList<>();
	try {
	    while (productsResultSet.next()) {
		products.add(new Product(productsResultSet.getString(1), productsResultSet.getInt(2), productsResultSet.getString(3), productsResultSet.getString(4), productsResultSet.getDouble(5)));
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
	}
	return products;
    }
}
