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
public class OrderHistoryTest {
	
	public OrderHistoryTest() {
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
	 * Test of createOrder method, of class OrderHistory.
	 */
	@Test
	public void testCreateOrder() {
		System.out.println("createOrder");
		Customer customer = null;
		ShoppingBasket shoppingBasket = null;
		boolean expResult = false;
		boolean result = OrderHistory.createOrder(customer, shoppingBasket);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLatestOrder method, of class OrderHistory.
	 */
	@Test
	public void testGetLatestOrder() {
		System.out.println("getLatestOrder");
		Customer customer = null;
		Order expResult = null;
		Order result = OrderHistory.getLatestOrder(customer);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
