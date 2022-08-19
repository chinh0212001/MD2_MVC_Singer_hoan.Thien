package rikkei.academy.view.singer;

import rikkei.academy.Config.Config;
import rikkei.academy.controller.SingerController;
import rikkei.academy.controller.SongController;
import rikkei.academy.model.Singer;
import rikkei.academy.model.Song;

import java.util.ArrayList;
import java.util.List;

public class ViewSong {
    private SongController songController = new SongController();
    public List<Song> songList = songController.showListSong();
    private SingerController singerController = new SingerController();
    List<Singer> singerList = singerController.showListSinger();
    public ViewSong(){
        System.out.println("----SONG  MANAGE---- ");

        System.out.println("1. Create Song");
        System.out.println("2. Show List Song");
//        System.out.println("3. Detail Singer ");
//        System.out.println("4. Update Singer ");
//        System.out.println("5. Delete Singer ");
//        System.out.println("6. Sort Singer");
        int chooseSong = Config.scanner().nextInt();
        switch (chooseSong) {
            case 1:
                fromCreateSong();
                break;
            case 2:
                fromShowListSong();
                break;
//            case 3:
//                fromDetailSinger();
//                break;
//            case 4:
//                fromEditSinger();
//                break;
//            case 5:
//                fromDeleteSinger();
//                break;
//            case 6:
//                fromShowListSingerAfterSort();
//                break;
        }
    }
    private void fromCreateSong(){
        int idSong;
        if (songList.size()==0){
            idSong = 1;
        }else {
            idSong = songList.get(songList.size()-1).getId()+1;
        }
        System.out.println("Enter the name Song: ");
        String name = Config.scanner().nextLine();
        List<Singer> listSelect = new ArrayList<>();
        selectSinger(listSelect);
        Song song = new Song(idSong,name,0,0,listSelect);
        songController.createSong(song);
        songController.showListSong();
        System.out.println("CREATE SONG SUCCESS!");
        showListSong();
    }
private void fromShowListSong(){
        showListSong();
    System.out.println("Enter any ;keyy to continue _ Enter Quit to exit select Singer");
    String exitSelect = Config.scanner().nextLine();
    if (exitSelect.equalsIgnoreCase("quit")){
        new ViewSong();
    }
}
    private void showListSong() {
        System.out.println("======ID======NAME======LISTEN=======LIKE======LIST SINGER");
        for (int i = 0; i < singerList.size(); i++) {
            System.out.println("======="+songList.get(i).getId()+"======"+songList.get(i).getName()+"======"+songList.get(i).getListen()+"======"
            +songList.get(i).getLike()+"======"+songList.get(i).getSingerList());
        }
    }

    private void selectSinger(List<Singer> listSelect) {
        while (true){
            System.out.println("=======ID======NAME======");
            for (int i = 0; i < singerList.size(); i++) {
                System.out.println("====="+singerList.get(i).getId()+"===="+singerList.get(i).getName());
            }
            System.out.println("Enter the id or Singer to select: ");
            int idSinger = Config.scanner().nextInt();
            Singer singer = singerController.detailSinger(idSinger);
            listSelect.add(singer);
            System.out.println("Enter any ;keyy to continue _ Enter Quit to exit select Singer");
            String exitSelect = Config.scanner().nextLine();
            if (exitSelect.equalsIgnoreCase("quit")){
                break;
            }
        }
    }
}
