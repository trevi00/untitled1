package _01_base;

import java.util.Scanner;

public class _07_ps2 {
    static int age = 0;
    static String s = ""; // 1 == male, 2 == female
    static String phone = ""; // 전화번호
    static String personN = ""; // 주민번호
    static String card = ""; // 카드번호

    static int bal = 100000;

    static boolean first = false;

    public static void main(String[] args) {
        ps2();
    }

    public static void ps2(){
        Scanner sc = new Scanner(System.in);

        ps2_p0(sc);
        int p1 = ps2_p1(sc);

        if(p1 == 2) return;

        int p2 = ps2_p2(sc);

        if(p2 == 2) return;

        ps2_p3(sc);
    }

    public static void ps2_p0(Scanner sc){
        System.out.println("나이 : ");
        age = sc.nextInt();
        System.out.println("성별 : ");
        s = sc.next();
        System.out.println("전화번호 : ");
        phone = sc.next();
        System.out.println("주민번호 : ");
        personN = sc.next();
        System.out.println("카드번호 : ");
        card = sc.next();
    }

    public static int ps2_p1(Scanner sc){
        System.out.println("주민번호 앞자리 : ");
        String p = sc.next();

        if(p.equals(personN)) return 1;

        if(p.length() != 6) {
            int idx = 3;
            while(idx > 0){
                System.out.println("주민번호 앞자리(남은 기회 : " + idx + "번) : ");
                p = sc.next();
                if(p.length() == 6){
                    if(p.equals(personN)){
                        return 1;
                    }
                } else if (p.length() > 6) {
                    idx--;
                }
                idx--;
            }
        }
        return 2;
    }

    static int p2Idx = 0;
    static boolean p2Fir = false;

    public static int ps2_p2(Scanner sc){
        System.out.println("카드번호 : ");
        if(p2Idx != 0 && p2Idx != 3) System.out.println("남은기회는 " + p2Idx + "번");
        String c = sc.next();

        if(c.equals(card)) return 1;

        if(c.length() != 4 && !p2Fir) {
            p2Fir = true;
            p2Idx = 3;
        }

        if(p2Idx == 0) return 2;

        p2Idx--;
        return ps2_p2(sc);
    }

    // 1.계좌 조회. 2.계좌 입금 3.계좌 출금
    public static void ps2_p3(Scanner sc){
        while(true) {
            System.out.println("1.계좌 조회");
            System.out.println("2.계좌 입금");
            System.out.println("3.계좌 출금");
            System.out.println("4.종료");
            int selc = sc.nextInt();

            if(selc == 1){
                if(!first) {
                    System.out.println(bal);
                    first = true;
                } else {
                    System.out.println("계좌조회는 한번만 가능합니다.");
                }

            } else if ((selc == 2 || selc == 3) && !first){
                System.out.println("[처음에는 계좌 조회만 가능합니다.]");
            } else if (selc == 2){
                System.out.println("얼마를 입금하시겠습니까 : ");
                int input = sc.nextInt();
                bal += input;
                System.out.println("계좌에 " + bal + "원이 있습니다.");
            } else if (selc == 3) {
                System.out.println("얼마를 출금하시겠습니까 : ");
                int input = sc.nextInt();
                if(input > bal){
                    System.out.println("잔액이 부족합니다,");
                } else {
                    bal -= input;
                    System.out.println("계좌에 " + bal + "원이 있습니다.");
                }
            } else if (selc == 4) {
                System.out.println("종료");
                break;
            }
        }
    }
}
