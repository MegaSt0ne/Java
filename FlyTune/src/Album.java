import java.util.ArrayList;

/**
 * purpose: class Album
 * @author Matthew Jin
 * @version 1.0
 */
public class Album {
	
	/*
	 * static variable
	 */
	private static int count = 0; //the total amounts albums in the App store

	/**
	 * @param albumName
	 * @param bandName
	 * @param albumPrice
	 */
	public Album(String albumName, String bandName) {
		this.albumName = albumName;
		this.bandName = bandName;
		count++;
	}

	/**
	 * @return the albumPrice
	 */
	public double getAlbumPrice() {
		return albumPrice;
	}
	
	/**
	 * @param albumPrice the albumPrice to set
	 */
	public void setAlbumPrice(double albumPrice) {
		this.albumPrice = albumPrice;
	}
	
	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}
	
	/**
	 * @return the albumName
	 */
	public String getAlbumName() {
		return albumName;
	}
	
	/**
	 * @return the bandName
	 */
	public String getBandName() {
		return bandName;
	}
	
	/**
	 * @return the songs
	 */
	public ArrayList<Song> getSongs() {
		return songs;
	}

	/**
	 * @param song
	 */
	public void addSong(Song song) {
		songs.add(song);
		System.out.println("New song has been added into album!");
	}

	
	/**
	 * Override toString method
	 */
	@Override
	public String toString() {
		return "Album" + "\"" + albumName + "\"" + "from band" + "\"" + bandName + "\"";
	}


	/*
	 * instance variable
	 */
	private String albumName;
	private String bandName;
	private double albumPrice;
	private ArrayList<Song> songs = new ArrayList<Song>();
}
