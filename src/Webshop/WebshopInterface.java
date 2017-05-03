package Webshop;

import java.util.ArrayList;
import java.util.TreeSet;

public interface WebshopInterface {

	public ArrayList<Product> findProduct(String query);

	public TreeSet<String> getCategories();

	public ArrayList<Product> getCategory(String category);

	public Product getProduct(int id);

	public ArrayList<Product> getProductList();

	public Order checkOut();

	public void addProductToBasket(int productId, int amount);

	public void removeProduct(int productId);

	public void setProductAmount(int productId, int amount);

	public ShoppingBasket getShoppingBasket();

}
