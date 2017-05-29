/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import DAM.DAMImage;
import Webshop.Customer;
import Webshop.Order;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javafx.scene.image.Image;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kongen
 */
public class DatabaseInterfaceTest {
	
	public DatabaseInterfaceTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of getProduct method, of class DatabaseInterface.
	 */
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int productId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ResultSet expResult = null;
		ResultSet result = instance.getProduct(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProducts method, of class DatabaseInterface.
	 */
	@Test
	public void testGetAllProducts() {
		System.out.println("getAllProducts");
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ResultSet expResult = null;
		ResultSet result = instance.getAllProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class DatabaseInterface.
	 */
	@Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ResultSet expResult = null;
		ResultSet result = instance.findProducts(query);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class DatabaseInterface.
	 */
	@Test
	public void testGetCategories() {
		System.out.println("getCategories");
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		LinkedHashMap<String, Integer> expResult = null;
		LinkedHashMap<String, Integer> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProductsInCategory method, of class DatabaseInterface.
	 */
	@Test
	public void testGetProductsInCategory() {
		System.out.println("getProductsInCategory");
		String category = "";
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ResultSet expResult = null;
		ResultSet result = instance.getProductsInCategory(category);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createOrder method, of class DatabaseInterface.
	 */
	@Test
	public void testCreateOrder() {
		System.out.println("createOrder");
		Order order = null;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.createOrder(order);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createImage method, of class DatabaseInterface.
	 */
	@Test
	public void testCreateImage() {
		System.out.println("createImage");
		String imagePath = "";
		String title = "";
		int category = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		instance.createImage(imagePath, title, category);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImage method, of class DatabaseInterface.
	 */
	@Test
	public void testGetImage() {
		System.out.println("getImage");
		int id = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		Image expResult = null;
		Image result = instance.getImage(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImages method, of class DatabaseInterface.
	 */
	@Test
	public void testGetImages_0args() {
		System.out.println("getImages");
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ArrayList<Image> expResult = null;
		ArrayList<Image> result = instance.getImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImages method, of class DatabaseInterface.
	 */
	@Test
	public void testGetImages_int() {
		System.out.println("getImages");
		int productID = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ArrayList<Image> expResult = null;
		ArrayList<Image> result = instance.getImages(productID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDAMImage method, of class DatabaseInterface.
	 */
	@Test
	public void testGetDAMImage() {
		System.out.println("getDAMImage");
		int id = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		DAMImage expResult = null;
		DAMImage result = instance.getDAMImage(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDAMImages method, of class DatabaseInterface.
	 */
	@Test
	public void testGetDAMImages() {
		System.out.println("getDAMImages");
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ArrayList<DAMImage> expResult = null;
		ArrayList<DAMImage> result = instance.getAllImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteImage method, of class DatabaseInterface.
	 */
	@Test
	public void testDeleteImage() {
		System.out.println("deleteImage");
		int id = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		instance.deleteImage(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createCustomer method, of class DatabaseInterface.
	 */
	@Test
	public void testCreateCustomer() {
		System.out.println("createCustomer");
		String email = "";
		String code = "";
		String firstName = "";
		String lastName = "";
		int phoneNumber = 0;
		int mobilePhoneNumber = 0;
		String address = "";
		String postalCode = "";
		String city = "";
		String country = "";
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.createCustomer(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCustomer method, of class DatabaseInterface.
	 */
	@Test
	public void testGetCustomer() {
		System.out.println("getCustomer");
		String email = "";
		String code = "";
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		Customer expResult = null;
		Customer result = instance.getCustomer(email, code);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProduct method, of class DatabaseInterface.
	 */
	@Test
	public void testAddProduct() {
		System.out.println("addProduct");
		int category = 0;
		double price = 0.0;
		String description = "";
		String titel = "";
		ArrayList<Integer> imageList = null;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		instance.createProduct(category, price, description, titel, imageList);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	public class DatabaseInterfaceImpl implements DatabaseInterface {

		public ResultSet getProduct(int productId) {
			return null;
		}

		public ResultSet getAllProducts() {
			return null;
		}

		public ResultSet findProducts(String query) {
			return null;
		}

		public LinkedHashMap<String, Integer> getCategories() {
			return null;
		}

		public ResultSet getProductsInCategory(String category) {
			return null;
		}

		public boolean createOrder(Order order) {
			return false;
		}

		public void createImage(String imagePath, String title, int category) {
		}

		public Image getImage(int id) {
			return null;
		}

		public ArrayList<Image> getImages() {
			return null;
		}

		public ArrayList<Image> getImages(int productID) {
			return null;
		}

		public DAMImage getDAMImage(int id) {
			return null;
		}

		public ArrayList<DAMImage> getAllImages() {
			return null;
		}

		public void deleteImage(int id) {
		}

		public boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country) {
			return false;
		}

		public Customer getCustomer(String email, String code) {
			return null;
		}

		public void createProduct(int category, double price, String description, String titel, ArrayList<Integer> imageList) {
		}
	}
	
}
