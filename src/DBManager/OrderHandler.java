package DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
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

	public HashMap<String, String> getLatestOrder(int customerId) {
		try {
			HashMap<String, String> orderMap = new HashMap<>();

			//Gets a ResultSet with the latest order in the first tuple
			ResultSet orderSet = executeQuery("SELECT orderId, date, orderStatus "
							+ "FROM Orders WHERE customerId = " + customerId + " ORDER BY date DESC");
			if (!orderSet.next()) {
				return null;
			}

			//Puts in the attributes of the order
			orderMap.put("orderId", orderSet.getString(1));
			orderMap.put("customerId", customerId + "");
			orderMap.put("date", orderSet.getString(2));
			orderMap.put("orderStatus", orderSet.getString(3));

			return orderMap;
		} catch (SQLException ex) {
			Logger.getLogger(OrderHandler.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public LinkedList<HashMap<String, String>> getOrdersOrderLines(int orderId) {
		try {
			LinkedList<HashMap<String, String>> orderLinesMap = new LinkedList<>();

			//Gets orderLines for this order
			ResultSet orderLineSet = executeQuery("SELECT productId, amount FROM ProductsInOrders WHERE orderId = " + orderId);
			while (orderLineSet.next()) {
				HashMap<String, String> orderLineMap = new HashMap<>();
				orderLineMap.put("productId", orderLineSet.getString(1));
				orderLineMap.put("amount", orderLineSet.getString(2));
				orderLinesMap.add(orderLineMap);
			}

			return orderLinesMap;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	/**
	 * Creates a new order in the database. It assumes that the associated
	 * customer does exist.
	 *
	 * @param customerId
	 * @param orderStatus
	 * @return
	 */
	public boolean createOrder(int customerId, String orderStatus) {
		try {
			executeUpdate("INSERT INTO Orders (customerId, date, orderStatus) VALUES ("
							+ customerId
							+ ", CURRENT_TIMESTAMP, '"
							+ orderStatus + "')");

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean addProductToOrder(int orderId, int productId, int amount) {
		try {
			executeUpdate("INSERT INTO ProductsInOrders (orderId, productId, amount) VALUES (" + orderId + ", " + productId + ", " + amount + ")");

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

}
