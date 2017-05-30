package Webshop;

import java.util.Date;

public class Order {

	private int id;
	private Customer customer;
	private Date date;
	private OrderStatus orderStatus;
	private ShoppingBasket shoppingBasket;

	public Order(int id, Customer customer, Date date, OrderStatus orderStatus, ShoppingBasket shoppingBasket) {
		this.id = id;
		this.customer = customer;
		this.date = date;
		this.orderStatus = orderStatus;
		this.shoppingBasket = shoppingBasket;
	}

	public Order(Customer customer, ShoppingBasket shoppingBasket) {
		this.id = -1;
		this.customer = customer;
		this.date = null;
		this.orderStatus = OrderStatus.SENT;
		this.shoppingBasket = shoppingBasket;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the orderStatus
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @return the shoppingBasket
	 */
	public ShoppingBasket getShoppingBasket() {
		return shoppingBasket;
	}

	public double getTotalPrice() {
		return shoppingBasket.getTotalPrice();
	}

}
