/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager.Data2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class TestData {

	private static String customerCreateQuery = "CREATE TABLE IF NOT EXISTS customer ("
					+ "id INTEGER NOT NULL,"
					+ "firstname CHARACTER(255),"
					+ "lastname CHARACTER(255),"
					+ "PRIMARY KEY (id));";

	private static String imageTestCreateQuery = "CREATE TABLE IF NOT EXISTS imageTest ("
					+ "name varchar(15),"
					+ "image bytea"
					+ ");";

	public static String[] createTableQueries = {
		customerCreateQuery,
		imageTestCreateQuery
	};

	public static String[] dropTableQueries = {
		"DROP TABLE IF EXISTS imageTest",
		"DROP TABLE IF EXISTS customer"
	};

}
