package DBManager;

import Webshop.Order;
import Webshop.OrderLine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderHandler {

	public boolean createOrder(Connection connection, Order order) {
		try {
			PreparedStatement orderStatement = connection.prepareStatement(
							"INSERT INTO orders (customerID, date, orderStatus)\n"
							+ "VALUES (?, CURRENT_TIMESTAMP,?)");
			//orderStatement.setInt(1, order.getId());
			orderStatement.setInt(1, order.getCustomer().getId());
			orderStatement.setString(2, order.getOrderStatus().name());
			orderStatement.executeUpdate();
			
			PreparedStatement orderIDStatement = connection.prepareStatement("SELECT MAX(orderID) FROM orders");
			ResultSet orderIDSet = orderIDStatement.executeQuery();
			orderIDSet.next();
			int orderID = orderIDSet.getInt(1);
			
			ArrayList<OrderLine> orderLines = order.getBasket().getBasketContent();
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
