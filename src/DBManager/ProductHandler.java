package DBManager;

import Webshop.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductHandler {

    public HashMap<String, String> getProduct(Connection connection, int productID) {
        HashMap<String, String> productMap = new HashMap<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT productName, productid, categoryName, description, price\n"
                    + "FROM products\n"
                    + "NATURAL JOIN categories\n"
                    + "WHERE productid = " + productID);
            ResultSet productResultSet = ps.executeQuery();
            productResultSet.next();

            //Maps the resultset to a hashmap
            productMap = mapProduct(productResultSet);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productMap;
    }

    public LinkedList<HashMap<String, String>> getAllProducts(Connection connection) {
        LinkedList<HashMap<String, String>> productsMapList = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT productName, productid, categoryName, description, price\n"
                    + "FROM products\n"
                    + "NATURAL JOIN categories");
            ResultSet productsResultSet = ps.executeQuery();

            //Maps the resultset to a HashMap.
            productsMapList = mapProducts(productsResultSet);

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsMapList;
    }

    public LinkedList<HashMap<String, String>> findProducts(Connection connection, String query) {
        LinkedList<HashMap<String, String>> productsMapList = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT productName, productid, categoryName, description, price\n"
                    + "FROM Products\n"
                    + "NATURAL JOIN categories\n"
                    + "WHERE LOWER(productName) LIKE '%" + query.toLowerCase() + "%'");
            ResultSet productsResultSet = ps.executeQuery();

            //Maps the resultset to a HashMap.
            productsMapList = mapProducts(productsResultSet);

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsMapList;
    }

    public LinkedList<HashMap<String, String>> findProducts(Connection connection, String query, int categoryID) {
        LinkedList<HashMap<String, String>> productsMapList = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT productName, productid, categoryName, description, price\n"
                    + "FROM Products\n"
                    + "NATURAL JOIN categories\n"
                    + "WHERE LOWER(productName) LIKE '%" + query.toLowerCase() + "%'");
            ResultSet productsResultSet = ps.executeQuery();

            //Maps the resultset to a HashMap.
            productsMapList = mapProducts(productsResultSet);

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsMapList;
    }

    public LinkedHashMap<String, Integer> getCategories(Connection connection) {
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

    public LinkedList<HashMap<String, String>> getProductsInCategory(Connection connection, String category) {
        LinkedList<HashMap<String, String>> productsMapList = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT productName, productid, categoryName, description, price\n"
                    + "FROM Products\n"
                    + "NATURAL JOIN categories\n"
                    + "WHERE categoryName = '" + category + "'");
            ResultSet productsResultSet = ps.executeQuery();

            //Maps the resultset to a HashMap.
            productsMapList = mapProducts(productsResultSet);

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsMapList;
    }

    public void addProduct(Connection connection, int category, double price, String description, String name, ArrayList<Integer> imageList) {
        try {
            //Getting new id for product 
            PreparedStatement psId = connection.prepareStatement("SELECT max(id) FROM Products;");

            ResultSet maxProductId = psId.executeQuery();
            maxProductId.next();
            int productId = 1 + maxProductId.getInt(1);

            //Query inserting products  
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Products (id, productName, categoryId, description, price) VALUES (" + productId + ", " + name + ", " + category + ", " + description + ", " + price + ")");
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
            productMap.put("productName", productsResultSet.getString(1));
            productMap.put("productID", productsResultSet.getString(2));
            productMap.put("categoryName", productsResultSet.getString(3));
            productMap.put("description", productsResultSet.getString(4));
            productMap.put("price", productsResultSet.getString(5));
           
        } catch (SQLException ex) {
            Logger.getLogger(ProductHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productMap;
    }

    /**
     * Repeatedly call the mapProduct method and adds the products to a
     * LinkedList for easy iteration.
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
