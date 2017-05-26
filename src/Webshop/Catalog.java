package Webshop;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class Catalog {

    private DatabaseInterface databaseInterface;

    public Catalog() {
        this.databaseInterface = DBManager.getInstance();
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

    public ArrayList<Product> findProducts(String query, int categoryID) {
        ArrayList<Product> products = mapProducts(databaseInterface.findProducts(query, categoryID));
        return products;
    }

    private Product mapProduct(HashMap<String, String> productMap) {
        String productName = productMap.get("productName");
        int productID = Integer.parseInt(productMap.get("productID"));
        String categoryName = productMap.get("categoryName");
        String description = productMap.get("description");
        double price = Double.parseDouble(productMap.get("price"));
        ArrayList<Image> images = databaseInterface.getImages(productID);
        Product product = new Product(productName, productID, categoryName, description, price, images);
        return product;
    }

    private ArrayList<Product> mapProducts(LinkedList<HashMap<String, String>> productsMapList) {
        ArrayList<Product> products = new ArrayList<>();

        //Iterates through the list to create the products.
        for (HashMap<String, String> productMap : productsMapList) {
            //Adds the product to the list of products
            products.add(mapProduct(productMap));
        }

        return products;
    }
}
