package _04_oop._03_gamemaker;

import java.util.ArrayList;

public class Game {

    private String genre; // 장르

    private ArrayList<String> status;

    public Game(String genre, ArrayList<String> status){
        this.genre = genre;
        this.status = status;
    }


    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<String> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<String> status) {
        this.status = status;
    }
}
