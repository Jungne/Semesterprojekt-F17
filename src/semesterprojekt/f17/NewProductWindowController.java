/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt.f17;

import DBManager.DBManager;
import PIM.PIMManager;
import PIM.PIMProduct;
import PIM.PIMage;
import Webshop.WebshopController;
import Webshop.WebshopInterface;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jungn
 */
public class NewProductWindowController implements Initializable {

    private WebshopInterface webshopController;
    private DBManager dbm;
    private PIMManager pimManager;

    private PIMProduct pimProduct;
    private LinkedHashMap<String, Integer> categoriesMap;

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private Button addImageButton;
    @FXML
    private ListView<ProductHBoxCell> availableImagesListView;
    @FXML
    private ListView<ProductHBoxCell> assignedImagesListView;
    @FXML
    private Button removeImageButton;
    @FXML
    private ChoiceBox<String> categoriesChoiceBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	try {
	    webshopController = new WebshopController();
	} catch (IOException ex) {
	    Logger.getLogger(NewProductWindowController.class.getName()).log(Level.SEVERE, null, ex);
	}

	pimManager = new PIMManager();

	categoriesMap = webshopController.getCategories();
	categoriesMap.put("Ingen", -1);
	ArrayList<String> categoriesList = new ArrayList<>();

	for (Map.Entry<String, Integer> entry : categoriesMap.entrySet()) {
	    categoriesList.add(entry.getKey());
	}
	//populates categoriesChoiceBox.
	categoriesChoiceBox.setItems(FXCollections.observableArrayList(categoriesList));
	categoriesChoiceBox.setValue(categoriesChoiceBox.getItems().get(0));

	ArrayList<PIMage> pimages = pimManager.getUnassignedPIMages();
	List<ProductHBoxCell> pimagesList = new ArrayList<>();

	for (PIMage pimage : pimages) {
	    pimagesList.add(new ProductHBoxCell(pimage));
	}
	ObservableList pimagesObservableList = FXCollections.observableArrayList(pimagesList);
	availableImagesListView.setItems(pimagesObservableList);

	//If editing an existing product it gets the product object and sets the textfields to the products values.
	if (pimManager.isEditingProduct()) {
	    pimProduct = pimManager.getProductToEdit();
	    nameTextField.setText(pimProduct.getName());
	    categoriesChoiceBox.setValue(pimProduct.getCategory());
	    priceTextField.setText(Double.toString(pimProduct.getPrice()));
	    descriptionTextArea.setText(pimProduct.getDescription());

	    //Shows the assigned images in the listview.
	    ArrayList<PIMage> productPimages = pimManager.getPImages(pimProduct.getId());
	    List<ProductHBoxCell> productPimagesList = new ArrayList<>();

	    for (PIMage pimage : productPimages) {
		productPimagesList.add(new ProductHBoxCell(pimage));
	    }
	    ObservableList productPimagesObservableList = FXCollections.observableArrayList(productPimagesList);
	    assignedImagesListView.setItems(productPimagesObservableList);
	}
    }

    @FXML
    public void handleAddImageButton(ActionEvent event) {
	ProductHBoxCell image = availableImagesListView.getSelectionModel().getSelectedItem();
	if (image != null) {
	    assignedImagesListView.getItems().add(image);
	    availableImagesListView.getItems().remove(image);
	}
    }

    @FXML
    public void handleRemoveImageButton(ActionEvent event) {
	ProductHBoxCell image = assignedImagesListView.getSelectionModel().getSelectedItem();
	if (image != null) {
	    availableImagesListView.getItems().add(image);
	    assignedImagesListView.getItems().remove(image);
	}
    }

    @FXML
    private void handleSaveButton(ActionEvent event) {
	ArrayList<Integer> imageIdList = new ArrayList<>();
	for (ProductHBoxCell imageCell : assignedImagesListView.getItems()) {
	    imageIdList.add(imageCell.getImageId());
	}

	String name = nameTextField.getText();
	String category = categoriesChoiceBox.getValue();
	String description = descriptionTextArea.getText();
	double price = Double.parseDouble(priceTextField.getText());

	if (pimManager.isEditingProduct()) {
	    pimManager.editProduct(pimProduct.getId(), name, category, description, price, imageIdList);
	} else {
	    pimManager.createProduct(name, category, description, price, imageIdList);
	}

	Stage stage = (Stage) saveButton.getScene().getWindow();
	stage.close();
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
	Stage stage = (Stage) cancelButton.getScene().getWindow();
	stage.close();
    }

}
