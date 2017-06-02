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
 * @author Daniel
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
	@org.junit.Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int productId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getProduct(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProducts method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetAllProducts() {
		System.out.println("getAllProducts");
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getAllProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllEnrichedProducts method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetAllEnrichedProducts() {
		System.out.println("getAllEnrichedProducts");
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getAllEnrichedProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		int categoryID = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.findProducts(query, categoryID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class DatabaseInterface.
	 */
	@org.junit.Test
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
	 * Test of getDAMImage method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetDAMImage() {
		System.out.println("getDAMImage");
		int imageId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getDAMImage(imageId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImage method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetImage() {
		System.out.println("getImage");
		int imageID = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		byte[] expResult = null;
		byte[] result = instance.getImage(imageID);
		assertArrayEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImages method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetImages() {
		System.out.println("getImages");
		int productID = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ArrayList expResult = null;
		ArrayList result = instance.getImages(productID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllImages method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetAllImages() {
		System.out.println("getAllImages");
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getAllImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUnassignedImages method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetUnassignedImages() {
		System.out.println("getUnassignedImages");
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getUnassignedImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPImages method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetPImages() {
		System.out.println("getPImages");
		int productId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getPImages(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createProduct method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testCreateProduct() {
		System.out.println("createProduct");
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.createProduct(name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of editProduct method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testEditProduct() {
		System.out.println("editProduct");
		int productID = 0;
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.editProduct(productID, name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createImage method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testCreateImage() {
		System.out.println("createImage");
		String name = "";
		String category = "";
		InputStream imageFile = null;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.createImage(name, category, imageFile);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteImage method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testDeleteImage() {
		System.out.println("deleteImage");
		int imageId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.deleteImage(imageId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCustomerId method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetCustomerId() {
		System.out.println("getCustomerId");
		String email = "";
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		int expResult = 0;
		int result = instance.getCustomerId(email);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCustomer method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetCustomer() {
		System.out.println("getCustomer");
		String email = "";
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getCustomer(email);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getBasketIds method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetBasketIds() {
		System.out.println("getBasketIds");
		int customerId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ArrayList<Integer> expResult = null;
		ArrayList<Integer> result = instance.getBasketIds(customerId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getBasketsOrderLines method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetBasketsOrderLines() {
		System.out.println("getBasketsOrderLines");
		int basketId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getBasketsOrderLines(basketId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createCustomer method, of class DatabaseInterface.
	 */
	@org.junit.Test
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
	 * Test of createBasket method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testCreateBasket() {
		System.out.println("createBasket");
		int customerId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		instance.createBasket(customerId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeBasket method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testRemoveBasket() {
		System.out.println("removeBasket");
		int basketId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		instance.removeBasket(basketId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProductToBasket method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testAddProductToBasket() {
		System.out.println("addProductToBasket");
		int basketId = 0;
		int productId = 0;
		int amount = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.addProductToBasket(basketId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setProductAmount method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testSetProductAmount() {
		System.out.println("setProductAmount");
		int basketId = 0;
		int productId = 0;
		int amount = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.setProductAmount(basketId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeProduct method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testRemoveProduct() {
		System.out.println("removeProduct");
		int basketId = 0;
		int productId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		instance.removeProduct(basketId, productId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of emptyBasket method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testEmptyBasket() {
		System.out.println("emptyBasket");
		int basketId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		instance.emptyBasket(basketId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLatestOrder method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetLatestOrder() {
		System.out.println("getLatestOrder");
		int customerId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getLatestOrder(customerId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getOrdersOrderLines method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testGetOrdersOrderLines() {
		System.out.println("getOrdersOrderLines");
		int orderId = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getOrdersOrderLines(orderId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createOrder method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testCreateOrder() {
		System.out.println("createOrder");
		int customerId = 0;
		String orderStatus = "";
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.createOrder(customerId, orderStatus);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProductToOrder method, of class DatabaseInterface.
	 */
	@org.junit.Test
	public void testAddProductToOrder() {
		System.out.println("addProductToOrder");
		int orderId = 0;
		int productId = 0;
		int amount = 0;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.addProductToOrder(orderId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	public class DatabaseInterfaceImpl implements DatabaseInterface {

		public HashMap<String, String> getProduct(int productId) {
			return null;
		}

		public LinkedList<HashMap<String, String>> getAllProducts() {
			return null;
		}

		public LinkedList<HashMap<String, String>> getAllEnrichedProducts() {
			return null;
		}

		public LinkedList<HashMap<String, String>> findProducts(String query, int categoryID) {
			return null;
		}

		public LinkedHashMap<String, Integer> getCategories() {
			return null;
		}

		public HashMap<String, String> getDAMImage(int imageId) {
			return null;
		}

		public byte[] getImage(int imageID) {
			return null;
		}

		public ArrayList<byte[]> getImages(int productID) {
			return null;
		}

		public LinkedList<HashMap<String, String>> getAllImages() {
			return null;
		}

		public LinkedList<HashMap<String, String>> getUnassignedImages() {
			return null;
		}

		public LinkedList<HashMap<String, String>> getPImages(int productId) {
			return null;
		}

		public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
			return false;
		}

		public boolean editProduct(int productID, String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
			return false;
		}

		public boolean createImage(String name, String category, InputStream imageFile) {
			return false;
		}

		public boolean deleteImage(int imageId) {
			return false;
		}

		public int getCustomerId(String email) {
			return 0;
		}

		public HashMap<String, String> getCustomer(String email) {
			return null;
		}

		public ArrayList<Integer> getBasketIds(int customerId) {
			return null;
		}

		public LinkedList<HashMap<String, String>> getBasketsOrderLines(int basketId) {
			return null;
		}

		public boolean createCustomer(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country) {
			return false;
		}

		public void createBasket(int customerId) {
		}

		public void removeBasket(int basketId) {
		}

		public boolean addProductToBasket(int basketId, int productId, int amount) {
			return false;
		}

		public boolean setProductAmount(int basketId, int productId, int amount) {
			return false;
		}

		public void removeProduct(int basketId, int productId) {
		}

		public void emptyBasket(int basketId) {
		}

		public HashMap<String, String> getLatestOrder(int customerId) {
			return null;
		}

		public LinkedList<HashMap<String, String>> getOrdersOrderLines(int orderId) {
			return null;
		}

		public boolean createOrder(int customerId, String orderStatus) {
			return false;
		}

		public boolean addProductToOrder(int orderId, int productId, int amount) {
			return false;
		}
	}
	
}
