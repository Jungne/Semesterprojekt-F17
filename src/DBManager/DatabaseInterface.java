package DBManager;

import DAM.DAMImage;
import Webshop.Customer2;
import Webshop.Order;
import Webshop.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javafx.scene.image.Image;

public interface DatabaseInterface {

	public ResultSet getProduct(int productId);

	public ResultSet getAllProducts();

	public ArrayList<Product> findProducts(String query);

	public LinkedHashMap<String, Integer> getCategories();

	public ArrayList<Product> getCategory(String category);

	public boolean createOrder(Order order);

	public void createImage(String imagePath, String title, int category);

	public Image getImage(int id);

	public ArrayList<Image> getImages();

	public DAMImage getDAMImage(int id);

	public ArrayList<DAMImage> getDAMImages();

	public void deleteImage(int id);
	
	public boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country);

	public Customer2 getCustomer(String email, String code);
}
