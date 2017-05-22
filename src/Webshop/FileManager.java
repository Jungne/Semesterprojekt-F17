package Webshop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class FileManager implements DatabaseInterface {

	private ArrayList<Product> products;
	private TreeSet<String> categories;

	public FileManager() {
		products = new ArrayList<>();
		categories = new TreeSet<>();
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
					Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
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
		ArrayList<Product> returnProducts = new ArrayList<>();
		for (Product product : this.products) {
			if (product.getCategory().equals(category)) {
				returnProducts.add(product);
			}
		}
		return returnProducts;
	}

	@Override
	public boolean saveOrder(Order order) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileWriter = new FileWriter("orderHistory.txt", true);
			bufferedWriter = new BufferedWriter(fileWriter);

			//TODO - Should return false if any of the values are invalid.
			String textToFile = "";
			textToFile += order.getId() + "\n";
			textToFile += order.getCustomer().getId() + "\n";
			textToFile += order.getDate().toString() + "\n";
			textToFile += order.getOrderStatus() + "\n";
			String basketLine = "";
			for (OrderLine orderLine : order.getBasket().getBasketContent()) {
				basketLine += orderLine.getProduct().getId() + "." + orderLine.getAmount() + ",";
			}
			if (basketLine.equals("")) {
				basketLine = "empty\n";
			} else {
				basketLine = basketLine.substring(0, basketLine.length() - 1) + "\n";
			}
			textToFile += basketLine;

			bufferedWriter.write(textToFile);
		} catch (IOException ex) {
			Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				//exception handling left as an exercise for the reader
			}
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				//exception handling left as an exercise for the reader
			}
		}
		return true;
	}

    @Override
    public void addImage(File imageFile) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getImage() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
