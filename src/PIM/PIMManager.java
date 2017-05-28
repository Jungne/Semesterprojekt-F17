package PIM;

import Webshop.Product;
import java.util.ArrayList;

public class PIMManager {

	private ArrayList<Product> currentProductList;

	public ArrayList<Product> getAllProducts() {
		this.currentProductList = ProductSearch.getAllProducts();

		return currentProductList;
	}

	public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
		return EditProduct.createProduct(name, category, description, price, imageIdList);
	}

}
