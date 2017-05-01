package Webshop;

public class Product {
    private String name;
    private int id;
    private ProductCategory category;
    private String description;

    public Product(String name, int id, ProductCategory category, String description) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
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
