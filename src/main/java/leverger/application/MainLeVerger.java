package leverger.application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MainLeVerger extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		Parent content = FXMLLoader.load(getClass().getResource("LeVergerPane.fxml"));
		root.setCenter(content);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}