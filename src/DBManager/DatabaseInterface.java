package DBManager;

import DAM.DAMImage;
import Webshop.Customer2;
import Webshop.Order;
import Webshop.ShoppingBasket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javafx.scene.image.Image;

public interface DatabaseInterface {

	public HashMap<String, String> getProduct(int productId);

	public LinkedList<HashMap<String, String>> getAllProducts();

	public LinkedList<HashMap<String, String>> findProducts(String query);
	
	public LinkedList<HashMap<String, String>> findProducts(String query, int categoryID);

	public LinkedHashMap<String, Integer> getCategories();

	public LinkedList<HashMap<String, String>> getProductsInCategory(String category);

	public boolean createOrder(Order order);

	public void createImage(String imagePath, String title, int category);

	public Image getImage(int id);

	public ArrayList<Image> getImages();
	
	public ArrayList<Image> getImages(int productID);

	public DAMImage getDAMImage(int id);

	public ArrayList<DAMImage> getDAMImages();

	public void deleteImage(int id);
	
	public boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ShoppingBasket shoppingBasket);

	public Customer2 getCustomer(String email, String code);
	
	public void addProduct(int category, double price, String description, String titel, ArrayList<Integer> imageList);
}
