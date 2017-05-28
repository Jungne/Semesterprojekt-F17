package Webshop;

public class OrderLine {

	private Product product;
	private int amount;

	public OrderLine(Product product, int amount) {
		this.product = product;
		this.amount = amount;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the amount to the given amount. If amount then is less than zero it
	 * becomes zero instead.
	 *
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount < 0 ? 0 : amount;
	}

}
