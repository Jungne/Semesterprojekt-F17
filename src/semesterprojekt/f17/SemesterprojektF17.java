package semesterprojekt.f17;

import Webshop.Customer;
import Webshop.FileSearcher;
import Webshop.Order;
import Webshop.Product;
import Webshop.ShoppingBasket;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SemesterprojektF17 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		launch(args);
	}
}
