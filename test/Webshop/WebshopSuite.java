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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Daniel
 */
@org.junit.runner.RunWith(org.junit.runners.Suite.class)
@	Suite.SuiteClasses({CustomerTest.class, ShoppingBasketTest.class, WebshopControllerTest.class, Customer2Test.class, OrderHistoryTest.class, ProductTest.class, OrderStatusTest.class, PaymentTest.class, WebshopInterfaceTest.class, OrderLineTest.class, ProductCategoryTest.class, CatalogTest.class, OrderTest.class})
public class WebshopSuite {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
}
