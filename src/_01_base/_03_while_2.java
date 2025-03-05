package _01_base;

import java.util.Scanner;

public class _03_while_2 {
    public static void main(String[] args) {

    }

    public static void ans(){
        String menu1 = "타코야끼";
        String menu2 = "해물찜";
        String menu3 = "튀김요리";
        String menu4 = "자동차기름";

        int price1 = priceFix(menu1);
        int price2 = priceFix(menu2);
        int price3 = priceFix(menu3);
        int price4 = priceFix(menu4);

        Scanner sc = new Scanner(System.in);
        int price = 0;
        int idx = 0;

        while(true){
            idx++;
            System.out.println("1. " + menu1);
            System.out.println("2. " + menu2);
            System.out.println("3. " + menu3);
            System.out.println("4. " + menu4);
            System.out.println("5. 종료");
            int select = sc.nextInt();

            if(select == 1){
                price += price1;
                System.out.println(idx + "번째 손님이 " + menu1 + "을 주문하셔서 현재 누적금액은 " + price + "입니다.");
            } else if (select == 2) {
                price += price2;
                System.out.println(idx + "번째 손님이 " + menu2 + "을 주문하셔서 현재 누적금액은 " + price + "입니다.");
            } else if (select == 3) {
                price += price3;
                System.out.println(idx + "번째 손님이 " + menu3 + "을 주문하셔서 현재 누적금액은 " + price + "입니다.");
            } else if (select == 4) {
                price += price4;
                System.out.println(idx + "번째 손님이 " + menu4 + "을 주문하셔서 현재 누적금액은 " + price + "입니다.");
            } else if (select == 5) {
                System.out.println("종료");
                break;
            }
        }
        System.out.println("누적금액 : " + price);

    }

    public static int priceFix(String menu){
        Scanner sc = new Scanner(System.in);
        System.out.println(menu + "의 가격은?");
        return sc.nextInt();
    }

}
