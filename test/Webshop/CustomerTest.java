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
 * @author Daniel
 */
public class CustomerTest {
	
	public CustomerTest() {
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
	 * Test of getId method, of class Customer.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Customer instance = null;
		int expResult = 0;
		int result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getName method, of class Customer.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Customer instance = null;
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setName method, of class Customer.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		Customer instance = null;
		instance.setName(name);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getEmail method, of class Customer.
	 */
	@Test
	public void testGetEmail() {
		System.out.println("getEmail");
		Customer instance = null;
		String expResult = "";
		String result = instance.getEmail();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setEmail method, of class Customer.
	 */
	@Test
	public void testSetEmail() {
		System.out.println("setEmail");
		String email = "";
		Customer instance = null;
		instance.setEmail(email);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPhoneNumber method, of class Customer.
	 */
	@Test
	public void testGetPhoneNumber() {
		System.out.println("getPhoneNumber");
		Customer instance = null;
		int expResult = 0;
		int result = instance.getPhoneNumber();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setPhoneNumber method, of class Customer.
	 */
	@Test
	public void testSetPhoneNumber() {
		System.out.println("setPhoneNumber");
		int phoneNumber = 0;
		Customer instance = null;
		instance.setPhoneNumber(phoneNumber);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getShoppingBasket method, of class Customer.
	 */
	@Test
	public void testGetShoppingBasket() {
		System.out.println("getShoppingBasket");
		Customer instance = null;
		ShoppingBasket expResult = null;
		ShoppingBasket result = instance.getShoppingBasket();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class Customer.
	 */
	@Test
	public void testCheckOut() {
		System.out.println("checkOut");
		Customer instance = null;
		Order expResult = null;
		Order result = instance.checkOut();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
