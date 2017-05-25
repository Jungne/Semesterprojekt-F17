package Webshop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

public class Product {

    private String name;
    private int id;
    private String category;
    private String description;
    private double price;
    private String imagePath;
    private ArrayList<Image> imageList = new ArrayList<>();

    public Product(String name, int id, String category, String description, double price, String imagePath) throws IOException {
	this.name = name;
	this.id = id;
	this.category = category;
	this.description = description;
	this.price = price;
	this.imagePath = imagePath;
    }

    public Product(String name, int id, String category, String description, double price) {
	this.name = name;
	this.id = id;
	this.category = category;
	this.description = description;
	this.price = price;
	this.imagePath = "test.jpeg";
    }

    public Product(String name, int id, String category, String description, double price, ArrayList<Image> images) {
	this.name = name;
	this.id = id;
	this.category = category;
	this.description = description;
	this.price = price;
	this.imageList = images;

	if (imageList.isEmpty()) {
	    imageList.add(new Image("images/test.jpeg"));
	}
    }

    public String getName() {
	return name;
    }

    public int getId() {
	return id;
    }

    public String getCategory() {
	return category;
    }

    public String getDescription() {
	return description;
    }

    public double getPrice() {
	return price;
    }

    public String getImagePath() {
	return imagePath;
    }

    public ArrayList<Image> getImageList() {
	return imageList;
    }

    @Override
    public String toString() {
	return "Product{" + "name=" + name + ", id=" + id + ", category=" + category + ", description=" + description + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {
	return this.id == ((Product) o).id;
    }
}
