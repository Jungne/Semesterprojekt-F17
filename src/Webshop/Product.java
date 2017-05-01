package Webshop;

public class Product {
    private String name;
    private int id;
    private ProductCategory category;
    private String description;
    private double price;

    public Product(String name, int id, ProductCategory category, String description, double price) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.description = description;
        this.price = price;
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

    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", id=" + id + ", category=" + category + ", description=" + description + ", price=" + price + '}';
    }
}
