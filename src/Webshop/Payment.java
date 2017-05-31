package Webshop;

import java.util.Date;

public class Payment {

	int amount;
	Date date;

	protected Payment(int amount) {
		this.amount = amount;
		date = new Date();
	}

	protected void pay(Order order, Customer customer) {
		//TODO
	}

}
