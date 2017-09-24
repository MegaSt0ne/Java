import java.util.ArrayList;

/**
 * purpose: class song
 * @author Matthew Jin
 *
 */
public class Song {
	/*
	 * static variables
	 */
	private static int count = 0;  //the amounts of songs in App store
	
	
	/**
	 * @param songName
	 * @param albumName
	 * @param songPrice
	 */
	public Song(String songName, String bandName, double songPrice) {
		this.songName = songName;
		this.bandName = bandName;
		this.songPrice = songPrice;
		count++;
	}


	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}
	
	
	/**
	 * @return the songPrice
	 */
	public double getSongPrice() {
		return songPrice;
	}
	
	/**
	 * @param songPrice the songPrice to set
	 */
	public void setSongPrice(double songPrice) {
		this.songPrice = songPrice;
	}
	
	/**
	 * @return the songName
	 */
	public String getSongName() {
		return songName;
	}
	
	/**
	 * @return the albumName
	 */
	public String getbandName() {
		return bandName;
	}
	
	/**
	 * Override toString method
	 */
	@Override
	public String toString() {
		return "\"" + songName + "\"" + " from band " + "\"" + bandName + "\"" + 
				" sold at price $" + songPrice;
	}

	/*
	 * instance variables
	 */
	private String songName;	//song name
	private String bandName;	//album name
	private double songPrice;	//song price
}
