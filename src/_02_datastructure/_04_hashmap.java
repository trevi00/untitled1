package _02_datastructure;

import java.util.HashMap;
import java.util.Scanner;

public class _04_hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> menu = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[메뉴]");
            System.out.println("1. 메뉴 추가");
            System.out.println("2. 주문");
            System.out.println("3. 취소");
            System.out.println("4. 전체 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) { // 메뉴 추가
                System.out.print("추가할 메뉴 이름: ");
                String newMenu = scanner.nextLine();
                if (menu.containsKey(newMenu)) {
                    System.out.println("이미 존재하는 메뉴입니다.");
                } else {
                    menu.put(newMenu, 0);
                    System.out.println("메뉴가 추가되었습니다.");
                }
            } else if (choice == 2) { // 주문
                System.out.print("주문할 메뉴 이름: ");
                String orderMenu = scanner.nextLine();
                if (menu.containsKey(orderMenu)) {
                    menu.put(orderMenu, menu.get(orderMenu) + 1);
                    System.out.println(orderMenu + "의 주문이 완료되었습니다.");
                } else {
                    System.out.println("없는 메뉴입니다.");
                }
            } else if (choice == 3) { // 취소
                System.out.print("취소할 메뉴 이름: ");
                String cancelMenu = scanner.nextLine();
                if (menu.containsKey(cancelMenu)) {
                    if (menu.get(cancelMenu) > 0) {
                        menu.put(cancelMenu, menu.get(cancelMenu) - 1);
                        System.out.println(cancelMenu + "의 주문이 취소되었습니다.");
                    } else {
                        System.out.println("취소 불가");
                    }
                } else {
                    System.out.println("없는 메뉴입니다.");
                }
            } else if (choice == 4) { // 전체 조회
                System.out.println("전체 메뉴 및 주문 개수:");
                for (String key : menu.keySet()) {
                    System.out.println(key + "=" + menu.get(key));
                }
            } else if (choice == 5) { // 종료
                System.out.println("프로그램을 종료합니다.");
                scanner.close();
                return;
            } else {
                System.out.println("올바른 번호를 선택해주세요.");
            }
        }
    }
}