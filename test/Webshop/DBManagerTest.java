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
	 * Test of getProduct method, of class FileManager.
	 */
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int productId = 0;
		FileManager instance = new FileManager();
		Product expResult = null;
		Product result = instance.getProduct(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProducts method, of class FileManager.
	 */
	@Test
	public void testGetAllProducts() {
		System.out.println("getAllProducts");
		FileManager instance = new FileManager();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getAllProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class FileManager.
	 */
	@Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		FileManager instance = new FileManager();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.findProducts(query);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class FileManager.
	 */
	@Test
	public void testGetCategories() {
		System.out.println("getCategories");
		FileManager instance = new FileManager();
		TreeSet<String> expResult = null;
		TreeSet<String> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategory method, of class FileManager.
	 */
	@Test
	public void testGetCategory() {
		System.out.println("getCategory");
		String category = "";
		FileManager instance = new FileManager();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getCategory(category);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of saveOrder method, of class FileManager.
	 */
	@Test
	public void testSaveOrder() {
		System.out.println("saveOrder");
		Order order = null;
		FileManager instance = new FileManager();
		boolean expResult = false;
		boolean result = instance.saveOrder(order);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
