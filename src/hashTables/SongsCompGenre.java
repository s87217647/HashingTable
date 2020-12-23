package hashTables;

import cs1c.SongEntry;

import java.util.ArrayList;

public class SongsCompGenre implements Comparable<String> {
    protected String name;
    protected ArrayList<SongEntry> songs;

    /**
     * Constructor
     * @param theSong
     */
    public SongsCompGenre(SongEntry theSong) {
        this.songs = new ArrayList<SongEntry>();
        this.name = theSong.getGenre();
    }

    /**
     * Wrapper
     */

    public String getName() {
        return name;
    }

    /**
     * Wrapper
     */
    public ArrayList<SongEntry> getData() {
        return songs;
    }

    /**
     * Wrapper
     */
    public void addSong(SongEntry e) {
        songs.add(e);
    }

    /**
     * Wrapper
     */
    public String toString() {
        return songs.toString();
    }

    public int compareTo(String key) {
        return name.compareTo(key);
    }

    /**
     * Wrapper
     */
    public boolean equals(SongsCompGenre target) {
        return name.equals(target.name);
    }

    /**
     * Wrapper
     */
    public int hashCode() {
        return name.hashCode();
    }

}
