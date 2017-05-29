package Webshop;

import java.util.ArrayList;

public class ShoppingBasket {

	private int id;
	private ArrayList<OrderLine> orderLines;

	public ShoppingBasket() {
		this.id = -1;
		this.orderLines = new ArrayList<>();
	}

	public ShoppingBasket(int id, ArrayList<OrderLine> orderLines) {
		this.id = id;
		this.orderLines = orderLines;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the orderLines
	 */
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

	public boolean isEmpty() {
		return getOrderLines().isEmpty();
	}

	/**
	 * Finds and return an existing OrderLine in the basket, that contains the
	 * given product. Null is returned if the OrderLine does not exist.
	 *
	 * @param product
	 * @return
	 */
	private OrderLine getExistingOrderLine(Product product) {
		for (OrderLine orderLine : getOrderLines()) {
			if (orderLine.getProduct().getId() == product.getId()) {
				return orderLine;
			}
		}
		return null;
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
			getOrderLines().add(new OrderLine(product, amount));
		} else {
			int currentAmount = existingOrderLine.getAmount();
			existingOrderLine.setAmount(currentAmount + amount);
		}
		return true;
	}

	public boolean setProductAmount(Product product, int amount) {
		OrderLine existingOrderLine = getExistingOrderLine(product);
		if (existingOrderLine == null) {
			return false;
		}
		if (amount <= 0) {
			getOrderLines().remove(existingOrderLine);
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
		getOrderLines().remove(getExistingOrderLine(product));
	}

	public void empty() {
		orderLines = new ArrayList<>();
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		double productPrice = 0;
		double productAmount = 0;
		for (OrderLine orderLine : orderLines) {
			productPrice = orderLine.getProduct().getPrice();
			productAmount = orderLine.getAmount();
			totalPrice += productPrice * productAmount;
		}
		return totalPrice;
	}

}
