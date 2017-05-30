package Webshop;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

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
		return null;//TODO
	}

	public static Product toProduct(HashMap<String, String> productMap) {
		int productId = Integer.parseInt(productMap.get("productId"));
		String productName = productMap.get("productName");
		String categoryName = productMap.get("categoryName");
		String description = productMap.get("description");
		double price = Double.parseDouble(productMap.get("price"));
		ArrayList<InputStream> imageFiles = new ArrayList<>();

		return new Product(productId, productName, categoryName, description, price, imageFiles);
	}

}
