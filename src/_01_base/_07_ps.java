package _01_base;

import java.util.Scanner;

public class _07_ps {

    // 사람이 구매할 때마다, 몇 번째 손님이 구매하는 건지 나타내시오.
    // 또한, 현재 누적금액이 얼마인지도 늘 나타내세요.

    // 문제출제1 : 아래 문제에서 장어덮밥의 개수가 가장 많을 경우,
    // '장어덮밥을 많이 주문하셨기 때문에
    // 옥수수콘과 감자튀김은 1개씩 무료로 드립니다.
    // 가 출력되며 실제로 그러하게 만들어주세요.



    // 문제출제2 : 아래 문제에서 옥수수콘의 개수가 가장 많을 경우,
    // 옥수수콘의 개수가 가장 많기 때문에,
    // 감자튀김 1개를 서비스로 드립니다.
    // 가 출력되며, 실제로 그러하게 만들어주세요.

    // 문제출제3 : 아래 문제에서 감자튀김의 개수가 가장 많을 경우,
    // 감자튀김의 개수가 가장 많기 때문에 아무것도 없습니다.
    // 라는 문구가 출력되며 실제로 그러하게 만들어주세요.

    static int n1 = 0;
    static int n2 = 0;
    static int n3 = 0;

    public static void main(String[] args) {
        ps();
    }

    public static void ps(){
        Scanner sc = new Scanner(System.in);

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        int prsentPerson = 1;
        while(true){
            int sum = sum(p1, p2, p3);
            p0(prsentPerson, sum);
            prsentPerson++;

            int selc = menu(sc);

            if(selc == 1){
                n1++;
                p1++;

            } else if (selc == 2) {
                n2++;
                p2++;

            } else if (selc == 3) {
                n3++;
                p3++;

            }
            else if (selc == 4){
                sum = sum(p1, p2, p3);
                int sIn = p2(sum, sc);
                if(sIn == 2){
                    break;
                }
                prsentPerson--;
            }

            int ruleN = p1(n1, n2, n3);
//            System.out.println(n1);
//            System.out.println(n2);
//            System.out.println(n3);
            service(ruleN);
//            System.out.println(n1);
//            System.out.println(n2);
//            System.out.println(n3);

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
        System.out.println("1.장어덮밥(5000원)");
        System.out.println("2.옥수수콘(10000원)");
        System.out.println("3.감자튀김(3000원)");
        System.out.println("4.총 가격");
        System.out.println("선택할 번호 : ");
        return sc.nextInt();
    }

    public static int sum(int p1, int p2, int p3){
        return (p1*5000) + (p2*10000) + (p3*3000);
    }
}
