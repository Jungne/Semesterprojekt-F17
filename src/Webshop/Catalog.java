package Webshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Catalog {

    private ArrayList<Product> productList = new ArrayList<>();

    public Catalog() throws FileNotFoundException {
        loadProductCatalog();
        
        //Testing methods
        System.out.println(searchProduct("e"));
        System.out.println(getCategories());
        System.out.println(getProduct(1).toString());
    }

    private void loadProductCatalog() throws FileNotFoundException {
        
        Scanner scanner = new Scanner(new File("productFile.txt"));
        String name;
        int id;
        ProductCategory category;
        String description;
        double price;

        while (scanner.hasNext()) {
            name = scanner.nextLine();
            id = Integer.parseInt(scanner.nextLine());
            category = ProductCategory.valueOf(scanner.nextLine().toUpperCase());
            description = scanner.nextLine();
            price = Double.parseDouble(scanner.nextLine());
            
            productList.add(new Product(name, id, category, description, price));
        }
        System.out.println(productList.toString());
    }

    public ArrayList<Product> searchProduct(String query) {
        ArrayList<Product> searchResultList = new ArrayList<>();
        
        for(Product product : productList) {
            if(product.getName().matches("(.*)" + query.toLowerCase() + "(.*)")) {
                searchResultList.add(product);
            }
        }
        
        return searchResultList;
    }
    
    public ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList(Arrays.asList(ProductCategory.values()));
        
        return categories;
    }
    
    public Product getProduct(int id) {
        for(Product product : productList) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
