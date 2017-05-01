package Webshop;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

	private HashMap<Product, Integer> products;

	public ShoppingBasket() {
		products = new HashMap<>();
	}

	/**
	 * Creates a map of the current content of the basket.
	 *
	 * @return returns the current content of the basket.
	 */
	public HashMap<Product, Integer> getBasketContent() {
		HashMap<Product, Integer> basketContent = new HashMap<>();
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			basketContent.put(entry.getKey(), entry.getValue());
		}
		return basketContent;
	}

	/**
	 * Adds a product and a product amount to the basket. If the basket already
	 * contains the product, then add the new amount to the previous amount.
	 *
	 * @param product
	 * @param amount
	 * @return returns true if the product was added or updated succesfully.
	 */
	public boolean addProduct(Product product, int amount) {
		return changeProductAmount(product, amount);
	}

	/**
	 * Adds one product to the basket. If the basket already contains the product,
	 * then increment the existing amount.
	 *
	 * @param product
	 * @param amount
	 * @return returns true if the product was added or updated succesfully.
	 */
	public boolean addProduct(Product product) {
		return this.addProduct(product, 1);
	}

	/**
	 * Subtracts the given amount from the existing amount of the given product.
	 * If the new amount is zero or less, the product is removed from the basket.
	 *
	 * @param product
	 * @param amount
	 * @return returns true if the product amount was subtracted or the product
	 * was fully removed succesfully. Returns false if the given amount was
	 * negative.
	 */
	public boolean subtractProductAmount(Product product, int amount) {
		return this.changeProductAmount(product, -amount);
	}

	private boolean changeProductAmount(Product product, int amount) {
		boolean productsContainsProduct = products.containsKey(product);
		if (amount < 0 && !productsContainsProduct) {
			return false;
		}
		if (productsContainsProduct) {
			amount += products.get(product);
			if (amount <= 0) {
				products.remove(product);
			}
			products.replace(product, amount);
		} else {
			products.put(product, amount);
		}
		return true;
	}

	/**
	 * Removes the given product from the basket.
	 *
	 * @param product
	 */
	public void removeProduct(Product product) {
		products.remove(product);
	}
}
