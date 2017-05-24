package PIM;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 *
 */
public class EditProduct {

    public void newProduct(int id, int category, double price, String description, String titel, ArrayList<Image> imageList) {
        PIMProduct product = new PIMProduct(id, category, price, description, titel, imageList);
    }

    public void editProduct(int id) {

    }

}
