
package DBManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ImageHandler {
    
    /**
    * adds an image to the database
    * 
     * @param connection
     * @param imagePath
     * @param title
     * @param category
    */
    public static void addImage(Connection connection, String imagePath, String title, int category) {
        try {
			String sql = "INSERT INTO images VALUES (?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
                        
                        //Getting next id for image by selecting max id and adding 1
                        String sqlId = "SELECT max(id) + 1 FROM images";
                        PreparedStatement psId = connection.prepareStatement(sqlId);
                        ResultSet rs = psId.executeQuery();
                        rs.next(); 
			ps.setInt(1, rs.getInt(1)); //Setting id
                        
                        ps.setString(2, title); //Setting titel

			InputStream input = new FileInputStream(new File(imagePath));
			ps.setBinaryStream(3, input); //Setting image
                        
                        ps.setInt(4, category); //Setting category
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
}
