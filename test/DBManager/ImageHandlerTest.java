/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
public class ImageHandlerTest {
	
	public ImageHandlerTest() {
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
	 * Test of getImageFile method, of class ImageHandler.
	 */
	@Test
	public void testGetImageFile() {
		System.out.println("getImageFile");
		int imageID = 0;
		ImageHandler instance = null;
		byte[] expResult = null;
		byte[] result = instance.getImageFile(imageID);
		assertArrayEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImageFiles method, of class ImageHandler.
	 */
	@Test
	public void testGetImageFiles() {
		System.out.println("getImageFiles");
		int productID = 0;
		ImageHandler instance = null;
		ArrayList expResult = null;
		ArrayList result = instance.getImageFiles(productID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDAMImage method, of class ImageHandler.
	 */
	@Test
	public void testGetDAMImage() {
		System.out.println("getDAMImage");
		int imageId = 0;
		ImageHandler instance = null;
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getDAMImage(imageId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllImages method, of class ImageHandler.
	 */
	@Test
	public void testGetAllImages() {
		System.out.println("getAllImages");
		ImageHandler instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getAllImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUnassignedImages method, of class ImageHandler.
	 */
	@Test
	public void testGetUnassignedImages() {
		System.out.println("getUnassignedImages");
		ImageHandler instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getUnassignedImages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPImages method, of class ImageHandler.
	 */
	@Test
	public void testGetPImages() {
		System.out.println("getPImages");
		int productId = 0;
		ImageHandler instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getPImages(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createImage method, of class ImageHandler.
	 */
	@Test
	public void testCreateImage() {
		System.out.println("createImage");
		String name = "";
		String category = "";
		InputStream imageFile = null;
		ImageHandler instance = null;
		boolean expResult = false;
		boolean result = instance.createImage(name, category, imageFile);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of deleteImage method, of class ImageHandler.
	 */
	@Test
	public void testDeleteImage() {
		System.out.println("deleteImage");
		int imageId = 0;
		ImageHandler instance = null;
		boolean expResult = false;
		boolean result = instance.deleteImage(imageId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
