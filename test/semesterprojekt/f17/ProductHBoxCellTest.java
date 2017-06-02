/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt.f17;

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
public class ProductHBoxCellTest {
	
	public ProductHBoxCellTest() {
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
	 * Test of getProductId method, of class ProductHBoxCell.
	 */
	@org.junit.Test
	public void testGetProductId() {
		System.out.println("getProductId");
		ProductHBoxCell instance = null;
		int expResult = 0;
		int result = instance.getProductId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getImageId method, of class ProductHBoxCell.
	 */
	@org.junit.Test
	public void testGetImageId() {
		System.out.println("getImageId");
		ProductHBoxCell instance = null;
		int expResult = 0;
		int result = instance.getImageId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class ProductHBoxCell.
	 */
	@org.junit.Test
	public void testToString() {
		System.out.println("toString");
		ProductHBoxCell instance = null;
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
