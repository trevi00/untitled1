package _01_base;

import java.util.Scanner;
/*
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c1 = wcost("감자", 1);
        int c2 = wcost("감자", 2);
        int c3 = wcost("감자", 3);

        int c4 = wcost("옥수수", 1);
        int c5 = wcost("옥수수", 2);
        int c6 = wcost("옥수수", 3);

        int c7 = wcost("수박", 1);
        int c8 = wcost("수박", 2);
        int c9 = wcost("수박", 3);

        System.out.println("다음 세가지 중 고르시오");
        int ch = choice("1. 감자 2. 옥수수 3. 수박");

        String myCh = fixName(ch);

        int cost1 = 0;
        int cost2 = 0;
        int cost3 = 0;

        fixCost(c1, c2, c3,
                c4, c5, c6,
                c7, c8, c9,
                ch,
                cost1, cost2, cost3);

        int myCost = choice(myCh + " 1. " + cost1 + " 2. " + cost2 + " 3. " + cost3 + " 고를 가격의 번호를 누르시오.");

        int x = choice("몇개를 사시겠습니까");
        ans(myCost, myCh, cost1, cost2, cost3, x);
    }



    public static int wcost(String mych, int a){
        Scanner sc = new Scanner(System.in);
        System.out.println(mych + " 의 " + a +"번째 가격은?");
        return sc.nextInt();
    }

    public static String fixName(int ch){
        String myCh = "";
        if(ch == 1){
            myCh = "감자";
        } else if (ch == 2) {
            myCh = "옥수수";
        } else if (ch == 3) {
            myCh = "수박";
        }
        return myCh;
    }

    public static void fixCost(int a1, int a2, int a3,
                               int b1, int b2, int b3,
                               int c1, int c2, int c3,
                               int ch,
                               int cost1, int cost2, int cost3){
        if(ch == 1) {
            cost1 = a1;
            cost2 = a2;
            cost3 = a3;
        } else if (ch == 2) {
            cost1 = b1;
            cost2 = b2;
            cost3 = b3;
        } else if (ch == 3) {
            cost1 = c1;
            cost2 = c2;
            cost3 = c3;
        }

    }

    public static int multi(int a, int b){
        return a*b;
    }

    public static int choice(String Q){
        Scanner sc = new Scanner(System.in);
        System.out.println(Q);
        return sc.nextInt();
    }

    public static void ans(int myCost, String myCh, int cost1, int cost2, int cost3, int x){
        if (myCost == 1){
            System.out.println(myCh + " " + multi(cost1, x) + "어치를 선택하셨습니다.");
        } else if (myCost == 2) {
            System.out.println(myCh + " " + multi(cost2, x) + "어치를 선택하셨습니다.");
        } else if (myCost == 3) {
            System.out.println(myCh + " " + multi(cost3, x) + "어치를 선택하셨습니다.");
        }
    }



    함수표현식을 쓰는 이유
    1. 단일 체계 원칙 -> 하나의 함수는 하나의 역할만을 해야 한다.
    2. 중복의 최소화
    3. 의존성 최소화


 */
public class _03_def {
    public static void main(String[] args) {
        int num = foodSelect();
        System.out.println("num = " + num);
    }

    //푸드를 관리하는 함수
    public static int foodSelect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.감자 2.옥수수 3.수박 4.호박");
        int select = sc.nextInt();

        if (select == 1) {
            return foodPriceSelect("감자", 1000, 2000, 3000);
        }
        if (select == 2) {
            return foodPriceSelect("옥수수", 1, 2, 3);
        }
        if (select == 3) {
            return foodPriceSelect("수박", 5, 2, 3);
        }
        if (select == 4) {
            return foodPriceSelect("호박", 15, 12, 13);
        }
        return 0;
    }

    //푸드의 가격을 관리하는 함수
    public static int foodPriceSelect(String food, int price1, int price2, int price3) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1."+price1+" 2."+price2+" 3."+price3);
        int select = sc.nextInt();
        if (select == 1) {
            return foodNumberSelect(food, price1);
        }
        if (select == 2) {
            return foodNumberSelect(food, price2);
        }
        if (select == 3) {
            return foodNumberSelect(food, price3);
        }
        return 0;
    }

    //푸드의 개수를 관리하는 함수
    public static int foodNumberSelect(String food, int price) {
        Scanner sc = new Scanner(System.in);
        System.out.println("개수 : ");
        int number = sc.nextInt();
        return number * price;
    }
}
