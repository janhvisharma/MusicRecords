package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * DeleteRecordController.java deletes record from the file
 *
 * @author Janhvi Sharma
 */
public class DeleteRecordController {

	/** text field linked with the GUI object with fx:id "id" */
	@FXML
	private TextField id;
	/** button field linked with the GUI object with fx:id "btnDelete */
	@FXML
	private Button btnDelete;
	/** button field linked with the GUI object with fx:id "btnCancel" */
	@FXML
	private Button btnCancel;
	/** button field linked with the GUI object with fx:id "btnSearch" */
	@FXML
	private Button btnSearch;
	/** text area linked with the GUI object with fx:id "txtArea" */
	@FXML
	private TextArea txtArea;

	/** object of Records class */
	Records rec = new Records();

	/** variable _id to get value from text field */
	String _id;

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

		btnDelete.setOnAction(e -> {
			try {
				onDeleteClicked(); // the handle method for Delete button
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		});

		btnCancel.setOnAction(e -> onCancelClicked()); // the handle method for
														// Clear button
		txtArea.setDisable(true);
		btnDelete.setDisable(true);
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

		// the try block defines using the mutator methods from Record to
		// assign value to be tested for errors while they are being executed.
		try {
			_id = id.getText();
			rec.setId(_id);
			try {
				@SuppressWarnings("resource")
				Scanner ifstream = new Scanner(new File("D://records.txt")).useDelimiter("\\s+");
				while (ifstream.hasNext()) { // checks if Scanner has next input
												// token
					String match = ifstream.nextLine();
					txtArea.setDisable(false);
					if (match.contains(_id)) {
						txtArea.clear();
						txtArea.appendText(match); // displays the record
													// containing the id
						txtArea.appendText("\n");
						txtArea.setEditable(false);
						id.clear();
						btnDelete.setDisable(false);
						btnDelete.requestFocus();
					} else {
						txtArea.appendText("");
					}
					if (txtArea.getText().isEmpty()) {
						txtArea.setText("Record doesn't exist in file!\n");
						txtArea.setEditable(false);
						id.clear();
						id.requestFocus();
					}
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
	 * onDeleteClicked deletes the record from file upon confirmation
	 *
	 * @throws FileNotFoundException
	 *             signals that the file specified doesn't exist
	 * @throws IOException
	 *             signals that an I/O exception of some sort has occurred
	 */
	public void onDeleteClicked() throws FileNotFoundException, IOException {

		Alert alert = new Alert(AlertType.CONFIRMATION);

		// confirmation alert to delete the record from file
		alert.setTitle("Exit?");
		alert.setHeaderText("Are you sure you want to delete this record?");
		ButtonType btnYes = new ButtonType("Yes");
		ButtonType btnNo = new ButtonType("No");

		alert.getButtonTypes().setAll(btnYes, btnNo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == btnYes) {

			try {
				BufferedReader file = new BufferedReader(new FileReader("D://records.txt"));
				String match;
				String line = "";
				while ((match = file.readLine()) != null) {
					// System.out.println(line);
					if (match.contains(_id)) { // checks if record contains id
						match = ""; // empties record
						txtArea.setText("The record is deleted from file!");
						btnDelete.setDisable(true);
						id.requestFocus();
					}
					line += match;
				}
				FileOutputStream File = new FileOutputStream("records.txt");
				File.write(line.getBytes());
				file.close();
				File.close();
			} catch (Exception e) {
				System.out.println("Problem reading file.");
			}

		}
	}

	/**
	 * onCancelClicked exits current stage and returns to main stage
	 */
	public void onCancelClicked() {
		// exits current stage and returns to main stage
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}
}
