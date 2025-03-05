package _01_base;

import java.util.Scanner;



public class _08_ps4 {

    static int price1 = 500;
    static int price2 = 1000;
    static int price3 = 300;
    static int pM = 1;
    static int n1 = 0;
    static int n2 = 0;
    static int n3 = 0;

    static int p1 = 0;
    static int p2 = 0;
    static int p3 = 0;


    static int age = 0;
    static String s = ""; // 1 == male, 2 == female
    static String phone = ""; // 전화번호
    static String personN = ""; // 주민번호
    static String card = ""; // 카드번호

    static int bal = 1;

    static boolean first = false;

    public static void main(String[] args) {
        ans();
    }

    public static void ans(){
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("1. 은행");
            System.out.println("2. 음식점");
            System.out.println("3. 완전종료");
            int idx = sc.nextInt();

            if(idx == 1){
                ps2();
            } else if (idx == 2) {
                ps1();
            } else if (idx == 3) {
                break;
            }
        }
    }

    public static void ps1(){

        Scanner sc = new Scanner(System.in);

        int prsentPerson = 1;
        while(true){
            // 200 0000
            int balTmp = bal/10000; // 200
            while(balTmp > 10){
                balTmp/=10; // 20 2
                pM *= 10; // 10 10
            }


            int sum = sum3(p1, p2, p3);

            if(bal < price1*pM || bal <price2*pM || bal < price3*pM){
                if(sum != 0){
                    System.out.println("현재 누적 금액은 " + sum + "원 입니다.");
                }
                System.out.println("계좌에 음식값을 더 지불할 돈이 없습니다. 입금하십시오.");
                System.out.println("잔액 : " + bal +"원");
            }

            p0(prsentPerson, sum);
            prsentPerson++;

            int selc = menu(sc);

            if(selc == 1){
                n1++;
                p1++;
                bal -= price1*pM;
            } else if (selc == 2) {
                n2++;
                p2++;
                bal -= price2*pM;
            } else if (selc == 3) {
                n3++;
                p3++;
                bal -= price3*pM;
            }
            else if (selc == 4){
                sum = sum3(p1, p2, p3);
                int sIn = p2(sum, sc);
                if(sIn == 2){
                    break;
                }
                prsentPerson--;
            }

            int ruleN = p1(n1, n2, n3);

            service(ruleN);


        }
    }

    private static void p0(int prsentPerson, int sum) {
        System.out.println(prsentPerson + "번째 손님 반갑습니다.");
        if(sum != 0){
            System.out.println("현재 누적 금액은 " + sum + "원 입니다.");
        }
    }

    public static int p1(int n1, int n2, int n3){
        if(n1 > n2 && n1 > n3){
            return 1;
        } else if (n2 > n1 && n2 > n3) {
            return 2;
        } else if (n3 > n1 && n3 > n2) {
            return 3;
        }
        return 0;
    }


    public static int p2(int sum, Scanner sc){
        System.out.println("감사합니다. 총 가격은" + sum + "원입니다.");
        System.out.println("계속 구매하시겠다면 1번, 아니면 2번을 눌러주세요.");
        System.out.println("선택할 번호 : ");
        int sIn = sc.nextInt();
        if(sIn != 1 && sIn != 2){
            System.out.println("선택할 번호 : ");
            sIn = sc.nextInt();
        }
        if (sIn == 1){
            System.out.println("계속 진행합니다.");
        }
        return sIn;
    }

    public static void service(int ruleN){
        if(ruleN == 1){
            System.out.println("장어덮밥을 많이 주문하셨기 때문에 옥수수콘과 감자튀김은 1개씩 무료로 드립니다.");
                n2++;
                n3++;
        } else if (ruleN == 2) {
            System.out.println("옥수수콘의 개수가 가장 많기 때문에, 감자튀김 1개를 서비스로 드립니다.");
                n3++;
        } else if (ruleN == 3) {
            System.out.println("감자튀김의 개수가 가장 많기 때문에 아무것도 없습니다.");
        }
    }

    public static int menu(Scanner sc){
        System.out.println("1.장어덮밥(" + price1*pM + ")");
        System.out.println("2.옥수수콘(" + price2*pM + ")");
        System.out.println("3.감자튀김(" + price3*pM + ")");
        System.out.println("4.총 가격");
        System.out.println("선택할 번호 : ");
        return sc.nextInt();
    }

    public static int sum3(int p1, int p2, int p3){
        return (p1*price1*pM) + (p2*price2*pM) + (p3*price3*pM);
    }





    public static void ps2(){
        Scanner sc = new Scanner(System.in);

        if(!first) {
            ps2_p0(sc);
        }
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
