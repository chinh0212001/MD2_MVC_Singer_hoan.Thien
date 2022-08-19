package rikkei.academy.view.singer;

import rikkei.academy.Config.Config;
import rikkei.academy.controller.SingerController;
import rikkei.academy.model.Singer;

import java.util.List;

public class ViewSinger {
    public SingerController singerController = new SingerController();
    public List<Singer> singerList = singerController.showListSinger();

    public ViewSinger() {
        System.out.println("----SINGER  MANAGE---- ");

        System.out.println("1. Create Singer");
        System.out.println("2. Show List Singer");
        System.out.println("3. Detail Singer ");
        System.out.println("4. Update Singer ");
        System.out.println("5. Delete Singer ");
        System.out.println("6. Sort Singer");
        int chooseSinger = Config.scanner().nextInt();
        switch (chooseSinger) {
            case 1:
                fromCreateSinger();
                break;
            case 2:
                fromShowListSinger();
                break;
            case 3:
                fromDetailSinger();
                break;
            case 4:
               fromEditSinger();
               break;
            case 5:
                fromDeleteSinger();
                break;
            case 6:
                fromShowListSingerAfterSort();
                break;
        }
    }

    public void fromCreateSinger() {
        System.out.println("=====CREATE SINGER=====");
        while (true) {
            int idSinger;
            if (singerList.size() == 0) {
                idSinger = 1;
            } else {
                idSinger = singerList.get(singerList.size() - 1).getId() + 1;
            }
            System.out.println("nhap vao ten Singer: ");
            String name = Config.scanner().nextLine();
            System.out.println("nhap vao tuoi: ");
            int age = Config.scanner().nextInt();
            Singer singer = new Singer(idSinger, name, age);
            singerController.createSinger(singer);
            System.out.println("Create success!");
//            System.out.println("Check List---->" + singerController.showListSinger());
            singerController.showListSinger();
            System.out.println("nhap vao phim bat ki de tiep tuc - nhap vao quit de thoat: ");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("Quit")) {
                new ViewSinger();
                break;
            }
        }
    }
    public void fromShowListSinger() {
        System.out.println("|======STT======NAME======AGE======|");
        for (int i = 0; i < singerList.size(); i++) {
            int j = i + 1;
            System.out.println("|======" + j + "======" + singerList.get(i).getName() + "======" + singerList.get(i).getAge() + "======|");
        }
//        fromDetailSinger();
        System.out.println(" nhap vao quit de thoat: ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewSinger();
        }
    }
    public void fromDetailSinger() {
        System.out.println("nhap vao id cua Singer: ");
        int idSinger = Config.scanner().nextInt();
        if (singerController.detailSinger(idSinger) == null) {
            System.out.println("ko ton tai!");
        }else {
            Singer singer = singerController.detailSinger(idSinger);
            System.out.println(singer);
        }
        System.out.println(" nhap vao quit de thoat: ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewSinger();
        }
    }
    public void fromEditSinger(){
        System.out.println("nhap vao id de sua: ");
        int idSinger = Config.scanner().nextInt();
        if (singerController.detailSinger(idSinger)==null){
            System.out.println("ko ton tai");
        }else {
            Singer singer = singerController.detailSinger(idSinger);
            System.out.println("OLD NAME: "+ singer.getName());
            System.out.println("OLD AGE: "+singer.getAge());
            System.out.println("nhap vao ten de sua: ");
            String newName = Config.scanner().nextLine();
            if (newName.trim().equals("")){
                newName = singer.getName();
            }
            System.out.println("nhap vao tuoi de sua: ");
            String newAge = Config.scanner().nextLine();
            if (newAge.trim().equals("")){
                newAge = String.valueOf(singer.getAge());
            }
            Singer newSinger = new Singer(newName,newAge);
            singerController.updateSinger(idSinger,newSinger);
            System.out.println("Edit success!!");
            singerController.showListSinger();
        }
        System.out.println("nhap vao phim bat ki de tiep tuc - nhap vao quit de thoat: ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("Quit")) {
            new ViewSinger();
        }
    }
    public void fromDeleteSinger(){
        System.out.println("nhap id vao de xoa: ");
        int idSinger = Config.scanner().nextInt();
        if (singerController.detailSinger(idSinger)==null){
            System.out.println("khong ton tai!");
        }else {
            System.out.println("nhap 1 de xoa - nhap 2 khong xoa");
            int chooseDelete = Config.scanner().nextInt();
            switch (chooseDelete){
                case 1:
                    singerController.deleteSinger(idSinger);
                    fromShowListSinger();
                    singerController.showListSinger();
                    break;
                case 2:
                    new ViewSinger();
                    break;
            }
        }
    }
    public void fromShowListSingerAfterSort() {
        System.out.println("|======STT======NAME======AGE======|");
        List<Singer> listSort = singerController.sortByNameAndAge();
        for (int i = 0; i < listSort.size(); i++) {
            int j = i + 1;
            System.out.println("|======" + j + "======" + singerList.get(i).getName() + "======" + singerList.get(i).getAge() + "======|");
        }
//        fromDetailSinger();
        System.out.println(" nhap vao quit de thoat: ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new ViewSinger();
        }
    }
}