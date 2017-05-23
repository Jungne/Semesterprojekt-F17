package DAM;

import java.io.InputStream;
import javafx.scene.image.Image;

public class DAMImage {

	private String title;
	private int id;
	private String category;
	private Image image;
	private int productID;

	public DAMImage(String title, int id, String category, Image image, int productID) {
		this.title = title;
		this.id = id;
		this.category = category;
		this.image = image;
		this.productID = productID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}
	
	public int getProductID() {
	    return productID;
	}
	
	@Override
	public String toString() {
	    return "ID: " + id + "\nTitle: " + title + "\nCategory: " + category + "\nProduct ID: " +productID;
	}
}
