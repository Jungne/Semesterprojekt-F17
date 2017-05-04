package Webshop;

public class Customer {

	private int id;
	private String name;
	private String email;
	private int phoneNumber;
	private ShoppingBasket shoppingBasket;

	public Customer(String name, String email, int phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.shoppingBasket = new ShoppingBasket();
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ShoppingBasket getShoppingBasket() {
		return this.shoppingBasket;
	}

	/**
	 * @return An order for this customer consisting this customer's current
	 * shopping basket.
	 */
	public Order checkOut() {
		if (shoppingBasket.isEmpty()) {
			return null;
		}
		return new Order(this);
	}
}
