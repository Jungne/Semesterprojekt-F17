package PIM;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 *
 */
public class PIMProduct {
    
    private int id;
    private String category;
    private double price;
    private String description;
    private String name;
    private ArrayList<Image> images;
    
    public PIMProduct(String name, int id, String category, String description, double price, ArrayList<Image> images) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.description = description;
        this.name = name;
        this.images = images;
    }

}
