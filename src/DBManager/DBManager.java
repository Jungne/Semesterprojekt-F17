package DBManager;

import Webshop.DatabaseInterface;
import Webshop.Order;
import Webshop.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author jungn
 */
public class DBManager implements DatabaseInterface {

    private static DBManager dbManager = null;
    
    private Connection con;
    private ProductHandler productHandler;

    private DBManager() {
	productHandler = new ProductHandler();

	String url = "jdbc:postgresql://localhost:5432/semesterprojekt";
	String user = "postgres";
	String password = "1234";
	try {
	    Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    return;
	}

	con = null;
	try {
	    con = DriverManager.getConnection(url, user, password);
	    System.out.println("Connection to database successful!");

	} catch (SQLException ex) {
	    System.out.println("Connection to database failed.");
	}
    }

    public static DBManager getInstance() {
	if (dbManager == null) {
	    dbManager = new DBManager();
	}
	return dbManager;
    }
    
    @Override
    public Product getProduct(int productId) {
	Product product = null;
	try {
	    PreparedStatement ps = con.prepareStatement("SELECT product.name, product.id, category.name, description, price\n"
		    + "FROM product, category\n"
		    + "WHERE category.id = categoryid AND product.id = " + productId);
	    ResultSet components = ps.executeQuery();
	    product = productHandler.getProduct(components);

	} catch (SQLException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	return product;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
	ArrayList<Product> products = null;
	try {
	    PreparedStatement ps = con.prepareStatement("SELECT product.name, product.id, category.name, description, price\n"
		    + "FROM product, category\n"
		    + "WHERE category.id = categoryid");
	    ResultSet components = ps.executeQuery();
	    products = productHandler.getProducts(components);

	} catch (SQLException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	return products;
    }

    @Override
    public ArrayList<Product> findProducts(String query) {
	ArrayList<Product> products = null;
	try {
	    PreparedStatement ps = con.prepareStatement("SELECT product.name, product.id, category.name, description, price\n"
		    + "FROM Products\n"
		    + "WHERE LOWER(name) LIKE '%" + query.toLowerCase() + "%'");
	    ResultSet components = ps.executeQuery();
	    products = productHandler.getProducts(components);

	} catch (SQLException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	return products;
    }

    @Override
    public TreeSet<String> getCategories() {
	TreeSet<String> categories = null;
	try {
	    PreparedStatement ps = con.prepareStatement("SELECT category FROM Products");
	    ResultSet components = ps.executeQuery();
	    categories = productHandler.getCategories(components);

	} catch (SQLException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	    System.out.println("Error");
	}
	return categories;
    }

    @Override
    public ArrayList<Product> getCategory(String category) {
	ArrayList<Product> products = null;
	try {
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM Products WHERE LOWER(category) = '" + category.toLowerCase() + "'");
	    ResultSet components = ps.executeQuery();
	    products = productHandler.getProducts(components);

	} catch (SQLException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	    System.out.println("error");
	} catch (IOException ex) {
	    Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	return products;
    }

    @Override
    public boolean saveOrder(Order order) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	/**
	 * This method is made for testing. To save images in a relationel database.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		DBManager manager = DBManager.getInstance();

		//manager.setUpImageTable();
		//manager.deleteImageTable();
		//manager.addImage("src/images/blender.jpeg");
	}

	public void setUpImageTable() {
		try {
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS imageTest ("
							+ "name varchar(15),"
							+ "image bytea"
							+ ");";
			statement.execute(sql);
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void deleteImageTable() {
		try {
			Statement statement = con.createStatement();
			String sql = "DROP TABLE imageTest;";
			statement.execute(sql);
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void addImage(String imagePath) {
		try {
			String sql = "INSERT INTO imageTest VALUES (?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "someName");

			InputStream input = new FileInputStream(new File(imagePath));
			ps.setBinaryStream(2, input);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Image getImage() {
		Image image = null;
		try {
			String sql = "SELECT image FROM imageTest WHERE name='someName'";
			Statement s = con.createStatement();
			ResultSet resulstSet = s.executeQuery(sql);
			resulstSet.next();
			InputStream x = resulstSet.getBinaryStream("image");
			image = new Image(x);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return image;
	}
}
