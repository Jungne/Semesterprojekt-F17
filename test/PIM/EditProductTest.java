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
	 * Test of newProduct method, of class EditProduct.
	 */
	@Test
	public void testNewProduct() {
		System.out.println("newProduct");
		int category = 0;
		double price = 0.0;
		String description = "";
		String titel = "";
		ArrayList<Integer> imageList = null;
		EditProduct instance = new EditProduct();
		instance.newProduct(category, price, description, titel, imageList);
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
		EditProduct instance = new EditProduct();
		instance.editProduct(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
