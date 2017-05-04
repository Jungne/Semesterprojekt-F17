package Webshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class FileSearcher {

	public static TreeSet<Product> findProduct(String query) {
		TreeSet<Product> productSet = new TreeSet<>();

		return productSet;
	}

	public static void loadEntireCatalog(Catalog catalog) throws FileNotFoundException, IOException {

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

			catalog.getProductList().add(new Product(name, id, category, description, price, imagePath));

			catalog.getCategories().add(category);
		}
	}
}
