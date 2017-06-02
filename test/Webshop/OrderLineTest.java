/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

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
public class OrderLineTest {
	
	public OrderLineTest() {
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
	 * Test of getProduct method, of class OrderLine.
	 */
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		OrderLine instance = null;
		Product expResult = null;
		Product result = instance.getProduct();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAmount method, of class OrderLine.
	 */
	@Test
	public void testGetAmount() {
		System.out.println("getAmount");
		OrderLine instance = null;
		int expResult = 0;
		int result = instance.getAmount();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setAmount method, of class OrderLine.
	 */
	@Test
	public void testSetAmount() {
		System.out.println("setAmount");
		int amount = 0;
		OrderLine instance = null;
		instance.setAmount(amount);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
