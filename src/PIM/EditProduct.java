package PIM;

import DBManager.ProductHandler;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 *
 */
public class EditProduct {

    public static void newProduct(int category, double price, String description, String titel, ArrayList<Integer> imageList) {
       DBManager.DBManager.getInstance().addProduct(category, price, description, titel, imageList);
    }

    public void editProduct(int id) {

    }

}
