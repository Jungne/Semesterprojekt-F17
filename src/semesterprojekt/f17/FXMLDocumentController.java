package semesterprojekt.f17;

import Webshop.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {

	private WebshopInterface webshopController;

	@FXML
	private Button CatalogTestShowProductsButton;
	@FXML
	private ListView<ProductHBoxCell> catalogTestListView;
	@FXML
	private TabPane tabPane;
	@FXML
	private Tab catalogTestTab;
	@FXML
	private AnchorPane catalogTestAnchorPane;
	@FXML
	private Button catalogTestShowInfoButton;
	@FXML
	private ImageView catalogTestImageView;
	@FXML
	private TextArea catalogTestTextArea;
	@FXML
	private TextField searchTextField;
	@FXML
	private Button searchButton;
	@FXML
	private ChoiceBox<String> categoriesChoiceBox;
	@FXML
	private Button addToBasketButton;
	@FXML
	private ListView<ProductHBoxCell> shoppingBasketListView;
	@FXML
	private Button setAmountButton;
	@FXML
	private Button deleteButton;
	@FXML
	private TextField amountTextField;
	@FXML
	private TextField totalPriceTextField;

	@FXML
	private void handleCatalogTestShowProductsButton(ActionEvent e) {
		ArrayList<Product> products = webshopController.getProductList();
		showProducts(products, catalogTestListView);
	}

	@FXML
	private void handleCatalogTestShowInfoButton(ActionEvent e) {
		int id = catalogTestListView.getSelectionModel().getSelectedItem().getProductId();
		Product product = webshopController.getProduct(id);

		catalogTestImageView.setImage(new Image("images/" + product.getImagePath()));

		String text = "";
		text = "Name: " + product.getName() + "\n";
		text += "Category: " + product.getCategory() + "\n";
		text += "Price: " + Double.toString(product.getPrice()) + "\n";
		text += "Description: " + product.getDescription();

		catalogTestTextArea.setText(text);
	}

	@FXML
	private void handleSearchButton(ActionEvent e) {
		ArrayList<Product> products = webshopController.findProduct(searchTextField.getText());
		showProducts(products, catalogTestListView);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		try {
			webshopController = new WebshopController();
		} catch (IOException ex) {
			//Do something about this.
			Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
		}

		//populates categoriesChoiceBox.
		categoriesChoiceBox.setItems(FXCollections.observableArrayList(webshopController.getCategories()));
		categoriesChoiceBox.setValue(categoriesChoiceBox.getItems().get(0));
	}

	private void showProducts(ArrayList<Product> products, ListView listview) {
		List<ProductHBoxCell> list = new ArrayList<>();
		for (Product product : products) {
			list.add(new ProductHBoxCell(product));
		}
		ObservableList observableList = FXCollections.observableArrayList(list);
		listview.setItems(observableList);
	}

	@FXML
	private void handleFilterButton(ActionEvent event) {
		ArrayList<Product> products = webshopController.getCategory(categoriesChoiceBox.getValue());
		showProducts(products, catalogTestListView);
	}

	@FXML
	private void handleAddToBasketButton(ActionEvent e) {
		int id = catalogTestListView.getSelectionModel().getSelectedItem().getProductId();
		webshopController.addProductToBasket(id, 1);

		updateShoppingBasket();
	}

	@FXML
	private void handleDeleteButton(ActionEvent e) {
		int id = shoppingBasketListView.getSelectionModel().getSelectedItem().getProductId();
		webshopController.removeProduct(id);

		updateShoppingBasket();
	}

	@FXML
	private void handleSetAmountButton(ActionEvent e) {
		try {
			int id = shoppingBasketListView.getSelectionModel().getSelectedItem().getProductId();
			webshopController.setProductAmount(id, Integer.parseInt(amountTextField.getText()));

			updateShoppingBasket();
		} catch (Exception ex) {
			amountTextField.setText("1");
		}
	}

	private void updateShoppingBasket() {
		double totalPrice = 0;

		ArrayList<OrderLine> orderLines = webshopController.getShoppingBasket().getBasketContent();
		List<ProductHBoxCell> list = new ArrayList<>();
		for (OrderLine orderLine : orderLines) {
			list.add(new ProductHBoxCell(orderLine));
			totalPrice += (orderLine.getProduct().getPrice() * orderLine.getAmount());
		}
		ObservableList observableList = FXCollections.observableArrayList(list);
		shoppingBasketListView.setItems(observableList);
		totalPriceTextField.setText(Double.toString(totalPrice));
	}
}
