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

	public boolean addProductToBasket(int productId, int amount);

	public void removeProduct(int productId);

	public boolean setProductAmount(int productId, int amount);

	public ShoppingBasket getShoppingBasket();

}
