package _02_datastructure;

import java.util.Scanner;

public class _01_array_7 {
    static Scanner sc = new Scanner(System.in);

    static int[] days = new int[32];
    // 0. 계좌 1. 베이컨 2. 아이스크림 3. 감자콩 4. 구매 금액 5. 포인트 적립 6. 할인
    static int[][][] customer = new int [32][11][7];
    static int mon = 1;
    static int day = 1;

    static int priv = 0;

    static int m1 = 0;
    static int m2 = 0;
    static int m3 = 0;

    static int p1 = 5000;
    static int p2 = 3000;
    static int p3 = 1000;

    public static void main(String[] args) {
        ps();
    }

    public static void ps(){

        while(true){

            System.out.println(mon + "월 " + day + "일");

            System.out.println("오늘 온 손님 : ");
            int today = sc.nextInt();

            int tmp = priv+today;
            days[day] = tmp;
            System.out.println(mon + "월 " + day + "일 인원수 : " + tmp);

            int discount = priv;
            if(tmp > 10){
                priv = tmp-10;
                tmp = 10;
            }
            customer[day][0][0] = tmp; // 그날 손님

            for(int i = 1; i <= tmp; i++){
                System.out.println(i + "번째 손님 가진 금액 : ");
                customer[day][i][0] = sc.nextInt();
            }

            for(int i = 1; i <= tmp; i++){
                m1 = 0;
                m2 = 0;
                m3 = 0;
                int selc = 0;
                customer[day][i][5] = 0;
                while(true) {
                    System.out.println(i+"번째 손님");
                    selc = menu();
                    if(customer[day][i][0]-m1*5000-m2*3000-m3*1000 < 1000) break;

                    if (selc == 1) {
                        m1 += 1;
                    } else if (selc == 2) {
                        m2 += 1;
                    } else if (selc == 3) {
                        m3 += 1;
                    } else if (selc == 4 || selc == 5) {
                        if (m2 % 10 != 0) {
                            System.out.println("아이스크림 개수 : " + m2);
                            System.out.println("구매해야할 아이스크림 개수 : " + m2 % 10);
                        } else if (m3 < m2) {
                            System.out.println("감자콩 개수 : " + m3);
                            System.out.println("아이스크림 개수 : " + m2);
                            System.out.println("구매해야할 감자콩 개수 : " + (m2 - m3));
                        } else {
                            customer[day][i][1] = m1;
                            customer[day][i][2] = m2;
                            customer[day][i][3] = m3;
                            int sum = m1*p1 + m2*p2 + m3*p3;
                            if(discount>0){
                                discount--;
                                customer[day][i][4] = sum-((sum/100)*5);
                                customer[day][i][6] = 1;
                                if(customer[day][i][5] == 1){
                                    customer[day][i][5] = customer[day][i][4]/100;
                                }

                            } else {
                                customer[day][i][4] = sum;
                                customer[day][i][6] = 0;
                                if(customer[day][i][5] == 1){
                                    customer[day][i][5] = customer[day][i][4]/100;
                                }
                            }
                        }
                    } else if (selc == 6) {
                        customer[day][i][5] = 1;
                    } else if (selc == 7) {
                        break;
                    } else if (selc == 8) {
                        recmenu();
                    }

                }
                if(selc == 7){
                    customer[day][0][0] = i;
                    int idx = tmp - i;
                    priv += idx;
                    break;
                }
            }
            day++;
        }


    }

    public static int menu() {
        int selc;

        System.out.println("1번 베이컨 5000원\n" +
                "2번 아이스크림 3000원\n" +
                "3번 감자콩 1000원\n" +
                "4.다음사람 5.종료\n" +
                "6. 포인트 적립 7. 다음 날 " +
                "\n8.영수증 조회");
        selc = sc.nextInt();

        if (selc > 0 && selc < 9) {
            return selc;
        }
        return menu();
    }

    public static void recmenu(){
        System.out.println(mon +"월 중 어느 날짜를 고르시겠습니까?");
        int idx = sc.nextInt();
        rec(idx);

    }

    public static void rec(int day){
        // 0. 계좌 1. 베이컨 2. 아이스크림 3. 감자콩 4. 구매 금액 5. 포인트 적립 6. 할인
        // static int[][][] customer = new int [32][11][7];
        for (int i = 1; i < 11; i++) {
            System.out.println(mon + "월 " + day + "일 " + i + "번째 손님");
            System.out.println("원금 : " + customer[day][i][0]);
            System.out.println("베이컨 : " + customer[day][i][1]);
            System.out.println("아이스크림 : " + customer[day][i][2]);
            System.out.println("감자콩 : " + customer[day][i][3]);
            System.out.println("구매 금액 : " + customer[day][i][4]);
            if(customer[day][i][5]!=0) {
                System.out.println("포인트 : " + customer[day][i][5]);
            }
            String idx = (customer[day][i][5]>0)?("yes"):("no");
            System.out.println("할인 : " + idx);

        }
    }
}
