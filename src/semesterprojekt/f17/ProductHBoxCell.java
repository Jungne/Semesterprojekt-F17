/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt.f17;

import Webshop.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ProductHBoxCell extends HBox {

	ImageView imageView = new ImageView();
	Label name = new Label();
	Label price = new Label();
	private int id;

	public ProductHBoxCell(Product product) {
		super(100);
		id = product.getId();

		imageView.setImage(new Image("images/" + product.getImagePath()));
		name.setText(product.getName());
		price.setText(Double.toString(product.getPrice()) + "kr");

		imageView.setFitWidth(100);
		imageView.setPreserveRatio(true);

		this.getChildren().addAll(imageView, name, price);
	}

	public int getProductId() {
		return id;
	}
}
