package jTunes;

import java.util.ArrayList;

public class Library { //implements Comparator<Song> {
	
	private ArrayList<Song> library = new ArrayList<>();
	private String sortMethod;
	
	public Library() {
		library = new ArrayList<>();
	}

	public void add(Song song) {
		if (library.contains(song)) {
			System.out.println("Library already contains this song.");
		} else {
			library.add(song);
		}
	}

	public Song remove(Song otherSong) {
		for (Song song: library) {
			if (song.getTitle().equals(otherSong.getTitle())
					&& song.getArtist().equals(otherSong.getArtist())) {
				library.remove(song);
				return song;
			}
		} System.out.println("Song not found.");
		return null;
	}
	
	public int removeAlbum(String albumName) {
		int numberOfSongs = 0;
		for (Song song: library) {
			if (song.getAlbum().equals(albumName)) {
				library.remove(song);
				numberOfSongs--;
			}
		} return numberOfSongs;
	}
	
	public Song returnSong(String songName, String artistName) {
		for (Song song: library) {
			if (song.getTitle().equals(songName)
					&& song.getArtist().equals(artistName)) {
				return song;
			}
		} System.out.println("Song not found.");
		return null;
	}
	
	public String getSortMethod() {
		return sortMethod;
	}
	
	public void setSortMethod(String sortMethod) {
		this.sortMethod = sortMethod;
	}
	
	public String toString() {
		
//		Collections.sort(library, new Comparator<Song>() {
//			public int compare(Object o1, Object o2) {
//				if (sortMethod == "Artist") {
//					Song song1 = (Song) o1;
//					Song song2 = (Song) o2;
//					return song1.getArtist().compareTo(song2.getArtist());
//				} if (sortMethod == "Album") {
//					Song song1 = (Song) o1;
//					Song song2 = (Song) o2;
//					return song1.getAlbum().compareTo(song2.getAlbum());
//				} if (sortMethod == "Title") {
//					Song song1 = (Song) o1;
//					Song song2 = (Song) o2;
//					return song1.getTitle().compareTo(song2.getTitle());
//				}
//			}		
//		});
		
		String toString = "Your music library:\n";
		for (Song song: library) {
			toString += song.toString() + "\n";
		} return toString;
	}

}