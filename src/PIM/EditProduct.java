package PIM;

import java.util.ArrayList;

public class EditProduct {

	public static boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
		return DBManager.DBManager.getInstance().createProduct(name, category, description, price, imageIdList);
	}

	public void editProduct(int id) {

	}

}
