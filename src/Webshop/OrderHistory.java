package Webshop;

import DBManager.DBManager;
import DBManager.DatabaseInterface;

public class OrderHistory {

	private DatabaseInterface databaseInterface;

	public OrderHistory() {
		this.databaseInterface = DBManager.getInstance();
	}

	public boolean saveOrder(Customer customer, Order order) {
		return databaseInterface.createOrder(order);
	}
}
