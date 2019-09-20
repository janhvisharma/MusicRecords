package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

/**
 * AddRecordController.java adds records with valid inputs
 *
 * @author Janhvi Sharma
 */
public class AddRecordController {

	/** text field linked with the GUI object with fx:id "id" */
	@FXML
	private TextField id;
	/** text field linked with the GUI object with fx:id "name" */
	@FXML
	private TextField name;
	/** text field linked with the GUI object with fx:id "artist" */
	@FXML
	private TextField artist;
	/** text field linked with the GUI object with fx:id "genre" */
	@FXML
	private TextField genre;
	/** text field linked with the GUI object with fx:id "year" */
	@FXML
	private TextField year;

	/** button field linked with the GUI object with fx:id "btnAdd" */
	@FXML
	private Button btnAdd;
	/** button field linked with the GUI object with fx:id "btnCancel" */
	@FXML
	private Button btnCancel;

	/** object of Record class */
	Records rec = new Records();

	/** ArrayList of type Record */
	private ArrayList<Records> record = new ArrayList<Records>();

	/**
	 * field variables to get values from the text fields.
	 */
	String _id, _name, _artist, _genre, _year;

	/**
	 * initialize method to create an object of all the handlers and passes them
	 * to the field variables using their setOnAction method.
	 */
	@FXML
	private void initialize() {

		btnAdd.setOnAction(e -> {
			try {
				onAddClicked(); // the handle method for Add button
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});

		btnCancel.setOnAction(e -> onCancelClicked());
	}

	/**
	 * onAddClicked to add the records to file if all inputs are valid.
	 *
	 * @throws IOException
	 *             signals that an I/O exception of some sort has occurred
	 */
	public void onAddClicked() throws IOException {
		try {

			_id = id.getText();
			rec.setId(_id);
			_name = name.getText();
			rec.setName(_name);
			_artist = artist.getText();
			rec.setArtist(_artist);
			_genre = genre.getText();
			rec.setGenre(_genre);
			_year = year.getText();
			rec.setYear(_year);

			record.add(rec);

			try {
				// create file at location
				File file = new File("D://records.txt");
				FileWriter filew = new FileWriter(file, true);
				BufferedWriter bwrite = new BufferedWriter(filew);
				bwrite.write(rec.getId() + ": " + rec.getName() + ", " + rec.getArtist() + "- " + rec.getGenre() + ", "
						+ rec.getYear() + "\n");

				// confirm that contact has been added to file
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Record added to file!");
				alert.showAndWait();

				bwrite.close();
				filew.close();

				id.clear();
				name.clear();
				artist.clear();
				genre.clear();
				year.clear();

				Stage stage = (Stage) btnAdd.getScene().getWindow();
				stage.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		catch (Exception ex) {
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
