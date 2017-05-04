package Webshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSearcher implements DatabaseInterface {

	public static TreeSet<Product> findProduct(String query) {
		TreeSet<Product> productSet = new TreeSet<>();

		return productSet;
	}

	public static void loadEntireCatalog(Catalog catalog) {
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
					catalog.getProductList().add(new Product(name, id, category, description, price, imagePath));
				} catch (IOException ex) {
					Logger.getLogger(FileSearcher.class.getName()).log(Level.SEVERE, null, ex);
				}

				catalog.getCategories().add(category);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileSearcher.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Product getProduct(int productId) {
		try {
			Scanner scanner = new Scanner(new File("productFile.txt"));

			int lineNumber = 0;
			int id;
			String line = "";
			String previousLine = "";

			while (scanner.hasNext()) {
				lineNumber++;
				previousLine = line;
				line = scanner.nextLine();

				//Checks all lines where the id is.
				if (lineNumber % 6 == 2) {
					id = Integer.parseInt(line);

					//If the id on the current line is equal to the given id, then product is created and returned.
					if (productId == id) {
						String name = previousLine;
						String category = scanner.nextLine();
						String description = scanner.nextLine();
						double price = Double.parseDouble(scanner.nextLine());
						String imagePath = scanner.nextLine();
						try {
							return new Product(name, id, category, description, price, imagePath);
						} catch (IOException ex) {
							Logger.getLogger(FileSearcher.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				}
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileSearcher.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public TreeSet<String> getCategories() {
		try {
			Scanner scanner = new Scanner(new File("productFile.txt"));

			TreeSet<String> categories = new TreeSet<>();
			String line = "";
			int lineNumber = 0;

			while (scanner.hasNext()) {
				lineNumber++;
				line = scanner.nextLine();
				if (lineNumber % 6 == 3) {
					categories.add(line);
				}
			}
			return categories;

		} catch (FileNotFoundException ex) {
			Logger.getLogger(FileSearcher.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
