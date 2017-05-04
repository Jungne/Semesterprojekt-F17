package Webshop;

import java.util.TreeSet;

public interface DatabaseInterface {

	public Product getProduct(int productId);

	public TreeSet<String> getCategories();

}
