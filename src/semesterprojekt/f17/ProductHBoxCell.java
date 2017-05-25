package semesterprojekt.f17;

import DAM.DAMImage;
import Webshop.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ProductHBoxCell extends HBox {

    ImageView imageView = new ImageView();
    Label name = new Label();
    Label price = new Label();
    Label amountLabel = new Label();
    Label totalPrice = new Label();
    private int id;

    public ProductHBoxCell(Product product) {
	//Sets the padding and spacing.
	super();
	this.setSpacing(10);

	id = product.getId();

	if (product.getImageList().isEmpty()) {
	    imageView.setImage(new Image("images/" + product.getImagePath()));
	} else {
	    imageView.setImage(product.getImageList().get(0));
	}
	name.setText(product.getName());
	name.setPrefWidth(150);
	price.setText(Double.toString(product.getPrice()) + "kr");

	imageView.setFitWidth(100);
	imageView.setPreserveRatio(true);

	this.getChildren().addAll(imageView, name, price);
    }

    public ProductHBoxCell(OrderLine orderLine) {
	//Sets the padding and spacing.
	super();
	this.setSpacing(10);

	Product product = orderLine.getProduct();
	int amount = orderLine.getAmount();

	id = product.getId();

	imageView.setImage(new Image("images/" + product.getImagePath()));
	name.setText(product.getName());
	price.setText(Double.toString(product.getPrice()) + "kr");
	amountLabel.setText(Integer.toString(amount));
	totalPrice.setText(Double.toString(product.getPrice() * amount) + "kr");

	name.setPrefWidth(150);
	price.setPrefWidth(100);
	amountLabel.setPrefWidth(100);
	imageView.setFitWidth(100);
	imageView.setPreserveRatio(true);

	this.getChildren().addAll(imageView, name, price, amountLabel, totalPrice);
    }

    public ProductHBoxCell(DAMImage damImage) {
	//Sets the padding and spacing.
	super();
	this.setSpacing(10);

	Label category = new Label();

	id = damImage.getId();

	imageView.setImage(damImage.getImage());
	name.setText(damImage.getTitle());
	name.setPrefWidth(150);

	category.setText(damImage.getCategory());
	category.setPrefWidth(150);

	imageView.setFitWidth(200);
	imageView.setPreserveRatio(true);

	this.getChildren().addAll(imageView, name, category);
    }

    public int getProductId() {
	return id;
    }

    @Override
    public String toString() {
	return id + name.getText();
    }
}
