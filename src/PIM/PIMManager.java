package PIM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.ArrayList;

public class PIMManager {

	private ArrayList<PIMProduct> currentProductList;
	private DatabaseInterface dbm;
	
	public PIMManager() {
	    dbm = DBManager.getInstance();
	}

	public ArrayList<PIMProduct> getAllProducts() {
		this.currentProductList = ProductSearch.getAllProducts();

		return currentProductList;
	}

	public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
		return EditProduct.createProduct(name, category, description, price, imageIdList);
	}
	
	public ArrayList<PIMage> getUnassignedPIMages() {
	    return Converter.createPIMages(dbm.getUnassignedImages());
	}

}
