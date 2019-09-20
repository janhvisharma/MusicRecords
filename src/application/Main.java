package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

/**
 * Main.java sets up the application and defines the stage and scene
 *
 * @author Janhvi Sharma
 */
public class Main extends Application {
	@Override
	/**
	 * start begins the program by loading the main stage
	 */
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root, 500, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * main method
	 *
	 * @param args arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
