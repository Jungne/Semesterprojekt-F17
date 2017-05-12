/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

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
public class ShoppingBasketTest {
	
	public ShoppingBasketTest() {
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
	 * Test of getBasketContent method, of class ShoppingBasket.
	 */
	@Test
	public void testGetBasketContent() {
		System.out.println("getBasketContent");
		ShoppingBasket instance = new ShoppingBasket();
		ArrayList<OrderLine> expResult = null;
		ArrayList<OrderLine> result = instance.getBasketContent();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProduct method, of class ShoppingBasket.
	 */
	@Test
	public void testAddProduct_Product_int() {
		System.out.println("addProduct");
		Product product = null;
		int amount = 0;
		ShoppingBasket instance = new ShoppingBasket();
		boolean expResult = false;
		boolean result = instance.addProduct(product, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProduct method, of class ShoppingBasket.
	 */
	@Test
	public void testAddProduct_OrderLine() {
		System.out.println("addProduct");
		OrderLine orderLine = null;
		ShoppingBasket instance = new ShoppingBasket();
		boolean expResult = false;
		boolean result = instance.addProduct(orderLine);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setProductAmount method, of class ShoppingBasket.
	 */
	@Test
	public void testSetProductAmount() {
		System.out.println("setProductAmount");
		Product product = null;
		int amount = 0;
		ShoppingBasket instance = new ShoppingBasket();
		boolean expResult = false;
		boolean result = instance.setProductAmount(product, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeProduct method, of class ShoppingBasket.
	 */
	@Test
	public void testRemoveProduct() {
		System.out.println("removeProduct");
		Product product = null;
		ShoppingBasket instance = new ShoppingBasket();
		instance.removeProduct(product);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of isEmpty method, of class ShoppingBasket.
	 */
	@Test
	public void testIsEmpty() {
		System.out.println("isEmpty");
		ShoppingBasket instance = new ShoppingBasket();
		boolean expResult = false;
		boolean result = instance.isEmpty();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of empty method, of class ShoppingBasket.
	 */
	@Test
	public void testEmpty() {
		System.out.println("empty");
		ShoppingBasket instance = new ShoppingBasket();
		instance.empty();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getTotalPrice method, of class ShoppingBasket.
	 */
	@Test
	public void testGetTotalPrice() {
		System.out.println("getTotalPrice");
		ShoppingBasket instance = new ShoppingBasket();
		double expResult = 0.0;
		double result = instance.getTotalPrice();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
