/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import Webshop.Product;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author jungn
 */
public class ProductHandler {
    
    
    public Product getProduct(ResultSet components) throws SQLException, IOException {
	return new Product(components.getString(2), components.getInt(1), components.getString(4), components.getString(5), components.getDouble(3), components.getString(6));
    }
    
    public ArrayList<Product> getProducts(ResultSet components) throws SQLException, IOException {
	ArrayList<Product> products = new ArrayList<>();
	while (components.next()) {
	    products.add(new Product(components.getString(2), components.getInt(1), components.getString(4), components.getString(5), components.getDouble(3), components.getString(6)));
        }
	return products;
    }
    
    public TreeSet<String> getCategories(ResultSet components) throws SQLException {
	TreeSet<String> categories = new TreeSet<>();
	
	while (components.next()) {
	    categories.add(components.getString(1));
        }
	
	return categories;
    }
}
