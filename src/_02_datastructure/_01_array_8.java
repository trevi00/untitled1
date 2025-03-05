package _02_datastructure;

import java.util.Scanner;


public class _01_array_8 {
    static Scanner sc = new Scanner(System.in);

    // 0 원금
    // 1~5 메뉴
    // 6 구매금액
    // 7 빛진 금액
    // 8 빛을 청산하고 남은 금액
    // 9 미납된 금액
    // 10 빌려준 금액
    static int[][] customer = new int[15][11];

    static String[] m = {"타코야끼", "감자튀김", "베이컨", "아이스크림", "사이다"};

    static int[] cnt = new int[5];

    static int[] p = {5000, 4000, 3000, 2000, 1000};

    public static void main(String[] args) {
        ps();
    }

    public static void ps(){
        for (int i = 0; i < 15; i++) {
            if(i < 5){
                customer[i][0] = 20000;
            } else if (i < 10) {
                customer[i][0] = 10000;
            } else {
                System.out.println((i + 1) + "번째 손님의 금액을 정하시오");
                customer[i][0] = sc.nextInt();
            }


            for (int j = 1; j < 11; j++) {
                customer[i][j] = 0;
            }
        }

        int idx = 0;
        while(true){
            System.out.println((idx+1) + "번째 손님");
            int selc = menu();

            if(selc == 1){
                buy(idx, 1);
            } else if (selc == 2) {
                buy(idx, 2);
            } else if (selc == 3) {
                buy(idx, 3);
            } else if (selc == 4) {
                buy(idx, 4);
            } else if (selc == 5) {
                buy(idx, 5);
            } else if (selc == 6) {
                rf(idx);
            } else if (selc == 7) {
                push(idx);
            } else if (selc == 8) {
                idx++;
            } else if (selc == 9) {
                menu2(idx);
            } else if (selc == 10) {
                System.out.println("종료합니다.");
                break;
            }

        }
    }

    public static void rf(int idx){
        System.out.println("어떤 품목을 환불 하시겠습니까?" +
                "1번 타코야끼 5000원\n" +
                "2번 감자튀김 3000원\n" +
                "3번 베이컨 1000원\n"+
                "4번 아이스크림 1000원\n" +
                "5번 사이다 1000원");
        int selc = sc.nextInt();

        if(selc <= 5 && selc >0) {
            if (customer[idx][selc] < 1) {
                System.out.println("환불할 것이 없습니다.");
            } else {
                System.out.println(m[selc] + "을 하나 환불하겠습니다.");
                customer[idx][selc] -= 1;
                customer[idx][6] -= p[selc - 1];
            }
        }

    }

    public static void buy(int idx, int choice){
        int bal = customer[idx][0] - customer[idx][6] + customer[idx][7] - customer[idx][10];
        if(bal > p[choice-1]){
            customer[idx][6]+=p[choice-1];
            customer[idx][choice]+=1;
        } else {
            System.out.println("금액이 부족합니다.");
            if(bal < p[4]){
                System.out.println("소지금이 부족합니다.");
                if(idx < 14){
                    pull(idx);
                }
            }
        }
    }

    public static void pull(int idx){
        System.out.println("다음 사람에게 돈을 꾸겠습니까 (1. yes 2. no)");
        int ch = sc.nextInt();
        int i = 1;
        if(ch == 1){
            while(true) {
                int nBal = customer[idx + i][0] - customer[idx + i][6] + customer[idx + i][7] - customer[idx + i][8] - customer[idx + i][10];
                System.out.println("빌릴 사람의 금액 : " + nBal);
                System.out.println("얼만큼 빌리겠습니까?");
                int my = sc.nextInt();
                if (my > nBal) {
                    System.out.println("불가능합니다.");
                } else if(nBal < p[4]) {
                    System.out.println("그다음 사람에게 빌리도록 합시다.");
                    i+=1;
                }else {
                    customer[idx + 1][10] += my;
                    customer[idx][7] += my;
                    System.out.println("1.더 빌린다 2.빌리지 않는다.");
                    int inner = sc.nextInt();
                    if(inner == 2){
                        break;
                    }
                }
            }
        }
    }

