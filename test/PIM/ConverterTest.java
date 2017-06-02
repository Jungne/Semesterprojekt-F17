/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIM;

import java.util.ArrayList;
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
public class ConverterTest {
	
	public ConverterTest() {
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
	 * Test of createPIMProduct method, of class Converter.
	 */
	@org.junit.Test
	public void testCreatePIMProduct() {
		System.out.println("createPIMProduct");
		HashMap<String, String> productMap = null;
		PIMProduct expResult = null;
		PIMProduct result = Converter.createPIMProduct(productMap);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createPIMProducts method, of class Converter.
	 */
	@org.junit.Test
	public void testCreatePIMProducts() {
		System.out.println("createPIMProducts");
		LinkedList<HashMap<String, String>> productsMapList = null;
		ArrayList<PIMProduct> expResult = null;
		ArrayList<PIMProduct> result = Converter.createPIMProducts(productsMapList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createPIMage method, of class Converter.
	 */
	@org.junit.Test
	public void testCreatePIMage() {
		System.out.println("createPIMage");
		HashMap<String, String> pimImageMap = null;
		PIMage expResult = null;
		PIMage result = Converter.createPIMage(pimImageMap);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createPIMages method, of class Converter.
	 */
	@org.junit.Test
	public void testCreatePIMages() {
		System.out.println("createPIMages");
		LinkedList<HashMap<String, String>> pimImageMapList = null;
		ArrayList<PIMage> expResult = null;
		ArrayList<PIMage> result = Converter.createPIMages(pimImageMapList);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
