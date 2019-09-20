package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * ListRecordsController.java lists all the records in the file.
 *
 * @author Janhvi Sharma
 */
public class ListRecordsController {

	/** text area linked with the GUI object with fx:id "txtArea" */
	@FXML
	private TextArea txtArea;
	/** button field linked with the GUI object with fx:id "btnCancel" */
	@FXML
	private Button btnCancel;

	/**
	 * initialize method to create an object of all the handlers and passes them
	 * to the field variables using their setOnAction method.
	 */
	@FXML
	private void initialize() {
		try {
			@SuppressWarnings("resource")

			// reading from file
			Scanner ifstream = new Scanner(new File("D://records.txt")).useDelimiter("\\s+");
			txtArea.setEditable(false);
			while (ifstream.hasNext()) {
				if (ifstream.hasNextLine()) {
					// appending each record to the text area
					txtArea.appendText(ifstream.nextLine() + " ");
					txtArea.appendText("\n");

				} else {
					txtArea.appendText(ifstream.nextLine() + " ");
				}
			}
		} catch (FileNotFoundException ex) {
			System.err.println("No records in file! Add some records for display.");
		}

		btnCancel.setOnAction(e -> onCancelClicked()); // handle method for
														// Cancel button
	}

	/**
	 * onCancelClicked exits current stage and returns to main stage
	 */
	public void onCancelClicked() {
		txtArea.clear();
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}

}
