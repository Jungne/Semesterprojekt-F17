package Webshop;

import DBManager.DBManager;
import DBManager.DatabaseInterface;

public class OrderHistory {

	private static DatabaseInterface databaseInterface = DBManager.getInstance();

	public static boolean saveOrder(Customer customer, Order order) {
		return databaseInterface.createOrder(order);
	}
}
