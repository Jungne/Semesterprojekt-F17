package Webshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Catalog {

	private ArrayList<Product> productList = new ArrayList<>();
	private TreeSet<String> categories = new TreeSet<>();

	public Catalog() throws FileNotFoundException, IOException {
		loadProductCatalog();

		//Testing methods
		System.out.println(searchProduct("e"));
		System.out.println(getCategories());
		System.out.println(getProduct(1).toString());
	}

	private void loadProductCatalog() throws FileNotFoundException, IOException {

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

			productList.add(new Product(name, id, category, description, price, imagePath));

			categories.add(category);
		}
		System.out.println(productList.toString());
	}

	public ArrayList<Product> searchProduct(String query) {
		ArrayList<Product> searchResultList = new ArrayList<>();

		for (Product product : productList) {
			if (product.getName().matches("(.*)" + query.toLowerCase() + "(.*)")) {
				searchResultList.add(product);
			}
		}

		return searchResultList;
	}

	public TreeSet<String> getCategories() {
		return categories;
	}

	public Product getProduct(int id) {
		for (Product product : productList) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}
        
        public ArrayList<Product> getCategory(String category) {
            ArrayList<Product> products = new ArrayList<>();
            for(Product product : productList) {
                if (product.getCategory().equals(category)) {
                    products.add(product);
                }
            }
            return products;
        }
}
