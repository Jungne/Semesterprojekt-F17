package semesterprojekt.f17;

import DAM.DAMImage;
import DAM.DAMManager;
import DBManager.DBManager;
import PIM.PIMManager;
import PIM.PIMProduct;
import PIM.PIMage;
import Webshop.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLDocumentController2 implements Initializable {

	private WebshopInterface webshopController;
	private DAMManager DAM;
	private DBManager dbm;
	private PIMManager pimManager;

	private Product currentProduct;
	private PIMProduct pimProduct;
	private int imageNumber;
	private ArrayList<Image> currentProductImages = new ArrayList<>();
	private LinkedHashMap<String, Integer> categoriesMap;
	private ShoppingBasket guestBasket = new ShoppingBasket();
	private ShoppingBasket currentBasket = new ShoppingBasket();
	private boolean isLoggedIn = false;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Pane MenuPane;
	// <editor-fold defaultstate="collapsed" desc="MenuPane - Elements">
	@FXML
	private Button MenuPane_WebshopButton;
	@FXML
	private Button MenuPane_PIMButton;
	@FXML
	private Button MenuPane_DAMButton;
	// </editor-fold>

	@FXML
	private TabPane WebshopPane;
	// <editor-fold defaultstate="collapsed" desc="WebshopPane - Elements">
	@FXML
	private Tab WebshopPane_CatalogTab;
	// <editor-fold defaultstate="collapsed" desc="WebshopPane_CatalogTab - Elements">
	@FXML
	private Button WebshopPane_CatalogTab_ShowProductsButton;
	@FXML
	private ListView<ProductHBoxCell> WebshopPane_CatalogTab_ProductsListView;
	@FXML
	private Button WebshopPane_CatalogTab_ShowInfoButton;
	@FXML
	private ImageView WebshopPane_CatalogTab_ProductImageView;
	@FXML
	private TextArea WebshopPane_CatalogTab_ProductTextArea;
	@FXML
	private TextField WebshopPane_CatalogTab_SearchTextField;
	@FXML
	private Button WebshopPane_CatalogTab_SearchButton;
	@FXML
	private ChoiceBox<String> WebshopPane_CatalogTab_CategoryChoiceBox;
	@FXML
	private Button WebshopPane_CatalogTab_AddToBasketButton;
	@FXML
	private Button WebshopPane_CatalogTab_ImageLeftButton;
	@FXML
	private Button WebshopPane_CatalogTab_ImageRightButton;
	@FXML
	private Label WebshopPane_CatalogTab_ImageNumberLabel;
	// </editor-fold>

	@FXML
	private Tab WebshopPane_BasketTab;
	// <editor-fold defaultstate="collapsed" desc="WebshopPane_BasketTab - Elements">
	@FXML
	private ListView<ProductHBoxCell> WebshopPane_BasketTab_BasketListView;
	@FXML
	private TextField WebshopPane_BasketTab_AmountTextField;
	@FXML
	private TextField WebshopPane_BasketTab_TotalPriceTextField;
	@FXML
	private Button WebshopPane_BasketTab_SetAmountButton;
	@FXML
	private Button WebshopPane_BasketTab_DeleteButton;
	@FXML
	private Button WebshopPane_BasketTab_CheckOutButton;
	@FXML
	private ChoiceBox<String> WebshopPane_BasketTab_BasketChoiceBox;
	// </editor-fold>

	@FXML
	private Tab WebshopPane_CheckoutTab;
	// <editor-fold defaultstate="collapsed" desc="WebshopPane_CheckoutTab - Elements">
	@FXML
	private Pane WebshopPane_CheckoutTab_InformationPane;
	@FXML
	private Button WebshopPane_CheckoutTab_ConfirmOrderButton;
	@FXML
	private TextField WebshopPane_CheckoutTab_InformationPane_FirstnameTextField;
	@FXML
	private TextField WebshopPane_CheckoutTab_InformationPane_LastnameTextField;
	@FXML
	private TextField WebshopPane_CheckoutTab_InformationPane_AddressTextField;
	@FXML
	private TextField WebshopPane_CheckoutTab_InformationPane_PostalCodeTextField;
	@FXML
	private TextField WebshopPane_CheckoutTab_InformationPane_CityTextField;
	@FXML
	private TextField WebshopPane_CheckoutTab_InformationPane_CountryTextField;
	@FXML
	private TextField WebshopPane_CheckoutTab_InformationPane_EmailTextField;
	@FXML
	private TextField WebshopPane_CheckoutTab_InformationPane_PhoneNumberTextField;
	@FXML
	private TextField WebshopPane_CheckoutTab_InformationPane_MobilePhoneNumberTextField;
	@FXML
	private Pane WebshopPane_CheckoutTab_PaymentPane;
	@FXML
	private Button WebshopPane_CheckoutTab_PaymentPane_PayButton;
	@FXML
	private Pane WebshopPane_CheckoutTab_EndPane;
	@FXML
	private Label WebshopPane_CheckoutTab_EndPane_ReceiptLabel;
	@FXML
	private Button WebshopPane_CheckoutTab_CancelOrderButton;
	@FXML
	private Button WebshopPane_CheckoutTab_EndPane_DoneButton;
	// </editor-fold>
	// </editor-fold>

	@FXML
	private Pane PIMPane;
	// <editor-fold defaultstate="collapsed" desc="PIMPane - Elements">
	@FXML
	private Pane PIMPane_NavigationPane;
	// <editor-fold defaultstate="collapsed" desc="PIMPane_NavigationPane - Elements">
	@FXML
	private ChoiceBox<String> PIMPane_NavigationPane_CategoryChoiceBox;
	@FXML
	private TextField PIMPane_NavigationPane_SearchBar;
	@FXML
	private Button PIMPane_NavigationPane_ShowProductsButton;
	@FXML
	private Button PIMPane_NavigationPane_SearchButton;
	@FXML
	private Button PIMPane_NavigationPane_UpdateProductButton;
	@FXML
	private ListView<ProductHBoxCell> PIMPane_NavigationPane_ProductListView;
	// </editor-fold>

	@FXML
	private Pane PIMPane_InformationPane;
	// <editor-fold defaultstate="collapsed" desc="PIMPane_InformationPane - Elements">
	@FXML
	private TextField PIMPane_InformationPane_NameTextField;
	@FXML
	private TextField PIMPane_InformationPane_PriceTextField;
	@FXML
	private TextArea PIMPane_InformationPane_DescriptionTextArea;
	@FXML
	private ChoiceBox<String> PIMPane_InformationPane_CategoryChoiceBox;
	@FXML
	private ListView<ProductHBoxCell> PIMPane_InformationPane_CategoryImageListView;
	@FXML
	private Button PIMPane_InformationPane_LinkButton;
	@FXML
	private ListView<ProductHBoxCell> PIMPane_InformationPane_ProductImageListView;
	@FXML
	private Button PIMPane_InformationPane_RemoveButton;
	@FXML
	private Button PIMPane_InformationPane_SaveButton;
	@FXML
	private Button PIMPane_InformationPane_CancelButton;
	// </editor-fold>
	// </editor-fold>

	@FXML
	private Pane DAMPane;
	// <editor-fold defaultstate="collapsed" desc="DAMPane - Elements">
	@FXML
	private Button DAMPane_SaveImageButton;
	@FXML
	private Button DAMPane_OpenButton;
	@FXML
	private ListView<ProductHBoxCell> DAMPane_ImageListView;
	@FXML
	private Button DAMPane_BrowseButton;
	@FXML
	private ChoiceBox<String> DAMPane_ImageCategoryChoiceBox;
	@FXML
	private TextField DAMPane_ImageTitleTextField;
	@FXML
	private Button DAMPane_DeleteButton;
	@FXML
	private TextField DAMPane_ImagePathTextField;
	@FXML
	private ImageView DAMPane_ImageView;
	// </editor-fold>

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			webshopController = new WebshopController();
			DAM = new DAMManager();
			dbm = DBManager.getInstance();
			pimManager = PIMManager.getInstance();
		} catch (IOException ex) {
			Logger.getLogger(FXMLDocumentController2.class.getName()).log(Level.SEVERE, null, ex);
		}
		updateChoiceBoxes();
	}

	// <editor-fold defaultstate="collapsed" desc="MenuPane - Methods">
	@FXML
	private void handle_MenuPane_Buttons(ActionEvent event) {
		MenuPane.setVisible(false);
		if (event.getSource().equals(MenuPane_WebshopButton)) {
			WebshopPane.setVisible(true);
		} else if (event.getSource().equals(MenuPane_PIMButton)) {
			PIMPane.setVisible(true);
		} else if (event.getSource().equals(MenuPane_DAMButton)) {
			DAMPane.setVisible(true);
		}
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="WebshopPane - Methods">
	@FXML
	private void handle_WebshopPane_CatalogTab_Buttons(ActionEvent event) {
		Button source = (Button) event.getSource();
		if (source.equals(WebshopPane_CatalogTab_ShowProductsButton)) {
			ArrayList<Product> products = webshopController.getAllProduct();
			showProducts(products, WebshopPane_CatalogTab_ProductsListView);
			WebshopPane_CatalogTab_SearchTextField.clear();

		} else if (source.equals(WebshopPane_CatalogTab_ShowInfoButton)) {
			ProductHBoxCell productHBoxCell = WebshopPane_CatalogTab_ProductsListView.getSelectionModel().getSelectedItem();
			if (productHBoxCell == null) {
				return;
			}

			//Gets the id for the selected product.
			int id = productHBoxCell.getProductId();
			currentProduct = webshopController.getProduct(id);

			//Updates currentProductImages and displays first image from the list.
			updateCurrentProductImages();
			WebshopPane_CatalogTab_ProductImageView.setImage(currentProductImages.get(0));

			//Sets the text under the image to display the number of images for the selected product.
			imageNumber = 1;
			updateImageNavigationItems();

			//Sets the descriptive text for the selected product.
			updateDescriptiveProductText();

		} else if (source.equals(WebshopPane_CatalogTab_SearchButton)) {
			ArrayList<Product> products = webshopController.findProducts(WebshopPane_CatalogTab_SearchTextField.getText(), getCategoryID(WebshopPane_CatalogTab_CategoryChoiceBox.getValue()));
			showProducts(products, WebshopPane_CatalogTab_ProductsListView);

		} else if (source.equals(WebshopPane_CatalogTab_AddToBasketButton)) {
			int id = WebshopPane_CatalogTab_ProductsListView.getSelectionModel().getSelectedItem().getProductId();
			if (isLoggedIn) {
				webshopController.addProductToBasket(webshopController.getCustomer().getShoppingBaskets().get(0).getId(), id, 1);
			} else {
				guestBasket.addProduct(webshopController.getProduct(id), 1);
			}
			updateBasketTabItems();

		} else if (source.equals(WebshopPane_CatalogTab_ImageLeftButton)) {
			imageNumber += imageNumber == 1 ? 0 : -1;
			updateImageNavigationItems();

		} else if (source.equals(WebshopPane_CatalogTab_ImageRightButton)) {
			imageNumber += imageNumber == currentProductImages.size() ? 0 : 1;
			updateImageNavigationItems();

		}
	}

	@FXML
	private void handle_WebshopPane_CatalogTab_SearchBar(ActionEvent event) {
		WebshopPane_CatalogTab_SearchButton.fire();
	}

	@FXML
	private void handle_WebshopPane_BasketTab_Buttons(ActionEvent event) {
		Button source = (Button) event.getSource();
		if (source.equals(WebshopPane_BasketTab_SetAmountButton)) {
			try {
				int id = WebshopPane_BasketTab_BasketListView.getSelectionModel().getSelectedItem().getProductId();
				int amount = Integer.parseInt(WebshopPane_BasketTab_AmountTextField.getText());
				if (isLoggedIn) {
					webshopController.setProductAmount(webshopController.getCustomer().getShoppingBaskets().get(0).getId(), id, amount);
				} else {
					guestBasket.setProductAmount(webshopController.getProduct(id), amount);
				}
				updateBasketTabItems();
			} catch (Exception ex) {
				WebshopPane_BasketTab_AmountTextField.setText("1");
			}

		} else if (source.equals(WebshopPane_BasketTab_DeleteButton)) {
			int id = WebshopPane_BasketTab_BasketListView.getSelectionModel().getSelectedItem().getProductId();
			if (isLoggedIn) {
				webshopController.removeProduct(webshopController.getCustomer().getShoppingBaskets().get(0).getId(), id);
			} else {
				guestBasket.removeProduct(webshopController.getProduct(id));
			}
			updateBasketTabItems();

		} else if (source.equals(WebshopPane_BasketTab_CheckOutButton)) {
			WebshopPane_CheckoutTab.setDisable(false);
			WebshopPane.getSelectionModel().select(WebshopPane_CheckoutTab);
			WebshopPane_BasketTab_CheckOutButton.setDisable(true);
			if (isLoggedIn) {
				handle_WebshopPane_CheckoutTab_InformationPane_Buttons(null);
			} else {
				WebshopPane_CheckoutTab_PaymentPane.setVisible(false);
				WebshopPane_CheckoutTab_InformationPane.setVisible(true);
			}
		}
	}

	@FXML
	private void handle_WebshopPane_CheckoutTab_InformationPane_Buttons(ActionEvent event) {
		Button source = (Button) event.getSource();
		if (source.equals(WebshopPane_CheckoutTab_ConfirmOrderButton)) {

			Order order = null;

			if (isLoggedIn) {
				webshopController.checkOut(1); //TODO: Needs to be basketId
				order = webshopController.getLatestOrder(); //TODO: Use information
			} else {
				order = webshopController.checkOut(
								WebshopPane_CheckoutTab_InformationPane_EmailTextField.getText(),
								WebshopPane_CheckoutTab_InformationPane_FirstnameTextField.getText(),
								WebshopPane_CheckoutTab_InformationPane_LastnameTextField.getText(),
								Integer.parseInt(WebshopPane_CheckoutTab_InformationPane_PhoneNumberTextField.getText()),
								Integer.parseInt(WebshopPane_CheckoutTab_InformationPane_MobilePhoneNumberTextField.getText()),
								WebshopPane_CheckoutTab_InformationPane_AddressTextField.getText(),
								WebshopPane_CheckoutTab_InformationPane_PostalCodeTextField.getText(),
								WebshopPane_CheckoutTab_InformationPane_CityTextField.getText(),
								WebshopPane_CheckoutTab_InformationPane_CountryTextField.getText(),
								guestBasket);
				if (order == null) {
					return;
				}
				resetCheckOutTabInformationPane();
			}

			resetCheckOutTabReceiptPane(order);

			WebshopPane_CheckoutTab_PaymentPane.setVisible(true);
			WebshopPane_CheckoutTab_InformationPane.setVisible(false);

		} else if (source.equals(WebshopPane_CheckoutTab_CancelOrderButton)) {
			resetWebshopPane();
		}
	}

	private void resetCheckOutTabInformationPane() {
		WebshopPane_CheckoutTab_InformationPane_EmailTextField.setText("");
		WebshopPane_CheckoutTab_InformationPane_FirstnameTextField.setText("");
		WebshopPane_CheckoutTab_InformationPane_LastnameTextField.setText("");
		WebshopPane_CheckoutTab_InformationPane_PhoneNumberTextField.setText("");
		WebshopPane_CheckoutTab_InformationPane_MobilePhoneNumberTextField.setText("");
		WebshopPane_CheckoutTab_InformationPane_AddressTextField.setText("");
		WebshopPane_CheckoutTab_InformationPane_PostalCodeTextField.setText("");
		WebshopPane_CheckoutTab_InformationPane_CityTextField.setText("");
		WebshopPane_CheckoutTab_InformationPane_CountryTextField.setText("");
	}

	private void resetCheckOutTabReceiptPane(Order order) {
		String text = "Ordrekvittering\n"
						+ "-------------------------------\n"
						+ "\n";

		for (OrderLine item : order.getShoppingBasket().getOrderLines()) {
			text += "" + item.getAmount() + "x " + item.getProduct().getName() + " : " + item.getProduct().getPrice() + "kr\n";
		}

		text += "Total Pris: " + order.getTotalPrice() + "kr.\n"
						+ "-------------------------------\n"
						+ "Ha' en god dag!";

		WebshopPane_CheckoutTab_EndPane_ReceiptLabel.setText(text);
		guestBasket.empty();
		updateBasketTabItems();
	}

	private void resetWebshopPane() {
		WebshopPane_CheckoutTab.setDisable(true);
		WebshopPane_CheckoutTab_EndPane.setVisible(false);
		WebshopPane.getSelectionModel().select(WebshopPane_CatalogTab);
		WebshopPane_BasketTab_CheckOutButton.setDisable(false);
		WebshopPane_CheckoutTab_EndPane_ReceiptLabel.setText("");
	}

	@FXML
	private void handle_WebshopPane_CheckoutTab_PaymentPane_Buttons(ActionEvent event) {
		WebshopPane_CheckoutTab_PaymentPane.setVisible(false);
		WebshopPane_CheckoutTab_EndPane.setVisible(true);
	}

	@FXML
	private void handle_WebshopPane_CheckoutTab_EndPane_Buttons(ActionEvent event) {
		resetWebshopPane();
	}

	private void updateImageNavigationItems() {
		int imageAmount = currentProductImages.size();
		if (imageAmount == 1) {
			WebshopPane_CatalogTab_ImageLeftButton.setDisable(true);
			WebshopPane_CatalogTab_ImageRightButton.setDisable(true);
			WebshopPane_CatalogTab_ImageNumberLabel.setText("1 ud af 1");
		} else if (imageAmount > 1) {
			WebshopPane_CatalogTab_ImageLeftButton.setDisable(true);
			WebshopPane_CatalogTab_ImageRightButton.setDisable(false);
			WebshopPane_CatalogTab_ImageNumberLabel.setText(imageNumber + " ud af " + imageAmount);
		} else {
			WebshopPane_CatalogTab_ImageLeftButton.setDisable(true);
			WebshopPane_CatalogTab_ImageRightButton.setDisable(true);
			WebshopPane_CatalogTab_ImageNumberLabel.setText("0 ud af 0");
		}
	}

	private void updateCurrentProductImages() {
		currentProductImages = new ArrayList<>();
		if (!currentProduct.getImageFiles().isEmpty()) {
			for (byte[] imageFile : currentProduct.getImageFiles()) {
				currentProductImages.add(new Image(new ByteArrayInputStream(imageFile)));
			}
		} else {
			currentProductImages.add(new Image("images/test.jpeg"));
		}
	}

	private void updateDescriptiveProductText() {
		String text = "";
		text = "Name: " + currentProduct.getName() + "\n";
		text += "Category: " + currentProduct.getCategory() + "\n";
		text += "Price: " + Double.toString(currentProduct.getPrice()) + "\n";
		text += "Description: " + currentProduct.getDescription();
		WebshopPane_CatalogTab_ProductTextArea.setText(text);
	}

	private void updateBasketTabItems() {
		double totalPrice = 0;

		ArrayList<OrderLine> orderLines = isLoggedIn ? webshopController.getCustomer().getShoppingBaskets().get(0).getOrderLines() : guestBasket.getOrderLines();
		List<ProductHBoxCell> list = new ArrayList<>();
		for (OrderLine orderLine : orderLines) {
			list.add(new ProductHBoxCell(orderLine));
			totalPrice += (orderLine.getProduct().getPrice() * orderLine.getAmount());
		}
		ObservableList observableList = FXCollections.observableArrayList(list);
		WebshopPane_BasketTab_BasketListView.setItems(observableList);
		WebshopPane_BasketTab_TotalPriceTextField.setText(Double.toString(totalPrice));
		if (orderLines.size() == 0) {
			WebshopPane_BasketTab_CheckOutButton.setDisable(true);
		} else {
			WebshopPane_BasketTab_CheckOutButton.setDisable(false);
		}
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="PIMPane - Methods">
	@FXML
	private void handle_PIMPane_NavigationPane_Buttons(ActionEvent event) {
		Button source = (Button) event.getSource();
		if (source.equals(PIMPane_NavigationPane_ShowProductsButton)) {
			handle_PIMPane_NavigationPane(null);
			showProducts(webshopController.getAllProduct(), PIMPane_NavigationPane_ProductListView);

		} else if (source.equals(PIMPane_NavigationPane_SearchButton)) {
			handle_PIMPane_NavigationPane(null);
			ArrayList<Product> products = webshopController.findProducts(
							PIMPane_NavigationPane_SearchBar.getText(),
							getCategoryID(PIMPane_NavigationPane_CategoryChoiceBox.getValue()));
			showProducts(products, PIMPane_NavigationPane_ProductListView);

		} else if (source.equals(PIMPane_NavigationPane_UpdateProductButton)) {
			PIMPane_NavigationPane.setVisible(false);
			PIMPane_InformationPane.setVisible(true);
			pimManager.setEditingProduct(true);
			pimManager.setProductToEdit(PIMPane_NavigationPane_ProductListView.getSelectionModel().getSelectedItem().getProductId());
			//If editing an existing product it gets the product object and sets the textfields to the products values.
			if (pimManager.isEditingProduct()) {
				pimProduct = pimManager.getProductToEdit();
				PIMPane_InformationPane_NameTextField.setText(pimProduct.getName());
				PIMPane_InformationPane_CategoryChoiceBox.setValue(pimProduct.getCategory());
				PIMPane_InformationPane_PriceTextField.setText(Double.toString(pimProduct.getPrice()));
				PIMPane_InformationPane_DescriptionTextArea.setText(pimProduct.getDescription());

				//Shows the assigned images in the listview.
				ArrayList<PIMage> productPimages = pimManager.getPImages(pimProduct.getId());
				List<ProductHBoxCell> productPimagesList = new ArrayList<>();

				for (PIMage pimage : productPimages) {
					productPimagesList.add(new ProductHBoxCell(pimage));
				}
				ObservableList productPimagesObservableList = FXCollections.observableArrayList(productPimagesList);
				PIMPane_InformationPane_ProductImageListView.setItems(productPimagesObservableList);
			}
			updatePIMPane_InformationPane_CategoryImageListView();
		}
	}

	@FXML
	private void handle_PIMPane_NavigationPane(MouseEvent event) {
		if (PIMPane_NavigationPane_ProductListView.getSelectionModel().getSelectedItem() == null || event == null) {
			PIMPane_NavigationPane_UpdateProductButton.setDisable(true);
		} else {
			PIMPane_NavigationPane_UpdateProductButton.setDisable(false);
		}
	}

	@FXML
	private void handle_PIMPane_InformationPane_Buttons(ActionEvent event) {
		Button source = (Button) event.getSource();
		if (source.equals(PIMPane_InformationPane_LinkButton)) {
			ProductHBoxCell image = PIMPane_InformationPane_CategoryImageListView.getSelectionModel().getSelectedItem();
			if (image != null) {
				PIMPane_InformationPane_ProductImageListView.getItems().add(image);
				PIMPane_InformationPane_CategoryImageListView.getItems().remove(image);
			}

		} else if (source.equals(PIMPane_InformationPane_RemoveButton)) {
			ProductHBoxCell image = PIMPane_InformationPane_ProductImageListView.getSelectionModel().getSelectedItem();
			if (image != null) {
				PIMPane_InformationPane_CategoryImageListView.getItems().add(image);
				PIMPane_InformationPane_ProductImageListView.getItems().remove(image);
			}

		} else if (source.equals(PIMPane_InformationPane_SaveButton)) {
			PIMPane_InformationPane.setVisible(false);
			PIMPane_NavigationPane.setVisible(true);

			ArrayList<Integer> imageIdList = new ArrayList<>();
			for (ProductHBoxCell imageCell : PIMPane_InformationPane_ProductImageListView.getItems()) {
				imageIdList.add(imageCell.getImageId());
			}

			String name = PIMPane_InformationPane_NameTextField.getText();
			String category = PIMPane_InformationPane_CategoryChoiceBox.getValue();
			String description = PIMPane_InformationPane_DescriptionTextArea.getText();
			double price = Double.parseDouble(PIMPane_InformationPane_PriceTextField.getText());

			if (pimManager.isEditingProduct()) {
				pimManager.editProduct(pimProduct.getId(), name, category, description, price, imageIdList);
			} else {
				pimManager.createProduct(name, category, description, price, imageIdList);
			}
			resetPIMPane();

		} else if (source.equals(PIMPane_InformationPane_CancelButton)) {
			PIMPane_InformationPane.setVisible(false);
			PIMPane_NavigationPane.setVisible(true);
			resetPIMPane();
		}
	}

	private void resetPIMPane() {
		PIMPane_InformationPane_NameTextField.setText("");
		PIMPane_InformationPane_PriceTextField.setText("");
		PIMPane_InformationPane_DescriptionTextArea.setText("");
		PIMPane_InformationPane_CategoryImageListView.getItems().clear();
		PIMPane_InformationPane_ProductImageListView.getItems().clear();
		PIMPane_NavigationPane_ShowProductsButton.fire();
	}

	private void updatePIMPane_InformationPane_CategoryImageListView() {
		ArrayList<PIMage> pimages = pimManager.getUnassignedPIMages();
		List<ProductHBoxCell> pimagesList = new ArrayList<>();

		for (PIMage pimage : pimages) {
			pimagesList.add(new ProductHBoxCell(pimage));
		}
		ObservableList pimagesObservableList = FXCollections.observableArrayList(pimagesList);
		PIMPane_InformationPane_CategoryImageListView.setItems(pimagesObservableList);
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="DAMPane - Methods">
	@FXML
	private void handle_DAMPane_Buttons(ActionEvent event) {
		Button source = (Button) event.getSource();
		if (source.equals(DAMPane_BrowseButton)) {
			Stage stage = (Stage) anchorPane.getScene().getWindow();
			FileChooser fileChooser = new FileChooser();

			File file = fileChooser.showOpenDialog(stage);

			DAMPane_ImagePathTextField.setText(file.getPath());

		} else if (source.equals(DAMPane_SaveImageButton)) {
			DAM.createImage(
							DAMPane_ImageTitleTextField.getText(),
							DAMPane_ImageCategoryChoiceBox.getValue(),
							DAMPane_ImagePathTextField.getText());
			showDAMImages();

		} else if (source.equals(DAMPane_OpenButton)) {
			showDAMImages();

		} else if (source.equals(DAMPane_DeleteButton)) {
			int id = DAMPane_ImageListView.getSelectionModel().getSelectedItem().getProductId();
			DAM.deleteImage(id);
			showDAMImages();
		}
	}

	private void showDAMImages() {
		ArrayList<DAMImage> damImages = DAM.getDAMImages();
		List<ProductHBoxCell> list = new ArrayList<>();
		for (DAMImage damImage : damImages) {
			list.add(new ProductHBoxCell(damImage));
			damImage.toString();
		}
		ObservableList observableList = FXCollections.observableArrayList(list);
		DAMPane_ImageListView.setItems(observableList);
	}
	// </editor-fold>

	private void showProducts(ArrayList<Product> products, ListView listview) {
		List<ProductHBoxCell> list = new ArrayList<>();
		for (Product product : products) {
			list.add(new ProductHBoxCell(product));
		}
		ObservableList observableList = FXCollections.observableArrayList(list);
		listview.setItems(observableList);
	}

	private void updateChoiceBoxes() {
		categoriesMap = webshopController.getCategories();
		categoriesMap.put("Ingen", -1);
		ArrayList<String> categoryList = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : categoriesMap.entrySet()) {
			categoryList.add(entry.getKey());
		}
		//populates categoryChoiceBoxes. 
		WebshopPane_CatalogTab_CategoryChoiceBox.setItems(FXCollections.observableArrayList(categoryList));
		WebshopPane_CatalogTab_CategoryChoiceBox.setValue(WebshopPane_CatalogTab_CategoryChoiceBox.getItems().get(0));
		PIMPane_NavigationPane_CategoryChoiceBox.setItems(FXCollections.observableArrayList(categoryList));
		PIMPane_NavigationPane_CategoryChoiceBox.setValue(PIMPane_NavigationPane_CategoryChoiceBox.getItems().get(0));
		PIMPane_InformationPane_CategoryChoiceBox.setItems(FXCollections.observableArrayList(categoryList));
		PIMPane_InformationPane_CategoryChoiceBox.setValue(PIMPane_InformationPane_CategoryChoiceBox.getItems().get(0));
		DAMPane_ImageCategoryChoiceBox.setItems(FXCollections.observableArrayList(categoryList));
		DAMPane_ImageCategoryChoiceBox.setValue(DAMPane_ImageCategoryChoiceBox.getItems().get(0));
	}

	private int getCategoryID(String category) {
		return categoriesMap.get(category);
	}
}
