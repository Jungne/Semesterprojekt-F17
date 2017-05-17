/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jungn
 */
public class DBManager implements DatabaseInterface{
    private Connection con;
    private ProductHandler productHandler;

    public DBManager() {
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

        con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to database successful!");

        } catch (SQLException ex) {
            System.out.println("Connection to database failed.");
        }
    }
    

    @Override
    public Product getProduct(int productId) {
	Product product = null;
	try {
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE id = " + productId);
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
    public ArrayList<Product> getAllProducts(){
	ArrayList<Product> products = null;
	try {
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM Products");
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
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE LOWER(name) LIKE '%" + query.toLowerCase() + "%'");
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
	    PreparedStatement ps = con.prepareStatement("SELECT category FROM Products");
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
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE LOWER(category) = '" + category.toLowerCase() + "'");
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
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
