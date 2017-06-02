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
	@org.junit.Test
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
	 * Test of getEmail method, of class Customer.
	 */
	@org.junit.Test
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
	 * Test of getCode method, of class Customer.
	 */
	@org.junit.Test
	public void testGetCode() {
		System.out.println("getCode");
		Customer instance = null;
		String expResult = "";
		String result = instance.getCode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getFirstName method, of class Customer.
	 */
	@org.junit.Test
	public void testGetFirstName() {
		System.out.println("getFirstName");
		Customer instance = null;
		String expResult = "";
		String result = instance.getFirstName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLastName method, of class Customer.
	 */
	@org.junit.Test
	public void testGetLastName() {
		System.out.println("getLastName");
		Customer instance = null;
		String expResult = "";
		String result = instance.getLastName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPhoneNumber method, of class Customer.
	 */
	@org.junit.Test
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
	 * Test of getMobilePhoneNumber method, of class Customer.
	 */
	@org.junit.Test
	public void testGetMobilePhoneNumber() {
		System.out.println("getMobilePhoneNumber");
		Customer instance = null;
		int expResult = 0;
		int result = instance.getMobilePhoneNumber();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAddress method, of class Customer.
	 */
	@org.junit.Test
	public void testGetAddress() {
		System.out.println("getAddress");
		Customer instance = null;
		String expResult = "";
		String result = instance.getAddress();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getPostalCode method, of class Customer.
	 */
	@org.junit.Test
	public void testGetPostalCode() {
		System.out.println("getPostalCode");
		Customer instance = null;
		String expResult = "";
		String result = instance.getPostalCode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCity method, of class Customer.
	 */
	@org.junit.Test
	public void testGetCity() {
		System.out.println("getCity");
		Customer instance = null;
		String expResult = "";
		String result = instance.getCity();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCountry method, of class Customer.
	 */
	@org.junit.Test
	public void testGetCountry() {
		System.out.println("getCountry");
		Customer instance = null;
		String expResult = "";
		String result = instance.getCountry();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getShoppingBaskets method, of class Customer.
	 */
	@org.junit.Test
	public void testGetShoppingBaskets() {
		System.out.println("getShoppingBaskets");
		Customer instance = null;
		ArrayList<ShoppingBasket> expResult = null;
		ArrayList<ShoppingBasket> result = instance.getShoppingBaskets();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getFirstShoppingBasket method, of class Customer.
	 */
	@org.junit.Test
	public void testGetFirstShoppingBasket() {
		System.out.println("getFirstShoppingBasket");
		Customer instance = null;
		ShoppingBasket expResult = null;
		ShoppingBasket result = instance.getFirstShoppingBasket();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of isRegisted method, of class Customer.
	 */
	@org.junit.Test
	public void testIsRegisted() {
		System.out.println("isRegisted");
		Customer instance = null;
		boolean expResult = false;
		boolean result = instance.isRegisted();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getShoppingBasket method, of class Customer.
	 */
	@org.junit.Test
	public void testGetShoppingBasket() {
		System.out.println("getShoppingBasket");
		int basketId = 0;
		Customer instance = null;
		ShoppingBasket expResult = null;
		ShoppingBasket result = instance.getShoppingBasket(basketId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeShoppingBasket method, of class Customer.
	 */
	@org.junit.Test
	public void testRemoveShoppingBasket() {
		System.out.println("removeShoppingBasket");
		ShoppingBasket shoppingBasket = null;
		Customer instance = null;
		instance.removeShoppingBasket(shoppingBasket);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class Customer.
	 */
	@org.junit.Test
	public void testCheckOut_0args() {
		System.out.println("checkOut");
		Customer instance = null;
		boolean expResult = false;
		boolean result = instance.checkOut();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class Customer.
	 */
	@org.junit.Test
	public void testCheckOut_ShoppingBasket() {
		System.out.println("checkOut");
		ShoppingBasket shoppingBasket = null;
		Customer instance = null;
		boolean expResult = false;
		boolean result = instance.checkOut(shoppingBasket);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
