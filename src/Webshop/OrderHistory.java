package Webshop;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.HashMap;
import java.util.LinkedList;

public class OrderHistory {

	private static DatabaseInterface databaseInterface = DBManager.getInstance();

	protected static boolean createOrder(Customer customer, ShoppingBasket shoppingBasket) {
		//Checks if there is any products for the order
		if (shoppingBasket == null || shoppingBasket.isEmpty()) {
			return false;
		}

		//Creates a new order without products in it yet
		boolean isCreated = databaseInterface.createOrder(customer.getId(), "Delivered");
		if (!isCreated) {
			return false;
		}

		int orderId = getLatestOrder(customer).getId();

		//Adds the products from shoppingBasket to the new order in database
		for (OrderLine orderLine : shoppingBasket.getOrderLines()) {
			databaseInterface.addProductToOrder(orderId, orderLine.getProduct().getId(), orderLine.getAmount());
		}

		return true;
	}

	protected static Order getLatestOrder(Customer customer) {

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
