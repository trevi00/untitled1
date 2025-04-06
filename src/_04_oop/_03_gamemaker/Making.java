package _04_oop._03_gamemaker;

public class Making {

    private GM gm;
    private Game game;

    public void namedGenre(GM gm){
        this.gm = gm;
        this.game = gm.getGame();
    }

    public void settingStatus(String status){
        if(game.getStatus().size() < 5) {
            game.getStatus().add(status);
        } else {
            System.out.println("이미 5개의 속성이 존재합니다.");
        }
    }
}
