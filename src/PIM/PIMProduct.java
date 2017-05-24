package PIM;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 *
 */
public class PIMProduct {
    
    private int id;
    private int category;
    private double price;
    private String description;
    private String titel;
    private ArrayList<Image> imageList;
    
    public PIMProduct(int id, int category, double price, String description, String titel, ArrayList<Image> imageList) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.description = description;
        this.titel = titel;
        this.imageList = imageList;
    }

}
