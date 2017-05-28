package PIM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import Webshop.Product;
import java.util.ArrayList;

public class ProductSearch {

	private static DatabaseInterface databaseInterface = DBManager.getInstance();

	public static ArrayList<Product> getAllProducts() {
		return databaseInterface.getAllProducts();
	}

}
