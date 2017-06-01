/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAM;

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
public class DAMManagerTest {
	
	public DAMManagerTest() {
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
	 * Test of createImage method, of class DAMManager.
	 */
	@Test
	public void testCreateImage() {
		System.out.println("createImage");
		String name = "";
		String category = "";
		String imagePath = "";
		DAMManager instance = new DAMManager();
		boolean expResult = false;
		boolean result = instance.createImage(name, category, imagePath);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDAMImages method, of class DAMManager.
	 */
	@Test
	public void testGetDAMImages() {
		System.out.println("getDAMImages");
		DAMManager instance = new DAMManager();
		ArrayList<DAMImage> expResult = null;
		ArrayList<DAMImage> result = instance.getDAMImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteImage method, of class DAMManager.
	 */
	@Test
	public void testDeleteImage() {
		System.out.println("deleteImage");
		int imageId = 0;
		DAMManager instance = new DAMManager();
		boolean expResult = false;
		boolean result = instance.deleteImage(imageId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
