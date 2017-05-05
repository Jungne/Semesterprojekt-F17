package Webshop;

public class OrderHistory {

	private DatabaseInterface databaseInterface;

	public OrderHistory(DatabaseInterface databaseInterface) {
		this.databaseInterface = databaseInterface;
	}

	public boolean saveOrder(Customer customer, Order order) {
		return databaseInterface.saveOrder(customer, order);
	}
}
