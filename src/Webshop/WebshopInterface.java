package Webshop;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public interface WebshopInterface {

	public List<Product> findProduct(String query);

	public TreeSet<String> getCategories();

	public Product getProduct(int id);

	public ArrayList<Product> getProductList();

	public ArrayList<Product> getCategory(String category);

	public boolean addProduct(int productId, int amount);

	public Order checkOut();

}
