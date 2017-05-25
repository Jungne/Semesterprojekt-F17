/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class WebshopControllerTest {

	private WebshopController instance = null;

	public WebshopControllerTest() {

		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
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
	 * Test of getProduct method, of class WebshopController.
	 */
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int productId = 0;
		Product expResult = null;
		Product result = instance.getProduct(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProduct method, of class WebshopController.
	 */
	@Test
	public void testGetAllProduct() {
		System.out.println("getAllProduct");
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getAllProduct();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class WebshopController.
	 */
	@Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.findProducts(query);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class WebshopController.
	 */
	@Test
	public void testGetCategories() {
		System.out.println("getCategories");
		LinkedHashMap<String, Integer> expResult = null;
		LinkedHashMap<String, Integer> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategory method, of class WebshopController.
	 */
	@Test
	public void testGetCategory() {
		System.out.println("getCategory");
		String category = "";
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getCategory(category);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class WebshopController.
	 */
	@Test
	public void testCheckOut_0args() {
		System.out.println("checkOut");
		Order expResult = null;
		Order result = instance.checkOut();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProductToBasket method, of class WebshopController.
	 */
	@Test
	public void testAddProductToBasket() {
		System.out.println("addProductToBasket");
		int productId = 0;
		int amount = 0;
		boolean expResult = false;
		boolean result = instance.addProductToBasket(productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeProduct method, of class WebshopController.
	 */
	@Test
	public void testRemoveProduct() {
		System.out.println("removeProduct");
		int productId = 0;
		instance.removeProduct(productId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setProductAmount method, of class WebshopController.
	 */
	@Test
	public void testSetProductAmount() {
		System.out.println("setProductAmount");
		int productId = 0;
		int amount = 0;
		boolean expResult = false;
		boolean result = instance.setProductAmount(productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getShoppingBasket method, of class WebshopController.
	 */
	@Test
	public void testGetShoppingBasket() {
		System.out.println("getShoppingBasket");
		ShoppingBasket expResult = null;
		ShoppingBasket result = instance.getShoppingBasket();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class WebshopController.
	 */
	@Test
	public void testCheckOut_4args() {
		System.out.println("checkOut");
		String name = "";
		String email = "";
		int phoneNumber = 0;
		ShoppingBasket shoppingBasket = null;
		Order expResult = null;
		Order result = instance.checkOut(name, email, phoneNumber, shoppingBasket);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of emptyShoppingBasket method, of class WebshopController.
	 */
	@Test
	public void testEmptyShoppingBasket() {
		System.out.println("emptyShoppingBasket");
		instance.emptyShoppingBasket();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of signUp method, of class WebshopController.
	 */
	@Test
	public void testSignUp() {
		System.out.println("signUp");
		String email = "";
		String code = "";
		String firstName = "";
		String lastName = "";
		int phoneNumber = 0;
		int mobilePhoneNumber = 0;
		String address = "";
		String postalCode = "";
		String city = "";
		String country = "";
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		boolean expResult = false;
		boolean result = instance.signUp(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of login method, of class WebshopController.
	 */
	@Test
	public void testLogin() {
		System.out.println("login");
		String email = "";
		String code = "";
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		boolean expResult = false;
		boolean result = instance.login(email, code);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
