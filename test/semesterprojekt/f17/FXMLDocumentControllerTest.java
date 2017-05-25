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
public class FXMLDocumentControllerTest {
	
	public FXMLDocumentControllerTest() {
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
	 * Test of initialize method, of class FXMLDocumentController.
	 */
	@Test
	public void testInitialize() {
		System.out.println("initialize");
		URL url = null;
		ResourceBundle rb = null;
		FXMLDocumentController instance = new FXMLDocumentController();
		instance.initialize(url, rb);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of handleBrowseButton method, of class FXMLDocumentController.
	 */
	@Test
	public void testHandleBrowseButton() {
		System.out.println("handleBrowseButton");
		ActionEvent event = null;
		FXMLDocumentController instance = new FXMLDocumentController();
		instance.handleBrowseButton(event);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of handleOpenImageButton method, of class FXMLDocumentController.
	 */
	@Test
	public void testHandleOpenImageButton() {
		System.out.println("handleOpenImageButton");
		ActionEvent event = null;
		FXMLDocumentController instance = new FXMLDocumentController();
		instance.handleOpenImageButton(event);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
