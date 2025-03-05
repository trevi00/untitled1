package _01_base;

import java.util.Scanner;

public class _05_for_ {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        for (int i = 0; i < 100; i++) {
            int selc = 0;
            System.out.println("1. 장어덮밥(5000)");
            System.out.println("2. 옥수수콘(10000원)");
            System.out.println("3. 감자튀김(3000원)");
            System.out.println("4. 총 가격");
            selc = sc.nextInt();

            if(selc != 4) {
                System.out.print((i + 1) + "번째 손님께서 ");
            }

            if(selc == 1){
                sum+=5000;
                System.out.println("1번 장어덮밥을 선택하셨습니다.");
            } else if (selc == 2) {
                sum+=10000;
                System.out.println("2번 옥수수콘을 선택하셨습니다.");
            } else if (selc == 3) {
                sum+=3000;
                System.out.println("3번 감자튀김을 선택하셨습니다.");
            } else {
                System.out.println("총 가격 : " + sum);
                System.out.println("계속 구매하시겠다면 1번, 아니면 2번을 눌러주세요");
                int innerSelc = sc.nextInt();
                if(innerSelc != 1){
                    break;
                }
                i--;
            }
        }

    }
}
