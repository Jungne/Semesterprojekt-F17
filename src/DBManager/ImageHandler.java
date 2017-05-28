package DBManager;

import DAM.DAMImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

	public DAMImage getImage(int imageId) {
		try {
			ResultSet imageSet = executeQuery("SELECT imageName, categoryName, imageFile "
							+ "FROM Images NATURAL JOIN Categories NATURAL JOIN ImageFiles "
							+ "WHERE imageId = " + imageId);
			imageSet.next();

			return new DAMImage(imageId, imageSet.getString(1), imageSet.getString(2), imageSet.getBinaryStream(3));
		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public ArrayList<DAMImage> getAllImages() {
		try {
			ResultSet imageSet = executeQuery("SELECT imageId, imageName, categoryName, imageFile FROM Images NATURAL JOIN Categories NATURAL JOIN ImageFiles");

			ArrayList<DAMImage> images = new ArrayList<>();
			while (imageSet.next()) {
				images.add(new DAMImage(imageSet.getInt(1), imageSet.getString(2), imageSet.getString(3), imageSet.getBinaryStream(4)));
			}

			return images;
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
