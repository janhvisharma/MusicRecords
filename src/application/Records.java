package application;

/**
 * Records.java models a record in the Records file and does data management
 *
 * @author Janhvi Sharma
 */
public class Records {

	/** id of the record */
	String id;
	/** name of the record */
	String name;
	/** artist of the record */
	String artist;
	/** genre of the record */
	String genre;
	/** year of release of the record */
	String year;

	/**
	 * Records default constructor
	 */
	public Records() {
	}

	/**
	 * Records constructor with 5 parameters
	 *
	 * @param id
	 *            Record's ID
	 * @param name
	 *            Record's Name
	 * @param artist
	 *            Record's Artist
	 * @param genre
	 *            Record's Genre
	 * @param year
	 *            Record's Year of Release
	 */
	public Records(String id, String name, String artist, String genre, String year) {
		setId(id);
		setName(name);
		setArtist(artist);
		setGenre(genre);
		setYear(year);
	}

	/**
	 * Records constructor 1 parameter
	 *
	 * @param row
	 *            Record info in one row separated ','
	 */
	public Records(String row) {
		String[] fiedls = row.split(",\\s*");
		setId(fiedls[0]);
		setName(fiedls[1]);
		setArtist(fiedls[2]);
		setGenre(fiedls[3]);
		setYear(fiedls[4]);
	}

	/**
	 * Record's accessor for ID with no parameter
	 *
	 * @return id of the record
	 */
	public String getId() {
		return id;
	}

	/**
	 * Record modifier 1
	 *
	 * @param id
	 *            Record new id
	 */
	public void setId(String id) {
		if (id.matches("[\\d]{4}")) {
			this.id = id;
		} else
			throw new IllegalArgumentException("Error: Record ID must be in the form 1234");
	}

	/**
	 * Record's accessor for name with no parameter
	 *
	 * @return name of the record
	 */
	public String getName() {
		return name;
	}

	/**
	 * Record modifier 2
	 *
	 * @param name
	 *            Record new name
	 */
	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else
			throw new IllegalArgumentException("Error: You must enter a record name.");
	}

	/**
	 * Record's accessor for artist with no parameter
	 *
	 * @return artist of the record
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Record modifier 3
	 *
	 * @param artist
	 *            Record new artist
	 */
	public void setArtist(String artist) {
		if (artist != null && !artist.isEmpty()) {
			this.artist = artist;
		} else
			throw new IllegalArgumentException("Error: You must enter an artist name.");
	}

	/**
	 * Record's accessor for genre with no parameter
	 *
	 * @return genre of the record
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Record modifier 4
	 *
	 * @param genre
	 *            Record new genre
	 */
	public void setGenre(String genre) {
		if (genre != null && !genre.isEmpty() && genre.matches("[a-zA-Z]+")) {
			this.genre = genre;
		} else
			throw new IllegalArgumentException("Error: You must enter a valid genre.");
	}

	/**
	 * Record's accessor for year with no parameter
	 *
	 * @return year of release of the record
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Record modifier 5
	 *
	 * @param year
	 *            Record new year
	 */
	public void setYear(String year) {
		if (!year.isEmpty() && (year.matches("[1][9][5-9][0-9]") || year.matches("[2][0][0-1][0-9]")) && year != null) {
			this.year = year;
		} else
			throw new IllegalArgumentException("Error: You must enter a valid year of release. (1950 - present)");
	}

}
