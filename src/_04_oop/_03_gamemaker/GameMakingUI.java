package _04_oop._03_gamemaker;

import _04_oop._02_ariplane_2.AirlineUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMakingUI {
    private Scanner scanner = new Scanner(System.in);

    private Game game;
    private GM gm;
    private List<GM> developers;

    private Making making;

    public static void main(String[] args) {
        GameMakingUI ui = new GameMakingUI();
        ui.start();
    }

    public void start() {
        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    showAllGames();
                    break;
                case 2:
                    createCustomGames();
                    break;
                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
        System.out.println("프로그램 종료.");
    }

    private void showMainMenu() {
        System.out.println("\n===== 게임 제작 프로그램 =====");
        System.out.println("1. 모든 게임 정보 보기");
        System.out.println("2. 커스텀 게임 만들기");
        System.out.println("3. 종료");
        System.out.print("선택: ");
    }


    private void initDevelopers() {
        developers.add(new GM("Han", new Game("레이싱", new ArrayList<>(List.of("속도", "부딪침", "가속도", "핸들링", "내구도")))));
        developers.add(new GM("Kim", new Game("RPG", new ArrayList<>(List.of("체력", "마나", "공격력", "방어력", "스피드")))));
        developers.add(new GM("Lee", new Game("FPS", new ArrayList<>(List.of("정확도", "연사력", "이동속도", "체력", "탄약")))));

        developers.add(new GM("사용자1", null));
        developers.add(new GM("사용자2", null));
    }

    private void showAllGames() {
        System.out.println("\n==== 모든 게임 정보 ====");
        for (GM gm : developers) {
            Game game = gm.getGame();
            if (game != null) {
                System.out.println("개발자: " + gm.getName());
                System.out.println("장르: " + game.getGenre());
                System.out.println("능력치: " + game.getStatus());
                System.out.println("---------------------------");
            } else {
                System.out.println("개발자: " + gm.getName() + "의 게임은 아직 만들어지지 않았습니다.");
                System.out.println("---------------------------");
            }
        }
    }

    private void createCustomGames() {
        for (GM gm : developers) {
            if (gm.getGame() == null) {
                System.out.println("\n[개발자: " + gm.getName() + "] 게임 만들기");
                System.out.print("게임 장르 입력: ");
                String genre = scanner.nextLine();

                ArrayList<String> statusList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    System.out.print((i + 1) + "번째 능력치 입력: ");
                    String status = scanner.nextLine();
                    statusList.add(status);
                }

                Game newGame = new Game(genre, statusList);
                gm.setGame(newGame);
                System.out.println(gm.getName() + "의 게임 제작 완료!\n");
            }
        }
    }

}
