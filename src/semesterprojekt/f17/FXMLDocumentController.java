package semesterprojekt.f17;

import DAM.DAMImage;
import DAM.DAMManager;
import DBManager.DBManager;
import Webshop.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

	private WebshopInterface webshopController;
	private DAMManager DAM;
	private DBManager dbm;

	private LinkedHashMap<String, Integer> categoriesMap;
	private boolean isLoggedIn = false;
	private ShoppingBasket guestBasket = new ShoppingBasket();
	private int imageNumber;
	private Product currentProduct;

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
	private ToggleButton testLogInOutButton;
	@FXML
	private Button ShoppingBasket_CheckOutButton;
	@FXML
	private Tab CheckOut_Tab;
	@FXML
	private Pane CheckOut_InformationPane;
	@FXML
	private Pane CheckOut_PaymentPane;
	@FXML
	private Button CheckOut_ConfirmOrderButton;
	@FXML
	private Button CheckOut_PayButton;
	@FXML
	private Button CheckOut_DoneButton;
	@FXML
	private Pane CheckOut_EndPane;
	@FXML
	private TextField CheckOut_URCPane_FirstnameTextField;
	@FXML
	private TextField CheckOut_URCPane_LastnameTextField;
	@FXML
	private TextField CheckOut_URCPane_EmailTextField;
	@FXML
	private TextField CheckOut_URCPane_PhoneTextField;
	@FXML
	private Label CheckOut_EndPane_Receipt;
	@FXML
	private ImageView DAMImageView;
	@FXML
	private Button browseButton;
	@FXML
	private TextField imagePathTextField;
	@FXML
	private Button saveImageButton;
	@FXML
	private Button openImageButton;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private TextField imageTitleTextField;
	@FXML
	private ChoiceBox<String> imageCategoryChoiceBox;
	@FXML
	private Button dbCreateButton;
	@FXML
	private Button dbDropButton;
	@FXML
	private Button dbInsertButton;
	@FXML
	private Button updateButton;
	@FXML
	private ListView<ProductHBoxCell> DAMListView;
	@FXML
	private Button DAMDeleteButton;
	@FXML
	private Button imageLeftButton;
	@FXML
	private Button imageRightButton;
	@FXML
	private Label imageNumberLabel;
	@FXML
	private Button PIMShowProductsButton;
	@FXML
	private Button PIMEditProductButton;
	@FXML
	private Button PIMNewProductButton;

	@FXML
	private void handleCatalogTestShowProductsButton(ActionEvent e) {
		ArrayList<Product> products = webshopController.getAllProduct();
		showProducts(products, catalogTestListView);
		searchTextField.clear();
	}

	@FXML
	private void handleCatalogTestShowInfoButton(ActionEvent e) {
		ProductHBoxCell productHBoxCell = catalogTestListView.getSelectionModel().getSelectedItem();
		if (productHBoxCell == null) {
			return;
		}

		//Gets the id for the selected product.
		int id = productHBoxCell.getProductId();
		currentProduct = webshopController.getProduct(id);

		//Sets the current image to the first if any, else it is set to the default image.
		if (!currentProduct.getImageFiles().isEmpty()) {
			InputStream inputStream = new ByteArrayInputStream(currentProduct.getImageFiles().get(0));
			catalogTestImageView.setImage(new Image(inputStream));
		} else {
			catalogTestImageView.setImage(new Image("images/test.jpeg"));
		}

		//Sets the text under the image to display the number of images for the selected product.
		if (currentProduct.getImageFiles().size() == 1) {
			imageLeftButton.setDisable(true);
			imageRightButton.setDisable(true);
			imageNumberLabel.setText("1 ud af 1");
		} else if (currentProduct.getImageFiles().size() > 1) {
			imageNumber = 1;
			imageLeftButton.setDisable(true);
			imageRightButton.setDisable(false);
			imageNumberLabel.setText(imageNumber + " ud af " + currentProduct.getImageFiles().size());
		} else {
			imageLeftButton.setDisable(true);
			imageRightButton.setDisable(true);
			imageNumberLabel.setText("0 ud af 0");
		}

		//Sets the descriptive text for the selected product.
		String text = "";
		text = "Name: " + currentProduct.getName() + "\n";
		text += "Category: " + currentProduct.getCategory() + "\n";
		text += "Price: " + Double.toString(currentProduct.getPrice()) + "\n";
		text += "Description: " + currentProduct.getDescription();
		catalogTestTextArea.setText(text);
	}

	@FXML
	private void handleSearchButton(ActionEvent e) {
		ArrayList<Product> products = webshopController.findProducts(searchTextField.getText(), getCategoryID(categoriesChoiceBox.getValue()));
		showProducts(products, catalogTestListView);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		try {
			webshopController = new WebshopController();
			DAM = new DAMManager();
			dbm = DBManager.getInstance();
		} catch (IOException ex) {
			//Do something about this.
			Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
		}

		updateChoiceBoxes();
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
	private void handleAddToBasketButton(ActionEvent e) {
		int id = catalogTestListView.getSelectionModel().getSelectedItem().getProductId();
		if (isLoggedIn) {
			webshopController.addProductToBasket(id, 1);
		} else {
			guestBasket.addProduct(webshopController.getProduct(id), 1);
		}

		updateShoppingBasket();
	}

	@FXML
	private void handleDeleteButton(ActionEvent e) {
		int id = shoppingBasketListView.getSelectionModel().getSelectedItem().getProductId();
		if (isLoggedIn) {
			webshopController.removeProduct(id);
		} else {
			guestBasket.removeProduct(webshopController.getProduct(id));
		}

		updateShoppingBasket();
	}

	@FXML
	private void handleSetAmountButton(ActionEvent e) {
		try {
			int id = shoppingBasketListView.getSelectionModel().getSelectedItem().getProductId();
			int amount = Integer.parseInt(amountTextField.getText());
			if (isLoggedIn) {
				webshopController.setProductAmount(id, amount);
			} else {
				guestBasket.setProductAmount(webshopController.getProduct(id), amount);
			}

			updateShoppingBasket();
		} catch (Exception ex) {
			amountTextField.setText("1");
		}
	}

	private void updateShoppingBasket() {
		double totalPrice = 0;

		ArrayList<OrderLine> orderLines = isLoggedIn ? webshopController.getShoppingBasket().getOrderLines() : guestBasket.getOrderLines();
		List<ProductHBoxCell> list = new ArrayList<>();
		for (OrderLine orderLine : orderLines) {
			list.add(new ProductHBoxCell(orderLine));
			totalPrice += (orderLine.getProduct().getPrice() * orderLine.getAmount());
		}
		ObservableList observableList = FXCollections.observableArrayList(list);
		shoppingBasketListView.setItems(observableList);
		totalPriceTextField.setText(Double.toString(totalPrice));
		if (orderLines.size() == 0) {
			ShoppingBasket_CheckOutButton.setDisable(true);
		} else {
			ShoppingBasket_CheckOutButton.setDisable(false);
		}
	}

	@FXML
	private void handleTestLogInOutButton(ActionEvent event) {
		if (!isLoggedIn) {
			testLogInOutButton.setText("Log ud");
			guestBasket.empty();
		} else {
			testLogInOutButton.setText("Log ind");
			reset();
		}
		isLoggedIn = !isLoggedIn;
		updateShoppingBasket();
	}

	@FXML
	private void handleShoppingBasket_CheckOutButton(ActionEvent event) {
		CheckOut_Tab.setDisable(false);
		tabPane.getSelectionModel().select(CheckOut_Tab);
		ShoppingBasket_CheckOutButton.setDisable(true);
		if (isLoggedIn) {
			handleCheckOut_ConfirmOrderButton(null);
		} else {
			CheckOut_PaymentPane.setVisible(false);
			CheckOut_InformationPane.setVisible(true);
		}
	}

	@FXML
	private void handleCheckOut_ConfirmOrderButton(ActionEvent event) {
		CheckOut_PaymentPane.setVisible(true);
		CheckOut_InformationPane.setVisible(false);
		if (isLoggedIn) {
			webshopController.checkOut(1);
		} else {
			webshopController.checkOut(
							CheckOut_URCPane_EmailTextField.getText(),
							CheckOut_URCPane_FirstnameTextField.getText(),
							CheckOut_URCPane_LastnameTextField.getText(),
							Integer.parseInt(CheckOut_URCPane_PhoneTextField.getText()),
							88888888,
							"address",
							"postalCode",
							"city",
							"country");
		}

		CheckOut_URCPane_FirstnameTextField.setText("");
		CheckOut_URCPane_LastnameTextField.setText("");
		CheckOut_URCPane_EmailTextField.setText("");
		CheckOut_URCPane_PhoneTextField.setText("");
		String text = "Ordrekvittering\n"
						+ "-------------------------------\n"
						+ "\n";

		Order order = webshopController.getLatestOrder(1);

		for (OrderLine item : order.getShoppingBasket().getOrderLines()) {
			text += "" + item.getAmount() + "x " + item.getProduct().getName() + " : " + item.getProduct().getPrice() + "kr\n";
		}
		text += "Total Pris: " + order.getTotalPrice() + "kr.\n"
						+ "-------------------------------\n"
						+ "Ha' en god dag!";
		CheckOut_EndPane_Receipt.setText(text);
		guestBasket.empty();
		webshopController.emptyShoppingBasket();
		updateShoppingBasket();
	}

	@FXML
	private void handleCheckOut_PayButton(ActionEvent event) {
		CheckOut_PaymentPane.setVisible(false);
		CheckOut_EndPane.setVisible(true);
	}

	@FXML
	private void handleCheckOut_DoneButton(ActionEvent event) {
		reset();
	}

	@FXML
	public void handleBrowseButton(ActionEvent event) {
		Stage stage = (Stage) anchorPane.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();

		File file = fileChooser.showOpenDialog(stage);

		imagePathTextField.setText(file.getPath());
	}

	@FXML
	private void handleSaveImageButton(ActionEvent event) {
		DAM.createImage(imageTitleTextField.getText(), imageCategoryChoiceBox.getValue(), imagePathTextField.getText());
		showDAMImages();
	}

	@FXML
	public void handleOpenImageButton(ActionEvent event) {
		//DAMImageView.setImage(DAM.getImage(0));
		showDAMImages();

	}

	private void showDAMImages() {
		ArrayList<DAMImage> damImages = DAM.getDAMImages();
		List<ProductHBoxCell> list = new ArrayList<>();
		for (DAMImage damImage : damImages) {
			list.add(new ProductHBoxCell(damImage));
			damImage.toString();
		}
		ObservableList observableList = FXCollections.observableArrayList(list);
		DAMListView.setItems(observableList);
	}

	private void reset() {
		CheckOut_Tab.setDisable(true);
		CheckOut_EndPane.setVisible(false);
		tabPane.getSelectionModel().select(catalogTestTab);
		ShoppingBasket_CheckOutButton.setDisable(false);
		CheckOut_EndPane_Receipt.setText("");
	}

	private void updateChoiceBoxes() {
		categoriesMap = webshopController.getCategories();
		categoriesMap.put("Ingen", -1);
		ArrayList<String> categoriesList = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : categoriesMap.entrySet()) {
			categoriesList.add(entry.getKey());
		}
		//populates categoriesChoiceBox.
		categoriesChoiceBox.setItems(FXCollections.observableArrayList(categoriesList));
		categoriesChoiceBox.setValue(categoriesChoiceBox.getItems().get(0));
		imageCategoryChoiceBox.setItems(FXCollections.observableArrayList(categoriesList));
		imageCategoryChoiceBox.setValue(imageCategoryChoiceBox.getItems().get(0));
	}

	@FXML
	private void handledbCreateButton(ActionEvent event) {
		dbm.setUpTables();
	}

	@FXML
	private void handledbDropButton(ActionEvent event) {
		dbm.dropTables();
	}

	@FXML
	private void handledbInsertButton(ActionEvent event) {
		dbm.insertData();
	}

	@FXML
	private void handleUpdateButton(ActionEvent event) {
		updateChoiceBoxes();
	}

	@FXML
	private void handleDAMDeleteButton(ActionEvent event) {
		int id = DAMListView.getSelectionModel().getSelectedItem().getProductId();

		DAM.deleteImage(id);

		showDAMImages();
	}

	private int getCategoryID(String category) {
		return categoriesMap.get(category);
	}

	@FXML
	private void handleLeftImageButton(ActionEvent event) {
		imageNumber--;
		InputStream inputStream = new ByteArrayInputStream(currentProduct.getImageFiles().get(imageNumber - 1));
		catalogTestImageView.setImage(new Image(inputStream));
		imageNumberLabel.setText((imageNumber) + " ud af " + currentProduct.getImageFiles().size());

		if (imageNumber == 1) {
			imageLeftButton.setDisable(true);
		}
		imageRightButton.setDisable(false);
	}

	@FXML
	private void handleImageRightButton(ActionEvent event) {
		imageNumber++;
		InputStream inputStream = new ByteArrayInputStream(currentProduct.getImageFiles().get(imageNumber - 1));
		catalogTestImageView.setImage(new Image(inputStream));
		imageNumberLabel.setText((imageNumber) + " ud af " + currentProduct.getImageFiles().size());

		if (imageNumber == currentProduct.getImageFiles().size()) {
			imageRightButton.setDisable(true);
		}
		imageLeftButton.setDisable(false);
	}

}