    public static void push(int idx){
        System.out.println("다음 사람에게 돈을 갚겠습니까 (1. yes 2. no)");
        int ch = sc.nextInt();
        if(ch == 1){
            int bal = customer[idx][0] - customer[idx][6] + customer[idx][7] - customer[idx][8] - customer[idx][10];
            System.out.println("내 금액 : " + bal);
            System.out.println("얼만큼 갚겠습니까?");
            int my = sc.nextInt();
            if(my > bal){
                System.out.println("불가능합니다.");
            } else{
                customer[idx+1][10] -= my;
                customer[idx][8] += my;
            }
        }
    }

    public static int menu() {
        int selc;

        System.out.println("1번 타코야끼 5000원\n" +
                "2번 감자튀김 3000원\n" +
                "3번 베이컨 1000원\n" +
                "4번 아이스크림 1000원\n" +
                "5번 사이다 1000원\n" +
                "6. 환불 " + "7. 돈갚기\n" +
                "8.다음사람 9.다른손님\n" +
                "10. 종료버튼");
        selc = sc.nextInt();

        if (selc > 0 && selc < 11) {
            return selc;
        }
        return menu();
    }

    public static int menu2(int priv){
        System.out.println("몇번째 손님을 제어하실 겁니까?");
        int idx = sc.nextInt();

        if(idx == priv){
            return menu2(priv);
        }



        System.out.println("1번 타코야끼 5000원\n" +
                "2번 감자튀김 3000원\n" +
                "3번 베이컨 1000원\n" +
                "4번 아이스크림 1000원\n" +
                "5번 사이다 1000원\n" +
                "6. 환불 " + "7. 돈갚기\n" +
                "8.다음사람 9.다른손님\n" +
                "10. 종료버튼" + " 11. 이전사람으로");
        int selc = sc.nextInt();

        if(selc == 1){
            buy(idx, 1);
        } else if (selc == 2) {
            buy(idx, 2);
        } else if (selc == 3) {
            buy(idx, 3);
        } else if (selc == 4) {
            buy(idx, 4);
        } else if (selc == 5) {
            buy(idx, 5);
        } else if (selc == 6) {
            rf(idx);
        } else if (selc == 7) {
            push(idx);
        } else if (selc == 8) {
            System.out.println("불가능합니다");
        } else if (selc == 9) {
            System.out.println("불가능합니다.");
        } else if (selc == 10 || selc == 11) {
            System.out.println("종료합니다.");
            return 0;
        }

        return 0;
    }


    public static void rec(int selc) {

        System.out.println("===주문표===");
        for (int i = 0; i < 5; i++) {
            if(customer[selc][i+1]>0){
                System.out.println( m[i] +" x " + customer[selc][i+1] + " = " + customer[selc][i+1]*p[i]);
            }
        }

        System.out.println("===" + selc + "번째 손님===");
        System.out.println("원금 : " + customer[selc][0]);

        for (int i = 0; i < 5; i++) {
            if(customer[selc][i+1]>0){
                System.out.println( m[i] +" x " + customer[selc][i+1] + " = " + customer[selc][i+1]*p[i]);
            }
        }

        System.out.println("현재 금액 : " + (customer[selc][0] - customer[selc][6] + customer[selc][7] - customer[selc][8] - customer[selc][10]));
        System.out.println("빛 진 금액 : " + customer[selc][7]);
        if(customer[selc][0] - customer[selc][6] < 0){
            System.out.println("빛을 청산하고 남은 금액 : " + 0);
        } else {
            System.out.println("빛을 청산하고 남은 금액 : " + (customer[selc][0] - customer[selc][6]));
        }
        System.out.println("미납된 금액 : " + customer[selc][9]);
        System.out.println("빌려준 금액 : " + customer[selc][10]);
    }
}
