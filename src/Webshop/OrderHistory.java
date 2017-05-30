package Webshop;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.HashMap;
import java.util.LinkedList;

public class OrderHistory {

	private static DatabaseInterface databaseInterface = DBManager.getInstance();

	public static boolean createOrder(Customer customer, ShoppingBasket shoppingBasket) {
		//Creates a new order without products in it yet
		boolean isCreated = databaseInterface.createOrder(customer.getId(), "Delivered");
		if (!isCreated) {
			return false;
		}

		//TODO
		return false;
	}

	public static Order getLatestOrder(Customer customer) {
		//Contructs the order, but without customer and shoppingBasket
		Order order = Converter.toOrder(databaseInterface.getLatestOrder(customer.getId()));

		//Sets the customer
		order.setCustomer(customer);

		//Gets the orderLines in the order and adds them to shoppingBasket
		LinkedList<HashMap<String, String>> orderLinesMap = databaseInterface.getOrdersOrderLines(order.getId());
		for (HashMap<String, String> orderLineMap : orderLinesMap) {
			int productId = Integer.parseInt(orderLineMap.get("productId"));
			int amount = Integer.parseInt(orderLineMap.get("amount"));
			order.getShoppingBasket().addProduct(Catalog.getProduct(productId), amount);
		}

		return order;
	}
}
