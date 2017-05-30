package Webshop;

public enum OrderStatus {

	CREATED("Created"), INPROGRESS("In progress"), PAID("Paid"), SENT("Sent"), DELIVERED("Delivered");

	private String statusString;

	OrderStatus(String statusString) {
		this.statusString = statusString;
	}

	@Override
	public String toString() {
		return statusString;
	}

	public static OrderStatus toOrderStaus(String orderStatusString) {
		return OrderStatus.valueOf(orderStatusString.toUpperCase());
	}

}
