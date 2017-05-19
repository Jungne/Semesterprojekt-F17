package DAM;

import DBManager.DBManager;
import Webshop.DatabaseInterface;

public class DAMManager {

	public DAMManager() {
		DatabaseInterface databaseInterface = DBManager.getInstance();
	}
}
