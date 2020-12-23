package hashTables;

import cs1c.SongEntry;


public class SongCompInt implements Comparable<Integer> {
    protected SongEntry theSong;

    /**
     * Constructor
     * @param newSong
     */
    public SongCompInt(SongEntry newSong) {
        this.theSong = newSong;
    }

    /**
     * Wrapper
     */
    public String toString() {
        return theSong.toString();
    }

    /**
     * Wrapper
     */
    public int compareTo(Integer key) {
        return theSong.getID() - key;
    }

    /**
     * Wrapper
     */
    public boolean equals(SongCompInt targetet) {
        return theSong.equals(targetet.theSong);
    }

    /**
     * Wrapper
     */
    public int hashCode() {
        return theSong.getID();
    }
}
