package DBManager;

public class Data {

	private static String categoriesTable
					= "CREATE TABLE IF NOT EXISTS Categories ("
					+ "id INTEGER,"
					+ "name varchar(255),"
					+ "PRIMARY KEY (id)"
					+ ");";

	private static String customersTable
					= "CREATE TABLE IF NOT EXISTS Customers ("
					+ "id INTEGER,"
					+ "firstName varchar(255),"
					+ "lastName varchar(255),"
					+ "email varchar(255),"
					+ "phoneNumber INTEGER,"
					+ "PRIMARY KEY (id)"
					+ ");";

	private static String productsTable
					= "CREATE TABLE IF NOT EXISTS Products ("
					+ "id INTEGER,"
					+ "name varchar(255),"
					+ "categoryId INTEGER"
					+ "desciption TEXT,"
					+ "price decimal(10,2),"
					+ "PRIMARY KEY (id),"
					+ "FOREIGN KEY (categoryId) REFERENCES Categories(id)"
					+ ");";

	private static String ordersTable
					= "CREATE TABLE IF NOT EXISTS Orders ("
					+ "id INTEGER,"
					+ "customerId INTEGER,"
					+ "date CURRENT_TIMESTAMP,"
					+ "orderStatus varchar(255),"
					+ "PRIMARY KEY (id),"
					+ "FOREIGN KEY (customerId) REFERENCES Customer(id)"
					+ ");";

	private static String productsInOrdersTable
					= "CREATE TABLE IF NOT EXISTS ProductsInOrders ("
					+ "orderId INTEGER,"
					+ "productId INTEGER,"
					+ "amount INTEGER,"
					+ "PRIMARY KEY (orderId, productId),"
					+ "FOREIGN KEY (orderId) REFERENCES Orders(id),"
					+ "FOREIGN KEY (productId) REFERENCES Products(id)"
					+ ");";

	private static String imagesTable
					= "CREATE TABLE IF NOT EXISTS Images ("
					+ "id INTEGER,"
					+ "title varchar(255),"
					+ "imageFile bytea,"
					+ "PRIMARY KEY (id)"
					+ ");";

	private static String imagesInProductsTable
					= "CREATE TABLE IF NOT EXISTS ImagesInProducts ("
					+ "productId INTEGER,"
					+ "imageId INTEGER,"
					+ "PRIMARY KEY (productId, imageId),"
					+ "FOREIGN KEY (productId) REFERENCES Products(id),"
					+ "FOREIGN KEY (imageId) REFERENCES Images(id)"
					+ ");";

	public static String[] createTableQueries = {
		categoriesTable,
		customersTable,
		productsTable,
		ordersTable,
		productsInOrdersTable,
		imagesTable,
		imagesInProductsTable
	};

	public static String[] dropTableQueries = {
		"DROP TABLE IF EXISTS Categories;",
		"DROP TABLE IF EXISTS Customers;",
		"DROP TABLE IF EXISTS Products;",
		"DROP TABLE IF EXISTS Orders;",
		"DROP TABLE IF EXISTS ProductsInOrders;",
		"DROP TABLE IF EXISTS Images;",
		"DROP TABLE IF EXISTS ImagesInProducts;",
		//Temporary part:'
		"DROP TABLE IF EXISTS imageTest;",
		"DROP TABLE IF EXISTS category;",
		"DROP TABLE IF EXISTS customer;",
		"DROP TABLE IF EXISTS image;",
		"DROP TABLE IF EXISTS product;",
		"DROP TABLE IF EXISTS productsinorder;"
	};
	
	public static String insertCategories = "INSERT INTO Categories VALUES ();";
}
