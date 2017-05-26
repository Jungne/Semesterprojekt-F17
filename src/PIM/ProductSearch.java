package PIM;

import DBManager.DatabaseInterface;
import Webshop.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        ArrayList<PIMProduct> productList = new ArrayList<PIMProduct>();

        ResultSet set = DBManager.DBManager.getInstance().getAllProducts();

        try {
            while (set.next()) {

                int productID = set.getInt(2);
                ArrayList<Image> images = databaseInterface.getImages(productID);
                productList.add(new PIMProduct(set.getString(1), productID, set.getString(3), set.getString(4), set.getDouble(5), images));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductSearch.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productList;
    }

}
