package PIM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import static java.lang.reflect.Array.set;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 *
 */
public class ProductSearch {

    private static DatabaseInterface databaseInterface;

    public static ArrayList<PIMProduct> getAllProducts() {
        databaseInterface = DBManager.getInstance();
        ArrayList<PIMProduct> productList = new ArrayList<PIMProduct>();
        LinkedList<HashMap<String, String>> productsMapList= databaseInterface.getAllProducts();

        for (HashMap<String, String> productMap : productsMapList) {
            String productName = productMap.get("productName");
            int productID = Integer.parseInt(productMap.get("productID"));
            String categoryName = productMap.get("categoryName");
            String description = productMap.get("description");
            double price = Double.parseDouble(productMap.get("price"));
            ArrayList<Image> images = databaseInterface.getImages(productID);
            productList.add(new PIMProduct(productName, productID, categoryName, description, price, images));
        }
        return productList;
    }

}
