/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAM;

import javafx.scene.image.Image;
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
public class DAMImageTest {
	
	public DAMImageTest() {
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
	 * Test of getTitle method, of class DAMImage.
	 */
	@Test
	public void testGetTitle() {
		System.out.println("getTitle");
		DAMImage instance = null;
		String expResult = "";
		String result = instance.getTitle();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getId method, of class DAMImage.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		DAMImage instance = null;
		int expResult = 0;
		int result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategory method, of class DAMImage.
	 */
	@Test
	public void testGetCategory() {
		System.out.println("getCategory");
		DAMImage instance = null;
		String expResult = "";
		String result = instance.getCategory();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImage method, of class DAMImage.
	 */
	@Test
	public void testGetImage() {
		System.out.println("getImage");
		DAMImage instance = null;
		Image expResult = null;
		Image result = instance.getImage();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProductID method, of class DAMImage.
	 */
	@Test
	public void testGetProductID() {
		System.out.println("getProductID");
		DAMImage instance = null;
		int expResult = 0;
		int result = instance.getProductID();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class DAMImage.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		DAMImage instance = null;
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
