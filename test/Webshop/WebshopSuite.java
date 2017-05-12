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
@RunWith(Suite.class)
@Suite.SuiteClasses({Webshop.OrderLineTest.class, Webshop.ProductTest.class, Webshop.PaymentTest.class, Webshop.OrderTest.class, Webshop.WebshopInterfaceTest.class, Webshop.OrderHistoryTest.class, Webshop.CustomerTest.class, Webshop.ShoppingBasketTest.class, Webshop.CatalogTest.class, Webshop.DatabaseInterfaceTest.class, Webshop.OrderStatusTest.class, Webshop.DBManagerTest.class, Webshop.ProductCategoryTest.class, Webshop.WebshopControllerTest.class})
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
