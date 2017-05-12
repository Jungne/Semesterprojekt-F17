package Webshop;

import java.util.Date;

public class Order {

	private int id;
	private Customer customer;
	private Date date;
	private OrderStatus orderStatus;
	private ShoppingBasket basket;

	public Order(Customer customer) {
		this.id = 0; // TODO - set id to something unique
		this.customer = customer;
		this.date = new Date();
		this.basket = customer.getShoppingBasket();
		this.orderStatus = OrderStatus.CREATED;
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
	public Date getDate() {
		return date;
	}

	/**
	 * @return the OrderStatus
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
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
