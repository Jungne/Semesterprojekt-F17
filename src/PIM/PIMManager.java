package PIM;

import Webshop.Product;
import java.util.ArrayList;

public class PIMManager {

	private ArrayList<PIMProduct> currentProductList;

	public ArrayList<PIMProduct> getAllProducts() {
		this.currentProductList = ProductSearch.getAllProducts();

		return currentProductList;
	}

	public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
		return EditProduct.createProduct(name, category, description, price, imageIdList);
	}

}
