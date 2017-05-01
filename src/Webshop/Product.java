package Webshop;

public class Product {
    private int id;
    private ProductCategory category;
    private String description;

    public Product(int id, ProductCategory category, String description) {
        this.id = id;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
    
}
