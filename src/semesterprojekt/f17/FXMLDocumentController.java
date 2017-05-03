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
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {

    private WebshopController webshopController;

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
    private void handleCatalogTestShowProductsButton(ActionEvent e) {
        ArrayList<Product> products = webshopController.getProductList();
        showProducts(products);
    }

    @FXML
    private void handleCatalogTestShowInfoButton(ActionEvent e) {
        int id = catalogTestListView.getSelectionModel().getSelectedItem().getProductId();
        Product product = webshopController.getProduct(id);

        String text = "";

        catalogTestImageView.setImage(new Image("images/" + product.getImagePath()));

        text = "Name: " + product.getName() + "\n";
        text += "Category: " + product.getCategory() + "\n";
        text += "Price: " + Double.toString(product.getPrice()) + "\n";
        text += "Description: " + product.getDescription();

        catalogTestTextArea.setText(text);

        System.out.println(product.getId());
    }
    
    @FXML
    private void handleSearchButton(ActionEvent e) {
        ArrayList<Product> products = webshopController.findProduct(searchTextField.getText());
        showProducts(products);
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

    private void showProducts(ArrayList<Product> products) {
        List<ProductHBoxCell> list = new ArrayList<>();

        for (Product product : products) {
            list.add(new ProductHBoxCell(product));
        }
        ObservableList observableList = FXCollections.observableArrayList(list);
        catalogTestListView.setItems(observableList);
    }

    @FXML
    private void handleFilterButton(ActionEvent event) {
        ArrayList<Product> products = webshopController.getCategory(categoriesChoiceBox.getValue());
        showProducts(products);
    }
}
