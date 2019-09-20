package application;

import java.util.ArrayList;

/**
 * RecordsList.java provides the functionality of the ArrayList to store records
 *
 * @author Janhvi Sharma
 */
public class RecordsList {
	private ArrayList<Records> recList = new ArrayList<Records>();

	/**
	 * RecordsList default constructor
	 */
	public RecordsList() {

	}

	/**
	 * add allows records to be added to the list
	 *
	 * @param rec
	 *            object of Records class
	 */
	public void add(Records rec) {
		recList.add(rec);
	}

	/**
	 * get gives the position of a record in the list
	 *
	 * @param index
	 *            position in the list
	 * @return object at valid index
	 */
	public Records get(int index) {
		try {
			return recList.get(index); // returns object at valid index
		} catch (Exception ex) {
			return null; // returning null object
		}
	}

	/**
	 * length provides the total number of records in the list
	 *
	 * @return the size of the list
	 */
	public int length() {
		return recList.size();
	}

}
