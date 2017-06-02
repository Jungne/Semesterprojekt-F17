/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getProduct(productID);
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
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getAllProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllEnrichedProducts method, of class DBManager.
	 */
	@Test
	public void testGetAllEnrichedProducts() {
		System.out.println("getAllEnrichedProducts");
		DBManager instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getAllEnrichedProducts();
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
		int categoryID = 0;
		DBManager instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.findProducts(query, categoryID);
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
	 * Test of createProduct method, of class DBManager.
	 */
	@Test
	public void testCreateProduct() {
		System.out.println("createProduct");
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.createProduct(name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of editProduct method, of class DBManager.
	 */
	@Test
	public void testEditProduct() {
		System.out.println("editProduct");
		int productID = 0;
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.editProduct(productID, name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImage method, of class DBManager.
	 */
	@Test
	public void testGetImage() {
		System.out.println("getImage");
		int imageID = 0;
		DBManager instance = null;
		byte[] expResult = null;
		byte[] result = instance.getImage(imageID);
		assertArrayEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImages method, of class DBManager.
	 */
	@Test
	public void testGetImages() {
		System.out.println("getImages");
		int productID = 0;
		DBManager instance = null;
		ArrayList expResult = null;
		ArrayList result = instance.getImages(productID);
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
		int imageId = 0;
		DBManager instance = null;
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getDAMImage(imageId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllImages method, of class DBManager.
	 */
	@Test
	public void testGetAllImages() {
		System.out.println("getAllImages");
		DBManager instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getAllImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUnassignedImages method, of class DBManager.
	 */
	@Test
	public void testGetUnassignedImages() {
		System.out.println("getUnassignedImages");
		DBManager instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getUnassignedImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPImages method, of class DBManager.
	 */
	@Test
	public void testGetPImages() {
		System.out.println("getPImages");
		int productId = 0;
		DBManager instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getPImages(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createImage method, of class DBManager.
	 */
	@Test
	public void testCreateImage() {
		System.out.println("createImage");
		String name = "";
		String category = "";
		InputStream imageFile = null;
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.createImage(name, category, imageFile);
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
		int imageId = 0;
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.deleteImage(imageId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCustomerId method, of class DBManager.
	 */
	@Test
	public void testGetCustomerId() {
		System.out.println("getCustomerId");
		String email = "";
		DBManager instance = null;
		int expResult = 0;
		int result = instance.getCustomerId(email);
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
		DBManager instance = null;
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getCustomer(email);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getBasketIds method, of class DBManager.
	 */
	@Test
	public void testGetBasketIds() {
		System.out.println("getBasketIds");
		int customerId = 0;
		DBManager instance = null;
		ArrayList<Integer> expResult = null;
		ArrayList<Integer> result = instance.getBasketIds(customerId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getBasketsOrderLines method, of class DBManager.
	 */
	@Test
	public void testGetBasketsOrderLines() {
		System.out.println("getBasketsOrderLines");
		int basketId = 0;
		DBManager instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getBasketsOrderLines(basketId);
		assertEquals(expResult, result);
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
	 * Test of createBasket method, of class DBManager.
	 */
	@Test
	public void testCreateBasket() {
		System.out.println("createBasket");
		int customerId = 0;
		DBManager instance = null;
		instance.createBasket(customerId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeBasket method, of class DBManager.
	 */
	@Test
	public void testRemoveBasket() {
		System.out.println("removeBasket");
		int basketId = 0;
		DBManager instance = null;
		instance.removeBasket(basketId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProductToBasket method, of class DBManager.
	 */
	@Test
	public void testAddProductToBasket() {
		System.out.println("addProductToBasket");
		int basketId = 0;
		int productId = 0;
		int amount = 0;
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.addProductToBasket(basketId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setProductAmount method, of class DBManager.
	 */
	@Test
	public void testSetProductAmount() {
		System.out.println("setProductAmount");
		int basketId = 0;
		int productId = 0;
		int amount = 0;
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.setProductAmount(basketId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeProduct method, of class DBManager.
	 */
	@Test
	public void testRemoveProduct() {
		System.out.println("removeProduct");
		int basketId = 0;
		int productId = 0;
		DBManager instance = null;
		instance.removeProduct(basketId, productId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of emptyBasket method, of class DBManager.
	 */
	@Test
	public void testEmptyBasket() {
		System.out.println("emptyBasket");
		int basketId = 0;
		DBManager instance = null;
		instance.emptyBasket(basketId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLatestOrder method, of class DBManager.
	 */
	@Test
	public void testGetLatestOrder() {
		System.out.println("getLatestOrder");
		int customerId = 0;
		DBManager instance = null;
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getLatestOrder(customerId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getOrdersOrderLines method, of class DBManager.
	 */
	@Test
	public void testGetOrdersOrderLines() {
		System.out.println("getOrdersOrderLines");
		int orderId = 0;
		DBManager instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getOrdersOrderLines(orderId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createOrder method, of class DBManager.
	 */
	@Test
	public void testCreateOrder() {
		System.out.println("createOrder");
		int customerId = 0;
		String orderStatus = "";
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.createOrder(customerId, orderStatus);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProductToOrder method, of class DBManager.
	 */
	@Test
	public void testAddProductToOrder() {
		System.out.println("addProductToOrder");
		int orderId = 0;
		int productId = 0;
		int amount = 0;
		DBManager instance = null;
		boolean expResult = false;
		boolean result = instance.addProductToOrder(orderId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
