package rikkei.academy.controller;

import rikkei.academy.model.Song;
import rikkei.academy.service.song.ISongService;
import rikkei.academy.service.song.SongServiceIMPL;

import java.util.List;

public class SongController {
    public ISongService songService = new SongServiceIMPL();
    public List<Song> showListSong(){
        return songService.findAll();
    }
    public void createSong(Song song){
        songService.save(song);
    }
}
