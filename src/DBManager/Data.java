package DBManager;

public class Data {

	private static String categoriesTable = "CREATE TABLE IF NOT EXISTS Categories ("
					+ "id INTEGER,"
					+ "name varchar(255),"
					+ "PRIMARY KEY (id)"
					+ ");";

	private static String customersTable = "CREATE TABLE IF NOT EXISTS Customers ("
					+ "id INTEGER,"
					+ "firstName varchar(255),"
					+ "lastName varchar(255),"
					+ "email varchar(255),"
					+ "phoneNumber INTEGER,"
					+ "PRIMARY KEY (id)"
					+ ");";

	private static String productsTable = "CREATE TABLE IF NOT EXISTS Products ("
					+ ""
					+ ");";

	private static String ordersTable = "CREATE TABLE IF NOT EXISTS Orders ("
					+ ");";

	private static String productsInOrdersTable = "CREATE TABLE IF NOT EXISTS ProductsInOrders ("
					+ ");";

	private static String imagesTable = "CREATE TABLE IF NOT EXISTS Images ("
					+ ");";

	private static String imagesInProductsTable = "CREATE TABLE IF NOT EXISTS ImagesInProducts ("
					+ ");";

	/**
	 * Temporary table
	 */
	private static String imageTestTable = "CREATE TABLE IF NOT EXISTS imageTest ("
					+ "name varchar(15),"
					+ "image bytea"
					+ ");";

	public static String[] createTableQueries = {
		categoriesTable,
		customersTable,
		productsTable,
		ordersTable,
		productsInOrdersTable,
		imagesTable,
		imagesInProductsTable,
		//Temporay part:
		imageTestTable
	};

	public static String[] dropTableQueries = {
		"DROP TABLE IF EXISTS Categories",
		"DROP TABLE IF EXISTS Customers",
		"DROP TABLE IF EXISTS Products",
		"DROP TABLE IF EXISTS Orders",
		"DROP TABLE IF EXISTS ProductsInOrders",
		"DROP TABLE IF EXISTS Images",
		"DROP TABLE IF EXISTS ImagesInProducts",
		//Temporary part:'
		"DROP TABLE IF EXISTS imageTest",
		"DROP TABLE IF EXISTS category",
		"DROP TABLE IF EXISTS customer",
		"DROP TABLE IF EXISTS image",
		"DROP TABLE IF EXISTS product",
		"DROP TABLE IF EXISTS productsinorder"
	};
}
