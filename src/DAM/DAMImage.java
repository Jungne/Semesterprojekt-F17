package DAM;

public class DAMImage {

	private int id;
	private String name;
	private String category;
	private byte[] imageFile;

	public DAMImage(int id, String name, String category, byte[] imageFile) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.imageFile = imageFile;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the imageFile
	 */
	public byte[] getImageFile() {
		return imageFile;
	}

}
