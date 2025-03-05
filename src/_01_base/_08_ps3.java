package _01_base;

import java.util.Objects;
import java.util.Scanner;

public class _08_ps3 {
    static int num1 = 0;
    static int num2 = 0;

    public static void main(String[] args) {
        ans();

    }

    public static int plus(int n1, int n2){
        return n1 + n2;
    }
    public static int minus(int n1, int n2){
        return (n1 - n2);
    }
    public static int multi(int n1, int n2){
        return n1 * n2;
    }
    public static int dv(int n1, int n2){
        if(n2 != 0){
            return n1 / n2;
        }

        System.out.println("불가능합니다.");
        return n1;
    }

    public static void ans(){
        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 숫자 : ");
        num1 = sc.nextInt();

        while(true){
            System.out.println("기호 : ");
            String idx = sc.next();
            System.out.println("두 번째 숫자");
            num2 = sc.nextInt();

            int tmp = num1;

            if(Objects.equals(idx, "+")){
                num1 = plus(num1, num2);
            } else if (Objects.equals(idx, "-")) {
                num1 = minus(num1, num2);
            } else if (Objects.equals(idx, "*")){
                num1 = multi(num1, num2);
            } else if (Objects.equals(idx, "/")){
                num1 = dv(num1, num2);
            }

            System.out.println(tmp + " " + idx + " " + num2 + "=" + num1);
        }
    }
}
