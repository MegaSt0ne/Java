import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * purpose: Functioned as a app store which can list songs,
 * list albums, add songs, add albums, list songs on an album,
 * update song price
 * @author Matthew Jin
 * @version 1.0
 */
public class FlyTuneApp {

	Scanner sc = new Scanner(System.in);

	/**
	 * @return the songs
	 */
	public ArrayList<Song> getSongs() {
		return songs;
	}

	/**
	 * @return the albums
	 */
	public HashMap<String, Album> getAlbums() {
		return albums;
	}

	/**
	 * list all songs
	 * @param songs
	 */
	public void listSongs(ArrayList<Song> songs) {
		for(Song s:songs) {
			System.out.println(s);
		}
	}

	/**
	 * @return an object of Song
	 */
	public Song addSong() {
		Song aSong = null;
		int index = -1;
		System.out.println("Please enter the name of the song (0 to quit): ");
		String songName = sc.nextLine();
		System.out.println("Please enter the name of the band: ");
		String bandName = sc.nextLine();
		
		index = findSong(songName, bandName);
		if (index != -1) {
			System.out.println("No song has been added!");
			return aSong = songs.get(index);
		}
		
		System.out.println("Please enter the price of the song: ");
		String songPrice = sc.nextLine();
		double price = Integer.parseInt(songPrice);
		songs.add(aSong = new Song(songName, bandName, price));
		System.out.println("New song has been added!");
		return aSong;	
	}

	/**
	 * @param songName
	 * @param bandName
	 * @return index
	 */
	public int findSong(String songName, String bandName) {
		int index = -1;
		for(int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getbandName().equals(bandName) && songs.get(i).getSongName().equals(songName)) {
//				System.out.println("The song has already existed!");
				index = i;
			}
		}
		return index;
	}

	/**
	 * list all albums
	 * @param albums
	 */
	public void listAlbums(HashMap<String, Album> albums) {
		for(Album a:albums.values()) {
			System.out.println(a);
		}
	}
	
	/**
	 * @param songName
	 * @param bandName
	 * @param price
	 */
	public void updatePrice() {
		int index = -1;
		System.out.println("Please enter the name of the song (0 to quit): ");
		String songName = sc.nextLine();
		System.out.println("Please enter the name of the band: ");
		String bandName = sc.nextLine();
		
		index = findSong(songName, bandName);
		if(index != -1) {
			double price = 0;
			String strPrice = null;
			
			System.out.println("Please enter the new price: ");
			strPrice = sc.nextLine();
			price = Integer.parseInt(strPrice);
			songs.get(index).setSongPrice(price);
			System.out.println("The new price has been updated to $" + price + ".");
		} else {
			System.out.println("The song doesn't exist!");
		}
	}
	
	/**
	 * Add new album
	 */
	public void addAlbum() {
		String nameAlbum = null;
		String nameBand = null;
		System.out.println("Please enter the name of album: ");
		nameAlbum = sc.nextLine();

		if(!albums.containsKey(nameAlbum)) {
			System.out.println("Please enter the name of band: ");
			nameBand = sc.nextLine();	
			
			Album album = new Album(nameAlbum, nameBand);
			albums.put(nameAlbum, album);
			System.out.println("The new album has been added!");
			
			Song song = addSong();
			if(song == null) {
				// song has existed in the album
			} else {
				albums.get(nameAlbum).addSong(song);
			}
		} else {
			System.out.println("The album has already existed!");
		}
	}
	
	public void listSongsAlbum() {
		String album = null;
		System.out.println("Please enter the name of album: ");
		album = sc.nextLine();
		if (albums.containsKey(album)) {
			for (Song s: albums.get(album).getSongs()) {
				System.out.println(s);
			}	
		} else {
			System.out.println("The album doesn't exist!");
		}
	}

	public static void main(String[] args)
	{	
		//Scanner declared
		Scanner sc = new Scanner(System.in);
		FlyTuneApp myStore = new FlyTuneApp();

		selection:
			while(true)
			{
				System.out.println("Please make a selection (0 to quit): ");
				System.out.println("1. List all songs");
				System.out.println("2. List all albums");
				System.out.println("3. Add a song");
				System.out.println("4. Add an album");
				System.out.println("5. List songs on an album");
				System.out.println("6. Update song price");
				System.out.println("Selection:");	

				String input = sc.nextLine();
				switch (input) {
				case QUIT:	
					break selection;
				case LIST_SONGS:
					myStore.listSongs(myStore.getSongs());
					break;
				case LIST_ALBUMS:
					myStore.listAlbums(myStore.getAlbums());
					break;
				case ADD_SONG:
					myStore.addSong();
					break;
				case ADD_ALBUM:
					myStore.addAlbum();
					break;
				case LIST_SONGS_ALBUM:
					myStore.listSongsAlbum();
					break;
				case UPDATE_PRICE:
					myStore.updatePrice();
					break;
				default:
					break selection;
				}
				System.out.println();
			}
		System.out.println("Exit FlyTunes App Store.");
	}

	/*
	 * instance variables
	 */
	private ArrayList<Song> songs = new ArrayList<Song>();
	private HashMap<String, Album> albums = new HashMap<String, Album>();

	/*
	 * constants
	 */
	private final static String QUIT = "0";	//quit
	private final static String LIST_SONGS = "1";	//list all songs
	private final static String LIST_ALBUMS = "2";	//list all albums
	private final static String ADD_SONG = "3";		//add song
	private final static String ADD_ALBUM = "4";	//add album
	private final static String LIST_SONGS_ALBUM = "5";	//list songs
	private final static String UPDATE_PRICE = "6";	//update price
}
