package DBManager;

import Webshop.Customer;
import Webshop.Order;
import Webshop.OrderLine;
import Webshop.OrderStatus;
import Webshop.ShoppingBasket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderHandler {

	private Connection connection;

	public OrderHandler(Connection connection) {
		this.connection = connection;
	}

	private void executeUpdate(String query) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(query);
		}
	}

	private ResultSet executeQuery(String query) throws SQLException {
		return connection.createStatement().executeQuery(query);
	}

	public Order getLatestOrder(int customerId) {
		try {
			ResultSet orderSet = executeQuery("SELECT orderId, customerId, date, orderStatus "
							+ "FROM Orders WHERE customerId = " + customerId + " ORDER BY date DESC");
			if (!orderSet.next()) {
				return null;
			}

			int orderId = orderSet.getInt(1);
			Customer customer = null; //TODO - get assosiated customer
			Date date = orderSet.getDate(3);
			OrderStatus orderStatus = OrderStatus.valueOf(orderSet.getString(4));
			ShoppingBasket shoppingBasket = null; //TODO - get products in order

			return new Order(orderId, customer, date, orderStatus, shoppingBasket);
		} catch (SQLException ex) {
			Logger.getLogger(OrderHandler.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	/**
	 * Creates a new order in the database. It assumes that the associated
	 * customer does exist.
	 *
	 * @param order
	 * @return
	 */
	public boolean createOrder(Order order) {
		try {
			int customerId = order.getCustomer().getId();
			String orderStatusString = order.getOrderStatus().toString();
			executeUpdate("INSERT INTO Orders (customerID, date, orderStatus) VALUES ("
							+ customerId
							+ ", CURRENT_TIMESTAMP, '"
							+ orderStatusString + "')");

			int orderID = getLatestOrder(customerId).getId();
			//TODO

			ArrayList<OrderLine> orderLines = order.getShoppingBasket().getOrderLines();
			PreparedStatement productsInOrderStatement = connection.prepareStatement("INSERT INTO productsInOrders "
							+ "VALUES (?,?,?)");
			for (OrderLine orderLine : orderLines) {

				productsInOrderStatement.setInt(1, orderID);
				productsInOrderStatement.setInt(2, orderLine.getProduct().getId());
				productsInOrderStatement.setInt(3, orderLine.getAmount());
				productsInOrderStatement.executeUpdate();
			}

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

}
