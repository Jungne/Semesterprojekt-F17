package DBManager;

import Webshop.Customer;
import Webshop.Order;
import Webshop.ShoppingBasket;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public interface DatabaseInterface {

	public HashMap<String, String> getProduct(int productId);

	public LinkedList<HashMap<String, String>> getAllProducts();

	public LinkedList<HashMap<String, String>> findProducts(String query, int categoryID);

	public LinkedHashMap<String, Integer> getCategories();

	public boolean createOrder(Order order);

	public HashMap<String, String> getDAMImage(int imageId);

	public byte[] getImage(int imageID);

	public ArrayList<byte[]> getImages(int productID);

	public LinkedList<HashMap<String, String>> getAllImages();

	public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList);

	public Order getLatestOrder(int customerId);

	public boolean createImage(String name, String category, InputStream imageFile);

	public boolean deleteImage(int imageId);

	public int getCustomerId(String email);

	public HashMap<String, String> getCustomer(String email);

	public Customer getCustomer(String email, String code);

	public boolean createCustomer(Customer customer, ShoppingBasket shoppingBasket);

}
