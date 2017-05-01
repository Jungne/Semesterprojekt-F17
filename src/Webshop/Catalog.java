package Webshop;

import java.util.TreeSet;

public class Catalog {
    private TreeSet<Product> productSet;
    
    public void loadProductCatalog() {
        
    }
    
    public void searchProduct(String query) {
        TreeSet<Product> searchProductSet;
        searchProductSet = FileSearcher.findProduct(query);
    }
}
