/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAM;

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
	 * Test of addImage method, of class DAMManager.
	 */
	@Test
	public void testAddImage() {
		System.out.println("addImage");
		String imagePath = "";
		String title = "";
		int category = 0;
		DAMManager instance = new DAMManager();
		instance.addImage(imagePath, title, category);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImage method, of class DAMManager.
	 */
	@Test
	public void testGetImage() {
		System.out.println("getImage");
		int id = 0;
		DAMManager instance = new DAMManager();
		Image expResult = null;
		Image result = instance.getImage(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImages method, of class DAMManager.
	 */
	@Test
	public void testGetImages() {
		System.out.println("getImages");
		DAMManager instance = new DAMManager();
		ArrayList<Image> expResult = null;
		ArrayList<Image> result = instance.getImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDAMImage method, of class DAMManager.
	 */
	@Test
	public void testGetDAMImage() {
		System.out.println("getDAMImage");
		int id = 0;
		DAMManager instance = new DAMManager();
		DAMImage expResult = null;
		DAMImage result = instance.getDAMImage(id);
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
		int id = 0;
		DAMManager instance = new DAMManager();
		instance.deleteImage(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
