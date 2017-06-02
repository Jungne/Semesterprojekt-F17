package DBManager;

public class Data {

	private static String categoriesTable
					= "CREATE TABLE IF NOT EXISTS Categories ("
					+ "categoryId serial,"
					+ "categoryName varchar(255),"
					+ "PRIMARY KEY (categoryId)"
					+ ");";

	private static String customersTable
					= "CREATE TABLE IF NOT EXISTS Customers ("
					+ "customerId serial,"
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
					+ "productId serial,"
					+ "productName varchar(255),"
					+ "categoryId INTEGER,"
					+ "description TEXT,"
					+ "price decimal(10,2),"
					+ "PRIMARY KEY (productId),"
					+ "FOREIGN KEY (categoryId) REFERENCES Categories(categoryId)"
					+ ");";

	private static String basketsTable
					= "CREATE TABLE IF NOT EXISTS Baskets ("
					+ "basketId serial,"
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
					+ "orderId serial,"
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
					+ "imageId serial,"
					+ "productId INTEGER,"
					+ "imageName varchar(255),"
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

	protected static String[] createTableQueries = {
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

	protected static String[] dropTableQueries = {
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

	private static String insertCategories
					= "INSERT INTO Categories (categoryName) VALUES "
					+ "('Appliances'), "
					+ "('TV'), "
					+ "('Computer'), "
					+ "('Videogame'), "
					+ "('LEGO'), "
					+ "('Phone') "
					+ "('Bicycle')";

	private static String insertProducts
					= "INSERT INTO Products (productName, categoryId, description, price) VALUES "
					+ "('Sportsblender', 1, 'Blender fra Electrolux. Blender ting om til mindre stykker.', 439.00), "
					+ "('Wilfa morgen brødrister', 1, 'Brødsrister fra Wilfa. Perfekt til brødristning af brød om morgenen', 396.00), "
					+ "('Samsung UE65KS8005', 2, 'LED, 4K UHD (3830x2160 pixel), 2300 Hz / Smart TV', 13299.00), "
					+ "('Philips LED TV 24PHT4000', 2, 'LED TV med Digital Crystal Clear og 100 PMR Hz', 1299.00), "
					+ "('LG Ultra HD 65UH6157', 2, 'Bare et TV', 7777.77), "
					+ "('Komplett Gamer Premium i35', 3, 'Er du træt af at have en gaming-pc, som giver dårlig FPS ved lave grafikindstillinger?', 8999.00), "
					+ "('First Gaming Computer', 3, 'Der er tale om en god, billig gaming computer, der er velegnet til folk som ønsker at stifte bekendtskab med populære spil som CSGO, Minecraft o.l.', 3995.00), "
					+ "('HP Z240 TWR', 3, 'Kraftfuld nok til at håndtere alle udfordringer', 8999.00), "
					+ "('Counter-Strike: Global Offensive', 4, 'Den seneste fra den klassiske Counter-Strike serie. Over 1 million tilfredse kunder.', 85.95), "
					+ "('Overwatch (Origins Edition)', 4, 'Overwatch er et 6 mod 6 skydespil som udspiller sig i en nær fremtid på jorden.', 259.99), "
					+ "('GTA 5', 4, 'Udfør kup og missioner som garvede kriminelle.', 299.00), "
					+ "('The Sims 4 (DK)', 4, 'The Sims 4 er et livssimulationsspil', 309.50), "
					+ "('Taj Mahal - 10189', 5, 'Advancert model', 8199.00), "
					+ "('Huawei Y6', 6, '8 megapixel kamera.', 1375.00), "
					+ "('Micado Sport Disc - Citybike', 7, 'Micado Sport Disc er en utrolig let citybike til herrer.', 4239.00), "
					+ "('Kross Trans Siberian - Citybike', 7, 'Denne Kross Trans Siberian er en god og funktionel damecykel, som er perfekt til bykørsel.', 3999.00)";

	protected static String[] insertIntoQueries = {
		insertCategories,
		insertProducts
	};

}
