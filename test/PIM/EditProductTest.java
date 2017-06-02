/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIM;

import java.util.ArrayList;
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
public class EditProductTest {
	
	public EditProductTest() {
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
	 * Test of createProduct method, of class EditProduct.
	 */
	@Test
	public void testCreateProduct() {
		System.out.println("createProduct");
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		boolean expResult = false;
		boolean result = EditProduct.createProduct(name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of editProduct method, of class EditProduct.
	 */
	@Test
	public void testEditProduct() {
		System.out.println("editProduct");
		int id = 0;
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		boolean expResult = false;
		boolean result = EditProduct.editProduct(id, name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
