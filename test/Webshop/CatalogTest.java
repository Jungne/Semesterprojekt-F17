/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
	 * Test of getProduct method, of class Catalog.
	 */
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int productId = 0;
		Product expResult = null;
		Product result = Catalog.getProduct(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProducts method, of class Catalog.
	 */
	@Test
	public void testGetAllProducts() {
		System.out.println("getAllProducts");
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = Catalog.getAllProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllEnrichedProducts method, of class Catalog.
	 */
	@Test
	public void testGetAllEnrichedProducts() {
		System.out.println("getAllEnrichedProducts");
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = Catalog.getAllEnrichedProducts();
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
		LinkedHashMap<String, Integer> expResult = null;
		LinkedHashMap<String, Integer> result = Catalog.getCategories();
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
		int categoryId = 0;
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = Catalog.findProducts(query, categoryId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
