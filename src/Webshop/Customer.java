package Webshop;

import java.util.ArrayList;

public class Customer {

	private int id;
	private String email;
	private String code;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private int mobilePhoneNumber;
	private String address;
	private String postalCode;
	private String city;
	private String country;
	private ArrayList<ShoppingBasket> shoppingBaskets;
	private boolean isRegisted;

	protected Customer(int id, String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ArrayList<ShoppingBasket> shoppingBaskets) {
		this.id = id;
		this.email = email;
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.shoppingBaskets = shoppingBaskets;
		this.isRegisted = true;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the mobilePhoneNumber
	 */
	public int getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the shoppingBaskets
	 */
	public ArrayList<ShoppingBasket> getShoppingBaskets() {
		return shoppingBaskets;
	}

	/**
	 * @return the first shoppingBasket
	 */
	public ShoppingBasket getFirstShoppingBasket() {
		return shoppingBaskets.get(0);
	}

	/**
	 * @return the isRegisted
	 */
	public boolean isRegisted() {
		return isRegisted;
	}

	public ShoppingBasket getShoppingBasket(int basketId) {
		for (ShoppingBasket shoppingBasket : shoppingBaskets) {
			if (basketId == shoppingBasket.getId()) {
				return shoppingBasket;
			}
		}
		return null;
	}

	public void removeShoppingBasket(ShoppingBasket shoppingBasket) {;
		if (shoppingBasket != null) {
			shoppingBaskets.remove(shoppingBasket);
		}
	}

	protected boolean checkOut() {
		if (shoppingBaskets.size() == 1) {
			return checkOut(shoppingBaskets.get(0));
		}
		return false;
	}

	protected boolean checkOut(ShoppingBasket shoppingBasket) {
		//Checks if such shoppingBasket is on the customer
		for (ShoppingBasket s : shoppingBaskets) {
			if (shoppingBasket.equals(s)) {
				return OrderHistory.createOrder(this, shoppingBasket);
			}
		}
		return false;
	}

}
