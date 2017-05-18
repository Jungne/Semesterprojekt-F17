/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAM;

import DBManager.DBManager;
import Webshop.DatabaseInterface;

/**
 *
 * @author jungn
 */
public class DAMManager {

    public DAMManager() {
	DatabaseInterface  databaseInterface = DBManager.getInstance();
    }
    
    
    
}
