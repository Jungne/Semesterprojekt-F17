/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class WebshopControllerTest {

	public WebshopControllerTest() {
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
	@org.junit.Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int productId = 0;
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		Product expResult = null;
		Product result = instance.getProduct(productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProduct method, of class WebshopController.
	 */
	@org.junit.Test
	public void testGetAllProduct() {
		System.out.println("getAllProduct");
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getAllProduct();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllEnrichedProducts method, of class WebshopController.
	 */
	@org.junit.Test
	public void testGetAllEnrichedProducts() {
		System.out.println("getAllEnrichedProducts");
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getAllEnrichedProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class WebshopController.
	 */
	@org.junit.Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		int categoryId = 0;
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.findProducts(query, categoryId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class WebshopController.
	 */
	@org.junit.Test
	public void testGetCategories() {
		System.out.println("getCategories");
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		LinkedHashMap<String, Integer> expResult = null;
		LinkedHashMap<String, Integer> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of signUp method, of class WebshopController.
	 */
	@org.junit.Test
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
		ShoppingBasket shoppingBasket = null;
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		boolean expResult = false;
		boolean result = instance.signUp(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, shoppingBasket);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of login method, of class WebshopController.
	 */
	@org.junit.Test
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

	/**
	 * Test of logOut method, of class WebshopController.
	 */
	@org.junit.Test
	public void testLogOut() {
		System.out.println("logOut");
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		boolean expResult = false;
		boolean result = instance.logOut();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCustomer method, of class WebshopController.
	 */
	@org.junit.Test
	public void testGetCustomer() {
		System.out.println("getCustomer");
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		Customer expResult = null;
		Customer result = instance.getCustomer();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getShoppingBaskets method, of class WebshopController.
	 */
	@org.junit.Test
	public void testGetShoppingBaskets() {
		System.out.println("getShoppingBaskets");
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		ArrayList<ShoppingBasket> expResult = null;
		ArrayList<ShoppingBasket> result = instance.getShoppingBaskets();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createBasket method, of class WebshopController.
	 */
	@org.junit.Test
	public void testCreateBasket() {
		System.out.println("createBasket");
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		instance.createBasket();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeBasket method, of class WebshopController.
	 */
	@org.junit.Test
	public void testRemoveBasket() {
		System.out.println("removeBasket");
		int basketId = 0;
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		instance.removeBasket(basketId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProductToBasket method, of class WebshopController.
	 */
	@org.junit.Test
	public void testAddProductToBasket() {
		System.out.println("addProductToBasket");
		int basketId = 0;
		int productId = 0;
		int amount = 0;
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		boolean expResult = false;
		boolean result = instance.addProductToBasket(basketId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setProductAmount method, of class WebshopController.
	 */
	@org.junit.Test
	public void testSetProductAmount() {
		System.out.println("setProductAmount");
		int basketId = 0;
		int productId = 0;
		int amount = 0;
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		boolean expResult = false;
		boolean result = instance.setProductAmount(basketId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeProduct method, of class WebshopController.
	 */
	@org.junit.Test
	public void testRemoveProduct() {
		System.out.println("removeProduct");
		int basketId = 0;
		int productId = 0;
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		boolean expResult = false;
		boolean result = instance.removeProduct(basketId, productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of emptyShoppingBasket method, of class WebshopController.
	 */
	@org.junit.Test
	public void testEmptyShoppingBasket() {
		System.out.println("emptyShoppingBasket");
		int basketId = 0;
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		instance.emptyShoppingBasket(basketId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLatestOrder method, of class WebshopController.
	 */
	@org.junit.Test
	public void testGetLatestOrder() {
		System.out.println("getLatestOrder");
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		Order expResult = null;
		Order result = instance.getLatestOrder();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class WebshopController.
	 */
	@org.junit.Test
	public void testCheckOut_10args() {
		System.out.println("checkOut");
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		//Test customer
		String email = "" + (int) (Math.random() * 10000);
		String firstName = "Stefan";
		String lastName = "Rasmussen";
		int phoneNumber = 63343718;
		int mobilePhoneNumber = 29381274;
		String address = "Åvænget 3";
		String postalCode = "3160";
		String city = "Holmerup";
		String country = "Danmark";
		ShoppingBasket basket = new ShoppingBasket();

		double totalPrice = 0;
						
		//Test orderline #1
		Product product = instance.getProduct(1);
		OrderLine orderLineOne = new OrderLine(product, 2);
		basket.addProduct(orderLineOne);
		
		totalPrice += product.getPrice() * 2;

		//Test orderline #2
		product = instance.getProduct(2);
		OrderLine orderLineTwo = new OrderLine(product, 3);
		basket.addProduct(orderLineTwo);

		totalPrice += product.getPrice() * 3;
		
		ArrayList<ShoppingBasket> baskets = new ArrayList<>();
		baskets.add(basket);
		Customer customer = new Customer(-1, email, "1234", firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, baskets);

		Order expResult = new Order(-1, customer, new Date(), OrderStatus.CREATED, customer.getShoppingBasket(0));
		Order result = instance.checkOut(email, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, basket);
		System.out.println("expr: " + expResult.getCustomer().getFirstName());
		System.out.println("r: " + result.getCustomer().getFirstName());
		assertEquals(expResult.getCustomer().getFirstName(), result.getCustomer().getFirstName());
		assertEquals(expResult.getCustomer().getLastName(), result.getCustomer().getLastName());
		assertTrue(totalPrice == result.getTotalPrice());
	}

	/**
	 * Test of checkOut method, of class WebshopController.
	 */
	@org.junit.Test
	public void testCheckOut_int() {
		System.out.println("checkOut");
		int basketId = 0;
		WebshopController instance = null;
		try {
			instance = new WebshopController();
		} catch (IOException ex) {
			Logger.getLogger(WebshopControllerTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		boolean expResult = false;
		boolean result = instance.checkOut(basketId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The tests case is a prototype.");
	}

}
