/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
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
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		Connection connection = null;
		int productID = 0;
		ProductHandler instance = new ProductHandler();
		ResultSet expResult = null;
		ResultSet result = instance.getProduct(connection, productID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProducts method, of class ProductHandler.
	 */
	@Test
	public void testGetAllProducts() {
		System.out.println("getAllProducts");
		Connection connection = null;
		ProductHandler instance = new ProductHandler();
		ResultSet expResult = null;
		ResultSet result = instance.getAllProducts(connection);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class ProductHandler.
	 */
	@Test
	public void testFindProducts() {
		System.out.println("findProducts");
		Connection connection = null;
		String query = "";
		ProductHandler instance = new ProductHandler();
		ResultSet expResult = null;
		ResultSet result = instance.findProducts(connection, query);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class ProductHandler.
	 */
	@Test
	public void testGetCategories() {
		System.out.println("getCategories");
		Connection connection = null;
		ProductHandler instance = new ProductHandler();
		LinkedHashMap<String, Integer> expResult = null;
		LinkedHashMap<String, Integer> result = instance.getCategories(connection);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProductsInCategory method, of class ProductHandler.
	 */
	@Test
	public void testGetProductsInCategory() {
		System.out.println("getProductsInCategory");
		Connection connection = null;
		String category = "";
		ProductHandler instance = new ProductHandler();
		ResultSet expResult = null;
		ResultSet result = instance.getProductsInCategory(connection, category);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProduct method, of class ProductHandler.
	 */
	@Test
	public void testAddProduct() {
		System.out.println("addProduct");
		Connection connection = null;
		int category = 0;
		double price = 0.0;
		String description = "";
		String name = "";
		ArrayList<Integer> imageList = null;
		ProductHandler instance = new ProductHandler();
		instance.addProduct(connection, category, price, description, name, imageList);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
