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
    
    public void newProduct(int category, double price, String description, String titel, ArrayList<Integer> imageList) {
        EditProduct.newProduct(category, price, description, titel, imageList);
    }

}
