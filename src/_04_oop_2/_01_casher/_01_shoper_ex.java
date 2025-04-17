package _04_oop_2._01_casher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*중세시대 문제에서 할인기간을 추가하고,
해당 할인 기간을 점장이 설정할 수 있으며,
실제 Date함수로 구현해보세요.*/


public class _01_shoper_ex {

    static LocalDateTime sdt= LocalDateTime.of(2024, 1, 1, 18, 30);
    static int discountdays = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] categories = {
                "검",
                "도끼",
                "철퇴",
                "활",
                "석궁",
                "창",
                "둔기",
                "단검",
                "해머",
                "지팡이"
        };

        int subItemCount = 10;
        String[][] weaponNames = new String[10][subItemCount];
        int[][] damageValues = new int[10][subItemCount];
        int[][] speedValues = new int[10][subItemCount];
        int[][] weightValues = new int[10][subItemCount];

        int[][] stock = new int[10][subItemCount];
        int[][] prices = new int[10][subItemCount];

        initializeWeapons(sc, categories, weaponNames, damageValues, speedValues, weightValues, prices, stock);

        int totalSales = 0;
        int customerCount = 0;

        while (true) {
            printMessage("메뉴를 선택하세요:");
            printMessage("1. 인벤토리 확인");
            printMessage("2. 구매하기");
            printMessage("3. 총 판매액 확인");
            printMessage("4. 프로그램 종료");
            int choice = inputInt(sc);
            if (choice == 1) {
                printInventory(categories, weaponNames, prices, stock);
            } else if (choice == 2) {
                totalSales = customerPurchaseTurn(sc, categories, weaponNames, prices, stock, totalSales);
                customerCount++;
                if (customerCount % 3 == 0) {
                    restockItems(stock);
                    printMessage("3명의 손님이 구매를 마쳐 품절된 상품이 재입고되었습니다.");
                }
            } else if (choice == 3) {
                printMessage("현재까지의 총 판매액: " + totalSales + " 골드");
            } else if (choice == 4) {
                printMessage("상점을 종료합니다.");
                break;
            } else {
                printMessage("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
        sc.close();
    }

    public static void initializeWeapons(Scanner sc,
                                         String[] categories,
                                         String[][] weaponNames,
                                         int[][] damageValues,
                                         int[][] speedValues,
                                         int[][] weightValues,
                                         int[][] prices,
                                         int[][] stock) {
        for (int i = 0; i < categories.length; i++) {
            for (int j = 0; j < weaponNames[i].length; j++) {
                printMessage("[" + categories[i] + "] " + (j+1) + "번 무기 이름을 입력하세요:");
                weaponNames[i][j] = inputString(sc);
                printMessage(weaponNames[i][j] + " 의 damage 값을 입력하세요:");
                damageValues[i][j] = inputInt(sc);
                printMessage(weaponNames[i][j] + " 의 speed 값을 입력하세요:");
                speedValues[i][j] = inputInt(sc);
                printMessage(weaponNames[i][j] + " 의 weight 값을 입력하세요:");
                weightValues[i][j] = inputInt(sc);
                stock[i][j] = 5;
                prices[i][j] = damageValues[i][j] * 10
                        + speedValues[i][j] * 5
                        + weightValues[i][j] * 2;
            }
        }
    }

    public static void printInventory(String[] categories,
                                      String[][] weaponNames,
                                      int[][] prices,
                                      int[][] stock) {
        for (int i = 0; i < categories.length; i++) {
            printMessage("=== " + categories[i] + " ===");
            for (int j = 0; j < weaponNames[i].length; j++) {
                if (stock[i][j] > 0) {
                    printMessage((j+1) + ". "
                            + weaponNames[i][j]
                            + " - 가격: " + prices[i][j] + " 골드"
                            + " / 재고: " + stock[i][j]);
                } else {
                    printMessage((j+1) + ". " + weaponNames[i][j] + " [판매 완료]");
                }
            }
        }
    }

    public static int customerPurchaseTurn(Scanner sc,
                                           String[] categories,
                                           String[][] weaponNames,
                                           int[][] prices,
                                           int[][] stock,
                                           int totalSales) {
        if(discount()){
            System.out.println("현재 세일 기간이므로 1골드를 깎아드립니다");
        }
        printMessage("구매할 무기 카테고리를 선택하세요 (1 ~ 10):");
        for (int i = 0; i < categories.length; i++) {
            printMessage((i+1) + ". " + categories[i]);
        }
        int catChoice = inputInt(sc) - 1;
        if (catChoice < 0 || catChoice >= categories.length) {
            printMessage("잘못된 카테고리 선택입니다.");
            return totalSales;
        }
        printMessage("구매할 무기의 번호를 선택하세요 (1 ~ 10):");
        for (int j = 0; j < weaponNames[catChoice].length; j++) {
            if (stock[catChoice][j] > 0) {
                int todayp = prices[catChoice][j];
                if(discount()){
                    todayp -= 1;
                }
                printMessage((j+1) + ". "
                        + weaponNames[catChoice][j]
                        + " - 가격: " + todayp + " 골드"
                        + " (재고: " + stock[catChoice][j] + ")");
            } else {
                printMessage((j+1) + ". " + weaponNames[catChoice][j] + " [판매 완료]");
            }
        }
        int weaponChoice = inputInt(sc) - 1;
        if (weaponChoice < 0 || weaponChoice >= weaponNames[catChoice].length) {
            printMessage("잘못된 무기 선택입니다.");
            return totalSales;
        }
        if (stock[catChoice][weaponChoice] <= 0) {
            printMessage("해당 무기는 이미 품절입니다.");
            return totalSales;
        }
        printMessage("구매할 수량을 입력하세요 (현재 재고: " + stock[catChoice][weaponChoice] + "):");
        int qty = inputInt(sc);
        if (qty <= 0) {
            printMessage("잘못된 수량입니다.");
            return totalSales;
        }
        if (qty > stock[catChoice][weaponChoice]) {
            printMessage("재고가 부족합니다. 최대 구매 가능 수량: " + stock[catChoice][weaponChoice]);
            return totalSales;
        }
        int sum = prices[catChoice][weaponChoice] * qty;
        stock[catChoice][weaponChoice] -= qty;
        if(discount()){
            printMessage("할인이 들어갑니다.");
            sum -= qty;
        }
        totalSales += sum;
        printMessage("구매 성공! "
                + weaponNames[catChoice][weaponChoice]
                + " " + qty + "개 구매 완료.");
        printMessage("지불하신 금액: " + sum + " 골드");
        return totalSales;
    }

    public static void restockItems(int[][] stock) {
        for (int i = 0; i < stock.length; i++) {
            for (int j = 0; j < stock[i].length; j++) {
                if (stock[i][j] == 0) {
                    stock[i][j] = 5;
                }
            }
        }
    }

    public static void printMessage(String msg) {
        System.out.println(msg);
    }

    public static int inputInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            printMessage("숫자를 입력해주세요:");
        }
        return sc.nextInt();
    }

    public static String inputString(Scanner sc) {
        while (!sc.hasNext()) {
        }
        return sc.next();
    }

    public static boolean discount(){
        LocalDateTime td = LocalDateTime.now();

        DateTimeFormatter fm = DateTimeFormatter.ofPattern("d");
        String fmd = td.format(fm);

        DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("d");
        String fmd2 = sdt.format(fm2);

        int m1 = Integer.parseInt(fmd);
        int m2 = Integer.parseInt(fmd2);

        if(m1>m2 && m1<m2+discountdays){
            return true;
        }

        return false;
    }
}
