package _01_base;

import java.util.Scanner;

public class _02_if_2 {
    public static void main(String[] args) {
        int a;
        int b;

        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 숫자를 입력하시오");
        a = sc.nextInt();
        System.out.println("두번째 숫자를 입력하시오");
        b = sc.nextInt();

        int ans;
        System.out.print(a + "+" + b + "= ");
        ans = sc.nextInt();

        int c = a+b;

        if(ans == c){
            System.out.println("정답입니다.");
            System.out.println("1. " + a);
            System.out.println("2. " + b);
            System.out.println("어느 숫자가 더 큽니까? (1 or 2) :");
            int which = sc.nextInt();
            int c2 = (a>b) ? 1 : 2;
            if(c2 == which){
                System.out.println("정답입니다.");
            }
            else{
                System.out.println("오답입니다.");
                System.out.println("정답은 " + c2 + "번이었습니다.");
            }
        }
        else{
            System.out.println("오답입니다.\n"
            + "정답은 " + c +"입니다.");
        }

    }
}
