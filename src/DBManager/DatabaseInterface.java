package DBManager;

import Webshop.Order;
import Webshop.Product;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.TreeSet;

public interface DatabaseInterface {

    //Methods for Catalog:
    public Product getProduct(int productId);

    public ArrayList<Product> getAllProducts();

    public ArrayList<Product> findProducts(String query);

    public TreeSet<String> getCategories();

    public ArrayList<Product> getCategory(String category);

    //Methods for OrderHistory:
    public boolean saveOrder(Order order);

    public void addImage(String imagePath, String title, int category);

    public ResultSet getImages();

}