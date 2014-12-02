package jTunes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.io.File;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
*/

public class Run {

	private static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<Album> albums = new ArrayList<>();
	private static ArrayList<Playlist> playlists = new ArrayList<>();
	public static int songCount;
	public static int albumCount;
	public static int playlistCount;
	
	public static void main(String[] args) throws IOException {
		
		Library library = new Library();
		
		/*JFrame mainFrame = new JFrame("jTunes");
		mainFrame.setSize(1400, 1000);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//mainFrame.setVisible(true);
		mainFrame.setLayout(new FlowLayout());
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setVisible(true);	
		//setExtendedState(MAXIMIZED_BOTH);
		*/
		
		System.out.println("Welcome to jTunes!");
		
		String menu = "\nWhat would you like to do?\n1: Display your song "
				+ "library\n2: Add a song to the library\n3: Remove a song "
				+ "from the library\n4: Add an album to the library\n"
				+ "5: Remove an album from the library\n6: Make a playlist\n"
				+ "7: Add a song to the playlist\n8: Edit Song\n9: Library Info\n"
				+ "0: Exit.";
		
		/*JLabel menuLabel = new JLabel(menu);
		JMenu optionsMenu = new JMenu("Menu");
		JMenuItem option1 = new JMenuItem("Display your song library");
		optionsMenu.add(option1);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(optionsMenu);
		//mainFrame.add(menuLabel);
		mainFrame.add(menuBar);
		
        InputStream in = new FileInputStream(new File("C:/Users/Jayden/workspace/jTunes/src/jTunes/atl.wav"));
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream); 
		*/
		System.out.println(menu);
		int input = Integer.parseInt(keyboard.nextLine());
		
		while (input != 0) {
			if (input == 1) {
				System.out.println(library.toString());
				
				System.out.println(menu);
				input = Integer.parseInt(keyboard.nextLine());
				
			} if (input == 2) {
				System.out.println("Name the song you would like to add.");
				String songName = keyboard.nextLine();
				System.out.println("Name its artist.");
				String artistName = keyboard.nextLine();
				System.out.println("Name its album. If it is not on an album, "
						+ "leave the space blank.");
				String albumName = keyboard.nextLine();
				Song newSong = new Song(songName, artistName, albumName);
				library.add(newSong);
				songCount++;
				boolean albumExists = false;
				for (Album album: albums) {
					if (album.getTitle().equals(albumName)
							&& album.getArtist().equals(artistName)) {
						albumExists = true;
						album.addSong(newSong);
					}
				} if (!albumExists) {
					Album newAlbum = new Album(albumName, artistName);
					albums.add(newAlbum);
					albumCount++;
				}
				
				System.out.println(menu);
				input = Integer.parseInt(keyboard.nextLine());
				
			} if (input == 3) {
				System.out.println("Name the song you would like to remove.");
				String songName = keyboard.nextLine();
				System.out.println("Name its artist.");
				String artistName = keyboard.nextLine();
				Song removedSong = new Song(songName, artistName, null);
				library.remove(removedSong);
				songCount--;
				
				System.out.println(menu);
				input = Integer.parseInt(keyboard.nextLine());
				
			} if (input == 4) {
				System.out.println("Name the album you wish to add.");
				String albumName = keyboard.nextLine();
				System.out.println("Name its artist.");
				String artistName = keyboard.nextLine();
				Album addedAlbum = new Album(albumName, artistName);
				albums.add(addedAlbum);
				albumCount++;

				System.out.println(menu);
				input = Integer.parseInt(keyboard.nextLine());
				
			} if (input == 5) {
				System.out.println("Name the album you wish to remove.");
				String albumName = keyboard.nextLine();
				System.out.println("Name its artist.");
				String artistName = keyboard.nextLine();
				Album removedAlbum = new Album(albumName, artistName);
				boolean albumFound = false;
				for (Album album: albums) {
					if (removedAlbum.getTitle().equals(album.getTitle())
							&& removedAlbum.getArtist().equals(album.getArtist())) {
						albumFound = true;
						albums.remove(album);
						int numberOfSongs = library.removeAlbum(albumName);
						albumCount--;
						songCount -= numberOfSongs;
					}
				} if (!albumFound) {
					System.out.println("Album not found.");
				}
				
				System.out.println(menu);
				input = Integer.parseInt(keyboard.nextLine());
				
			} if (input == 6) {
				System.out.println("Name your playlist.");
				String playlistName = keyboard.nextLine();
				Playlist newPlaylist = new Playlist(playlistName);
				boolean playlistExists = false;
				for (Playlist playlist: playlists) {
					if (playlist.getTitle().equals(playlistName)) {
						playlistExists = true;
					}
				} if (!playlistExists) {
					playlists.add(newPlaylist);
					playlistCount++;
				}
				System.out.println(menu);
				input = Integer.parseInt(keyboard.nextLine());
			
			} if (input == 7) {
				System.out.println("Name the playlist.");
				String playlistName = keyboard.nextLine();
				System.out.println("Name the song you want to add to the playlist.");
				String songName = keyboard.nextLine();
				System.out.println("Artist name?");
				String artistName = keyboard.nextLine();
				for (Playlist playlist: playlists) {
					if (playlist.getTitle().equals(playlistName)) {
						playlist.addSong(library.returnSong(songName, artistName));
					}
				}
				
				System.out.println(menu);
				input = Integer.parseInt(keyboard.nextLine());
				
			} if (input == 8) {
				System.out.println("1: Change song title\n2: Change song artist\n"
						+ "3: Change song album\n4: Change album title\n"
						+ "5: Change album artist\n6: Change playlist title");
				int input2 = Integer.parseInt(keyboard.nextLine());
				if (input2 == 1) {
					System.out.println("Enter the song name, then its artist's name,"
							+ "then the song's new name.");
					String songName = keyboard.nextLine();
					String artistName = keyboard.nextLine();
					String newName = keyboard.nextLine();
					library.returnSong(songName, artistName).setTitle(newName);
				} if (input2 == 2) {
					System.out.println("Enter the song name, then its artist's name,"
							+ "then the song's new artist.");
					String songName = keyboard.nextLine();
					String artistName = keyboard.nextLine();
					String newArtist = keyboard.nextLine();
					library.returnSong(songName, artistName).setArtist(newArtist);
				} if (input2 == 3) {
					System.out.println("Enter the song name, then its artist's name,"
							+ "then the song's new album.");
					String songName = keyboard.nextLine();
					String artistName = keyboard.nextLine();
					String newAlbum = keyboard.nextLine();
					library.returnSong(songName, artistName).setAlbum(newAlbum);
				} if (input2 == 4) {
					System.out.println("Enter album name, then artist name, then "
							+ "its new name.");
					String albumName = keyboard.nextLine();
					String artistName = keyboard.nextLine();
					String newName = keyboard.nextLine();
					for (Album album: albums) {
						if (album.getTitle().equals(albumName)
								&& album.getArtist().equals(artistName)) {
							album.setTitle(newName);
						}
					}
				} if (input2 == 5) {
					System.out.println("Enter album name, then artist name, then "
							+ "its new artist.");
					String albumName = keyboard.nextLine();
					String artistName = keyboard.nextLine();
					String newArtist = keyboard.nextLine();
					for (Album album: albums) {
						if (album.getTitle().equals(albumName)
								&& album.getArtist().equals(artistName)) {
							album.setArtist(newArtist);
						}
					}
				} if (input2 == 6) {
					System.out.println("Enter the playlist's old then new names.");
					String playlistName = keyboard.nextLine();
					String newName = keyboard.nextLine();
					for (Playlist playlist: playlists) {
						if (playlist.getTitle().equals(playlistName)) {
							playlist.setTitle(newName);
						}
					}
				} System.out.println(menu);
				input = Integer.parseInt(keyboard.nextLine());
			} if (input == 9) {
				String jTunesInfo = "Library Info\n"
						+ "\nNumber of songs: " + songCount
						+ "\nNumber of albums:" + albumCount
						+ "\nNumber of playlists: " + playlistCount;
				System.out.println(jTunesInfo);
				
				System.out.println(menu);
				input = Integer.parseInt(keyboard.nextLine());

			}
		
		}

	}
}