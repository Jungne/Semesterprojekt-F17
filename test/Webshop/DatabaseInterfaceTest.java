/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

import DBManager.DatabaseInterface;
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
		Product expResult = null;
		Product result = instance.getProduct(productId);
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
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getAllProducts();
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
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.findProducts(query);
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
		TreeSet<String> expResult = null;
		TreeSet<String> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProductsInCategory method, of class DatabaseInterface.
	 */
	@Test
	public void testGetCategory() {
		System.out.println("getCategory");
		String category = "";
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getProductsInCategory(category);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of saveOrder method, of class DatabaseInterface.
	 */
	@Test
	public void testSaveOrder() {
		System.out.println("saveOrder");
		Order order = null;
		DatabaseInterface instance = new DatabaseInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.createOrder(order);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	public class DatabaseInterfaceImpl implements DatabaseInterface {

		public Product getProduct(int productId) {
			return null;
		}

		public ArrayList<Product> getAllProducts() {
			return null;
		}

		public ArrayList<Product> findProducts(String query) {
			return null;
		}

		public TreeSet<String> getCategories() {
			return null;
		}

		public ArrayList<Product> getProductsInCategory(String category) {
			return null;
		}

		public boolean createOrder(Order order) {
			return false;
		}
	}
	
}
