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
 * @author Daniel
 */
public class PIMManagerTest {
	
	public PIMManagerTest() {
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
	 * Test of getInstance method, of class PIMManager.
	 */
	@org.junit.Test
	public void testGetInstance() {
		System.out.println("getInstance");
		PIMManager expResult = null;
		PIMManager result = PIMManager.getInstance();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProducts method, of class PIMManager.
	 */
	@org.junit.Test
	public void testGetAllProducts() {
		System.out.println("getAllProducts");
		PIMManager instance = null;
		ArrayList<PIMProduct> expResult = null;
		ArrayList<PIMProduct> result = instance.getAllProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createProduct method, of class PIMManager.
	 */
	@org.junit.Test
	public void testCreateProduct() {
		System.out.println("createProduct");
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		PIMManager instance = null;
		boolean expResult = false;
		boolean result = instance.createProduct(name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of editProduct method, of class PIMManager.
	 */
	@org.junit.Test
	public void testEditProduct() {
		System.out.println("editProduct");
		int productID = 0;
		String name = "";
		String category = "";
		String description = "";
		double price = 0.0;
		ArrayList<Integer> imageIdList = null;
		PIMManager instance = null;
		boolean expResult = false;
		boolean result = instance.editProduct(productID, name, category, description, price, imageIdList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUnassignedPIMages method, of class PIMManager.
	 */
	@org.junit.Test
	public void testGetUnassignedPIMages() {
		System.out.println("getUnassignedPIMages");
		PIMManager instance = null;
		ArrayList<PIMage> expResult = null;
		ArrayList<PIMage> result = instance.getUnassignedPIMages();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPImages method, of class PIMManager.
	 */
	@org.junit.Test
	public void testGetPImages() {
		System.out.println("getPImages");
		int productID = 0;
		PIMManager instance = null;
		ArrayList<PIMage> expResult = null;
		ArrayList<PIMage> result = instance.getPImages(productID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setProductToEdit method, of class PIMManager.
	 */
	@org.junit.Test
	public void testSetProductToEdit() {
		System.out.println("setProductToEdit");
		int productID = 0;
		PIMManager instance = null;
		instance.setProductToEdit(productID);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getProductToEdit method, of class PIMManager.
	 */
	@org.junit.Test
	public void testGetProductToEdit() {
		System.out.println("getProductToEdit");
		PIMManager instance = null;
		PIMProduct expResult = null;
		PIMProduct result = instance.getProductToEdit();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of isEditingProduct method, of class PIMManager.
	 */
	@org.junit.Test
	public void testIsEditingProduct() {
		System.out.println("isEditingProduct");
		PIMManager instance = null;
		boolean expResult = false;
		boolean result = instance.isEditingProduct();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setEditingProduct method, of class PIMManager.
	 */
	@org.junit.Test
	public void testSetEditingProduct() {
		System.out.println("setEditingProduct");
		boolean editingProduct = false;
		PIMManager instance = null;
		instance.setEditingProduct(editingProduct);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
