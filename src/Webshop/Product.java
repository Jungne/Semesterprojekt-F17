package Webshop;

import java.io.InputStream;
import java.util.ArrayList;

public class Product {

	private int id;
	private String name;
	private String category;
	private String description;
	private double price;
	private ArrayList<InputStream> imageFiles;

	public Product(int id, String name, String category, String description, double price, ArrayList<InputStream> imageFiles) {
		this.name = name;
		this.id = id;
		this.category = category;
		this.description = description;
		this.price = price;
		this.imageFiles = imageFiles;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the imageFiles
	 */
	public ArrayList<InputStream> getImageFiles() {
		return imageFiles;
	}

}
