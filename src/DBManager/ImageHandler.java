package DBManager;

import DAM.DAMImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class ImageHandler {

	/**
	 * adds an image to the database
	 *
	 * @param connection
	 * @param imagePath
	 * @param title
	 * @param category
	 */
	public static void createImage(Connection connection, String imagePath, String title, int categoryid) {
		try {
			//Getting next id for image by selecting max id and adding 1
			String sqlId = "SELECT max(id) + 1 FROM Images;";
			PreparedStatement psId = connection.prepareStatement(sqlId);
			ResultSet maxID = psId.executeQuery();
			maxID.next();
			int id = maxID.getInt(1);
			//Setting up the query for images
			String sql = "INSERT INTO Images VALUES (?, null, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id); //Setting id
			ps.setString(2, title); //Setting title
			ps.setInt(3, categoryid); //Setting category
			ps.executeUpdate();

			//Setting up the query for imagefile
			PreparedStatement insertImageFile = connection.prepareStatement("INSERT INTO ImageFiles VALUES (?, ?);");
			insertImageFile.setInt(1, id);
			InputStream input = new FileInputStream(new File(imagePath));
			insertImageFile.setBinaryStream(2, input); //Setting image

			insertImageFile.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static Image getImage(Connection connection, int id) {
		Image image = null;
		try {
			String sql = "SELECT imageFile FROM ImageFiles WHERE imageId = " + id;
			Statement s = connection.createStatement();
			ResultSet resultSet = s.executeQuery(sql);
			resultSet.next();
			InputStream inputStream = resultSet.getBinaryStream("imageFile");
			image = new Image(inputStream);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return image;
	}

	public static ArrayList<Image> getImages(Connection connection) {
		ArrayList<Image> imageList = null;
		ResultSet imageSet = null;
		InputStream inputStream = null;

		try {
			String sql = "SELECT * FROM ImageFiles;";
			PreparedStatement ps = connection.prepareStatement(sql);
			imageSet = ps.executeQuery(sql);
			inputStream = imageSet.getBinaryStream("imageFile");

			while (imageSet.next()) {
				imageList.add(new Image(inputStream));
			}

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return imageList;
	}

	public static DAMImage getDAMImage(Connection connection, int id) {
		DAMImage damImage = null;
		Image image = getImage(connection, id);
		String title;
		String category;
		int productID;

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT Images.id, productId, title, Categories.name, ImageFiles.imageFile "
							+ "FROM Images, ImageFiles, Categories "
							+ "WHERE Images.id = " + id + " AND Categories.id = Images.categoryId;");
			ResultSet images = ps.executeQuery();
			images.next();

			title = images.getString(3);
			category = images.getString(4);
			productID = images.getInt(2);
			damImage = new DAMImage(title, id, category, image, productID);

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return damImage;
	}

	public static ArrayList<DAMImage> getDAMImages(Connection connection) {
		ArrayList<DAMImage> damImages = new ArrayList<>();
		DAMImage damImage = null;
		Image image;
		int id;
		String title;
		String category;
		int productID;

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT Images.id, productId, title, Categories.name, ImageFiles.imageFile "
							+ "FROM Images, ImageFiles, Categories "
							+ "WHERE Images.id = ImageFiles.imageId AND Categories.id = Images.categoryId;");
			ResultSet images = ps.executeQuery();

			while (images.next()) {
				id = images.getInt(1);
				title = images.getString(3);
				category = images.getString(4);
				productID = images.getInt(2);
				image = getImage(connection, id);
				damImages.add(new DAMImage(title, id, category, image, productID));
			}

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return damImages;
	}

	public static void deleteImage(Connection connection, int id) {
		try {
			PreparedStatement deleteFromImageFiles = connection.prepareStatement("DELETE FROM ImageFiles WHERE imageId = " + id);
			deleteFromImageFiles.executeUpdate();
			PreparedStatement deleteFromImages = connection.prepareStatement("DELETE FROM Images WHERE id = " + id);
			deleteFromImages.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
