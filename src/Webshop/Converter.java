package Webshop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Converter {

	public static Customer toCustomer(HashMap<String, String> customerMap) {
		int customerId = Integer.parseInt(customerMap.get("customerId"));
		String email = customerMap.get("email");
		String code = customerMap.get("code");
		String firstName = customerMap.get("firstName");
		String lastName = customerMap.get("lastName");
		int phoneNumber = Integer.parseInt(customerMap.get("phoneNumber"));
		int mobilePhoneNumber = Integer.parseInt(customerMap.get("mobilePhoneNumber"));
		String address = customerMap.get("address");
		String postalCode = customerMap.get("postalCode");
		String city = customerMap.get("city");
		String country = customerMap.get("country");
		ArrayList<ShoppingBasket> shoppingBaskets = new ArrayList<>();

		return new Customer(customerId, email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, shoppingBaskets);
	}

	public static Order toOrder(HashMap<String, String> orderMap) {
		int orderId = Integer.parseInt(orderMap.get("orderId"));

		//Sets the date by converting the given StringDate from String to Date
		DateFormat format = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss.mmm");//TODO - Should be adjusted to the dateformat from postgreSQL
		Date date;
		try {
			String sqlDateString = orderMap.get("date");
			date = format.parse(sqlDateString.substring(0, sqlDateString.length() - 3));
		} catch (ParseException ex) {
			Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
			date = null;
		}

		OrderStatus orderStatus = OrderStatus.toOrderStaus(orderMap.get("orderStatus"));

		return new Order(orderId, null, date, orderStatus, new ShoppingBasket());
	}

	public static Product toProduct(HashMap<String, String> productMap) {
		int productId = Integer.parseInt(productMap.get("productId"));
		String productName = productMap.get("productName");
		String categoryName = productMap.get("categoryName");
		String description = productMap.get("description");
		double price = Double.parseDouble(productMap.get("price"));
		ArrayList<byte[]> imageFiles = new ArrayList<>();

		return new Product(productId, productName, categoryName, description, price, imageFiles);
	}

}
