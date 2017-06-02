/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webshop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
public class WebshopInterfaceTest {
	
	public WebshopInterfaceTest() {
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
	 * Test of getProduct method, of class WebshopInterface.
	 */
	@Test
	public void testGetProduct() {
		System.out.println("getProduct");
		int id = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		Product expResult = null;
		Product result = instance.getProduct(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllProduct method, of class WebshopInterface.
	 */
	@Test
	public void testGetAllProduct() {
		System.out.println("getAllProduct");
		WebshopInterface instance = new WebshopInterfaceImpl();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getAllProduct();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAllEnrichedProducts method, of class WebshopInterface.
	 */
	@Test
	public void testGetAllEnrichedProducts() {
		System.out.println("getAllEnrichedProducts");
		WebshopInterface instance = new WebshopInterfaceImpl();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.getAllEnrichedProducts();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findProducts method, of class WebshopInterface.
	 */
	@Test
	public void testFindProducts() {
		System.out.println("findProducts");
		String query = "";
		int categoryID = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		ArrayList<Product> expResult = null;
		ArrayList<Product> result = instance.findProducts(query, categoryID);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCategories method, of class WebshopInterface.
	 */
	@Test
	public void testGetCategories() {
		System.out.println("getCategories");
		WebshopInterface instance = new WebshopInterfaceImpl();
		LinkedHashMap<String, Integer> expResult = null;
		LinkedHashMap<String, Integer> result = instance.getCategories();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of signUp method, of class WebshopInterface.
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
		ShoppingBasket shoppingBasket = null;
		WebshopInterface instance = new WebshopInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.signUp(email, code, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, shoppingBasket);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of login method, of class WebshopInterface.
	 */
	@Test
	public void testLogin() {
		System.out.println("login");
		String email = "";
		String code = "";
		WebshopInterface instance = new WebshopInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.login(email, code);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of logOut method, of class WebshopInterface.
	 */
	@Test
	public void testLogOut() {
		System.out.println("logOut");
		WebshopInterface instance = new WebshopInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.logOut();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCustomer method, of class WebshopInterface.
	 */
	@Test
	public void testGetCustomer() {
		System.out.println("getCustomer");
		WebshopInterface instance = new WebshopInterfaceImpl();
		Customer expResult = null;
		Customer result = instance.getCustomer();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getShoppingBaskets method, of class WebshopInterface.
	 */
	@Test
	public void testGetShoppingBaskets() {
		System.out.println("getShoppingBaskets");
		WebshopInterface instance = new WebshopInterfaceImpl();
		ArrayList<ShoppingBasket> expResult = null;
		ArrayList<ShoppingBasket> result = instance.getShoppingBaskets();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createBasket method, of class WebshopInterface.
	 */
	@Test
	public void testCreateBasket() {
		System.out.println("createBasket");
		WebshopInterface instance = new WebshopInterfaceImpl();
		instance.createBasket();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeBasket method, of class WebshopInterface.
	 */
	@Test
	public void testRemoveBasket() {
		System.out.println("removeBasket");
		int basketId = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		instance.removeBasket(basketId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addProductToBasket method, of class WebshopInterface.
	 */
	@Test
	public void testAddProductToBasket() {
		System.out.println("addProductToBasket");
		int basketId = 0;
		int productId = 0;
		int amount = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.addProductToBasket(basketId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setProductAmount method, of class WebshopInterface.
	 */
	@Test
	public void testSetProductAmount() {
		System.out.println("setProductAmount");
		int basketId = 0;
		int productId = 0;
		int amount = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.setProductAmount(basketId, productId, amount);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of removeProduct method, of class WebshopInterface.
	 */
	@Test
	public void testRemoveProduct() {
		System.out.println("removeProduct");
		int basketId = 0;
		int productId = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.removeProduct(basketId, productId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of emptyShoppingBasket method, of class WebshopInterface.
	 */
	@Test
	public void testEmptyShoppingBasket() {
		System.out.println("emptyShoppingBasket");
		int basketId = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		instance.emptyShoppingBasket(basketId);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getLatestOrder method, of class WebshopInterface.
	 */
	@Test
	public void testGetLatestOrder() {
		System.out.println("getLatestOrder");
		WebshopInterface instance = new WebshopInterfaceImpl();
		Order expResult = null;
		Order result = instance.getLatestOrder();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class WebshopInterface.
	 */
	@Test
	public void testCheckOut_10args() {
		System.out.println("checkOut");
		String email = "";
		String firstName = "";
		String lastName = "";
		int phoneNumber = 0;
		int mobilePhoneNumber = 0;
		String address = "";
		String postalCode = "";
		String city = "";
		String country = "";
		ShoppingBasket shoppingBasket = null;
		WebshopInterface instance = new WebshopInterfaceImpl();
		Order expResult = null;
		Order result = instance.checkOut(email, firstName, lastName, phoneNumber, mobilePhoneNumber, address, postalCode, city, country, shoppingBasket);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of checkOut method, of class WebshopInterface.
	 */
	@Test
	public void testCheckOut_int() {
		System.out.println("checkOut");
		int basketId = 0;
		WebshopInterface instance = new WebshopInterfaceImpl();
		boolean expResult = false;
		boolean result = instance.checkOut(basketId);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	public class WebshopInterfaceImpl implements WebshopInterface {

		public Product getProduct(int id) {
			return null;
		}

		public ArrayList<Product> getAllProduct() {
			return null;
		}

		public ArrayList<Product> getAllEnrichedProducts() {
			return null;
		}

		public ArrayList<Product> findProducts(String query, int categoryID) {
			return null;
		}

		public LinkedHashMap<String, Integer> getCategories() {
			return null;
		}

		public boolean signUp(String email, String code, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ShoppingBasket shoppingBasket) {
			return false;
		}

		public boolean login(String email, String code) {
			return false;
		}

		public boolean logOut() {
			return false;
		}

		public Customer getCustomer() {
			return null;
		}

		public ArrayList<ShoppingBasket> getShoppingBaskets() {
			return null;
		}

		public void createBasket() {
		}

		public void removeBasket(int basketId) {
		}

		public boolean addProductToBasket(int basketId, int productId, int amount) {
			return false;
		}

		public boolean setProductAmount(int basketId, int productId, int amount) {
			return false;
		}

		public boolean removeProduct(int basketId, int productId) {
			return false;
		}

		public void emptyShoppingBasket(int basketId) {
		}

		public Order getLatestOrder() {
			return null;
		}

		public Order checkOut(String email, String firstName, String lastName, int phoneNumber, int mobilePhoneNumber, String address, String postalCode, String city, String country, ShoppingBasket shoppingBasket) {
			return null;
		}

		public boolean checkOut(int basketId) {
			return false;
		}
	}
	
}
