package _04_oop._03_gamemaker;

public class GM {

    private String name;

    private Game game;

    public GM(String name, Game game){
        this.name = name;
        this.game = game;
    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
