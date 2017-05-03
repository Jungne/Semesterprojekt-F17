package Webshop;

import java.util.ArrayList;
import java.util.Date;

public class Order {

	private int id;
	private Date dato;
	private Enum OrderStatus;
	private boolean complete;
	private Customer customer;
	private ShoppingBasket basket;
	
	public Order(Customer customer, ShoppingBasket basket) {
		this.customer = customer;
		this.basket = basket;
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
}
