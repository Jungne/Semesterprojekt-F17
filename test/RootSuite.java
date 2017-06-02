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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import semesterprojekt.SemesterprojektSuite;

/**
 *
 * @author Daniel
 */
@org.junit.runner.RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({WebshopSuite.class, ImagesSuite.class, SemesterprojektSuite.class, PIMSuite.class, DBManagerSuite.class, DAMSuite.class})
public class RootSuite {

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
