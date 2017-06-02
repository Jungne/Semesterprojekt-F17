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
public class PIMProductTest {
	
	public PIMProductTest() {
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
	 * Test of getId method, of class PIMProduct.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		PIMProduct instance = null;
		int expResult = 0;
		int result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class PIMProduct.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		PIMProduct instance = null;
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategory method, of class PIMProduct.
	 */
	@Test
	public void testGetCategory() {
		System.out.println("getCategory");
		PIMProduct instance = null;
		String expResult = "";
		String result = instance.getCategory();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDescription method, of class PIMProduct.
	 */
	@Test
	public void testGetDescription() {
		System.out.println("getDescription");
		PIMProduct instance = null;
		String expResult = "";
		String result = instance.getDescription();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPrice method, of class PIMProduct.
	 */
	@Test
	public void testGetPrice() {
		System.out.println("getPrice");
		PIMProduct instance = null;
		double expResult = 0.0;
		double result = instance.getPrice();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImageFiles method, of class PIMProduct.
	 */
	@Test
	public void testGetImageFiles() {
		System.out.println("getImageFiles");
		PIMProduct instance = null;
		ArrayList expResult = null;
		ArrayList result = instance.getImageFiles();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
