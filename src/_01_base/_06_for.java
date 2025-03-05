package _01_base;

import java.util.Scanner;

public class _06_for {
    // 1. 껌 5000
    // 2. 과자 7000
    // 3. 복숭아 4000
    // 4. 환불
    // 5. 종료

    // 주문한것
    // 몇번째 사람
    // 누적금앰
    // 해당음식 구매 누적횟수

    // 환불에서는 전체환불과 개별환불

    // 종료 시에 과자가 10의 배수가 아니면 다시 구매 혹은 환불

    // 5번 종료 시에는 템플릿에 맞게

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);

        // 메뉴별 합
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        // 메뉴 고른 사람 몇명 누적
        int menu1 = 0;
        int menu2 = 0;
        int menu3 = 0;

        // 메뉴 가격
        int price1 = 5000;
        int price2 = 7000;
        int price3 = 4000;

        while(true){
            System.out.println("1. 껌 5000");
            System.out.println("2. 과자 7000");
            System.out.println("3. 복숭아 4000");
            System.out.println("4. 환불");
            System.out.println("5. 종료");
            int selc = sc.nextInt();

            if(selc == 1){
                System.out.println("껌 구매");
                menu1++;
                System.out.println("껌 구매자 : " + menu1);
                sum1+=price1;
                System.out.println("껌 누적 금액 : " + sum1);
            } else if (selc == 2) {
                System.out.println("과자 구매");
                menu2++;
                System.out.println("과자 구매자 : " + menu2);
                sum2+=price2;
                System.out.println("과자 누적 금액 : " + sum2);
            } else if (selc == 3) {
                System.out.println("복숭아 구매");
                menu3++;
                System.out.println("복숭아 구매자 : " + menu3);
                sum3+=price3;
                System.out.println("복숭아 누적 금액 : " + sum3);
            } else if (selc == 4) {

                // 환불
                int s = menu2(sc);
                if(s == 1){
                    int s2 = menu3(sc);
                    if(s2 == 1){
                        sum1 -= price1;
                        menu1--;
                    } else if (s2 == 2) {
                        sum2 -= price2;
                        menu2--;
                    } else if (s2 == 3) {
                        sum2 -= price3;
                        menu3--;
                    }
                } else if (s == 2) {
                    // 총합

                    // 메뉴별 합
                    sum1 = 0;
                    sum2 = 0;
                    sum3 = 0;

                    // 메뉴 고른 사람 몇명 누적
                    menu1 = 0;
                    menu2 = 0;
                    menu3 = 0;
                } else if(s == 3){
                    System.out.println("환불 취소");
                }
            } else if (selc == 5) {
                if(menu2 % 10 != 0){
                    System.out.println("현재 과자가 " + menu2 + "개 이고 " + (10 - (menu2%10)) + "개 더 주문해야합니다.");
                } else if(menu2 > menu3){
                    System.out.println("현재 과자가 " + menu2 + "개 이고, 복숭아가 " + menu3 + "개 입니다. 복숭아를 " + (menu2 - menu3) + "개 더 주문해야합니다.");
                } else {
                    System.out.println("===매출표===");
                    System.out.println("오늘의 매출 : " + (sum1 + sum2 + sum3) + "원");
                    if(menu1>0){
                        System.out.println("껌 X " + menu1 + "개 : " + sum1);
                    }
                    if(menu2>0){
                        System.out.println("과자 X " + menu2 + "개 : " + sum2);
                    }
                    if(menu3>0){
                        System.out.println("복숭아 X " + menu3 + "개 : " + sum3);
                    }
                    break;
                }
            }
        }
    }

    public static int menu2(Scanner sc){
        while(true){
            System.out.println("환불하시겠습니까?");
            System.out.println("1. 개별환불");
            System.out.println("2. 전체환불");
            System.out.println("3. 취소");
            int selc = sc.nextInt();
            if(selc == 1){
                return 1;
            } else if (selc == 2) {
                return 2;
            } else if (selc == 3) {
                return 3;
            }
        }
    }

    public static int menu3(Scanner sc){
        while(true){
            System.out.println("무엇을 환불하시겠습니까?");
            System.out.println("1. 껌 5000");
            System.out.println("2. 과자 7000");
            System.out.println("3. 복숭아 4000");
            int selc = sc.nextInt();
            if(selc == 1){
                return 1;
            } else if (selc == 2) {
                return 2;
            } else if (selc == 3) {
                return 3;
            }
        }
    }
}
