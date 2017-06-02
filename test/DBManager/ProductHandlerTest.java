/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import java.sql.ResultSet;
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
public class ProductHandlerTest {
	
	public ProductHandlerTest() {
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
	 * Test of getProduct method, of class ProductHandler.
	 */
	@org.junit.Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int productID = 0;
		ProductHandler instance = null;
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getProduct(productID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProducts method, of class ProductHandler.
	 */
	@org.junit.Test
	public void testGetAllProducts() {
		System.out.println("getAllProducts");
		ProductHandler instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getAllProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllEnrichedProducts method, of class ProductHandler.
	 */
	@org.junit.Test
	public void testGetAllEnrichedProducts() {
		System.out.println("getAllEnrichedProducts");
		ProductHandler instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getAllEnrichedProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class ProductHandler.
	 */
	@org.junit.Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		int categoryID = 0;
		ProductHandler instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.findProducts(query, categoryID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class ProductHandler.
	 */
	@org.junit.Test
	public void testGetCategories() {
		System.out.println("getCategories");
		ProductHandler instance = null;
		LinkedHashMap<String, Integer> expResult = null;
		LinkedHashMap<String, Integer> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createProduct method, of class ProductHandler.
	 */
	@org.junit.Test
	public void testCreateProduct() {
		System.out.println("createProduct");
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		ProductHandler instance = null;
		boolean expResult = false;
		boolean result = instance.createProduct(name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of editProduct method, of class ProductHandler.
	 */
	@org.junit.Test
	public void testEditProduct() {
		System.out.println("editProduct");
		int productId = 0;
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		ProductHandler instance = null;
		boolean expResult = false;
		boolean result = instance.editProduct(productId, name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of mapProduct method, of class ProductHandler.
	 */
	@org.junit.Test
	public void testMapProduct() {
		System.out.println("mapProduct");
		ResultSet productsResultSet = null;
		ProductHandler instance = null;
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.mapProduct(productsResultSet);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of mapProducts method, of class ProductHandler.
	 */
	@org.junit.Test
	public void testMapProducts() {
		System.out.println("mapProducts");
		ResultSet productsResultSet = null;
		ProductHandler instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.mapProducts(productsResultSet);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
