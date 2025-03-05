package _01_base;

import java.util.Scanner;

public class _04_while_4 {
    public static void main(String[] args) {
        ans();
    }

    public static void ans() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("첫번째 숫자 :");
            int num1 = sc.nextInt();

            System.out.println("두번째 숫자 :");
            int num2 = sc.nextInt();

            int retry = plus(num1, num2);
            if(retry >= 3){
                System.out.println("기회 3회보다 더 사용");
                break;
            }

            if(p2(num1, num2)){
                System.out.println("종료");
                break;
            }

        }
    }

    public static int plus(int num1, int num2){
        Scanner sc = new Scanner(System.in);

        int ans = num1 + num2;
        int left = 0;
        int right = 10;
        int lm = 0;
        int wIdx = 0;
        int rIdx = 0;

        while(lm < 3) {
            while (left < right) {
                System.out.print(num1 + "+" + num2 + " = ");
                int inputNum = sc.nextInt();

                if (inputNum == ans) {
                    System.out.println("정답");
                    rIdx++;
                    break;
                } else {
                    System.out.println("오답");
                    wIdx++;
                    left++;
                }
            }

            if (left < right) {
                break;
            } else {
                System.out.println("초기화");
                lm++;
                left = 0;
            }

            if (rIdx > wIdx) {
                right += 10;
            } else {
                break;
            }
        }
        return lm;
    }

    public static boolean p2(int num1, int num2){
        Scanner sc = new Scanner(System.in);
        int idx = 0;
        int lm = 0;

        while(idx < 5){
            System.out.println("1 : " + num1);
            System.out.println("2 : " + num2);
            System.out.println("1 or 2");
            int input = sc.nextInt();

            if((input == 1 && num1 > num2) ||
                    (input == 2 && num1 < num2)){
                System.out.println("정답");
                return true;
            } else {
                System.out.println("오답");
                lm++;
            }

            int tmp = num1;
            num1 = num2;
            num2 = tmp;
            idx++;
        }

        if(lm >= 3){
            System.out.println("오답 3회 이상");
            int ans = num1>num2 ? 1 : 2;
            System.out.println("정답 : " + ans);
        }
        return false;
    }

}
