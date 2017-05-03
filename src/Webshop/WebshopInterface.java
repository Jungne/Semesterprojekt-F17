package Webshop;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public interface WebshopInterface {

	public List<Product> findProduct(String query);

	public TreeSet<String> getCategories();

	public Product getProduct(int id);

	public ArrayList<Product> getProductList();
	
	public Order checkOut();

}
