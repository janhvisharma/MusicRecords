package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * FindRecordController.java searches for a particular record in the file
 *
 * @author Janhvi Sharma
 */
public class FindRecordController {

	/** text field linked with the GUI object with fx:id "name" */
	@FXML
	private TextField name;
	/** text field linked with the GUI object with fx:id "artist" */
	@FXML
	private TextField artist;
	/** button field linked with the GUI object with fx:id "btnSearch" */
	@FXML
	private Button btnSearch;
	/** button field linked with the GUI object with fx:id "btnCancel" */
	@FXML
	private Button btnCancel;
	/** text area linked with the GUI object with fx:id "txtArea" */
	@FXML
	private TextArea txtArea;

	/** object of Records class */
	Records rec = new Records();

	/** variables to get values from text fields */
	String _name, _artist;

	/**
	 * initialize method to create an object of all the handlers and passes them
	 * to the field variables using their setOnAction method.
	 */
	public void initialize() {

		btnSearch.setOnAction(e -> {
			try {
				onSearchClicked(); // the handle method for Search button
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		btnCancel.setOnAction(e -> onCancelClicked()); // the handle method for
														// Cancel button

		txtArea.setDisable(true);
	}

	/**
	 * onSearchClicked searches for a record in file that contains given id
	 *
	 * @throws FileNotFoundException
	 *             signals that the file specified doesn't exist
	 * @throws IOException
	 *             signals that an I/O exception of some sort has occurred
	 */
	public void onSearchClicked() throws FileNotFoundException, IOException {
		try {
			_name = name.getText();
			rec.setName(_name);
			_artist = artist.getText();
			rec.setArtist(_artist);

			try {
				@SuppressWarnings("resource")

				// reading from file
				Scanner ifstream = new Scanner(new File("D://records.txt")).useDelimiter("\\s+");
				while (ifstream.hasNext()) {
					String match = ifstream.nextLine();
					txtArea.setDisable(false);
					if (match.contains(_name) && match.contains(_artist)) {
						txtArea.clear();
						txtArea.appendText(match);
						txtArea.appendText("\n");
						txtArea.setEditable(false);
						name.clear();
						artist.clear();
					} else {
						txtArea.appendText("");
					}
				}
				if (txtArea.getText().isEmpty()) {
					txtArea.setText("Record doesn't exist in file!\n");
					txtArea.setEditable(false);
					name.clear();
					artist.clear();
					name.requestFocus();
				}
			} catch (FileNotFoundException ex) {
				System.err.println("No records in file! Add some records for display.");
			}
		} catch (Exception ex) {
			// error messages are displayed if input is not valid
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(ex.getMessage());
			alert.showAndWait();
		}
	}

	/**
	 * onCancelClicked exits current stage and returns to main stage
	 */
	public void onCancelClicked() {
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}

}
