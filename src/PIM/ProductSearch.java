package PIM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.InputStream;
import java.util.ArrayList;

public class ProductSearch {

    private static DatabaseInterface databaseInterface = DBManager.getInstance();

    public static ArrayList<PIMProduct> getAllProducts() {
	databaseInterface = DBManager.getInstance();
	ArrayList<PIMProduct> productList = Converter.createPIMProducts(databaseInterface.getAllProducts());
	return productList;
    }
}
