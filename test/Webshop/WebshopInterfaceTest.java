/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

import java.util.ArrayList;
import java.util.TreeSet;
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
public class WebshopInterfaceTest {

	public WebshopInterfaceTest() {
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
	 * Test of findProducts method, of class WebshopInterface.
	 */
	@Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		WebshopInterface instance = new WebshopInterfaceImpl();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.findProducts(query);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class WebshopInterface.
	 */
	@Test
	public void testGetCategories() {
		System.out.println("getCategories");
		WebshopInterface instance = new WebshopInterfaceImpl();
		TreeSet<String> expResult = null;
		TreeSet<String> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategory method, of class WebshopInterface.
	 */
	@Test
	public void testGetCategory() {
		System.out.println("getCategory");
		String category = "";
		WebshopInterface instance = new WebshopInterfaceImpl();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getCategory(category);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProduct method, of class WebshopInterface.
	 */
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int id = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		Product expResult = null;
		Product result = instance.getProduct(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProduct method, of class WebshopInterface.
	 */
	@Test
	public void testGetAllProduct() {
		System.out.println("getAllProduct");
		WebshopInterface instance = new WebshopInterfaceImpl();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getAllProduct();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class WebshopInterface.
	 */
	@Test
	public void testCheckOut_0args() {
		System.out.println("checkOut");
		WebshopInterface instance = new WebshopInterfaceImpl();
		Order expResult = null;
		Order result = instance.checkOut();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class WebshopInterface.
	 */
	@Test
	public void testCheckOut_4args() {
		System.out.println("checkOut");
		String name = "";
		String email = "";
		int phoneNumber = 0;
		ShoppingBasket shoppingBasket = null;
		WebshopInterface instance = new WebshopInterfaceImpl();
		Order expResult = null;
		Order result = instance.checkOut(name, email, phoneNumber, shoppingBasket);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProductToBasket method, of class WebshopInterface.
	 */
	@Test
	public void testAddProductToBasket() {
		System.out.println("addProductToBasket");
		int productId = 0;
		int amount = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.addProductToBasket(productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeProduct method, of class WebshopInterface.
	 */
	@Test
	public void testRemoveProduct() {
		System.out.println("removeProduct");
		int productId = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		instance.removeProduct(productId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setProductAmount method, of class WebshopInterface.
	 */
	@Test
	public void testSetProductAmount() {
		System.out.println("setProductAmount");
		int productId = 0;
		int amount = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.setProductAmount(productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getShoppingBasket method, of class WebshopInterface.
	 */
	@Test
	public void testGetShoppingBasket() {
		System.out.println("getShoppingBasket");
		WebshopInterface instance = new WebshopInterfaceImpl();
		ShoppingBasket expResult = null;
		ShoppingBasket result = instance.getShoppingBasket();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of emptyShoppingBasket method, of class WebshopInterface.
	 */
	@Test
	public void testEmptyShoppingBasket() {
		System.out.println("emptyShoppingBasket");
		WebshopInterface instance = new WebshopInterfaceImpl();
		instance.emptyShoppingBasket();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	public class WebshopInterfaceImpl implements WebshopInterface {

		public ArrayList<Product> findProducts(String query) {
			return null;
		}

		public TreeSet<String> getCategories() {
			return null;
		}

		public ArrayList<Product> getCategory(String category) {
			return null;
		}

		public Product getProduct(int id) {
			return null;
		}

		public ArrayList<Product> getAllProduct() {
			return null;
		}

		public Order checkOut() {
			return null;
		}

		public Order checkOut(String name, String email, int phoneNumber, ShoppingBasket shoppingBasket) {
			return null;
		}

		public boolean addProductToBasket(int productId, int amount) {
			return false;
		}

		public void removeProduct(int productId) {
		}

		public boolean setProductAmount(int productId, int amount) {
			return false;
		}

		public ShoppingBasket getShoppingBasket() {
			return null;
		}

		public void emptyShoppingBasket() {
		}
	}

}
