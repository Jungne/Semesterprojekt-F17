package DBManager;

import DAM.DAMImage;
import Webshop.Order;
import Webshop.Product;
import java.util.ArrayList;
import java.util.TreeSet;
import javafx.scene.image.Image;

public interface DatabaseInterface {

	//Methods for Catalog:
	public Product getProduct(int productId);

	public ArrayList<Product> getAllProducts();

	public ArrayList<Product> findProducts(String query);

	public TreeSet<String> getCategories();

	public ArrayList<Product> getCategory(String category);

	//Methods for OrderHistory:
	public boolean saveOrder(Order order);

	public void addImage(String imagePath, String title, int category);

	public Image getImage(int id);

	public ArrayList<Image> getImages();

	public DAMImage getDAMImage(int id);

	public ArrayList<DAMImage> getDAMImages();

	public void deleteImage(int id);

}
