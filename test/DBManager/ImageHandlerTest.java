/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import DAM.DAMImage;
import java.sql.Connection;
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
	 * Test of createImage method, of class ImageHandler.
	 */
	@Test
	public void testCreateImage() {
		System.out.println("createImage");
		Connection connection = null;
		String imagePath = "";
		String title = "";
		int categoryid = 0;
		ImageHandler.createImage(connection, imagePath, title, categoryid);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImage method, of class ImageHandler.
	 */
	@Test
	public void testGetImage() {
		System.out.println("getImage");
		Connection connection = null;
		int id = 0;
		Image expResult = null;
		Image result = ImageHandler.getImage(connection, id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImages method, of class ImageHandler.
	 */
	@Test
	public void testGetImages_Connection() {
		System.out.println("getImages");
		Connection connection = null;
		ArrayList<Image> expResult = null;
		ArrayList<Image> result = ImageHandler.getImages(connection);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImages method, of class ImageHandler.
	 */
	@Test
	public void testGetImages_Connection_int() {
		System.out.println("getImages");
		Connection connection = null;
		int productID = 0;
		ArrayList<Image> expResult = null;
		ArrayList<Image> result = ImageHandler.getImages(connection, productID);
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
		Connection connection = null;
		int id = 0;
		DAMImage expResult = null;
		DAMImage result = ImageHandler.getDAMImage(connection, id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDAMImages method, of class ImageHandler.
	 */
	@Test
	public void testGetDAMImages() {
		System.out.println("getDAMImages");
		Connection connection = null;
		ArrayList<DAMImage> expResult = null;
		ArrayList<DAMImage> result = ImageHandler.getDAMImages(connection);
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
		Connection connection = null;
		int id = 0;
		ImageHandler.deleteImage(connection, id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
