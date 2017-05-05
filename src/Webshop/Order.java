package Webshop;

import java.util.Date;

public class Order {

	private int id;
	private Date dato;
	private Enum OrderStatus;
	private boolean complete;
	private Customer customer;
	private ShoppingBasket basket;

	public Order(Customer customer) {
		this.customer = customer;
		this.basket = customer.getShoppingBasket();
		this.dato = new Date();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the dato
	 */
	public Date getDato() {
		return dato;
	}

	/**
	 * @return the OrderStatus
	 */
	public Enum getOrderStatus() {
		return OrderStatus;
	}

	/**
	 * @return the complete
	 */
	public boolean isComplete() {
		return complete;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the basket
	 */
	public ShoppingBasket getBasket() {
		return basket;
	}

	public double getTotalPrice() {
		return basket.getTotalPrice();
	}
}
