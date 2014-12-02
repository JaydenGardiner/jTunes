package jTunes;

import java.util.ArrayList;

public class Album {
	
	private ArrayList<Song> album = new ArrayList<>();
	private String title;
	private String artist;
	
	public Album(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public void addSong(Song song) {
		if (album.contains(song)) {
			System.out.println("Album already contains this song.");
		} else {
			album.add(song);
		}
	}
	
	public void removeSong(Song song) {
		if (album.contains(song)) {
			album.remove(song);
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
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String toString() {
		String toString = title + ":\n";
		for (Song song: album) {
			toString += song.toString() + "\n";
		} return toString;
    }

}