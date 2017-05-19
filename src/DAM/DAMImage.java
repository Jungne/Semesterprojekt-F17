package DAM;

import java.io.InputStream;

public class DAMImage {

	private String title;
	private int id;
	private String category;
	private InputStream image;

	public DAMImage(String title, int id, String category, InputStream image) {
		this.title = title;
		this.id = id;
		this.category = category;
		this.image = image;
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
	public InputStream getImage() {
		return image;
	}
}
