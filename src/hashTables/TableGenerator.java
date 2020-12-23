package hashTables;

import cs1c.SongEntry;

import java.util.ArrayList;

public class TableGenerator {
    ArrayList<String> genreNames;
    FHhashQPwFind<Integer, SongCompInt> tableOfSongIDs;
    FHhashQPwFind<String, SongsCompGenre> tableOfSongGenres;

    /***
     * Constructor that initialize names of genres,table Of song IDs, table of song genres.
     */
    public TableGenerator() {
        genreNames = new ArrayList<>();
        tableOfSongIDs = new FHhashQPwFind<>();
        tableOfSongGenres = new FHhashQPwFind<>();
    }

    /**
     * @return the name of genres
     */
    public ArrayList<String> getGenreNames() {
        return genreNames;
    }

    /***
     * @param allSongs  received songs
     * @return a loaded table songs by genre
     */
    public FHhashQPwFind<String, SongsCompGenre> populateGenreTable(SongEntry[] allSongs) {
        for (SongEntry currentSong : allSongs) {
            if (!tableOfSongGenres.contain(currentSong.getGenre())) {
                SongsCompGenre newG = new SongsCompGenre(currentSong);
                genreNames.add(currentSong.getGenre());
                newG.addSong(currentSong);
                tableOfSongGenres.insert(newG);
            } else
                tableOfSongGenres.find(currentSong.getGenre()).addSong(currentSong);
        }

        return tableOfSongGenres;
    }

    /***
     * @param allSongs  received songs
     * @return a loaded table songs by ID
     */
    public FHhashQPwFind<Integer, SongCompInt> populateIDtable(SongEntry[] allSongs) {

        for (SongEntry currentSong : allSongs) {
            if (!tableOfSongIDs.contain(currentSong.getID()))
                tableOfSongIDs.insert(new SongCompInt(currentSong));
        }

        return tableOfSongIDs;
    }
}
    
    
    

