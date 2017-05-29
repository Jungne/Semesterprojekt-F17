package DBManager;

import DAM.DAMImage;
import Webshop.Customer;
import Webshop.Order;
import Webshop.Product;
import Webshop.ShoppingBasket;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface DatabaseInterface {

	public Product getProduct(int productId);

	public ArrayList<Product> getAllProducts();

	public ArrayList<Product> findProducts(String query, int categoryID);

	public LinkedHashMap<String, Integer> getCategories();

	public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList);

	public Order getLatestOrder(int customerId);
	
	public boolean createOrder(Order order);

	public DAMImage getImage(int imageId);

	public ArrayList<DAMImage> getAllImages();

	public boolean createImage(String name, String category, InputStream imageFile);

	public boolean deleteImage(int imageId);

	public int getCustomerId(String email);
	
	public Customer getCustomer(String email);

	public Customer getCustomer(String email, String code);

	public boolean createCustomer(Customer customer, ShoppingBasket shoppingBasket);

}
