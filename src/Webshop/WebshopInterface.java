package Webshop;

import java.util.ArrayList;
import java.util.TreeSet;

public interface WebshopInterface {

	public ArrayList<Product> findProducts(String query);

	public TreeSet<String> getCategories();

	public ArrayList<Product> getCategory(String category);

	public Product getProduct(int id);

	public ArrayList<Product> getAllProduct();

	public Order checkOut();

	public Order checkOut(String name, String email, int phoneNumber, ShoppingBasket shoppingBasket);

	public boolean addProductToBasket(int productId, int amount);

	public void removeProduct(int productId);

	public boolean setProductAmount(int productId, int amount);

	public ShoppingBasket getShoppingBasket();

	public void emptyShoppingBasket();

	public boolean signUp(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country);

	public boolean login(String email, String code);

}
