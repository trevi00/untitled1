package _01_base;

import java.util.Scanner;

public class _04_while_3 {
    public static void main(String[] args) {
        ans();
    }

    //몇 가지 수를 입력받을 지
    //몇 개의 숫자를 입력받으시겠습니까?

    public static void ans() {
        int idx = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. 프로그램 실행");
            System.out.println("2. 프로그램 종료");
            int select = sc.nextInt();

            if(select == 1){
                System.out.println("몇개의 숫자를 입력받으시겠습니까? : ");
                int p = sc.nextInt();
                System.out.println("결과값 : " + sum(p));
            } else if (select == 2) {
                break;
            }
        }
    }

    public static int sum(int p){
        int idx = 0;
        if (p <= 0) return 0;

        int sum = 0;
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.println("처음에 입력받을 숫자 : ");
        num = sc.nextInt();
        sum += num;
        idx++;

        System.out.println("두번째 숫자 : ");
        num = sc.nextInt();
        System.out.println(sum + "[본인이 생각한 숫자] + " + num + "[본인이 생각한 숫자] = ");
        sum += num;
        idx++;

        System.out.println(sum);

        while(idx < p){
            idx++;
            System.out.println((idx) + "번째로 입력받을 숫자 :");
            num = sc.nextInt();
            System.out.println(+ sum + "[결과값] + " + num + "[입력값] =");
            sum+=num;
            System.out.println(sum + "[결과값]");
        }
        return sum;
    }
}
