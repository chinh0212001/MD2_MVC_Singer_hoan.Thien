package rikkei.academy.service.song;

import rikkei.academy.Config.Config;
import rikkei.academy.model.Song;

import javax.jws.Oneway;
import java.util.List;

public class SongServiceIMPL implements ISongService{
    public static final String PATH_SONG = "C:\\Users\\Chinh\\IdeaProjects\\untitled15\\src\\rikkei\\academy\\database\\song.txt";
    public static List<Song> songList = new Config<Song>().readFile(PATH_SONG);
    @Override
    public List<Song> findAll() {
        new Config<Song>().writeFile(PATH_SONG,songList);
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);

    }

    @Override
    public Song findByID(int id) {
        return null;
    }

    @Override
    public void deleteByID(int id) {

    }
}
