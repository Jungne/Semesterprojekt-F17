package semesterprojekt.f17;

import Webshop.Catalog;
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

		//Test of Catalog class.
		Catalog catalog = new Catalog();
	}
}
