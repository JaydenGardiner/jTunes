package jTunes;

import java.util.ArrayList;

public class Playlist {

	private ArrayList<Song> playlist = new ArrayList<>();
	private String title;
	
	public Playlist(String title) {
		this.title = title;
	}
	
	public void addSong(Song song) {
		playlist.add(song);
	}
	
	public void removeSong(Song song) {
		if (playlist.contains(song)) {
			playlist.remove(song);
		} else {
			System.out.println("Cannot find song.");
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

    public String toString() {
		String toString = title + ":\n";
		for (Song song: playlist) {
			toString += song.toString() + "\n";
		} return toString;
    }

}
