package Webshop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSearcher implements DatabaseInterface {

	private ArrayList<Product> products;
	private TreeSet<String> categories;

	public FileSearcher() {
		products = new ArrayList<Product>();
		categories = new TreeSet<String>();
		loadFile();
	}

	/**
	 * Loads all products from productFile.txt into productList, if it has not
	 * been done yet
	 */
	private void loadFile() {
		try {
			Scanner scanner = new Scanner(new File("productFile.txt"));

			String name;
			int id;
			String category;
			String description;
			double price;
			String imagePath;

			while (scanner.hasNext()) {
				name = scanner.nextLine();
				id = Integer.parseInt(scanner.nextLine());
				category = scanner.nextLine();
				description = scanner.nextLine();
				price = Double.parseDouble(scanner.nextLine());
				imagePath = scanner.nextLine();

				try {
					products.add(new Product(name, id, category, description, price, imagePath));
					categories.add(category);
				} catch (IOException ex) {
					Logger.getLogger(FileSearcher.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileSearcher.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Product getProduct(int productId) {
		for (Product product : products) {
			if (product.getId() == productId) {
				return product;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) products.clone();
	}

	@Override
	public ArrayList<Product> findProducts(String query) {
		ArrayList<Product> searchResult = new ArrayList<>();

		for (Product product : products) {
			if (product.getName().matches("(.*)" + query.toLowerCase() + "(.*)")) {
				searchResult.add(product);
			}
		}

		return searchResult;
	}

	@Override
	public TreeSet<String> getCategories() {
		return (TreeSet<String>) categories.clone();
	}

	@Override
	public ArrayList<Product> getCategory(String category) {
		ArrayList<Product> products = new ArrayList<>();
		for (Product product : this.products) {
			if (product.getCategory().equals(category)) {
				products.add(product);
			}
		}
		return products;
	}

	@Override
	public boolean saveOrder(Customer customer, Order order) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("orderHistory.txt"));
			//TODO - Save the order into orderHistory.txt
			bufferedWriter.close();
		} catch (IOException ex) {
			Logger.getLogger(FileSearcher.class.getName()).log(Level.SEVERE, null, ex);
		}
		return true;
	}
}
