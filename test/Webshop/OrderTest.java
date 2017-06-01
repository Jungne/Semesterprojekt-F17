/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

import java.util.Date;
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
public class OrderTest {
	
	public OrderTest() {
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
	 * Test of getId method, of class Order.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Order instance = null;
		int expResult = 0;
		int result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCustomer method, of class Order.
	 */
	@Test
	public void testGetCustomer() {
		System.out.println("getCustomer");
		Order instance = null;
		Customer expResult = null;
		Customer result = instance.getCustomer();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setCustomer method, of class Order.
	 */
	@Test
	public void testSetCustomer() {
		System.out.println("setCustomer");
		Customer customer = null;
		Order instance = null;
		instance.setCustomer(customer);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDate method, of class Order.
	 */
	@Test
	public void testGetDate() {
		System.out.println("getDate");
		Order instance = null;
		Date expResult = null;
		Date result = instance.getDate();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getOrderStatus method, of class Order.
	 */
	@Test
	public void testGetOrderStatus() {
		System.out.println("getOrderStatus");
		Order instance = null;
		OrderStatus expResult = null;
		OrderStatus result = instance.getOrderStatus();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getShoppingBasket method, of class Order.
	 */
	@Test
	public void testGetShoppingBasket() {
		System.out.println("getShoppingBasket");
		Order instance = null;
		ShoppingBasket expResult = null;
		ShoppingBasket result = instance.getShoppingBasket();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getTotalPrice method, of class Order.
	 */
	@Test
	public void testGetTotalPrice() {
		System.out.println("getTotalPrice");
		Order instance = null;
		double expResult = 0.0;
		double result = instance.getTotalPrice();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
