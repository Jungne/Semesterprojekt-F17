package Webshop;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Product {

	private String name;
	private int id;
	private String category;
	private String description;
	private double price;
	private String imagePath;
	private ArrayList<BufferedImage> imageList = new ArrayList<>();

	public Product(String name, int id, String category, String description, double price, String imagePath) throws IOException {
		this.name = name;
		this.id = id;
		this.category = category;
		this.description = description;
		this.price = price;
		this.imagePath = imagePath;
		loadImage();
	}

	public void loadImage() throws IOException {
		imageList.add(ImageIO.read(new File("src/images/" + imagePath)));
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

	@Override
	public String toString() {
		return "Product{" + "name=" + name + ", id=" + id + ", category=" + category + ", description=" + description + ", price=" + price + '}';
	}

	public boolean equals(Product product) {
		return this.id == product.id;
	}
}
