package PIM;

import java.util.ArrayList;

/**
 *
 *
 */
public class PIMManager {

    private ArrayList<PIMProduct> currentProductList;

    public ArrayList<PIMProduct> getAllProducts() {
        this.currentProductList = ProductSearch.getAllProducts();
        return currentProductList;
    }

}
