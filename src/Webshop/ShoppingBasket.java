package Webshop;

import java.util.ArrayList;

public class ShoppingBasket {

	private ArrayList<OrderLine> basket;

	public ShoppingBasket() {
		basket = new ArrayList<>();
	}

	/**
	 * Finds and return an existing OrderLine in the basket, that contains the
	 * given product. Null is returned if the OrderLine does not exist.
	 *
	 * @param product
	 * @return
	 */
	private OrderLine getExistingOrderLine(Product product) {
		for (OrderLine orderLine : basket) {
			if (orderLine.getProduct().equals(product)) {
				return orderLine;
			}
		}
		return null;
	}

	/**
	 * Creates a ArrayList of the current content of the basket.
	 *
	 * @return returns the current content of the basket.
	 */
	public ArrayList<OrderLine> getBasketContent() {
		ArrayList<OrderLine> returnBasket = new ArrayList<>();
		for (OrderLine orderLine : basket) {
			returnBasket.add(new OrderLine(orderLine));
		}
		return returnBasket;
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
		if (amount <= 0) {
			return false;
		}
		OrderLine existingOrderLine = getExistingOrderLine(product);
		if (existingOrderLine == null) {
			basket.add(new OrderLine(product, amount));
		} else {
			int currentAmount = existingOrderLine.getAmount();
			existingOrderLine.setAmount(currentAmount + amount);
		}
		return true;
	}

	/**
	 * Adds OrderLine to basket. If the basket already contains the product that
	 * that OrderLine contains, then add the new amount in the OrderLine to the
	 * previous amount.
	 *
	 * @param orderLine
	 * @return
	 */
	public boolean addProduct(OrderLine orderLine) {
		return addProduct(orderLine.getProduct(), orderLine.getAmount());
	}

	public boolean setProductAmount(Product product, int amount) {
		OrderLine existingOrderLine = getExistingOrderLine(product);
		if (existingOrderLine == null) {
			return false;
		}
		if (amount <= 0) {
			basket.remove(existingOrderLine);
		} else {
			existingOrderLine.setAmount(amount);
		}
		return true;
	}

	/**
	 * Removes the given product from the basket.
	 *
	 * @param product
	 */
	public void removeProduct(Product product) {
		basket.remove(getExistingOrderLine(product));
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		double productPrice = 0;
		double productAmount = 0;
		for (OrderLine orderLine : basket) {
			productPrice = orderLine.getProduct().getPrice();
			productAmount = orderLine.getAmount();
			totalPrice += productPrice * productAmount;
		}
		return totalPrice;
	}
}
