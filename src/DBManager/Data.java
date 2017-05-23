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
					+ "email varchar(255) NOT NULL UNIQUE,"
					+ "phoneNumber INTEGER,"
					+ "PRIMARY KEY (id)"
					+ ");";

	private static String productsTable
					= "CREATE TABLE IF NOT EXISTS Products ("
					+ "id INTEGER,"
					+ "name varchar(255),"
					+ "categoryId INTEGER,"
					+ "description TEXT,"
					+ "price decimal(10,2),"
					+ "PRIMARY KEY (id),"
					+ "FOREIGN KEY (categoryId) REFERENCES Categories(id)"
					+ ");";

	private static String ordersTable
					= "CREATE TABLE IF NOT EXISTS Orders ("
					+ "id INTEGER,"
					+ "customerId INTEGER,"
					+ "date TIMESTAMP,"
					+ "orderStatus varchar(255),"
					+ "PRIMARY KEY (id),"
					+ "FOREIGN KEY (customerId) REFERENCES Customers(id)"
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
					+ "productId INTEGER,"
					+ "title varchar(255),"
					+ "categoryId INTEGER,"
					+ "imageFile bytea,"
					+ "PRIMARY KEY (id),"
					+ "FOREIGN KEY (productId) REFERENCES Products(id),"
					+ "FOREIGN KEY (categoryId) REFERENCES Categories(id)"
					+ ");";

	private static String imageFiles
					= "CREATE TABLE IF NOT EXISTS ImageFiles ("
					+ "imageId INTEGER,"
					+ "imageFile bytea,"
					+ "PRIMARY KEY (imageId),"
					+ "FOREIGN KEY (imageId) REFERENCES Images(id)"
					+ ");";

	public static String[] createTableQueries = {
		categoriesTable,
		customersTable,
		productsTable,
		ordersTable,
		productsInOrdersTable,
		imagesTable,
		imageFiles
	};

	public static String[] dropTableQueries = {
		"DROP TABLE IF EXISTS ImagesInProducts;",
		"DROP TABLE IF EXISTS Images;",
		"DROP TABLE IF EXISTS ProductsInOrders;",
		"DROP TABLE IF EXISTS Orders;",
		"DROP TABLE IF EXISTS Products;",
		"DROP TABLE IF EXISTS Customers;",
		"DROP TABLE IF EXISTS Categories;"
	};

	public static String insertCategories
					= "INSERT INTO Categories (id, name) VALUES"
					+ "(1, 'Appliances'),"
					+ "(2, 'PC'),"
					+ "(3, 'TV'),"
					+ "(4, 'Mobil')"
					+ ";";

	public static String insertProducts
					= "INSERT INTO Products (id, name, categoryId, description, price) VALUES"
					+ "(1, 'Blender', 1, 'Blender fra Electrolux. Blender ting om til mindre stykker.', 299.00),"
					+ "(2, 'Computeren', 2, 'En computer.', 999.99),"
					+ "(3, 'Sony TV', 3, 'Et Sony TV', 3999.99),"
					+ "(4, 'LG TV 43', 3, 'Et 43 tommer LG TV', 2499.00),"
					+ "(5, 'Samsung Galaxy s9', 4, 'The newest member in the Galaxy family.', 5999.42)"
					+ ";";

	public static String[] insertIntoQueries = {
		insertCategories,
		insertProducts
	};
}
