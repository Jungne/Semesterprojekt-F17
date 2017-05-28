package Webshop;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface WebshopInterface {

	public Product getProduct(int id);

	public ArrayList<Product> getAllProduct();

	public ArrayList<Product> findProducts(String query, int categoryID);

	public LinkedHashMap<String, Integer> getCategories();

	public boolean signUp(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ShoppingBasket shoppingBasket);

	public boolean login(String email, String code);

	public Customer getCustomer();

	//Basket methods for guests
	public ShoppingBasket getShoppingBasket();

	public boolean addProductToBasket(int productId, int amount);

	public boolean setProductAmount(int productId, int amount);

	public void removeProduct(int productId);

	public void emptyShoppingBasket();

	//Basket methods for customers
	public ArrayList<ShoppingBasket> getShoppingBaskets();

	public void createBasket();

	public void removeBasket(int basketId);

	public boolean addProductToBasket(int basketId, int productId, int amount);

	public boolean setProductAmount(int basketId, int productId, int amount);

	public boolean removeProduct(int basketId, int productId);

	public void emptyShoppingBasket(int basketId);

	//CheckOut for guests
	public Order checkOut(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country);

	//CheckOut for customers
	public Order checkOut(int basketId);

}
