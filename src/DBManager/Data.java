package DBManager;

public class Data {

	private static String categoriesTable
					= "CREATE TABLE IF NOT EXISTS Categories ("
					+ "categoryId INTEGER,"
					+ "name varchar(255),"
					+ "PRIMARY KEY (categoryId)"
					+ ");";

	private static String customersTable
					= "CREATE TABLE IF NOT EXISTS Customers ("
					+ "customerId INTEGER,"
					+ "email varchar(255) NOT NULL UNIQUE,"
					+ "code varchar(255),"
					+ "firstName varchar(255),"
					+ "lastName varchar(255),"
					+ "phoneNumber INTEGER,"
					+ "mobilePhoneNumber INTEGER,"
					+ "address varchar(255),"
					+ "postalCode varchar(255),"
					+ "city varchar(255),"
					+ "country varchar(255),"
					+ "PRIMARY KEY (customerId)"
					+ ");";

	private static String productsTable
					= "CREATE TABLE IF NOT EXISTS Products ("
					+ "productId INTEGER,"
					+ "name varchar(255),"
					+ "categoryId INTEGER,"
					+ "description TEXT,"
					+ "price decimal(10,2),"
					+ "PRIMARY KEY (productId),"
					+ "FOREIGN KEY (categoryId) REFERENCES Categories(categoryId)"
					+ ");";

	private static String basketsTable
					= "CREATE TABLE IF NOT EXISTS Baskets ("
					+ "basketId INTEGER,"
					+ "customerId INTEGER,"
					+ "PRIMARY KEY (basketId),"
					+ "FOREIGN KEY (customerId) REFERENCES Customers(customerId)"
					+ ");";

	private static String productsInBasketsTable
					= "CREATE TABLE IF NOT EXISTS ProductsInBaskets ("
					+ "basketId INTEGER,"
					+ "productId INTEGER,"
					+ "amount INTEGER,"
					+ "PRIMARY KEY (basketId, productId),"
					+ "FOREIGN KEY (basketId) REFERENCES Baskets(basketId),"
					+ "FOREIGN KEY (productId) REFERENCES Products(productId)"
					+ ");";

	private static String ordersTable
					= "CREATE TABLE IF NOT EXISTS Orders ("
					+ "orderId INTEGER,"
					+ "customerId INTEGER,"
					+ "date TIMESTAMP,"
					+ "orderStatus varchar(255),"
					+ "PRIMARY KEY (orderId),"
					+ "FOREIGN KEY (customerId) REFERENCES Customers(customerId)"
					+ ");";

	private static String productsInOrdersTable
					= "CREATE TABLE IF NOT EXISTS ProductsInOrders ("
					+ "orderId INTEGER,"
					+ "productId INTEGER,"
					+ "amount INTEGER,"
					+ "PRIMARY KEY (orderId, productId),"
					+ "FOREIGN KEY (orderId) REFERENCES Orders(orderId),"
					+ "FOREIGN KEY (productId) REFERENCES Products(productId)"
					+ ");";

	private static String imagesTable
					= "CREATE TABLE IF NOT EXISTS Images ("
					+ "imageId INTEGER,"
					+ "productId INTEGER,"
					+ "title varchar(255),"
					+ "categoryId INTEGER,"
					+ "PRIMARY KEY (imageId),"
					+ "FOREIGN KEY (productId) REFERENCES Products(productId),"
					+ "FOREIGN KEY (categoryId) REFERENCES Categories(categoryId)"
					+ ");";

	private static String imageFiles
					= "CREATE TABLE IF NOT EXISTS ImageFiles ("
					+ "imageId INTEGER,"
					+ "imageFile bytea,"
					+ "PRIMARY KEY (imageId),"
					+ "FOREIGN KEY (imageId) REFERENCES Images(imageId)"
					+ ");";

	public static String[] createTableQueries = {
		categoriesTable,
		customersTable,
		productsTable,
		basketsTable,
		productsInBasketsTable,
		ordersTable,
		productsInOrdersTable,
		imagesTable,
		imageFiles
	};

	public static String[] dropTableQueries = {
		"DROP TABLE IF EXISTS ImageFiles;",
		"DROP TABLE IF EXISTS Images;",
		"DROP TABLE IF EXISTS ProductsInOrders;",
		"DROP TABLE IF EXISTS Orders;",
		"DROP TABLE IF EXISTS ProductsInBaskets;",
		"DROP TABLE IF EXISTS Baskets;",
		"DROP TABLE IF EXISTS Products;",
		"DROP TABLE IF EXISTS Customers;",
		"DROP TABLE IF EXISTS Categories;"
	};

	public static String insertCategories
					= "INSERT INTO Categories (categoryId, name) VALUES"
					+ "(1, 'Appliances'),"
					+ "(2, 'PC'),"
					+ "(3, 'TV'),"
					+ "(4, 'Mobil')"
					+ ";";

	public static String insertProducts
					= "INSERT INTO Products (productId, name, categoryId, description, price) VALUES"
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
