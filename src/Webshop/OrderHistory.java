package Webshop;

import DBManager.DBManager;
import DBManager.DatabaseInterface;

public class OrderHistory {

	private static DatabaseInterface databaseInterface = DBManager.getInstance();

	public static boolean createOrder(Customer customer, ShoppingBasket shoppingBasket) {
		return databaseInterface.createOrder(new Order(customer, shoppingBasket));
	}

	public static Order getLatestOrder(Customer customer) {
		//TODO
	}
}
