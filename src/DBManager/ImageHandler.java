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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import static jdk.nashorn.internal.runtime.Debug.id;

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
            String sqlId = "SELECT max(imageid) + 1 FROM Images;";
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
            String sql = "SELECT * FROM ImageFiles";
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

    public static ArrayList<Image> getImages(Connection connection, int productID) {
        ArrayList<Image> imageList = new ArrayList<>();
        ResultSet imageSet = null;

        try {
            String sql = "SELECT imagefile "
                    + "FROM images "
                    + "NATURAL JOIN imageFiles "
                    + "WHERE images.productid = " + productID;
            PreparedStatement ps = connection.prepareStatement(sql);
            imageSet = ps.executeQuery();

            while (imageSet.next()) {
                InputStream inputStream = imageSet.getBinaryStream("imagefile");
                imageList.add(new Image(inputStream));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageList;
    }

    public static HashMap<String, String> getDAMImage(Connection connection, int id) {
        HashMap<String, String> DAMImageMap = new HashMap<>();

        DAMImage damImage = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT title, imageid, categoryName, productId "
                    + "FROM Images "
                    + "WHERE Imageid = " + id);
            ResultSet images = ps.executeQuery();
            images.next();

            DAMImageMap.put("title", images.getString(1));
            DAMImageMap.put("imageID", images.getString(2));
            DAMImageMap.put("categoryName", images.getString(3));
            DAMImageMap.put("productID", images.getString(4));

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return DAMImageMap;
    }

    public static LinkedList<HashMap<String, String>> getDAMImages(Connection connection) {
        LinkedList<HashMap<String, String>> DAMImageMapList = new LinkedList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT title, imageid, categoryName, productId "
                    + "FROM Images "
                    + "NATURAL JOIN categories");
            ResultSet images = ps.executeQuery();

            while (images.next()) {
                HashMap<String, String> DAMImageMap = new HashMap<>();
                DAMImageMap.put("title", images.getString(1));
                DAMImageMap.put("imageID", images.getString(2));
                DAMImageMap.put("categoryName", images.getString(3));
                DAMImageMap.put("productID", images.getString(4));

                DAMImageMapList.add(DAMImageMap);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DAMImageMapList;
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
