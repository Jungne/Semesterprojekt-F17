package DBManager;

import DAM.DAMImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageHandler {

	private Connection connection;

	public ImageHandler(Connection connection) {
		this.connection = connection;
	}

	private void executeUpdate(String query) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(query);
		}
	}

	private ResultSet executeQuery(String query) throws SQLException {
		return connection.createStatement().executeQuery(query);
	}

	public InputStream getImage(int imageID) {
		try {
			InputStream inputStream = null;
			ResultSet imageFileSet = executeQuery("SELECT imageFile FROM imageFiles WHERE imageID = " + imageID);
			if (imageFileSet.next()) {
				inputStream = imageFileSet.getBinaryStream(1);
			}
			return inputStream;
		} catch (SQLException ex) {
			Logger.getLogger(ImageHandler.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}

	}

	public ArrayList<InputStream> getImageFiles(int productID) {
		try {
			ResultSet imageFileSet = executeQuery("SELECT imageFile FROM Images NATURAL JOIN ImageFiles WHERE productId = " + productID);

			ArrayList<InputStream> imageFiles = new ArrayList<>();
			while (imageFileSet.next()) {
				imageFiles.add(imageFileSet.getBinaryStream(1));
			}

			return imageFiles;
		} catch (SQLException ex) {
			Logger.getLogger(ImageHandler.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public HashMap<String, String> getDAMImage(int imageId) {
		try {

			HashMap<String, String> DAMImageMap = new HashMap<>();

			DAMImage damImage = null;

			ResultSet imageSet = executeQuery("SELECT imageName, categoryName "
							+ "FROM Images NATURAL JOIN Categories "
							+ "WHERE imageId = " + imageId);
			imageSet.next();

			DAMImageMap.put("imageId", imageId + "");
			DAMImageMap.put("imageName", imageSet.getString(1));
			DAMImageMap.put("categoryName", imageSet.getString(2));

			return DAMImageMap;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public LinkedList<HashMap<String, String>> getAllImages() {
		try {
			LinkedList<HashMap<String, String>> DAMImageMapList = new LinkedList<>();

			ResultSet imageSet = executeQuery("SELECT imageID, imageName, categoryName FROM Images NATURAL JOIN Categories");

			while (imageSet.next()) {
				HashMap<String, String> DAMImageMap = new HashMap<>();
				DAMImageMap.put("imageID", imageSet.getString(1));
				DAMImageMap.put("imageName", imageSet.getString(2));
				DAMImageMap.put("categoryName", imageSet.getString(3));

				DAMImageMapList.add(DAMImageMap);
			}
			return DAMImageMapList;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public boolean createImage(String name, String category, InputStream imageFile) {
		try {
			//Creates new category if not exists
			ResultSet categoryNameSet = executeQuery("SELECT categoryName FROM Categories WHERE categoryName = '" + category + "'");
			if (!categoryNameSet.next()) {
				executeUpdate("INSERT INTO Categories (categoryName) VALUES ('" + category + "')");
			}

			//Gets the categoryId
			ResultSet categoryIdSet = executeQuery("SELECT categoryId FROM Categories WHERE categoryName = '" + category + "'");
			categoryIdSet.next();
			int categoryId = categoryIdSet.getInt(1);

			//Inserts the image
			executeUpdate("INSERT INTO Images (productId, imageName, categoryId) VALUES (null, '" + name + "', " + categoryId + ")");

			//Gets the imageId
			ResultSet imageIdSet = executeQuery("SELECT imageId FROM Images WHERE imageName = '" + name + "'");
			imageIdSet.next();
			int imageId = imageIdSet.getInt(1);

			//Inserts the imageFile
			PreparedStatement insertImageFile = connection.prepareStatement("INSERT INTO ImageFiles (imageId, imageFile) VALUES (" + imageId + ", ?)");
			insertImageFile.setBinaryStream(1, imageFile);
			insertImageFile.executeUpdate();

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean deleteImage(int imageId) {
		try {
			executeUpdate("DELETE FROM ImageFiles WHERE imageId = " + imageId);
			executeUpdate("DELETE FROM Images WHERE imageId = " + imageId);

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

}
