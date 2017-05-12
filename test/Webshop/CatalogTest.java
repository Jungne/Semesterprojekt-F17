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
public class CatalogTest {
	
	public CatalogTest() {
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
	 * Test of getAllProducts method, of class Catalog.
	 */
	@Test
	public void testGetAllProducts() {
		System.out.println("getAllProducts");
		Catalog instance = null;
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getAllProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProduct method, of class Catalog.
	 */
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int productId = 0;
		Catalog instance = null;
		Product expResult = null;
		Product result = instance.getProduct(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class Catalog.
	 */
	@Test
	public void testGetCategories() {
		System.out.println("getCategories");
		Catalog instance = null;
		TreeSet<String> expResult = null;
		TreeSet<String> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategory method, of class Catalog.
	 */
	@Test
	public void testGetCategory() {
		System.out.println("getCategory");
		String category = "";
		Catalog instance = null;
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getCategory(category);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class Catalog.
	 */
	@Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		Catalog instance = null;
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.findProducts(query);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
