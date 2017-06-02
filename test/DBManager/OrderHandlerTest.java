/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

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
 * @author Daniel
 */
public class OrderHandlerTest {
	
	public OrderHandlerTest() {
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
	 * Test of getLatestOrder method, of class OrderHandler.
	 */
	@org.junit.Test
	public void testGetLatestOrder() {
		System.out.println("getLatestOrder");
		int customerId = 0;
		OrderHandler instance = null;
		HashMap<String, String> expResult = null;
		HashMap<String, String> result = instance.getLatestOrder(customerId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getOrdersOrderLines method, of class OrderHandler.
	 */
	@org.junit.Test
	public void testGetOrdersOrderLines() {
		System.out.println("getOrdersOrderLines");
		int orderId = 0;
		OrderHandler instance = null;
		LinkedList<HashMap<String, String>> expResult = null;
		LinkedList<HashMap<String, String>> result = instance.getOrdersOrderLines(orderId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createOrder method, of class OrderHandler.
	 */
	@org.junit.Test
	public void testCreateOrder() {
		System.out.println("createOrder");
		int customerId = 0;
		String orderStatus = "";
		OrderHandler instance = null;
		boolean expResult = false;
		boolean result = instance.createOrder(customerId, orderStatus);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProductToOrder method, of class OrderHandler.
	 */
	@org.junit.Test
	public void testAddProductToOrder() {
		System.out.println("addProductToOrder");
		int orderId = 0;
		int productId = 0;
		int amount = 0;
		OrderHandler instance = null;
		boolean expResult = false;
		boolean result = instance.addProductToOrder(orderId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
