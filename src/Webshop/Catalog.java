package Webshop;

import DBManager.DatabaseInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

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

    public ArrayList<Product> getProductsInCategory(String category) {
	ArrayList<Product> products = mapProducts(databaseInterface.getProductsInCategory(category));
	return products;
    }

    public ArrayList<Product> findProducts(String query) {
	ArrayList<Product> products = mapProducts(databaseInterface.findProducts(query));
	return products;
    }

    private Product mapProduct(ResultSet productResultSet) {
	Product product = null;
	try {
	    productResultSet.next();	    
	    int productID = productResultSet.getInt(2);
	    ArrayList<Image> images = databaseInterface.getImages(productID);
	    product = new Product(productResultSet.getString(1), productID, productResultSet.getString(3), productResultSet.getString(4), productResultSet.getDouble(5), images);
	} catch (SQLException ex) {
	    Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
	}
	return product;
    }

    private ArrayList<Product> mapProducts(ResultSet productsResultSet) {
	ArrayList<Product> products = new ArrayList<>();
	try {
	    while (productsResultSet.next()) {
		int productID = productsResultSet.getInt(2);
		ArrayList<Image> images = databaseInterface.getImages(productID);
		products.add(new Product(productsResultSet.getString(1), productID, productsResultSet.getString(3), productsResultSet.getString(4), productsResultSet.getDouble(5), images));
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
	}
	return products;
    }
}
