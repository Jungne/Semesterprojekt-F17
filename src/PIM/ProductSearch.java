package PIM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class ProductSearch {

    public static ArrayList<PIMProduct> getAllProducts() {

        ArrayList<PIMProduct> productList = new ArrayList<PIMProduct>();
        
        ResultSet set = DBManager.DBManager.getInstance().getAllProducts();
        
        try {
            while(set.next()) {
                //productList.add(new PIMProduct(set.getInt(2),));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return productList;
    }

}
