/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import DAM.DAMImage;
import Webshop.Customer2;
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
public class DBManagerTest {
	
	public DBManagerTest() {
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
	 * Test of getInstance method, of class DBManager.
	 */
	@Test
	public void testGetInstance() {
		System.out.println("getInstance");
		DBManager expResult = null;
		DBManager result = DBManager.getInstance();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProduct method, of class DBManager.
	 */
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int productID = 0;
		DBManager instance = null;
		ResultSet expResult = null;
		ResultSet result = instance.getProduct(productID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProducts method, of class DBManager.
	 */
	@Test
	public void testGetAllProducts() {
		System.out.println("getAllProducts");
		DBManager instance = null;
		ResultSet expResult = null;
		ResultSet result = instance.getAllProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class DBManager.
	 */
	@Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		DBManager instance = null;
		ResultSet expResult = null;
		ResultSet result = instance.findProducts(query);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class DBManager.
	 */
	@Test
	public void testGetCategories() {
		System.out.println("getCategories");
		DBManager instance = null;
		LinkedHashMap<String, Integer> expResult = null;
		LinkedHashMap<String, Integer> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProductsInCategory method, of class DBManager.
	 */
	@Test
	public void testGetProductsInCategory() {
		System.out.println("getProductsInCategory");
		String category = "";
		DBManager instance = null;
		ResultSet expResult = null;
		ResultSet result = instance.getProductsInCategory(category);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProduct method, of class DBManager.
	 */
	@Test
	public void testAddProduct() {
		System.out.println("addProduct");
		int category = 0;
		double price = 0.0;
		String description = "";
		String name = "";
		ArrayList<Integer> imageList = null;
		DBManager instance = null;
		instance.addProduct(category, price, description, name, imageList);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createOrder method, of class DBManager.
	 */
	@Test
	public void testCreateOrder() {
		System.out.println("createOrder");
		Order order = null;
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.createOrder(order);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setUpTables method, of class DBManager.
	 */
	@Test
	public void testSetUpTables() {
		System.out.println("setUpTables");
		DBManager instance = null;
		instance.setUpTables();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of dropTables method, of class DBManager.
	 */
	@Test
	public void testDropTables() {
		System.out.println("dropTables");
		DBManager instance = null;
		instance.dropTables();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of insertData method, of class DBManager.
	 */
	@Test
	public void testInsertData() {
		System.out.println("insertData");
		DBManager instance = null;
		instance.insertData();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createImage method, of class DBManager.
	 */
	@Test
	public void testCreateImage() {
		System.out.println("createImage");
		String imagePath = "";
		String title = "";
		int category = 0;
		DBManager instance = null;
		instance.createImage(imagePath, title, category);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImage method, of class DBManager.
	 */
	@Test
	public void testGetImage() {
		System.out.println("getImage");
		int id = 0;
		DBManager instance = null;
		Image expResult = null;
		Image result = instance.getImage(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImages method, of class DBManager.
	 */
	@Test
	public void testGetImages_0args() {
		System.out.println("getImages");
		DBManager instance = null;
		ArrayList<Image> expResult = null;
		ArrayList<Image> result = instance.getImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImages method, of class DBManager.
	 */
	@Test
	public void testGetImages_int() {
		System.out.println("getImages");
		int productID = 0;
		DBManager instance = null;
		ArrayList<Image> expResult = null;
		ArrayList<Image> result = instance.getImages(productID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDAMImage method, of class DBManager.
	 */
	@Test
	public void testGetDAMImage() {
		System.out.println("getDAMImage");
		int id = 0;
		DBManager instance = null;
		DAMImage expResult = null;
		DAMImage result = instance.getDAMImage(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDAMImages method, of class DBManager.
	 */
	@Test
	public void testGetDAMImages() {
		System.out.println("getDAMImages");
		DBManager instance = null;
		ArrayList<DAMImage> expResult = null;
		ArrayList<DAMImage> result = instance.getDAMImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteImage method, of class DBManager.
	 */
	@Test
	public void testDeleteImage() {
		System.out.println("deleteImage");
		int id = 0;
		DBManager instance = null;
		instance.deleteImage(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createCustomer method, of class DBManager.
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
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.createCustomer(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCustomer method, of class DBManager.
	 */
	@Test
	public void testGetCustomer() {
		System.out.println("getCustomer");
		String email = "";
		String code = "";
		DBManager instance = null;
		Customer2 expResult = null;
		Customer2 result = instance.getCustomer(email, code);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
