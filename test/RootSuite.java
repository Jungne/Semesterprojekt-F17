/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAM.DAMSuite;
import DBManager.DBManagerSuite;
import PIM.PIMSuite;
import Webshop.WebshopSuite;
import images.ImagesSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import semesterprojekt.SemesterprojektSuite;

/**
 *
 * @author Daniel
 */
@org.junit.runner.RunWith(org.junit.runners.Suite.class)
@	Suite.SuiteClasses({SemesterprojektSuite.class, WebshopSuite.class, DAMSuite.class, ImagesSuite.class, DBManagerSuite.class, PIMSuite.class})
public class RootSuite {

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
