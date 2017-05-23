package Webshop;

<<<<<<< Updated upstream
=======
import java.io.File;
import java.sql.ResultSet;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

	public Image getImage();
=======
	
	public ResultSet getImages();
>>>>>>> Stashed changes

}
