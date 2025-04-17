package _01_base._00_sBase;

import java.util.Scanner;

public class _00_sBase3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수 : ");
        int num = sc.nextInt();

        System.out.println(num>0?"양수입니다":"음수 또는 0입니다.");


        System.out.println("****************************");

        System.out.println("sunny? : ");
        boolean isSunny = sc.nextBoolean();

        System.out.println("warm? : ");
        boolean isWarm = sc.nextBoolean();

        boolean isNiceWeather = isSunny && isWarm;

        System.out.println(isNiceWeather);
    }
}
