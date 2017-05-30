package PIM;

import DBManager.DBManager;
import java.util.ArrayList;

public class EditProduct {

	public static boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
		return DBManager.getInstance().createProduct(name, category, description, price, imageIdList);
	}

	public static boolean editProduct(int id, String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
		return DBManager.getInstance().editProduct(id, name, category, description, price, imageIdList);
	}

}
