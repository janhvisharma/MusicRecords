package application;

import java.util.Optional;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * MainController.java defines the contents in the main stage
 *
 * @author Janhvi Sharma
 */
public class MainController {

	/** button field linked with the GUI object with fx:id "btnAdd" */
	@FXML
	private Button btnAdd;
	/** button field linked with the GUI object with fx:id "btnFind" */
	@FXML
	private Button btnFind;
	/** button field linked with the GUI object with fx:id "btnList" */
	@FXML
	private Button btnList;
	/** button field linked with the GUI object with fx:id "btnDelete" */
	@FXML
	private Button btnDelete;
	/** button field linked with the GUI object with fx:id "btnExit" */
	@FXML
	private Button btnExit;

	/**
	 * initialize method to create an object of all the handlers and passes them
	 * to the field variables using their setOnAction method.
	 */
	public void initialize() {

		// setOnAction method accepts an EventHandler object, so one is created
		// (e) is the parameter passed to the handle method
		// it implements one method, the handle method. Calls a method in the
		// outer class.

		btnAdd.setOnAction(e -> {
			try {
				onAddClicked(); // handle method for Add button
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btnFind.setOnAction(e -> {
			try {
				onFindClicked(); // handle method for Find Button
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btnList.setOnAction(e -> {
			try {
				onListClicked(); // handle method for List Button
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btnDelete.setOnAction(e -> {
			try {
				onDeleteClicked(); // handle method for Delete button
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		btnExit.setOnAction(e -> onExitClicked()); // handle method for Exit
													// button
	}

	/**
	 * onAddClicked opens stage to add a new record to file
	 *
	 * @throws Exception
	 *             exception can occur while opening new stage
	 */
	public void onAddClicked() throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddRecord.fxml"));
			Parent p = loader.load();

			Stage stage = new Stage();
			stage.setScene(new Scene(p));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * onFindClicked opens stage to search for a record in file
	 *
	 * @throws Exception
	 *             exception can occur while opening new stage
	 */
	public void onFindClicked() throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("FindRecord.fxml"));
			Parent p = loader.load();

			Stage stage = new Stage();
			stage.setScene(new Scene(p));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * onListClicked open stage to list all the records in file
	 *
	 * @throws Exception
	 *             exception can occur while opening new stage
	 */
	public void onListClicked() throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ListRecords.fxml"));
			Parent p = loader.load();

			Stage stage = new Stage();
			stage.setScene(new Scene(p));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * onDeleteClicked open stage to delete a record in file
	 *
	 * @throws Exception
	 *             exception can occur while opening new stage
	 */
	public void onDeleteClicked() throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteRecord.fxml"));
			Parent p = loader.load();

			Stage stage = new Stage();
			stage.setScene(new Scene(p));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * onExitClicked displays alert to confirm exiting the platform
	 */
	public void onExitClicked() {
		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("Exit?");
		alert.setHeaderText("Are you sure you want to exit?");
		ButtonType btnYes = new ButtonType("Yes");
		ButtonType btnNo = new ButtonType("No");

		alert.getButtonTypes().setAll(btnYes, btnNo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == btnYes) {
			Platform.exit();
			System.exit(0);
		}
	}

}
