/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt.f17;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Daniel
 */
@org.junit.runner.RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({NewProductWindowControllerTest.class, SemesterprojektF17Test.class, ProductHBoxCellTest.class, FXMLDocumentControllerTest.class})
public class F17Suite {

	@org.junit.BeforeClass
	public static void setUpClass() throws Exception {
	}

	@org.junit.AfterClass
	public static void tearDownClass() throws Exception {
	}

	@org.junit.Before
	public void setUp() throws Exception {
	}

	@org.junit.After
	public void tearDown() throws Exception {
	}
	
}
