package Webshop;

import java.util.ArrayList;
import java.util.Date;

public class Order {

	private int id;
	private Date dato;
	private Enum OrderStatus;
	private boolean complete;
	private Customer customer;
	private ArrayList<OrderLine> products;

	public Order(Customer customer, ArrayList<OrderLine> products) {
		this.customer = customer;
		this.products = products;
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
	 * @return the products
	 */
	public ArrayList<OrderLine> getProducts() {
		return products;
	}
}
