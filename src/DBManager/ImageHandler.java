
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

/**
 *
 * @author hjaltefromholtrindom
 */
public class ImageHandler {
    
    public static void addImage(Connection connection, String imagePath, String titel, int category) {
        try {
			String sql = "INSERT INTO images VALUES (?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
                        
                        //Getting next id for image by selecting max id and adding 1
                        String sqlId = "SELECT max(id) + 1 FROM images";
                        PreparedStatement psId = connection.prepareStatement(sqlId);
                        ResultSet resultset = psId.executeQuery();
                        
			ps.setInt(1, );

			InputStream input = new FileInputStream(new File(imagePath));
			ps.setBinaryStream(2, input);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
}
