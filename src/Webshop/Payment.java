package Webshop;

import java.util.Date;

public class Payment {

	int amount;
	Date date;

	public Payment(int amount) {
		this.amount = amount;
		date = new Date();
	}

	public void pay(Order order, Customer customer) {
		//TODO
	}

}
