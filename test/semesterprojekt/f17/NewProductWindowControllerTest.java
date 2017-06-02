/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt.f17;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class NewProductWindowControllerTest {
	
	public NewProductWindowControllerTest() {
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
	 * Test of initialize method, of class NewProductWindowController.
	 */
	@org.junit.Test
	public void testInitialize() {
		System.out.println("initialize");
		URL url = null;
		ResourceBundle rb = null;
		NewProductWindowController instance = new NewProductWindowController();
		instance.initialize(url, rb);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of handleAddImageButton method, of class NewProductWindowController.
	 */
	@org.junit.Test
	public void testHandleAddImageButton() {
		System.out.println("handleAddImageButton");
		ActionEvent event = null;
		NewProductWindowController instance = new NewProductWindowController();
		instance.handleAddImageButton(event);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of handleRemoveImageButton method, of class NewProductWindowController.
	 */
	@org.junit.Test
	public void testHandleRemoveImageButton() {
		System.out.println("handleRemoveImageButton");
		ActionEvent event = null;
		NewProductWindowController instance = new NewProductWindowController();
		instance.handleRemoveImageButton(event);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
