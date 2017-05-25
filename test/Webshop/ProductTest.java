/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

import java.util.ArrayList;
import javafx.scene.image.Image;
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
public class ProductTest {
	
	public ProductTest() {
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
	 * Test of loadImage method, of class Product.
	 */
	@Test
	public void testLoadImage() throws Exception {
		System.out.println("loadImage");
		Product instance = null;
		instance.loadImage();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class Product.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Product instance = null;
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getId method, of class Product.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Product instance = null;
		int expResult = 0;
		int result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategory method, of class Product.
	 */
	@Test
	public void testGetCategory() {
		System.out.println("getCategory");
		Product instance = null;
		String expResult = "";
		String result = instance.getCategory();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDescription method, of class Product.
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		Product instance = null;
		String expResult = "";
		String result = instance.getDescription();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPrice method, of class Product.
	 */
	@Test
	public void testGetPrice() {
		System.out.println("getPrice");
		Product instance = null;
		double expResult = 0.0;
		double result = instance.getPrice();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImagePath method, of class Product.
	 */
	@Test
	public void testGetImagePath() {
		System.out.println("getImagePath");
		Product instance = null;
		String expResult = "";
		String result = instance.getImagePath();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class Product.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Product instance = null;
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of equals method, of class Product.
	 */
	@Test
	public void testEquals() {
		System.out.println("equals");
		Product product = null;
		Product instance = null;
		boolean expResult = false;
		boolean result = instance.equals(product);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImageList method, of class Product.
	 */
	@Test
	public void testGetImageList() {
		System.out.println("getImageList");
		Product instance = null;
		ArrayList<Image> expResult = null;
		ArrayList<Image> result = instance.getImageList();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
