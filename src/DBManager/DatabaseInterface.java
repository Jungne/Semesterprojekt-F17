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

	public LinkedList<HashMap<String, String>> getAllEnrichedProducts();

	public LinkedList<HashMap<String, String>> findProducts(String query, int categoryID);

	public LinkedHashMap<String, Integer> getCategories();

	public HashMap<String, String> getDAMImage(int imageId);

	public byte[] getImage(int imageID);

	public ArrayList<byte[]> getImages(int productID);

	public LinkedList<HashMap<String, String>> getAllImages();

	public LinkedList<HashMap<String, String>> getUnassignedImages();

	public LinkedList<HashMap<String, String>> getPImages(int productId);

	public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList);

	public boolean editProduct(int productID, String name, String category, String description, double price, ArrayList<Integer> imageIdList);

	public boolean createImage(String name, String category, InputStream imageFile);

	public boolean deleteImage(int imageId);

	public int getCustomerId(String email);

	public HashMap<String, String> getCustomer(String email);

	public ArrayList<Integer> getBasketIds(int customerId);

	public LinkedList<HashMap<String, String>> getBasketsOrderLines(int basketId);

	public boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, boolean includesEmptyBasket);

	public void createBasket(int customerId);

	public void removeBasket(int basketId);

	public boolean addProductToBasket(int basketId, int productId, int amount);

	public boolean setProductAmount(int basketId, int productId, int amount);

	public void removeProduct(int basketId, int productId);

	public void emptyBasket(int basketId);

	public HashMap<String, String> getLatestOrder(int customerId);

	public LinkedList<HashMap<String, String>> getOrdersOrderLines(int orderId);

	public boolean createOrder(int customerId, String orderStatus);

	public boolean addProductToOrder(int orderId, int productId, int amount);

}
